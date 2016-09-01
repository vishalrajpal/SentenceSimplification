package com.neu.sentencesimplification.simplifier;

import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;
import com.neu.sentencesimplification.stanfordcorenlp.PartsOfSpeech;
import com.neu.sentencesimplification.stanfordcorenlp.QuestionSentence;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class SimplifierUtilities {

    private static String SPACE = " ";
    private static String FULL_STOP = ".";

    public static QuestionSentence createQuestionSentenceFromPartsOfSpeech(final SortedSet<PartsOfSpeech> partsOfSpeeches) {
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

    private static String createSentenceFromSortedList(final List<String> wordList) {
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

        /** If the sentence does not end with a full stop, add a full stop to it.*/
        if (!sentenceBuilder.toString().endsWith(FULL_STOP)) {
            sentenceBuilder.append(FULL_STOP);
        }

        return sentenceBuilder.toString();
    }

}
