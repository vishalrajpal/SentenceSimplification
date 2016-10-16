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
	
	private static final String QUESTION_13_SENTENCE_1 = "A restaurant served 9 pizzas during lunch and 6 during dinner today .";
	private static final String QUESTION_13_SENTENCE_1_1 = "A restaurant served 9 pizzas during lunch today .";
	private static final String QUESTION_13_SENTENCE_1_2 = "A restaurant served 6 pizzas during dinner today .";
	
	@Test
    public void question13_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_13_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_13_SENTENCE_1_1'", QUESTION_13_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_13_SENTENCE_1_2'", QUESTION_13_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_15_SENTENCE_1 = "Joan found 6 seashells and Jessica found 8 seashells on the beach .";
	private static final String QUESTION_15_SENTENCE_1_1 = "Joan found 6 seashells on the beach .";
	private static final String QUESTION_15_SENTENCE_1_2 = "Jessica found 8 seashells on the beach .";
	
	@Test
    public void question15_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_15_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_15_SENTENCE_1_1'", QUESTION_15_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_15_SENTENCE_1_2'", QUESTION_15_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_17_SENTENCE_1 = "Benny picked 2 apples and Dan picked 9 apples from the apple tree .";
	private static final String QUESTION_17_SENTENCE_1_1 = "Benny picked 2 apples from the apple tree .";
	private static final String QUESTION_17_SENTENCE_1_2 = "Dan picked 9 apples from the apple tree .";
	
	@Test
    public void question17_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_17_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_17_SENTENCE_1_1'", QUESTION_17_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_17_SENTENCE_1_2'", QUESTION_17_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_18_SENTENCE_1 = "Sally found 9 seashells , Tom found 7 seashells , and Jessica found 5 seashells on the beach .";
	private static final String QUESTION_18_SENTENCE_1_1 = "Sally found 9 seashells on the beach .";
	private static final String QUESTION_18_SENTENCE_1_2 = "Tom found 7 seashells on the beach .";
	private static final String QUESTION_18_SENTENCE_1_3 = "Jessica found 5 seashells on the beach .";
	
	@Test
    public void question18_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_18_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_18_SENTENCE_1_1'", QUESTION_18_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_18_SENTENCE_1_2'", QUESTION_18_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_18_SENTENCE_1_3'", QUESTION_18_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }
	
	private static final String QUESTION_19_SENTENCE_1 = "Tim 's cat had kittens . He gave 3 to Jessica and 6 to Sara .";
	private static final String QUESTION_19_SENTENCE_1_1 = "He gave 3 kittens to Jessica .";
	private static final String QUESTION_19_SENTENCE_1_2 = "He gave 6 kittens to Sara .";
	
	@Test
    public void question19_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_19_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 2);
        final QuestionSentence questionSentence = questionSentences.get(1);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_19_SENTENCE_1_1'", QUESTION_19_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_19_SENTENCE_1_2'", QUESTION_19_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_20_SENTENCE_1 = "Joan has 9 blue balloons , Sally has 5 blue balloons , and Jessica has 2 blue balloons .";
	private static final String QUESTION_20_SENTENCE_1_1 = "Joan has 9 blue balloons .";
	private static final String QUESTION_20_SENTENCE_1_2 = "Sally has 5 blue balloons .";
	private static final String QUESTION_20_SENTENCE_1_3 = "Jessica has 2 blue balloons .";
	
	@Test
    public void question20_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_20_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_20_SENTENCE_1_1'", QUESTION_20_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_20_SENTENCE_1_2'", QUESTION_20_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_20_SENTENCE_1_3'", QUESTION_20_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }
}