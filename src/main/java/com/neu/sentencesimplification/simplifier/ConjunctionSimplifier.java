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
            if (firstPartsOfSpeechBeforeConjunctionType.equals(PartsOfSpeech.Type.NOUN)
                    || firstPartsOfSpeechBeforeConjunctionType.equals(PartsOfSpeech.Type.EXPLETIVE)
                    || firstPartsOfSpeechBeforeConjunctionType.equals(PartsOfSpeech.Type.DETERMINER)) {
                updateConjunctionPartsBasedOnNoun1(partsOfSpeechBeforeConjunction,
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

            }
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
    private void updateConjunctionPartsBasedOnNoun1(final SortedSet<PartsOfSpeech> partsOfSpeechBeforeConjunction,
                                                    final SortedSet<PartsOfSpeech> partsOfSpeechAfterConjunction) {
        boolean toTakeDeterminer, toTakeExpletive, toTakeNoun, toTakeVerb;
        toTakeDeterminer = toTakeExpletive = toTakeNoun = toTakeVerb = false;

        final PartsOfSpeech firstPartsOfSpeechBeforeConjunction = partsOfSpeechBeforeConjunction.first();
        final PartsOfSpeech.Type firstPartsOfSpeechBeforeConjunctionType = firstPartsOfSpeechBeforeConjunction.getType();
        final PartsOfSpeech firstPartsOfSpeechAfterConjunction = partsOfSpeechAfterConjunction.first();
        final PartsOfSpeech.Type firstPartsOfSpeechAfterConjunctionType = firstPartsOfSpeechAfterConjunction.getType();

        final int maxIterateCount = 2;
        int currentIterateCount = 0;

        PartsOfSpeech secondPartsOfSpeechAfterConjunction = null;
        for (final PartsOfSpeech partsOfSpeech: partsOfSpeechAfterConjunction) {
            currentIterateCount++;
            if (currentIterateCount == maxIterateCount) {
                secondPartsOfSpeechAfterConjunction = partsOfSpeech;
                break;
            }
        }

        final PartsOfSpeech.Type secondPartsOfSpeechAfterConjunctionType = secondPartsOfSpeechAfterConjunction.getType();


        if (firstPartsOfSpeechBeforeConjunctionType.equals(PartsOfSpeech.Type.EXPLETIVE) ||
                firstPartsOfSpeechBeforeConjunctionType.equals(PartsOfSpeech.Type.DETERMINER)) {
            if (firstPartsOfSpeechAfterConjunctionType.equals(PartsOfSpeech.Type.CARDINAL)) {
                toTakeExpletive = firstPartsOfSpeechBeforeConjunctionType.equals(PartsOfSpeech.Type.EXPLETIVE);
                toTakeDeterminer = firstPartsOfSpeechBeforeConjunctionType.equals(PartsOfSpeech.Type.DETERMINER);
                toTakeNoun = true;
                toTakeVerb = true;
            } else if (firstPartsOfSpeechAfterConjunctionType.equals(PartsOfSpeech.Type.VERB)) {
                toTakeExpletive = firstPartsOfSpeechBeforeConjunctionType.equals(PartsOfSpeech.Type.EXPLETIVE);
                toTakeDeterminer = firstPartsOfSpeechBeforeConjunctionType.equals(PartsOfSpeech.Type.DETERMINER);
                toTakeNoun = true;
            } else if (firstPartsOfSpeechAfterConjunctionType.equals(PartsOfSpeech.Type.NOUN)) {
                if (!secondPartsOfSpeechAfterConjunctionType.equals(PartsOfSpeech.Type.VERB)) {
                    toTakeNoun = true;
                    toTakeVerb = true;
                }
            }
        } else if (firstPartsOfSpeechBeforeConjunctionType.equals(PartsOfSpeech.Type.NOUN)){
            if(firstPartsOfSpeechAfterConjunctionType.equals(PartsOfSpeech.Type.VERB)) {
                toTakeNoun = true;
            } else if (!firstPartsOfSpeechAfterConjunctionType.equals(PartsOfSpeech.Type.NOUN)) {
                if (!secondPartsOfSpeechAfterConjunctionType.equals(PartsOfSpeech.Type.VERB)) {
                    toTakeNoun = true;
                    toTakeVerb = true;
                }
            }
        }

        if (toTakeExpletive) {
            final PartsOfSpeech expletivePartsOfSpeech = findFirstOccurrenceOfType(partsOfSpeechBeforeConjunction,
                    PartsOfSpeech.Type.EXPLETIVE);
            partsOfSpeechAfterConjunction.add(expletivePartsOfSpeech);
        } else if (toTakeDeterminer) {
            final PartsOfSpeech determinerPartsOfSpeech = findFirstOccurrenceOfType(partsOfSpeechBeforeConjunction,
                    PartsOfSpeech.Type.DETERMINER);
            partsOfSpeechAfterConjunction.add(determinerPartsOfSpeech);
        }

        if (toTakeNoun) {
            final PartsOfSpeech nounPartsOfSpeech = findFirstOccurrenceOfType(partsOfSpeechBeforeConjunction,
                    PartsOfSpeech.Type.NOUN);
            partsOfSpeechAfterConjunction.add(nounPartsOfSpeech);
        }

        if (toTakeVerb) {
            final PartsOfSpeech verbPartsOfSpeech = findFirstOccurrenceOfType(partsOfSpeechBeforeConjunction,
                    PartsOfSpeech.Type.VERB);
            partsOfSpeechAfterConjunction.add(verbPartsOfSpeech);
        }

    }

    private PartsOfSpeech findFirstOccurrenceOfType(final SortedSet<PartsOfSpeech> partsOfSpeech,
                                                    final PartsOfSpeech.Type typeToFind) {
        PartsOfSpeech typeParrtsOfSpeech = null;
        for (final PartsOfSpeech pos: partsOfSpeech) {
            if (pos.getType().equals(typeToFind)) {
                typeParrtsOfSpeech = pos;
                break;
            }
        }
        return typeParrtsOfSpeech;
    }

    private PartsOfSpeech updateConjunctionPartsBasedOnPreposition(final SortedSet<PartsOfSpeech> partsOfSpeechBeforeConjunction,
                                                          final SortedSet<PartsOfSpeech> partsOfSpeechAfterConjunction) {

        final SortedSet<PartsOfSpeech> partsOfSpeechAfterPrepositionSecondSentence =
                new TreeSet<>(partsOfSpeechBeforeConjunction.comparator());
        final PartsOfSpeech lastPrepositionOfSecondSentence = getAndUpdatePartsOfSpeechAfterPreposition(
                partsOfSpeechAfterConjunction, partsOfSpeechAfterPrepositionSecondSentence);

        final PartsOfSpeech prepositionBeforeConjunction = findFirstOccurrenceOfType(partsOfSpeechBeforeConjunction,
                PartsOfSpeech.Type.PREPOSITION);

        if (prepositionBeforeConjunction == null) {
            for (final PartsOfSpeech partsOfSpeech : partsOfSpeechAfterPrepositionSecondSentence) {
                partsOfSpeechBeforeConjunction.add(partsOfSpeech);
            }
        } else {
            final SortedSet<PartsOfSpeech> partsOfSpeechAfterPrepositionFirstSentence =
                    new TreeSet<>(partsOfSpeechBeforeConjunction.comparator());
            getAndUpdatePartsOfSpeechAfterPreposition( partsOfSpeechBeforeConjunction, partsOfSpeechAfterPrepositionFirstSentence);
            final int firstSentencePrepositionPOSSize = partsOfSpeechAfterPrepositionFirstSentence.size();
            final int secondSentencePrepositionPOSSize = partsOfSpeechAfterPrepositionSecondSentence.size();
            if (firstSentencePrepositionPOSSize != secondSentencePrepositionPOSSize) {
                int currentIndex = 1;
                for (final PartsOfSpeech pos: partsOfSpeechAfterPrepositionSecondSentence) {
                    if (currentIndex > firstSentencePrepositionPOSSize) {
                        partsOfSpeechBeforeConjunction.add(pos);
                    }
                    currentIndex++;
                }
            }
        }
        return lastPrepositionOfSecondSentence;
    }

    private PartsOfSpeech getAndUpdatePartsOfSpeechAfterPreposition(final SortedSet<PartsOfSpeech> partsOfSpeechAfterConjunction,
                                                                    final SortedSet<PartsOfSpeech> partsOfSpeechAfterPreposition) {
        PartsOfSpeech lastPrepositionOfSecondSentence = null;
        for (final PartsOfSpeech partsOfSpeech: partsOfSpeechAfterConjunction) {
            if (partsOfSpeech.getType().equals(PartsOfSpeech.Type.PREPOSITION)) {
                lastPrepositionOfSecondSentence = partsOfSpeech;
                partsOfSpeechAfterPreposition.clear();
                partsOfSpeechAfterPreposition.add(partsOfSpeech);
            } else if (lastPrepositionOfSecondSentence != null) {
                partsOfSpeechAfterPreposition.add(partsOfSpeech);
            }
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
            sortedIndicesInPartsOfSpeech.addAll(partsOfSpeech.getIndices());
        }

        for (final PartsOfSpeech partsOfSpeech: partsOfSpeechAfterConjunction) {
            sortedIndicesInPartsOfSpeech.addAll(partsOfSpeech.getIndices());
        }

        int taggedWordIndex = 1;
        for (final TaggedWord taggedWord: taggedWords) {
            if (taggedWordIndex == splitPartsOfSpeech.getLowestIndex()) {
                taggedWordIndex++;
                continue;
            }

            if (!sortedIndicesInPartsOfSpeech.contains(taggedWordIndex)) {
                final String word = taggedWord.word();
                final SortedSet<Integer> indices = new TreeSet<>();
                indices.add(taggedWordIndex);
                final OtherPartsOfSpeech otherPartsOfSpeech = new OtherPartsOfSpeech(indices,
                        word,
                        questionSentence.getQuestionText(),
                        questionSentence.getSentenceText());

                /**
                 * If the word is a FULL_STOP or it is after the preposition identified in the second sentence,
                 * append it in both the sentences.
                 */
                //if (word.equals(FULL_STOP) || taggedWordIndex > prepositionInSecondSentence.getIndices()) {
                if (word.equals(FULL_STOP)) {
                    partsOfSpeechBeforeConjunction.add(otherPartsOfSpeech);
                    partsOfSpeechAfterConjunction.add(otherPartsOfSpeech);
                } else if (taggedWordIndex < splitPartsOfSpeech.getHighestIndex()) {
                    partsOfSpeechBeforeConjunction.add(otherPartsOfSpeech);
                } else {
                    partsOfSpeechAfterConjunction.add(otherPartsOfSpeech);
                }

            }
            taggedWordIndex++;
        }
    }
}
