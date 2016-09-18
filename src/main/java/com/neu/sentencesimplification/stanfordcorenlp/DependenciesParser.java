package com.neu.sentencesimplification.stanfordcorenlp;

import com.neu.sentencesimplification.simplifier.CommaSimplifier;
import com.neu.sentencesimplification.simplifier.ConjunctionSimplifier;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.parser.nndep.DependencyParser;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.trees.*;

import java.io.StringReader;
import java.util.*;

/**
 * DependenciesParser: Parses the dependencies returned by Stanford Parser.
 */
public class DependenciesParser {

    private static final TreebankLanguagePack TREE_LANGUAGE_PACK;
    private static final MaxentTagger MAXENT_TAGGER;
    private static final GrammaticalStructureFactory GRAMMATICAL_STRUCTURE_FACTORY;
    private static final DependencyParser DEPENDENCY_PARSER;
    private static final ConjunctionSimplifier CONJUNCTION_SIMPLIFIER;
    private static final CommaSimplifier COMMA_SIMPLIFIER;

    static {
        TREE_LANGUAGE_PACK = new PennTreebankLanguagePack();
        GRAMMATICAL_STRUCTURE_FACTORY = TREE_LANGUAGE_PACK.grammaticalStructureFactory();
        DEPENDENCY_PARSER = DependencyParser.loadFromModelFile("models/english_UD.gz");
        MAXENT_TAGGER = new MaxentTagger("models/english-left3words/english-left3words-distsim.tagger");
        CONJUNCTION_SIMPLIFIER = new ConjunctionSimplifier();
        COMMA_SIMPLIFIER = new CommaSimplifier();
    }

    public static List<QuestionSentence> extractPartsOfSpeechFromDependencies(final String text) {

        final List<QuestionSentence> questionSentences = new ArrayList<>();
        final StringReader textReader = new StringReader(text);
        final DocumentPreprocessor textProcessor = new DocumentPreprocessor(textReader);
        textProcessor.setTokenizerFactory(TREE_LANGUAGE_PACK.getTokenizerFactory());

        final List<TypedDependency> quantifiedNouns = new ArrayList<>();

        for (List<HasWord> sentenceWordList : textProcessor) {
            String sentenceText = Sentence.listToString(sentenceWordList);

            List<TaggedWord> taggedWords = MAXENT_TAGGER.tagSentence(sentenceWordList);
            GrammaticalStructure grammaticalStructure = DEPENDENCY_PARSER.predict(taggedWords);

            Collection<TypedDependency> sentenceDependencies = grammaticalStructure.typedDependenciesCCprocessed();
            updateQuantifiedNouns(quantifiedNouns, sentenceDependencies);

            final SortedSet<IndexedWord> cardinalsWithoutNummods = containsCardinalWithoutNummod(sentenceDependencies);
            if (cardinalsWithoutNummods.size() > 0) {
                updateCardinalsWithNouns(quantifiedNouns, cardinalsWithoutNummods, sentenceWordList);
                taggedWords = MAXENT_TAGGER.tagSentence(sentenceWordList);
                grammaticalStructure = DEPENDENCY_PARSER.predict(taggedWords);

                sentenceDependencies = grammaticalStructure.typedDependenciesCCprocessed();
                sentenceText = Sentence.listToString(sentenceWordList);
            }

            final QuestionSentence questionSentence = new QuestionSentence(text, sentenceText, sentenceDependencies, taggedWords);

            final List<QuestionSentence> commaSimplifiedQuestionSentences =
                    COMMA_SIMPLIFIER.simplify(questionSentence, taggedWords);

            for (final QuestionSentence commaSimplifiedQuestionSentence: commaSimplifiedQuestionSentences) {
                final List<QuestionSentence> conjunctionSimplifiedQuestionSentences =
                        CONJUNCTION_SIMPLIFIER.simplify(commaSimplifiedQuestionSentence, taggedWords);
                questionSentences.addAll(conjunctionSimplifiedQuestionSentences);
            }
            
        }

        System.out.println(questionSentences);
        return questionSentences;
    }


    /**
     * Finds the quantified Nouns from the given dependencies.
     * @param quantifiedNouns: Quantified Nouns which have been found till now.
     * @param dependencies: The dependencies from which to find the quantified Nouns.
     */
    private static void updateQuantifiedNouns(final List<TypedDependency> quantifiedNouns,
                                              final Collection<TypedDependency> dependencies) {
        for (final TypedDependency dependency: dependencies) {
            if (PennRelationsTag.isANummod(dependency)) {
                quantifiedNouns.add(dependency);
            }
        }
    }

    /**
     * Checks if there are any cardinals without nouns associated.
     * @param dependencies: The dependencies from which to find the cardinals without associated nouns.
     * @return Cardinal IndexedWords for which there were no associated Nouns sorted in decreasing order.
     */
    private static SortedSet<IndexedWord> containsCardinalWithoutNummod (final Collection<TypedDependency> dependencies) {
        final SortedSet<IndexedWord> cardinals = new TreeSet<>(new Comparator<IndexedWord>() {
            @Override
            public int compare(IndexedWord o1, IndexedWord o2) {
                return o2.index() - o1.index();
            }
        });

        for (TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isACardinal(depTag)) {
                cardinals.add(dependency.dep());
            }
        }

        for (TypedDependency dependency: dependencies) {
            if (PennRelationsTag.isANummod(dependency)) {
                cardinals.remove(dependency.dep());
            }
        }

        return cardinals;
    }

    /**
     * Associates the cardinals without Nouns with Nouns and updates the sentenceWordList accordingly.
     * @param quantifiedNouns: The quantified Nouns.
     * @param cardinalsWithoutNummods: Cardinals without associated Nouns.
     * @param sentenceWordList: list of HasWord for a sentence.
     */
    private static void updateCardinalsWithNouns(final List<TypedDependency> quantifiedNouns,
                                                 final SortedSet<IndexedWord> cardinalsWithoutNummods,
                                                 final List<HasWord> sentenceWordList) {
        final int noOfQuantifiedNouns = quantifiedNouns.size();
        final TypedDependency lastQuantifiedNoun = quantifiedNouns.get(noOfQuantifiedNouns - 1);
        final String word = lastQuantifiedNoun.gov().backingLabel().
                getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
        for (final IndexedWord indexedWord: cardinalsWithoutNummods) {
            final CoreLabel newCoreLabel = new CoreLabel();
            newCoreLabel.setValue(word);
            newCoreLabel.setOriginalText(word);
            newCoreLabel.setWord(word);
            sentenceWordList.add(indexedWord.index(), newCoreLabel);
            //  CoreLabel currentHasWord = (CoreLabel) sentenceWordList.get(indexedWord.index() - 1);
            //  sb.insert(currentHasWord.get(edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetEndAnnotation.class), " " + word);
        }


    }
}
