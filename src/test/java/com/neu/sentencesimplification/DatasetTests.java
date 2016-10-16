package com.neu.sentencesimplification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;
import com.neu.sentencesimplification.stanfordcorenlp.QuestionSentence;

public class DatasetTests {
	
	private static final String QUESTION_10_SENTENCE_1 = "Tom has 9 yellow balloons and Sara has 8 yellow balloons .";
	private static final String QUESTION_10_SENTENCE_1_1 = "Tom has 9 yellow balloons .";
	private static final String QUESTION_10_SENTENCE_1_2 = "Sara has 8 yellow balloons .";
	
	@Test
    public void question10_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_10_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_10_SENTENCE_1_1'", QUESTION_10_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_10_SENTENCE_1_2'", QUESTION_10_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
}