package com.neu.sentencesimplification.simplifier;

import com.neu.sentencesimplification.stanfordcorenlp.PartsOfSpeech;
import com.neu.sentencesimplification.stanfordcorenlp.QuestionSentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.trees.TypedDependency;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static com.neu.sentencesimplification.simplifier.SimplifierUtilities.createQuestionSentenceFromPartsOfSpeech;

/**
 * CommaSimplifier: Simplifies the sentence based on a comma and returns the simplified sentences.
 */
public class CommaSimplifier implements Simplifier {

    private static final String COMMA = ",";

    @Override
    public List<QuestionSentence> simplify(final QuestionSentence questionSentence,
                                           final List<TaggedWord> taggedWords) {

        final String questionText = questionSentence.getQuestionText();
        final String[] commaSplitSentences = questionText.split(COMMA);
        final List<QuestionSentence> simplifiedQuestions = new ArrayList<>();
        if (commaSplitSentences.length > 1) {
            final SortedSet<PartsOfSpeech> partsOfSpeeches = questionSentence.getPartsOfSpeech();
            final String firstSentence = commaSplitSentences[0];
            final List<TaggedWord> firstSentenceTaggedWords = new ArrayList<>();
            final SortedSet<PartsOfSpeech> firstSentencePartsOfSpeech = new TreeSet<>(partsOfSpeeches.comparator());
            extractPartsOfSpeechByCommaIndex(partsOfSpeeches, taggedWords, 0, firstSentenceTaggedWords,
                    firstSentencePartsOfSpeech);
            final QuestionSentence firstSentenceQuestionSentence = createQuestionSentenceFromPartsOfSpeech(
                    firstSentencePartsOfSpeech);

            final TypedDependency firstSentenceSubjectVerbDependency = firstSentenceQuestionSentence.getSubjectVerbDependency();
            if (firstSentenceSubjectVerbDependency != null) {

                simplifiedQuestions.add(firstSentenceQuestionSentence);

                /** Assign the subject and verb to other sentences.*/
                for (int splitCounter = 1; splitCounter < commaSplitSentences.length; splitCounter++) {
                    final List<TaggedWord> currentSentenceTaggedWords = new ArrayList<>();
                    final SortedSet<PartsOfSpeech> currentSentencePartsOfSpeech = new TreeSet<>(partsOfSpeeches.comparator());
                    extractPartsOfSpeechByCommaIndex(partsOfSpeeches, taggedWords, splitCounter,
                            currentSentenceTaggedWords, currentSentencePartsOfSpeech);
                    final QuestionSentence currentSentenceQuestionSentence = createQuestionSentenceFromPartsOfSpeech(
                            currentSentencePartsOfSpeech);

                    final boolean assignNoun = currentSentenceQuestionSentence.getSubjectNounPartsOfSpeech() == null;
                    final boolean assignVerb = currentSentenceQuestionSentence.getVerbPartsOfSpeech() == null;

                    if (assignNoun) {
                        currentSentencePartsOfSpeech.add(firstSentenceQuestionSentence.getSubjectNounPartsOfSpeech());
                    }

                    if (assignVerb) {
                        currentSentencePartsOfSpeech.add(firstSentenceQuestionSentence.getVerbPartsOfSpeech());
                    }

                    if (assignNoun || assignVerb) {
                        final QuestionSentence modifiedSentenceQuestionSentence = createQuestionSentenceFromPartsOfSpeech(
                                currentSentencePartsOfSpeech);

                        simplifiedQuestions.add(modifiedSentenceQuestionSentence);
                    } else {
                        simplifiedQuestions.add(currentSentenceQuestionSentence);
                    }
                }

            }


        } else {
            simplifiedQuestions.add(questionSentence);
        }

        return simplifiedQuestions;
    }

    private final SortedSet<PartsOfSpeech> extractPartsOfSpeechByCommaIndex (
            final SortedSet<PartsOfSpeech> partsOfSpeeches,
            final List<TaggedWord> taggedWords,
            final int commaIndex,
            final List<TaggedWord> indexTaggedWords,
            final SortedSet<PartsOfSpeech> indexPartsOfSpeeches) {

        int currentCommaIndex = 0;
        int startIndex = 0;
        int endIndex = -1;
        int currentTaggedWordIndex = -1;
        final int noOfTaggedWords = taggedWords.size();

        for (final TaggedWord taggedWord: taggedWords) {
            currentTaggedWordIndex++;
            if (taggedWord.word().equals(COMMA)) {
                if (currentCommaIndex == commaIndex) {
                    endIndex = currentTaggedWordIndex - 1;
                    break;
                } else {
                    startIndex = currentTaggedWordIndex + 1;
                    currentCommaIndex++;
                }
            }

            if (endIndex == -1 && currentTaggedWordIndex == (noOfTaggedWords - 1)) {
                endIndex = currentTaggedWordIndex;
            }
        }

        if (startIndex < noOfTaggedWords && endIndex >= 0 && endIndex < noOfTaggedWords) {
            int index = 0;
            for (final PartsOfSpeech pos : partsOfSpeeches) {
                /** If the sentence after begins with a comma, ignore the conjunction.*/
                if (index == 0 && pos.getType().equals(PartsOfSpeech.Type.CONJUNCTION)) {
                    index++;
                    continue;
                }
                final int posArrIndex = pos.getIndex() - 1;
                if (posArrIndex >= startIndex && posArrIndex <= endIndex) {
                    indexPartsOfSpeeches.add(pos);
                }
            }

            for (int startCounter = startIndex; startCounter <= endIndex; startCounter++) {
                indexTaggedWords.add(taggedWords.get(startCounter));
            }
        }

        System.out.println("Start Index:" + startIndex + " End Index: " + endIndex);
        System.out.println(indexPartsOfSpeeches);
        System.out.println(indexTaggedWords);
        return indexPartsOfSpeeches;
    }
}
