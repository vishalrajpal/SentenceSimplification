package com.neu.sentencesimplification.simplifier;

import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;
import com.neu.sentencesimplification.stanfordcorenlp.OtherPartsOfSpeech;
import com.neu.sentencesimplification.stanfordcorenlp.PartsOfSpeech;
import com.neu.sentencesimplification.stanfordcorenlp.QuestionSentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.pipeline.DependencyParseAnnotator;

import java.util.*;

/**
 * ConjunctionSimplifier: Simplifies a sentence based on a conjunction and returns all the simplified sentences.
 */
public class ConjunctionSimplifier implements Simplifier {

    private static final String SPACE = " ";
    private static final String FULL_STOP = ".";

    @Override
    public List<QuestionSentence> simplify(final QuestionSentence questionSentence,
                                           final List<TaggedWord> taggedWords) {
        final SortedSet<PartsOfSpeech> partsOfSpeeches = questionSentence.getPartsOfSpeech();
        final List<QuestionSentence> simplifiedSentences = new ArrayList<>();

        if (questionSentence.hasConjunction()) {

            final SortedSet<PartsOfSpeech> partsOfSpeechBeforeConjunction = new TreeSet<>(partsOfSpeeches.comparator());
            final SortedSet<PartsOfSpeech> partsOfSpeechAfterConjunction = new TreeSet<>(partsOfSpeeches.comparator());
            final PartsOfSpeech splitPartsOfSpeech = populateBeforeAndAfterConjunctionLists(partsOfSpeeches,
                    partsOfSpeechBeforeConjunction,
                    partsOfSpeechAfterConjunction);

            final PartsOfSpeech firstPartsOfSpeechBeforeConjunction = partsOfSpeechBeforeConjunction.first();
            final PartsOfSpeech.Type firstPartsOfSpeechBeforeConjunctionType = firstPartsOfSpeechBeforeConjunction.getType();
            if (firstPartsOfSpeechBeforeConjunctionType.equals(PartsOfSpeech.Type.NOUN)) {
                updateConjunctionPartsBasedOnNoun(partsOfSpeechBeforeConjunction,
                        partsOfSpeechAfterConjunction);

                mergeTaggedWordsAndPartsOfSpeechOfAConjunction(taggedWords,
                        partsOfSpeechBeforeConjunction,
                        partsOfSpeechAfterConjunction,
                        splitPartsOfSpeech,
                        questionSentence);

                final QuestionSentence firstSentenceQuestionSentence = createQuestionSentenceFromPartsOfSpeech(partsOfSpeechBeforeConjunction);
                final QuestionSentence secondSentenceQuestionSentence = createQuestionSentenceFromPartsOfSpeech(partsOfSpeechAfterConjunction);
                simplifiedSentences.add(firstSentenceQuestionSentence);
                simplifiedSentences.add(secondSentenceQuestionSentence);

            } /*else if(firstPartsOfSpeechBeforeConjunctionType.equals(PartsOfSpeech.Type.EXPLETIVE)) {

            }*/



        } else {
            simplifiedSentences.add(questionSentence);
        }


        return simplifiedSentences;
    }

    /**
     * Populates two sorted sets i.e. before the conjunction and after the conunction.
     * @param partsOfSpeeches: the sorted set of the entire sentence.
     * @param partsOfSpeechBeforeConjunction: the sorted set to be populated with PartsOfSpeech before the Conjunction.
     * @param partsOfSpeechAfterConjunction: the sorted set to be populated with PartsOfSpeech after the Conjunction.
     * @return PartsOfSpeech: The PartsOfSpeech based on which split was made.
     */
    private PartsOfSpeech populateBeforeAndAfterConjunctionLists(final SortedSet<PartsOfSpeech> partsOfSpeeches,
                                                        final SortedSet<PartsOfSpeech> partsOfSpeechBeforeConjunction,
                                                        final SortedSet<PartsOfSpeech> partsOfSpeechAfterConjunction) {
        PartsOfSpeech splitPartsOfSpeech = null;
        boolean hasConjunctionAppeared = false;
        for (final PartsOfSpeech partsOfSpeech: partsOfSpeeches) {
            if(partsOfSpeech.getType().equals(PartsOfSpeech.Type.CONJUNCTION)) {
                hasConjunctionAppeared = true;
                splitPartsOfSpeech = partsOfSpeech;
                continue;
            }
            if (!hasConjunctionAppeared) {
                partsOfSpeechBeforeConjunction.add(partsOfSpeech);
            } else {
                partsOfSpeechAfterConjunction.add(partsOfSpeech);
            }
        }
        return splitPartsOfSpeech;
    }

