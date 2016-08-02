package com.neu.sentencesimplification.stanfordcorenlp;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.parser.nndep.DependencyParser;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.trees.*;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * DependenciesParser: Parses the dependencies returned by Stanford Parser.
 */
public class DependenciesParser {

    private static final TreebankLanguagePack TREE_LANGUAGE_PACK;
    private static final MaxentTagger MAXENT_TAGGER;
    private static final GrammaticalStructureFactory GRAMMATICAL_STRUCTURE_FACTORY;
    private static final DependencyParser DEPENDENCY_PARSER;

    static {
        TREE_LANGUAGE_PACK = new PennTreebankLanguagePack();
        GRAMMATICAL_STRUCTURE_FACTORY = TREE_LANGUAGE_PACK.grammaticalStructureFactory();
        DEPENDENCY_PARSER = DependencyParser.loadFromModelFile("models/english_UD.gz");
        MAXENT_TAGGER = new MaxentTagger("models/tagger-models/english-left3words-distsim.tagger");
    }

    public static List<QuestionSentence> extractPartsOfSpeechFromDependencies(final String text) {

        final List<QuestionSentence> questionSentences = new ArrayList<>();
        final StringReader textReader = new StringReader(text);
        final DocumentPreprocessor textProcessor = new DocumentPreprocessor(textReader);
        textProcessor.setTokenizerFactory(TREE_LANGUAGE_PACK.getTokenizerFactory());
        for (List<HasWord> sentenceWordList : textProcessor) {
            final String sentenceText = Sentence.listToString(sentenceWordList);

            List<TaggedWord> tagged = MAXENT_TAGGER.tagSentence(sentenceWordList);
            final GrammaticalStructure grammaticalStructure = DEPENDENCY_PARSER.predict(tagged);

            final Collection<TypedDependency> sentenceDependencies = grammaticalStructure.typedDependenciesCCprocessed();
            final QuestionSentence questionSentence = new QuestionSentence(text, sentenceText, sentenceDependencies);
            questionSentences.add(questionSentence);
        }

        return questionSentences;
    }
}
