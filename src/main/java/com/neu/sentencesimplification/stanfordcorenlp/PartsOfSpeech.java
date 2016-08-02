package com.neu.sentencesimplification.stanfordcorenlp;

/**
 * PartsOfSpeech: Interface to be implemented by different PartsOfSpeech.
 */
public interface PartsOfSpeech {

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
}
