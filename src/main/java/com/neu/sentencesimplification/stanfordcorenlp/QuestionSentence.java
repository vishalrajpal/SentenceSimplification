package com.neu.sentencesimplification.stanfordcorenlp;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import edu.stanford.nlp.trees.TypedDependency;
import lombok.Getter;

/**
 * QuestionSentence: An individual sentence of a question.
 */
@Getter
public class QuestionSentence {

    private final String mQuestionText;
    private final String mSentenceText;
    private final Collection<TypedDependency> mDependencies;
    private final SortedSet<PartsOfSpeech> mPartsOfSpeech;

    public QuestionSentence(final String questionText, final String sentenceText, final Collection<TypedDependency> dependencies) {
        mQuestionText = questionText;
        mSentenceText = sentenceText;
        mDependencies = dependencies;
        mPartsOfSpeech = extractSentencePartsOfSpeech();
    }

    private SortedSet<PartsOfSpeech> extractSentencePartsOfSpeech() {
        final SortedSet<PartsOfSpeech> partsOfSpeeches = new TreeSet<>();
        //TODO extract parts of speech from dependencies.

        return partsOfSpeeches;
    }
}
