package com.neu.sentencesimplification.stanfordcorenlp;

import edu.stanford.nlp.trees.TypedDependency;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

/**
 * Determiner: Represents a determiner and its properties.
 */
@EqualsAndHashCode(exclude = "mDependencies")
@ToString(exclude = {"mQuestionText", "mSentenceText", "mDependencies"})
@Accessors(prefix = "m")
@Getter
public class Determiner implements PartsOfSpeech {

    private final SortedSet<Integer> mIndices;
    private final String mWord;
    private final String mQuestionText;
    private final String mSentenceText;
    private final Set<TypedDependency> mDependencies;

    public Determiner(final TypedDependency determinerDependency,
                      final SortedSet<Integer> indices,
                      final String word,
                      final String questionText,
                      final String sentenceText) {
        mDependencies = new HashSet<>();
        mDependencies.add(determinerDependency);

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
        return PartsOfSpeech.Type.DETERMINER;
    }

    @Override
    public void associateDependency(final TypedDependency dependency) {
        mDependencies.add(dependency);
    }
}
