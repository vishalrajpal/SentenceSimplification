package com.neu.sentencesimplification.stanfordcorenlp;

import edu.stanford.nlp.trees.TypedDependency;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

/**
 * WHAdverb: Represents a WHAdverb and its properties.
 */
@EqualsAndHashCode(exclude = "mDependencies")
@ToString(exclude = {"mQuestionText", "mSentenceText", "mDependencies"})
@Accessors(prefix = "m")
@Getter
public class WHAdverb implements PartsOfSpeech {

    private final int mIndex;
    private final String mWord;
    private final String mQuestionText;
    private final String mSentenceText;
    private final Set<TypedDependency> mDependencies;

    public WHAdverb(final TypedDependency nounDependency,
                       final int index,
                       final String word,
                       final String questionText,
                       final String sentenceText) {
        mDependencies = new HashSet<>();
        mDependencies.add(nounDependency);

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
        return PartsOfSpeech.Type.WHADVERB;
    }

    @Override
    public void associateDependency(TypedDependency dependency) {
        mDependencies.add(dependency);
    }
}
