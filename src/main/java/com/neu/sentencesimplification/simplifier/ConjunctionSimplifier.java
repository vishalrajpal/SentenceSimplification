package com.neu.sentencesimplification.simplifier;

import com.neu.sentencesimplification.stanfordcorenlp.PartsOfSpeech;
import com.neu.sentencesimplification.stanfordcorenlp.QuestionSentence;
import edu.stanford.nlp.ling.TaggedWord;

import java.util.*;

/**
 * ConjunctionSimplifier: Simplifies a sentence based on a conjunction and returns all the simplified sentences.
 */
public class ConjunctionSimplifier implements Simplifier {

    @Override
    public List<QuestionSentence> simplify(final QuestionSentence questionSentence,
                                           final List<TaggedWord> taggedWords) {
        final SortedSet<PartsOfSpeech> partsOfSpeeches = questionSentence.getPartsOfSpeech();
        final List<QuestionSentence> simplifiedSentences = new ArrayList<>();

        if (questionSentence.hasConjunction()) {

            final SortedSet<PartsOfSpeech> partsOfSpeechBeforeConjunction = new TreeSet<>(partsOfSpeeches.comparator());
            final SortedSet<PartsOfSpeech> partsOfSpeechAfterConjunction = new TreeSet<>(partsOfSpeeches.comparator());
            populateBeforeAndAfterConjunctionLists(partsOfSpeeches,
                    partsOfSpeechBeforeConjunction,
                    partsOfSpeechAfterConjunction);

            final PartsOfSpeech firstPartsOfSpeechBeforeConjunction = partsOfSpeechBeforeConjunction.first();
            final PartsOfSpeech.Type firstPartsOfSpeechBeforeConjunctionType = firstPartsOfSpeechBeforeConjunction.getType();
            if (firstPartsOfSpeechBeforeConjunctionType.equals(PartsOfSpeech.Type.NOUN)) {
                updateConjunctionPartsBasedOnNoun(partsOfSpeechBeforeConjunction,
                        partsOfSpeechAfterConjunction);
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
     */
    private void populateBeforeAndAfterConjunctionLists(final SortedSet<PartsOfSpeech> partsOfSpeeches,
                                                        final SortedSet<PartsOfSpeech> partsOfSpeechBeforeConjunction,
                                                        final SortedSet<PartsOfSpeech> partsOfSpeechAfterConjunction) {
        boolean hasConjunctionAppeared = false;
        for (final PartsOfSpeech partsOfSpeech: partsOfSpeeches) {
            if(partsOfSpeech.getType().equals(PartsOfSpeech.Type.CONJUNCTION)) {
                hasConjunctionAppeared = true;
                continue;
            }
            if (!hasConjunctionAppeared) {
                partsOfSpeechBeforeConjunction.add(partsOfSpeech);
            } else {
                partsOfSpeechAfterConjunction.add(partsOfSpeech);
            }
        }
    }

    /**
     * Updates the second part of the sentence after the conjunction with the Noun and Verb if needed.
     * @param partsOfSpeechBeforeConjunction: PartsOfSpeech before the Conjunction.
     * @param partsOfSpeechAfterConjunction: PartsOfSpeech after the Conjunction.
     */
    private void updateConjunctionPartsBasedOnNoun(final SortedSet<PartsOfSpeech> partsOfSpeechBeforeConjunction,
                                                   final SortedSet<PartsOfSpeech> partsOfSpeechAfterConjunction) {
        final boolean toPrependNounToSecondPart = !partsOfSpeechAfterConjunction.first().getType().equals(PartsOfSpeech.Type.NOUN);
        final boolean toPrependVerbToSecondPart = !partsOfSpeechAfterConjunction.first().getType().equals(PartsOfSpeech.Type.VERB);

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
}