    /**
     * Updates the second part of the sentence after the conjunction with the Noun and Verb if needed.
     * @param partsOfSpeechBeforeConjunction: PartsOfSpeech before the Conjunction.
     * @param partsOfSpeechAfterConjunction: PartsOfSpeech after the Conjunction.
     */
    private void updateConjunctionPartsBasedOnNoun(final SortedSet<PartsOfSpeech> partsOfSpeechBeforeConjunction,
                                                   final SortedSet<PartsOfSpeech> partsOfSpeechAfterConjunction) {

        /** If the first part of speech of the second part of the conjunction is not a Noun,
         * prepend the Noun from the first part. */
        final boolean toPrependNounToSecondPart =
                !partsOfSpeechAfterConjunction.first().getType().equals(PartsOfSpeech.Type.NOUN);

        /** If the first part of speech of the second part of the conjunction is not a Verb and not the Noun,
         * prepend the Verb from the first part. */
        final boolean toPrependVerbToSecondPart = toPrependNounToSecondPart &&
                !partsOfSpeechAfterConjunction.first().getType().equals(PartsOfSpeech.Type.VERB);

        if (toPrependNounToSecondPart) {
            partsOfSpeechAfterConjunction.add(partsOfSpeechBeforeConjunction.first());
        }

        if (toPrependVerbToSecondPart) {
            boolean hasFirstNounBeenEncountered = false;
            for (final PartsOfSpeech partsOfSpeech: partsOfSpeechBeforeConjunction) {
                if (partsOfSpeech.getType().equals(PartsOfSpeech.Type.NOUN)) {

                    if (!hasFirstNounBeenEncountered) {
                        hasFirstNounBeenEncountered = true;
                    } else {
                        /** Break when you encounter the second Noun, Before this Noun all the verbs have been
                         * added to the second sentence's PartOfSpeech. */
                        break;
                    }

                } else if (partsOfSpeech.getType().equals(PartsOfSpeech.Type.VERB)) {
                    if (hasFirstNounBeenEncountered) {
                        partsOfSpeechAfterConjunction.add(partsOfSpeech);
                    }
                }
            }
        }
    }

    private void mergeTaggedWordsAndPartsOfSpeechOfAConjunction(
            final List<TaggedWord> taggedWords,
            final SortedSet<PartsOfSpeech> partsOfSpeechBeforeConjunction,
            final SortedSet<PartsOfSpeech> partsOfSpeechAfterConjunction,
            final PartsOfSpeech splitPartsOfSpeech,
            final QuestionSentence questionSentence) {

        final SortedSet<Integer> sortedIndicesInPartsOfSpeech = new TreeSet<>();

        for (final PartsOfSpeech partsOfSpeech: partsOfSpeechBeforeConjunction) {
            sortedIndicesInPartsOfSpeech.add(partsOfSpeech.getIndex());
        }

        for (final PartsOfSpeech partsOfSpeech: partsOfSpeechAfterConjunction) {
            sortedIndicesInPartsOfSpeech.add(partsOfSpeech.getIndex());
        }

        int taggedWordIndex = 1;
        for (final TaggedWord taggedWord: taggedWords) {
            if (taggedWordIndex == splitPartsOfSpeech.getIndex()) {
                taggedWordIndex++;
                continue;
            }

            if (!sortedIndicesInPartsOfSpeech.contains(taggedWordIndex)) {
                final String word = taggedWord.word();
                final OtherPartsOfSpeech otherPartsOfSpeech = new OtherPartsOfSpeech(taggedWordIndex,
                        word,
                        questionSentence.getQuestionText(),
                        questionSentence.getSentenceText());

                if (word.equals(FULL_STOP)) {
                    partsOfSpeechBeforeConjunction.add(otherPartsOfSpeech);
                    partsOfSpeechAfterConjunction.add(otherPartsOfSpeech);
                } else if (taggedWordIndex < splitPartsOfSpeech.getIndex()) {
                    partsOfSpeechBeforeConjunction.add(otherPartsOfSpeech);
                } else {
                    partsOfSpeechAfterConjunction.add(otherPartsOfSpeech);
                }

            }
            taggedWordIndex++;
        }
    }

    private QuestionSentence createQuestionSentenceFromPartsOfSpeech(final SortedSet<PartsOfSpeech> partsOfSpeeches) {
        final List<String> wordList = new ArrayList<>();

        for (final PartsOfSpeech partsOfSpeech: partsOfSpeeches) {
            wordList.add(partsOfSpeech.getWord());
        }
        final String sentenceText = createSentenceFromSortedList(wordList);
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(sentenceText);

        if (questionSentences.size() > 1) {
            System.err.println("Split Sentences size greater than 1.");
        }
        return questionSentences.get(0);
    }

    private String createSentenceFromSortedList(final List<String> wordList) {
        final StringBuilder sentenceBuilder = new StringBuilder();
        int index = 0;
        for (final String word: wordList) {
            if (index == 0) {
                   index++;
            } else {
                sentenceBuilder.append(SPACE);
            }
            sentenceBuilder.append(word);
        }
        return sentenceBuilder.toString();
    }
}
