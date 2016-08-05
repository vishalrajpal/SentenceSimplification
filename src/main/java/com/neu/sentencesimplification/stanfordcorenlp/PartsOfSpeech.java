package com.neu.sentencesimplification.stanfordcorenlp;

import edu.stanford.nlp.trees.TypedDependency;

import java.lang.reflect.ParameterizedType;

/**
 * PartsOfSpeech: Interface to be implemented by different PartsOfSpeech.
 */
public interface PartsOfSpeech {

    enum Type {
        ADJECTIVE,
        CARDINAL,
        CONJUNCTION,
        DETERMINER,
        EXPLETIVE,
        NOUN,
        OTHER,
        PREPOSITION,
        VERB,
        WHADVERB;
    }

    /**
     * Returns the index of the PartsOfSpeech in the sentence.
     * @return the index of the word in the sentence.
     */
    int getIndex();

    /**
     * Returns the word
     * @return the word for this PartsOfSpeech.
     */
    String getWord();

    /**
     * Returns the Type of PartOfSpeech.
     */
    PartsOfSpeech.Type getType();

    /**
     * Associate a dependency with this PartOfSpeech.
     * @param dependency The dependency to associate with this PartOfSpeech.
     */
    void associateDependency(final TypedDependency dependency);
}
