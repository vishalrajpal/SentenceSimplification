package com.neu.sentencesimplification.stanfordcorenlp;

import edu.stanford.nlp.trees.TypedDependency;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.SortedSet;

/**
 * OtherPartsOfSpeech: Represents a word which has not been extracted by the dependency parser.
 */
@EqualsAndHashCode
@ToString(exclude = {"mQuestionText", "mSentenceText"})
@Accessors(prefix = "m")
@Getter
public class OtherPartsOfSpeech implements PartsOfSpeech {

    private final SortedSet<Integer> mIndices;
    private final String mWord;
    private final String mQuestionText;
    private final String mSentenceText;

    public OtherPartsOfSpeech(final SortedSet<Integer> indices,
                              final String word,
                              final String questionText,
                              final String sentenceText) {
        mIndices = indices;
        mWord = word;
        mQuestionText = questionText;
        mSentenceText = sentenceText;
    }

    @Override
    public SortedSet<Integer> getIndices() {
        return mIndices;
    }

    @Override
    public int getHighestIndex() {
        return mIndices.last();
    }

    @Override
    public int getLowestIndex() {
        return mIndices.first();
    }

    @Override
    public String getWord() {
        return mWord;
    }

    @Override
    public PartsOfSpeech.Type getType() {
        return PartsOfSpeech.Type.OTHER;
    }

    @Override
    public void associateDependency(TypedDependency dependency) {}
}
