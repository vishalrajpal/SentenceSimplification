package com.neu.sentencesimplification.stanfordcorenlp;

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
     *
     */
    PartsOfSpeech.Type getType();
}
