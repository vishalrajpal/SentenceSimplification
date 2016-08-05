package com.neu.sentencesimplification.stanfordcorenlp;

import edu.stanford.nlp.trees.TypedDependency;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

/**
 * OtherPartsOfSpeech: Represents a word which has not been extracted by the dependency parser.
 */
@EqualsAndHashCode
@ToString(exclude = {"mQuestionText", "mSentenceText"})
@Accessors(prefix = "m")
@Getter
public class OtherPartsOfSpeech implements PartsOfSpeech {

    private final int mIndex;
    private final String mWord;
    private final String mQuestionText;
    private final String mSentenceText;

    public OtherPartsOfSpeech(final int index,
                              final String word,
                              final String questionText,
                              final String sentenceText) {
        mIndex = index;
        mWord = word;
        mQuestionText = questionText;
        mSentenceText = sentenceText;
    }

    @Override
    public int getIndex() {
        return mIndex;
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
