package com.neu.sentencesimplification.stanfordcorenlp;

import edu.stanford.nlp.trees.TypedDependency;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Cardinal: Represents a Cardinal Number and its properties.
 */
@EqualsAndHashCode
@ToString(exclude = {"mQuestionText", "mSentenceText", "mDependency"})
public class Cardinal implements PartsOfSpeech {

    private final int mIndex;
    private final String mWord;
    private final String mQuestionText;
    private final String mSentenceText;
    private final TypedDependency mDependency;

    public Cardinal(final TypedDependency nounDependency,
                    final int index,
                    final String word,
                    final String questionText,
                    final String sentenceText) {
        mDependency = nounDependency;
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
        return PartsOfSpeech.Type.CARDINAL;
    }
}
