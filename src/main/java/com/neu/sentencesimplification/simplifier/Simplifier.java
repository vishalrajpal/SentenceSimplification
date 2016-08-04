package com.neu.sentencesimplification.simplifier;

import com.neu.sentencesimplification.stanfordcorenlp.PartsOfSpeech;
import com.neu.sentencesimplification.stanfordcorenlp.QuestionSentence;
import edu.stanford.nlp.ling.TaggedWord;

import java.util.List;
import java.util.SortedSet;

/**
 * Simplifier: Interface to be implemented by all the simplifiers.
 */
public interface Simplifier {

    List<QuestionSentence> simplify(final QuestionSentence questionSentence,
                                    final List<TaggedWord> taggedWords);
}
