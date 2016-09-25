package com.neu.sentencesimplification.stanfordcorenlp;

import edu.stanford.nlp.trees.TypedDependency;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

/**
 * Verb: Represents a Verb and its properties.
 */
@EqualsAndHashCode(exclude = "mDependencies")
@ToString(exclude = {"mQuestionText", "mSentenceText", "mDependencies"})
@Accessors(prefix = "m")
@Getter
public class Verb implements PartsOfSpeech {

    private final Set<Integer> mIndices;
    private final String mWord;
    private final String mQuestionText;
    private final String mSentenceText;
    private final Set<TypedDependency> mDependencies;

    public Verb(final TypedDependency verbDependency,
                final Set<Integer> indices,
                final String word,
                final String questionText,
                final String sentenceText) {
        mDependencies = new HashSet<>();
        mDependencies.add(verbDependency);

        mIndices = indices;
        mWord = word;
        mQuestionText = questionText;
        mSentenceText = sentenceText;
    }

    @Override
    public Set<Integer> getIndices() {
        return mIndices;
    }

    @Override
    public String getWord() {
        return mWord;
    }

    @Override
    public PartsOfSpeech.Type getType() {
        return PartsOfSpeech.Type.VERB;
    }

    @Override
    public void associateDependency(final TypedDependency dependency) {
        mDependencies.add(dependency);
    }
}
