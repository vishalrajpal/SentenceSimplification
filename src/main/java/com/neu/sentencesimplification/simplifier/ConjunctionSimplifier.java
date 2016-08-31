package com.neu.sentencesimplification.simplifier;

import com.neu.sentencesimplification.stanfordcorenlp.OtherPartsOfSpeech;
import com.neu.sentencesimplification.stanfordcorenlp.PartsOfSpeech;
import com.neu.sentencesimplification.stanfordcorenlp.QuestionSentence;
import edu.stanford.nlp.ling.TaggedWord;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static com.neu.sentencesimplification.simplifier.SimplifierUtilities.createQuestionSentenceFromPartsOfSpeech;

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

                final PartsOfSpeech prepositionInSecondSentence = updateConjunctionPartsBasedOnPreposition(partsOfSpeechBeforeConjunction,
                        partsOfSpeechAfterConjunction);

                mergeTaggedWordsAndPartsOfSpeechOfAConjunction(taggedWords,
                        partsOfSpeechBeforeConjunction,
                        partsOfSpeechAfterConjunction,
                        splitPartsOfSpeech,
                        questionSentence,
                        prepositionInSecondSentence);

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

        final int maxIterateCount = 2;
        int currentIterateCount = 0;

        final PartsOfSpeech firstPartsOfSpeechAfterConjunction = partsOfSpeechAfterConjunction.first();

        PartsOfSpeech secondPartsOfSpeechAfterConjunction = null;
        for (final PartsOfSpeech partsOfSpeech: partsOfSpeechAfterConjunction) {
            currentIterateCount++;
            if (currentIterateCount == maxIterateCount) {
                secondPartsOfSpeechAfterConjunction = partsOfSpeech;
                break;
            }
        }

        boolean toTakeNounFromFirstSentence = false;
        boolean toTakeVerbFromFirstSentence = false;

        /** If the pattern in the second sentence is not Noun,Verb then take both from the first sentence.
         *  If the second sentence starts with a Verb, then take the Verb from the second sentence.*/
        if (firstPartsOfSpeechAfterConjunction.getType().equals(PartsOfSpeech.Type.VERB)) {
            toTakeNounFromFirstSentence = true;
        } else if (!firstPartsOfSpeechAfterConjunction.getType().equals(PartsOfSpeech.Type.NOUN)
                && !secondPartsOfSpeechAfterConjunction.getType().equals(PartsOfSpeech.Type.VERB)) {
            toTakeNounFromFirstSentence = true;
            toTakeVerbFromFirstSentence = true;
        }

        if (toTakeNounFromFirstSentence) {
            partsOfSpeechAfterConjunction.add(partsOfSpeechBeforeConjunction.first());
        }

        if (toTakeVerbFromFirstSentence) {
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

    private PartsOfSpeech updateConjunctionPartsBasedOnPreposition(final SortedSet<PartsOfSpeech> partsOfSpeechBeforeConjunction,
                                                          final SortedSet<PartsOfSpeech> partsOfSpeechAfterConjunction) {

        //boolean prepositionExistsIn
        PartsOfSpeech lastPrepositionOfSecondSentence = null;
        final SortedSet<PartsOfSpeech> partsOfSpeechAfterLastPreposition =
                new TreeSet<>(partsOfSpeechBeforeConjunction.comparator());
        for (final PartsOfSpeech partsOfSpeech: partsOfSpeechAfterConjunction) {
            if (partsOfSpeech.getType().equals(PartsOfSpeech.Type.PREPOSITION)) {
                lastPrepositionOfSecondSentence = partsOfSpeech;
                partsOfSpeechAfterLastPreposition.clear();
                partsOfSpeechAfterLastPreposition.add(partsOfSpeech);
            } else if (lastPrepositionOfSecondSentence != null) {
                partsOfSpeechAfterLastPreposition.add(partsOfSpeech);
            }
        }

        /**
         * Currently, if finds a Preposition in the second sentence, adds it to the first sentence.
         * TODO Identify if there is a preposition in the first sentence, if not use the preposition from the second sentence
         **/
        for (final PartsOfSpeech partsOfSpeech: partsOfSpeechAfterLastPreposition) {
            partsOfSpeechBeforeConjunction.add(partsOfSpeech);
        }
        return lastPrepositionOfSecondSentence;
    }


    private void mergeTaggedWordsAndPartsOfSpeechOfAConjunction(
            final List<TaggedWord> taggedWords,
            final SortedSet<PartsOfSpeech> partsOfSpeechBeforeConjunction,
            final SortedSet<PartsOfSpeech> partsOfSpeechAfterConjunction,
            final PartsOfSpeech splitPartsOfSpeech,
            final QuestionSentence questionSentence,
            final PartsOfSpeech prepositionInSecondSentence) {

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

                /**
                 * If the word is a FULL_STOP or it is after the preposition identified in the second sentence,
                 * append it in both the sentences.
                 */
                if (word.equals(FULL_STOP) || taggedWordIndex > prepositionInSecondSentence.getIndex()) {
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
}
