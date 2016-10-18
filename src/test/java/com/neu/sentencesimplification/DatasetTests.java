package com.neu.sentencesimplification;

import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;
import com.neu.sentencesimplification.stanfordcorenlp.QuestionSentence;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	
	private static final String QUESTION_21_SENTENCE_1 = "Her dad gave her 8 dimes and her mother gave her 4 dimes .";
	private static final String QUESTION_21_SENTENCE_1_1 = "Her dad gave her 8 dimes .";
	private static final String QUESTION_21_SENTENCE_1_2 = "her mother gave her 4 dimes .";
	
	@Test
    public void question21_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_21_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_21_SENTENCE_1_1'", QUESTION_21_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_21_SENTENCE_1_2'", QUESTION_21_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_22_SENTENCE_1 = "A restaurant served 5 cakes during lunch and 6 during dinner today .";
	private static final String QUESTION_22_SENTENCE_1_1 = "A restaurant served 5 cakes during lunch today .";
	private static final String QUESTION_22_SENTENCE_1_2 = "A restaurant served 6 cakes during dinner today .";
	
	@Test
    public void question22_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_22_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_22_SENTENCE_1_1'", QUESTION_22_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_22_SENTENCE_1_2'", QUESTION_22_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_23_SENTENCE_1 = "Melanie picked 4 plums , Dan picked 9 plums , and Sally picked 3 plums from the plum tree .";
	private static final String QUESTION_23_SENTENCE_1_1 = "Melanie picked 4 plums from the plum tree .";
	private static final String QUESTION_23_SENTENCE_1_2 = "Dan picked 9 plums from the plum tree .";
	private static final String QUESTION_23_SENTENCE_1_3 = "Sally picked 3 plums from the plum tree .";
	
	@Test
    public void question23_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_23_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_23_SENTENCE_1_1'", QUESTION_23_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_23_SENTENCE_1_2'", QUESTION_23_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_23_SENTENCE_1_3'", QUESTION_23_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }
	
	private static final String QUESTION_24_SENTENCE_1 = "Park workers will plant 3 dogwood trees today and 2 dogwood trees tomorrow .";
	private static final String QUESTION_24_SENTENCE_1_1 = "Park workers will plant 3 dogwood trees today .";
	private static final String QUESTION_24_SENTENCE_1_2 = "Park workers will plant 2 dogwood trees tomorrow .";
	
	@Test
    public void question24_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_24_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_24_SENTENCE_1_1'", QUESTION_24_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_24_SENTENCE_1_2'", QUESTION_24_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_25_SENTENCE_1 = "Sara grew 4 onions , Sally grew 5 onions , and Fred grew 9 onions .";
	private static final String QUESTION_25_SENTENCE_1_1 = "Sara grew 4 onions .";
	private static final String QUESTION_25_SENTENCE_1_2 = "Sally grew 5 onions .";
	private static final String QUESTION_25_SENTENCE_1_3 = "Fred grew 9 onions .";
	
	@Test
    public void question25_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_25_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_25_SENTENCE_1_1'", QUESTION_25_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_25_SENTENCE_1_2'", QUESTION_25_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_25_SENTENCE_1_3'", QUESTION_25_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }
	
	private static final String QUESTION_26_SENTENCE_1 = "Jason has 43 blue and 16 red marbles .";
	private static final String QUESTION_26_SENTENCE_1_1 = "Jason has 43 blue marbles .";
	private static final String QUESTION_26_SENTENCE_1_2 = "Jason has 16 red marbles .";
	
	@Test
    public void question26_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_26_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_26_SENTENCE_1_1'", QUESTION_26_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_26_SENTENCE_1_2'", QUESTION_26_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_27_SENTENCE_1 = "Sam found 18 seashells and Mary found 47 seashells on the beach .";
	private static final String QUESTION_27_SENTENCE_1_1 = "Sam found 18 seashells on the beach .";
	private static final String QUESTION_27_SENTENCE_1_2 = "Mary found 47 seashells on the beach .";
	
	@Test
    public void question27_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_27_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_27_SENTENCE_1_1'", QUESTION_27_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_27_SENTENCE_1_2'", QUESTION_27_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_28_SENTENCE_1 = "Jason grew 23 watermelons and 18 turnips .";
	private static final String QUESTION_28_SENTENCE_1_1 = "Jason grew 23 watermelons .";
	private static final String QUESTION_28_SENTENCE_1_2 = "Jason grew 18 turnips .";
	
	@Test
    public void question28_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_28_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_28_SENTENCE_1_1'", QUESTION_28_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_28_SENTENCE_1_2'", QUESTION_28_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_29_SENTENCE_1 = "There are 11 rulers and 34 crayons in the drawer .";
	private static final String QUESTION_29_SENTENCE_1_1 = "There are 11 rulers in the drawer .";
	private static final String QUESTION_29_SENTENCE_1_2 = "There are 34 crayons in the drawer .";
	
	@Test
    public void question29_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_29_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_29_SENTENCE_1_1'", QUESTION_29_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_29_SENTENCE_1_2'", QUESTION_29_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_30_SENTENCE_1 = "Sara picked 45 pears and Sally picked 11 pears from the pear tree .";
	private static final String QUESTION_30_SENTENCE_1_1 = "Sara picked 45 pears from the pear tree .";
	private static final String QUESTION_30_SENTENCE_1_2 = "Sally picked 11 pears from the pear tree .";
	
	@Test
    public void question30_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_30_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_30_SENTENCE_1_1'", QUESTION_30_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_30_SENTENCE_1_2'", QUESTION_30_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_33_SENTENCE_1 = "Tom found 15 seashells and Fred found 43 seashells on the beach . When they cleaned them , they discovered that 29 were cracked .";
	private static final String QUESTION_33_SENTENCE_1_1 = "Tom found 15 seashells on the beach .";
	private static final String QUESTION_33_SENTENCE_1_2 = "Fred found 43 seashells on the beach .";
	private static final String QUESTION_33_SENTENCE_2_1 = "When they cleaned them .";
	private static final String QUESTION_33_SENTENCE_2_2 = "they discovered that 29 seashells were cracked .";
	
	@Test
    public void question33_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_33_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_33_SENTENCE_1_1'", QUESTION_33_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_33_SENTENCE_1_2'", QUESTION_33_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());
        
        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_33_SENTENCE_2_1'", QUESTION_33_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_33_SENTENCE_2_2'", QUESTION_33_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_34_SENTENCE_1 = "Sara has 31 red and 15 green balloons .";
	private static final String QUESTION_34_SENTENCE_1_1 = "Sara has 31 red balloons .";
	private static final String QUESTION_34_SENTENCE_1_2 = "Sara has 15 green balloons .";
	
	@Test
    public void question34_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_34_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_34_SENTENCE_1_1'", QUESTION_34_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_34_SENTENCE_1_2'", QUESTION_34_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_35_SENTENCE_1 = "Joan picked 37 oranges and Sara picked 10 oranges .";
	private static final String QUESTION_35_SENTENCE_1_1 = "Joan picked 37 oranges .";
	private static final String QUESTION_35_SENTENCE_1_2 = "Sara picked 10 oranges .";
	
	@Test
    public void question35_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_35_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_35_SENTENCE_1_1'", QUESTION_35_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_35_SENTENCE_1_2'", QUESTION_35_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_36_SENTENCE_1 = "Fred went to 36 basketball games this year , but missed 35 .";
	private static final String QUESTION_36_SENTENCE_1_1 = "Fred went to 36 basketball games this year .";
	private static final String QUESTION_36_SENTENCE_1_2 = "Fred missed 35 games .";
	
	@Test
    public void question36_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_36_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_36_SENTENCE_1_1'", QUESTION_36_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_36_SENTENCE_1_2'", QUESTION_36_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_37_SENTENCE_1 = "There are 33 pencils and 44 crayons in the drawer .";
	private static final String QUESTION_37_SENTENCE_1_1 = "There are 33 pencils in the drawer .";
	private static final String QUESTION_37_SENTENCE_1_2 = "There are 44 crayons in the drawer .";
	
	@Test
    public void question37_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_37_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_37_SENTENCE_1_1'", QUESTION_37_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_37_SENTENCE_1_2'", QUESTION_37_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_38_SENTENCE_1 = "Sam had 49 pennies and 24 nickels in his bank . His dad gave him 39 nickels and 31 quarters .";
	private static final String QUESTION_38_SENTENCE_1_1 = "Sam had 49 pennies in his bank .";
	private static final String QUESTION_38_SENTENCE_1_2 = "Sam had 24 nickels in his bank .";
	private static final String QUESTION_38_SENTENCE_2_1 = "His dad gave him 39 nickels .";
	private static final String QUESTION_38_SENTENCE_2_2 = "His dad gave him 31 quarters .";
	
	@Test
    public void question38_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_38_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_38_SENTENCE_1_1'", QUESTION_38_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_38_SENTENCE_1_2'", QUESTION_38_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());
        
        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_38_SENTENCE_2_1'", QUESTION_38_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_38_SENTENCE_2_2'", QUESTION_38_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_39_SENTENCE_1 = "Dan grew 42 turnips and 38 cantelopes .";
	private static final String QUESTION_39_SENTENCE_1_1 = "Dan grew 42 turnips .";
	private static final String QUESTION_39_SENTENCE_1_2 = "Dan grew 38 cantelopes .";
	
	@Test
    public void question39_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_39_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_39_SENTENCE_1_1'", QUESTION_39_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_39_SENTENCE_1_2'", QUESTION_39_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_44_SENTENCE_1 = "Joan has 40 blue balloons and Melanie has 41 blue balloons .";
	private static final String QUESTION_44_SENTENCE_1_1 = "Joan has 40 blue balloons .";
	private static final String QUESTION_44_SENTENCE_1_2 = "Melanie has 41 blue balloons .";
	
	@Test
    public void question44_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_44_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_44_SENTENCE_1_1'", QUESTION_44_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_44_SENTENCE_1_2'", QUESTION_44_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_47_SENTENCE_1 = "Mary found 18 seashells and Jessica found 41 seashells on the beach .";
	private static final String QUESTION_47_SENTENCE_1_1 = "Mary found 18 seashells on the beach .";
	private static final String QUESTION_47_SENTENCE_1_2 = "Jessica found 41 seashells on the beach .";
	
	@Test
    public void question47_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_47_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_47_SENTENCE_1_1'", QUESTION_47_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_47_SENTENCE_1_2'", QUESTION_47_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_48_SENTENCE_1 = "Park workers will plant 41 dogwood trees today and 20 dogwood trees tomorrow .";
	private static final String QUESTION_48_SENTENCE_1_1 = "Park workers will plant 41 dogwood trees today .";
	private static final String QUESTION_48_SENTENCE_1_2 = "Park workers will plant 20 dogwood trees tomorrow .";
	
	@Test
    public void question48_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_48_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_48_SENTENCE_1_1'", QUESTION_48_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_48_SENTENCE_1_2'", QUESTION_48_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
    
	private static final String QUESTION_49_SENTENCE_1 = "Sandy has 10 books , Benny has 24 books , and Tim has 33 books .";
	private static final String QUESTION_49_SENTENCE_1_1 = "Sandy has 10 books .";
	private static final String QUESTION_49_SENTENCE_1_2 = "Benny has 24 books .";
	private static final String QUESTION_49_SENTENCE_1_3 = "Tim has 33 books .";
	
	@Test
    public void question49_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_49_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_49_SENTENCE_1_1'", QUESTION_49_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_49_SENTENCE_1_2'", QUESTION_49_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_49_SENTENCE_1_3'", QUESTION_49_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }
	
	private static final String QUESTION_50_SENTENCE_1 = "Jason picked 46 pears , Keith picked 47 pears , and Mike picked 12 pears from the pear tree .";
	private static final String QUESTION_50_SENTENCE_1_1 = "Jason picked 46 pears from the pear tree .";
	private static final String QUESTION_50_SENTENCE_1_2 = "Keith picked 47 pears from the pear tree .";
	private static final String QUESTION_50_SENTENCE_1_3 = "Mike picked 12 pears from the pear tree .";
	
	@Test
    public void question50_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_50_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_50_SENTENCE_1_1'", QUESTION_50_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_50_SENTENCE_1_2'", QUESTION_50_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_50_SENTENCE_1_3'", QUESTION_50_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }
	
	private static final String QUESTION_51_SENTENCE_1 = "Keith grew 29 cantelopes , Fred grew 16 cantelopes , and Jason grew 20 cantelopes .";
	private static final String QUESTION_51_SENTENCE_1_1 = "Keith grew 29 cantelopes .";
	private static final String QUESTION_51_SENTENCE_1_2 = "Fred grew 16 cantelopes .";
	private static final String QUESTION_51_SENTENCE_1_3 = "Jason grew 20 cantelopes .";
	
	@Test
    public void question51_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_51_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_51_SENTENCE_1_1'", QUESTION_51_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_51_SENTENCE_1_2'", QUESTION_51_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_51_SENTENCE_1_3'", QUESTION_51_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }
	
	private static final String QUESTION_52_SENTENCE_1 = "Her dad gave her 39 dimes and her mother gave her 25 dimes .";
	private static final String QUESTION_52_SENTENCE_1_1 = "Her dad gave her 39 dimes .";
	private static final String QUESTION_52_SENTENCE_1_2 = "her mother gave her 25 dimes .";
	
	@Test
    public void question52_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_52_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_52_SENTENCE_1_1'", QUESTION_52_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_52_SENTENCE_1_2'", QUESTION_52_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_53_SENTENCE_1 = "Alyssa has 37 blue balloons , Sandy has 28 blue balloons , and Sally has 39 blue balloons .";
	private static final String QUESTION_53_SENTENCE_1_1 = "Alyssa has 37 blue balloons .";
	private static final String QUESTION_53_SENTENCE_1_2 = "Sandy has 28 blue balloons .";
	private static final String QUESTION_53_SENTENCE_1_3 = "Sally has 39 blue balloons .";
	
	@Test
    public void question53_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_53_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_53_SENTENCE_1_1'", QUESTION_53_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_53_SENTENCE_1_2'", QUESTION_53_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_53_SENTENCE_1_3'", QUESTION_53_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }
	
	private static final String QUESTION_55_SENTENCE_1 = "He went to 17 games last month , and plans to go to 16 games next month .";
	private static final String QUESTION_55_SENTENCE_1_1 = "He went to 17 games last month .";
	private static final String QUESTION_55_SENTENCE_1_2 = "He plans to go to 16 games next month .";
	
	@Test
    public void question55_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_55_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_55_SENTENCE_1_1'", QUESTION_55_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_55_SENTENCE_1_2'", QUESTION_55_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_56_SENTENCE_1 = "There are 43 pencils in the drawer and 19 pencils on the desk .";
	private static final String QUESTION_56_SENTENCE_1_1 = "There are 43 pencils in the drawer .";
	private static final String QUESTION_56_SENTENCE_1_2 = "There are 19 pencils on the desk .";
	
	@Test
    public void question56_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_56_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_56_SENTENCE_1_1'", QUESTION_56_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_56_SENTENCE_1_2'", QUESTION_56_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_59_SENTENCE_1 = "Dan found 56 seashells on the beach , he gave Jessica some of his seashells .";
	private static final String QUESTION_59_SENTENCE_1_1 = "Dan found 56 seashells on the beach .";
	private static final String QUESTION_59_SENTENCE_1_2 = "he gave Jessica some of his seashells .";
	
	@Test
    public void question59_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_59_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_59_SENTENCE_1_1'", QUESTION_59_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_59_SENTENCE_1_2'", QUESTION_59_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_60_SENTENCE_1 = "She went to the orchard and picked peaches to stock up .";
	private static final String QUESTION_60_SENTENCE_1_1 = "She went to the orchard .";
	private static final String QUESTION_60_SENTENCE_1_2 = "She picked peaches to stock up .";
	
	@Test
    public void question60_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_60_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_60_SENTENCE_1_1'", QUESTION_60_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_60_SENTENCE_1_2'", QUESTION_60_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_61_SENTENCE_1 = "He went to a sporting goods store and bought a baseball glove , baseball , and bat . He had 33 dollars over , how much did he spent on the baseball gear ?";
	private static final String QUESTION_61_SENTENCE_1_1 = "He went to a sporting goods store .";
	private static final String QUESTION_61_SENTENCE_1_2 = "He bought a baseball glove .";
	private static final String QUESTION_61_SENTENCE_1_3 = "He bought baseball .";
	private static final String QUESTION_61_SENTENCE_1_4 = "He bought bat .";
	private static final String QUESTION_61_SENTENCE_2_1 = "He had 33 dollars over .";
	private static final String QUESTION_61_SENTENCE_2_2 = "how much did he spent on the baseball gear ?";
	
	@Test
    public void question61_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_61_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 4.", firstSimplifiedSentences.size() == 4);
        assertEquals("First sentence should be equal to 'QUESTION_61_SENTENCE_1_1'", QUESTION_61_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_61_SENTENCE_1_2'", QUESTION_61_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_61_SENTENCE_1_3'", QUESTION_61_SENTENCE_1_3, firstSimplifiedSentences.get(2).getSentenceText());
        assertEquals("Fourth sentence should be equal to 'QUESTION_61_SENTENCE_1_4'", QUESTION_61_SENTENCE_1_4, firstSimplifiedSentences.get(3).getSentenceText());
        
        final QuestionSentence secondQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_53_SENTENCE_2_1'", QUESTION_61_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_53_SENTENCE_2_2'", QUESTION_61_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_63_SENTENCE_1 = "He washed cars over the weekend and now has 86 dollars .";
	private static final String QUESTION_63_SENTENCE_1_1 = "He washed cars over the weekend .";
	private static final String QUESTION_63_SENTENCE_1_2 = "He now has 86 dollars .";
	
	@Test
    public void question63_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_63_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_63_SENTENCE_1_1'", QUESTION_63_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_63_SENTENCE_1_2'", QUESTION_63_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_68_SENTENCE_1 = "Tom found 7 seashells but 4 were broken .";
	private static final String QUESTION_68_SENTENCE_1_1 = "Tom found 7 seashells .";
	private static final String QUESTION_68_SENTENCE_1_2 = "Tom found 4 seashells were broken .";
	
	@Test
    public void question68_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_68_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_68_SENTENCE_1_1'", QUESTION_68_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_68_SENTENCE_1_2'", QUESTION_68_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_69_SENTENCE_1 = "Sally picked 7 lemons and Mary picked 9 lemons from the lemon tree .";
	private static final String QUESTION_69_SENTENCE_1_1 = "Sally picked 7 lemons from the lemon tree .";
	private static final String QUESTION_69_SENTENCE_1_2 = "Mary picked 9 lemons from the lemon tree .";
	
	@Test
    public void question69_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_69_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_69_SENTENCE_1_1'", QUESTION_69_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_69_SENTENCE_1_2'", QUESTION_69_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_70_SENTENCE_1 = "A restaurant served 6 cakes during lunch and 9 cakes during dinner today .";
	private static final String QUESTION_70_SENTENCE_1_1 = "A restaurant served 6 cakes during lunch today .";
	private static final String QUESTION_70_SENTENCE_1_2 = "A restaurant served 9 cakes during dinner today .";
	
	@Test
    public void question70_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_70_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_70_SENTENCE_1_1'", QUESTION_70_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_70_SENTENCE_1_2'", QUESTION_70_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_71_SENTENCE_1 = "Joan has 8 orange balloons but lost 2 of them .";
	private static final String QUESTION_71_SENTENCE_1_1 = "Joan has 8 orange balloons .";
	private static final String QUESTION_71_SENTENCE_1_2 = "Joan lost 2 of them .";
	
	@Test
    public void question71_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_71_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_71_SENTENCE_1_1'", QUESTION_71_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_71_SENTENCE_1_2'", QUESTION_71_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_76_SENTENCE_1 = "Sam found 35 seashells on the beach , he gave Joan 18 of the seashells .";
	private static final String QUESTION_76_SENTENCE_1_1 = "Sam found 35 seashells on the beach .";
	private static final String QUESTION_76_SENTENCE_1_2 = "he gave Joan 18 of the seashells .";
	
	@Test
    public void question76_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_76_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_76_SENTENCE_1_1'", QUESTION_76_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_76_SENTENCE_1_2'", QUESTION_76_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_81_SENTENCE_1 = "Dan has 64 violet marbles , he gave Mary 14 of the marbles .";
	private static final String QUESTION_81_SENTENCE_1_1 = "Dan has 64 violet marbles .";
	private static final String QUESTION_81_SENTENCE_1_2 = "he gave Mary 14 of the marbles .";
	
	@Test
    public void question81_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_81_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_81_SENTENCE_1_1'", QUESTION_81_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_81_SENTENCE_1_2'", QUESTION_81_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_84_SENTENCE_1 = "Alyssa picked 42 pears and Nancy picked 17 pears from the pear tree .";
	private static final String QUESTION_84_SENTENCE_1_1 = "Alyssa picked 42 pears from the pear tree .";
	private static final String QUESTION_84_SENTENCE_1_2 = "Nancy picked 17 pears from the pear tree .";
	
	@Test
    public void question84_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_84_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_84_SENTENCE_1_1'", QUESTION_84_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_84_SENTENCE_1_2'", QUESTION_84_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_86_SENTENCE_1 = "Joan found 79 seashells on the beach , she gave Mike 63 of the seashells .";
	private static final String QUESTION_86_SENTENCE_1_1 = "Joan found 79 seashells on the beach .";
	private static final String QUESTION_86_SENTENCE_1_2 = "she gave Mike 63 of the seashells .";
	
	@Test
    public void question86_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_86_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_86_SENTENCE_1_1'", QUESTION_86_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_86_SENTENCE_1_2'", QUESTION_86_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_88_SENTENCE_1 = "Mary picked 122 oranges and Jason picked 105 oranges from the orange tree .";
	private static final String QUESTION_88_SENTENCE_1_1 = "Mary picked 122 oranges from the orange tree .";
	private static final String QUESTION_88_SENTENCE_1_2 = "Jason picked 105 oranges from the orange tree .";
	
	@Test
    public void question88_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_88_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_88_SENTENCE_1_1'", QUESTION_88_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_88_SENTENCE_1_2'", QUESTION_88_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_93_SENTENCE_1 = "Fred has 709 green balloons , he gave Sandy 221 of the balloons .";
	private static final String QUESTION_93_SENTENCE_1_1 = "Fred has 709 green balloons .";
	private static final String QUESTION_93_SENTENCE_1_2 = "he gave Sandy 221 of the balloons .";
	
	@Test
    public void question93_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_93_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_93_SENTENCE_1_1'", QUESTION_93_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_93_SENTENCE_1_2'", QUESTION_93_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_96_SENTENCE_1 = "Mike has 8 orange marbles , he gave Sam 4 of the marbles .";
	private static final String QUESTION_96_SENTENCE_1_1 = "Mike has 8 orange marbles .";
	private static final String QUESTION_96_SENTENCE_1_2 = "he gave Sam 4 of the marbles .";
	
	@Test
    public void question96_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_96_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_96_SENTENCE_1_1'", QUESTION_96_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_96_SENTENCE_1_2'", QUESTION_96_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_99_SENTENCE_1 = "Sara picked 6 pears and Tim picked 5 pears from the pear tree .";
	private static final String QUESTION_99_SENTENCE_1_1 = "Sara picked 6 pears from the pear tree .";
	private static final String QUESTION_99_SENTENCE_1_2 = "Tim picked 5 pears from the pear tree .";
	
	@Test
    public void question99_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_99_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_99_SENTENCE_1_1'", QUESTION_99_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_99_SENTENCE_1_2'", QUESTION_99_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_100_SENTENCE_1 = "Sam grew 4 watermelons , but the rabbits ate 3 watermelons .";
	private static final String QUESTION_100_SENTENCE_1_1 = "Sam grew 4 watermelons .";
	private static final String QUESTION_100_SENTENCE_1_2 = "the rabbits ate 3 watermelons .";
	
	@Test
    public void question100_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_100_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_100_SENTENCE_1_1'", QUESTION_100_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_100_SENTENCE_1_2'", QUESTION_100_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_104_SENTENCE_1 = "Mary has 9 yellow marbles and Joan has 3 yellow marbles .";
	private static final String QUESTION_104_SENTENCE_1_1 = "Mary has 9 yellow marbles .";
	private static final String QUESTION_104_SENTENCE_1_2 = "Joan has 3 yellow marbles .";
	
	@Test
    public void question104_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_104_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_104_SENTENCE_1_1'", QUESTION_104_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_104_SENTENCE_1_2'", QUESTION_104_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_113_SENTENCE_1 = "Dan picked 9 limes and gave Sara 4 of the limes .";
	private static final String QUESTION_113_SENTENCE_1_1 = "Dan picked 9 limes .";
	private static final String QUESTION_113_SENTENCE_1_2 = "Dan gave Sara 4 of the limes .";
	
	@Test
    public void question113_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_113_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_113_SENTENCE_1_1'", QUESTION_113_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_113_SENTENCE_1_2'", QUESTION_113_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_114_SENTENCE_1 = "Joan has 9 blue balloons but lost 2 of them .";
	private static final String QUESTION_114_SENTENCE_1_1 = "Joan has 9 blue balloons .";
	private static final String QUESTION_114_SENTENCE_1_2 = "Joan lost 2 of blue balloons .";
	
	@Test
    public void question114_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_114_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_114_SENTENCE_1_1'", QUESTION_114_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_114_SENTENCE_1_2'", QUESTION_114_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_115_SENTENCE_1 = "Joan picked 43 apples from the orchard , and gave 27 apples to Melanie .";
	private static final String QUESTION_115_SENTENCE_1_1 = "Joan picked 43 apples from the orchard .";
	private static final String QUESTION_115_SENTENCE_1_2 = "Joan gave 27 apples to Melanie .";
	
	@Test
    public void question115_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_115_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_115_SENTENCE_1_1'", QUESTION_115_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_115_SENTENCE_1_2'", QUESTION_115_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_116_SENTENCE_1 = "Tom has 30 violet balloons , he gave Fred 16 of the balloons .";
	private static final String QUESTION_116_SENTENCE_1_1 = "Tom has 30 violet balloons .";
	private static final String QUESTION_116_SENTENCE_1_2 = "he gave Fred 16 of the balloons .";
	
	@Test
    public void question116_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_116_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_116_SENTENCE_1_1'", QUESTION_116_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_116_SENTENCE_1_2'", QUESTION_116_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_118_SENTENCE_1 = "Fred found 47 seashells on the beach , he gave Jessica 25 of the seashells .";
	private static final String QUESTION_118_SENTENCE_1_1 = "Fred found 47 seashells on the beach .";
	private static final String QUESTION_118_SENTENCE_1_2 = "he gave Jessica 25 of the seashells .";
	
	@Test
    public void question118_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_118_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_118_SENTENCE_1_1'", QUESTION_118_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_118_SENTENCE_1_2'", QUESTION_118_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_119_SENTENCE_1 = "Sara grew 43 pumpkins , but the rabbits ate 23 pumpkins .";
	private static final String QUESTION_119_SENTENCE_1_1 = "Sara grew 43 pumpkins .";
	private static final String QUESTION_119_SENTENCE_1_2 = "the rabbits ate 23 pumpkins .";
	
	@Test
    public void question119_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_119_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_119_SENTENCE_1_1'", QUESTION_119_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_119_SENTENCE_1_2'", QUESTION_119_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_123_SENTENCE_1 = "Joan purchased a basketball game for $ 5.20 , and a racing game for $ 4.23 .";
	private static final String QUESTION_123_SENTENCE_1_1 = "Joan purchased a basketball game for $ 5.20 .";
	private static final String QUESTION_123_SENTENCE_1_2 = "Joan purchased a racing game for $ 4.23 .";
	
	@Test
    public void question123_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_123_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_123_SENTENCE_1_1'", QUESTION_123_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_123_SENTENCE_1_2'", QUESTION_123_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_124_SENTENCE_1 = "He bought a trumpet for $ 145.16 , and a song book which was $ 5.84 .";
	private static final String QUESTION_124_SENTENCE_1_1 = "He bought a trumpet for $ 145.16 .";
	private static final String QUESTION_124_SENTENCE_1_2 = "He bought a song book which was $ 5.84 .";
	
	@Test
    public void question124_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_124_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_124_SENTENCE_1_1'", QUESTION_124_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_124_SENTENCE_1_2'", QUESTION_124_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_125_SENTENCE_1 = "She bought a football for $ 5.71 , and spent $ 6.59 on marbles .";
	private static final String QUESTION_125_SENTENCE_1_1 = "She bought a football for $ 5.71 .";
	private static final String QUESTION_125_SENTENCE_1_2 = "She spent $ 6.59 on marbles .";
	
	@Test
    public void question125_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_125_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_125_SENTENCE_1_1'", QUESTION_125_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_125_SENTENCE_1_2'", QUESTION_125_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_126_SENTENCE_1 = "Jessica spent $ 10.22 on a cat toy , and a cage cost her $ 11.73 .";
	private static final String QUESTION_126_SENTENCE_1_1 = "Jessica spent $ 10.22 on a cat toy .";
	private static final String QUESTION_126_SENTENCE_1_2 = "a cage cost her $ 11.73 .";
	
	@Test
    public void question126_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_126_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_126_SENTENCE_1_1'", QUESTION_126_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_126_SENTENCE_1_2'", QUESTION_126_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_127_SENTENCE_1 = "Sara spent $ 5.36 on a hotdog and $ 5.10 on a salad .";
	private static final String QUESTION_127_SENTENCE_1_1 = "Sara spent $ 5.36 on a hotdog .";
	private static final String QUESTION_127_SENTENCE_1_2 = "Sara spent $ 5.10 on a salad .";
	
	@Test
    public void question127_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_127_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_127_SENTENCE_1_1'", QUESTION_127_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_127_SENTENCE_1_2'", QUESTION_127_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_128_SENTENCE_1 = "He spent $ 14.28 on shorts and $ 4.74 on a jacket .";
	private static final String QUESTION_128_SENTENCE_1_1 = "He spent $ 14.28 on shorts .";
	private static final String QUESTION_128_SENTENCE_1_2 = "He spent $ 4.74 on a jacket .";
	
	@Test
    public void question128_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_128_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_128_SENTENCE_1_1'", QUESTION_128_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_128_SENTENCE_1_2'", QUESTION_128_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_129_SENTENCE_1 = "Alyssa paid $ 12.08 for grapes , and $ 9.85 for cherries .";
	private static final String QUESTION_129_SENTENCE_1_1 = "Alyssa paid $ 12.08 for grapes .";
	private static final String QUESTION_129_SENTENCE_1_2 = "Alyssa paid $ 9.85 for cherries .";
	
	@Test
    public void question129_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_129_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_129_SENTENCE_1_1'", QUESTION_129_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_129_SENTENCE_1_2'", QUESTION_129_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_130_SENTENCE_1 = "Mary paid $ 11.08 for berries , $ 14.33 for apples , and $ 9.31 for peaches .";
	private static final String QUESTION_130_SENTENCE_1_1 = "Mary paid $ 11.08 for berries .";
	private static final String QUESTION_130_SENTENCE_1_2 = "Mary paid $ 14.33 for apples .";
	private static final String QUESTION_130_SENTENCE_1_3 = "Mary paid $ 9.31 for peaches .";
	
	@Test
    public void question130_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_130_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_130_SENTENCE_1_1'", QUESTION_130_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_130_SENTENCE_1_2'", QUESTION_130_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_130_SENTENCE_1_3'", QUESTION_130_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }
	
	private static final String QUESTION_131_SENTENCE_1 = "She spent $ 13.99 on shorts , $ 12.14 on a shirt , and $ 7.43 on a jacket .";
	private static final String QUESTION_131_SENTENCE_1_1 = "She spent $ 13.99 on shorts .";
	private static final String QUESTION_131_SENTENCE_1_2 = "She spent $ 12.14 on a shirt .";
	private static final String QUESTION_131_SENTENCE_1_3 = "She spent $ 7.43 on a jacket .";
	
	@Test
    public void question131_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_131_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_131_SENTENCE_1_1'", QUESTION_131_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_131_SENTENCE_1_2'", QUESTION_131_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_131_SENTENCE_1_3'", QUESTION_131_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }
	
	private static final String QUESTION_132_SENTENCE_1 = "He bought a flute for $ 142.46 , a music tool for $ 8.89 , and a song book for $ 7 .";
	private static final String QUESTION_132_SENTENCE_1_1 = "He bought a flute for $ 142.46 .";
	private static final String QUESTION_132_SENTENCE_1_2 = "He bought a music tool for $ 8.89 .";
	private static final String QUESTION_132_SENTENCE_1_3 = "He bought a song book for $ 7 .";
	
	@Test
    public void question132_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_132_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_132_SENTENCE_1_1'", QUESTION_132_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_132_SENTENCE_1_2'", QUESTION_132_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_132_SENTENCE_1_3'", QUESTION_132_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }
	
	private static final String QUESTION_133_SENTENCE_1 = "Tom purchased a football game for $ 14.02 , a strategy game for $ 9.46 , and a Batman game for $ 12.04 .";
	private static final String QUESTION_133_SENTENCE_1_1 = "Tom purchased a football game for $ 14.02 .";
	private static final String QUESTION_133_SENTENCE_1_2 = "Tom purchased a strategy game for $ 9.46 .";
	private static final String QUESTION_133_SENTENCE_1_3 = "Tom purchased a Batman game for $ 12.04 .";
	
	@Test
    public void question133_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_133_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_133_SENTENCE_1_1'", QUESTION_133_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_133_SENTENCE_1_2'", QUESTION_133_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_133_SENTENCE_1_3'", QUESTION_133_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }
	
	private static final String QUESTION_134_SENTENCE_1 = "He bought marbles for $ 9.05 , a football for $ 4.95 , and spent $ 6.52 on a baseball .";
	private static final String QUESTION_134_SENTENCE_1_1 = "He bought marbles for $ 9.05 .";
	private static final String QUESTION_134_SENTENCE_1_2 = "He bought a football for $ 4.95 .";
	private static final String QUESTION_134_SENTENCE_1_3 = "He spent $ 6.52 on a baseball .";
	
	@Test
    public void question134_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_134_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_134_SENTENCE_1_1'", QUESTION_134_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_134_SENTENCE_1_2'", QUESTION_134_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_134_SENTENCE_1_3'", QUESTION_134_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }
	
	private static final String QUESTION_135_SENTENCE_1 = "It stops in the Bahamas , where sailors load 8723 tons of cargo onboard .";
	private static final String QUESTION_135_SENTENCE_1_1 = "It stops in the Bahamas .";
	private static final String QUESTION_135_SENTENCE_1_2 = "where sailors load 8723 tons of cargo onboard .";
	
	@Test
    public void question135_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_135_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_135_SENTENCE_1_1'", QUESTION_135_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_135_SENTENCE_1_2'", QUESTION_135_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_136_SENTENCE_1 = "During December , they buy 6444 muffs , and there are none .";
	private static final String QUESTION_136_SENTENCE_1_1 = "During December they buy 6444 muffs .";
	private static final String QUESTION_136_SENTENCE_1_2 = "During December there are none .";
	
	@Test
    public void question136_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_136_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_136_SENTENCE_1_1'", QUESTION_136_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_136_SENTENCE_1_2'", QUESTION_136_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_137_SENTENCE_1 = "This year , she bought some new hives and increased her honey harvest by 6085 pounds .";
	private static final String QUESTION_137_SENTENCE_1_1 = "This year she bought some new hives .";
	private static final String QUESTION_137_SENTENCE_1_2 = "This year she increased her honey harvest by 6085 pounds .";
	
	@Test
    public void question137_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_137_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_137_SENTENCE_1_1'", QUESTION_137_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_137_SENTENCE_1_2'", QUESTION_137_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_138_SENTENCE_1 = "Before engineers started to fix the pipe , 6522 liters of oil leaked into the water . While the engineers worked , the pipe leaked 5165 liters of oil .";
	private static final String QUESTION_138_SENTENCE_1_1 = "Before engineers started to fix the pipe .";
	private static final String QUESTION_138_SENTENCE_1_2 = "6522 liters of oil leaked into the water .";
	private static final String QUESTION_138_SENTENCE_2_1 = "While the engineers worked .";
	private static final String QUESTION_138_SENTENCE_2_2 = "the pipe leaked 5165 liters of oil .";
	
	@Test
    public void question138_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_138_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_138_SENTENCE_1_1'", QUESTION_138_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_138_SENTENCE_1_2'", QUESTION_138_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());
        
        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_138_SENTENCE_2_1'", QUESTION_138_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_138_SENTENCE_2_2'", QUESTION_138_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_139_SENTENCE_1 = "A car company produced 3884 cars in North America and 2871 cars in Europe .";
	private static final String QUESTION_139_SENTENCE_1_1 = "A car company produced 3884 cars in North America .";
	private static final String QUESTION_139_SENTENCE_1_2 = "A car company produced 2871 cars in Europe .";
	
	@Test
    public void question139_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_139_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_139_SENTENCE_1_1'", QUESTION_139_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_139_SENTENCE_1_2'", QUESTION_139_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_140_SENTENCE_1 = "Abe 's family moved from the Bahamas to Japan , so they had convert their money into Japanese yen . Their checking account now has 6359 yen and their savings account now has 3485 yen .";
	private static final String QUESTION_140_SENTENCE_1_1 = "Abe 's family moved from the Bahamas to Japan .";
	private static final String QUESTION_140_SENTENCE_1_2 = "so they had convert their money into Japanese yen .";
	private static final String QUESTION_140_SENTENCE_2_1 = "Their checking account now has 6359 yen .";
	private static final String QUESTION_140_SENTENCE_2_2 = "their savings account now has 3485 yen .";
	
	@Test
    public void question140_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_140_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_140_SENTENCE_1_1'", QUESTION_140_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_140_SENTENCE_1_2'", QUESTION_140_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());
        
        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_140_SENTENCE_2_1'", QUESTION_140_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_140_SENTENCE_2_2'", QUESTION_140_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_143_SENTENCE_1 = "The weather is perfect during the growing season , so he harvests 684 bushels of wheat than expected .";
	private static final String QUESTION_143_SENTENCE_1_1 = "The weather is perfect during the growing season .";
	private static final String QUESTION_143_SENTENCE_1_2 = "so he harvests 684 bushels of wheat than expected .";
	
	@Test
    public void question143_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_143_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_143_SENTENCE_1_1'", QUESTION_143_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_143_SENTENCE_1_2'", QUESTION_143_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_146_SENTENCE_1 = "It covers 64535 acres of the prairie in dust , but leaves 522 acres untouched .";
	private static final String QUESTION_146_SENTENCE_1_1 = "It covers 64535 acres of the prairie in dust .";
	private static final String QUESTION_146_SENTENCE_1_2 = "It leaves 522 acres untouched .";
	
	@Test
    public void question146_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_146_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_146_SENTENCE_1_1'", QUESTION_146_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_146_SENTENCE_1_2'", QUESTION_146_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_147_SENTENCE_1 = "There are 12170 ladybugs with spots and 54912 ladybugs without spots .";
	private static final String QUESTION_147_SENTENCE_1_1 = "There are 12170 ladybugs with spots .";
	private static final String QUESTION_147_SENTENCE_1_2 = "There are 54912 ladybugs without spots .";
	
	@Test
    public void question147_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_147_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_147_SENTENCE_1_1'", QUESTION_147_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_147_SENTENCE_1_2'", QUESTION_147_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_148_SENTENCE_1 = "Last year , 90171 people were born in a country , and 16320 people immigrated to it .";
	private static final String QUESTION_148_SENTENCE_1_1 = "Last year 90171 people were born in a country .";
	private static final String QUESTION_148_SENTENCE_1_2 = "Last year 16320 people immigrated to it .";
	
	@Test
    public void question148_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_148_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_148_SENTENCE_1_1'", QUESTION_148_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_148_SENTENCE_1_2'", QUESTION_148_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_150_SENTENCE_1 = "To fill an order , the factory dyed 61921 yards of silk green and 49500 yards pink .";
	private static final String QUESTION_150_SENTENCE_1_1 = "To fill an order the factory dyed 61921 yards of silk green .";
	private static final String QUESTION_150_SENTENCE_1_2 = "To fill an order the factory dyed 49500 yards of silk pink .";
	
	@Test
    public void question150_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_150_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_150_SENTENCE_1_1'", QUESTION_150_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_150_SENTENCE_1_2'", QUESTION_150_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_151_SENTENCE_1 = "A multi-national corporation has 2041 part-time employees and 63093 full-time employees .";
	private static final String QUESTION_151_SENTENCE_1_1 = "A multi-national corporation has 2041 part-time employees .";
	private static final String QUESTION_151_SENTENCE_1_2 = "A multi-national corporation has 63093 full-time employees .";
	
	@Test
    public void question151_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_151_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_151_SENTENCE_1_1'", QUESTION_151_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_151_SENTENCE_1_2'", QUESTION_151_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_152_SENTENCE_1 = "This year , 712261 male and 259378 female salmon returned to their rivers .";
	private static final String QUESTION_152_SENTENCE_1_1 = "This year 712261 male salmon returned to their rivers .";
	private static final String QUESTION_152_SENTENCE_1_2 = "This year 259378 female salmon returned to their rivers .";
	
	@Test
    public void question152_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_152_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_152_SENTENCE_1_1'", QUESTION_152_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_152_SENTENCE_1_2'", QUESTION_152_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_156_SENTENCE_1 = "If they have sold 3513 pounds of frozen fruit , how many pounds of fresh fruit have been sold so far ?";
	private static final String QUESTION_156_SENTENCE_1_1 = "If they have sold 3513 pounds of frozen fruit .";
	private static final String QUESTION_156_SENTENCE_1_2 = "how many pounds of fresh fruit have been sold so far ?";
	
	@Test
    public void question156_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_156_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_156_SENTENCE_1_1'", QUESTION_156_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_156_SENTENCE_1_2'", QUESTION_156_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_157_SENTENCE_1 = "If her fund was worth $ 1472 before , how much is it worth now ?";
	private static final String QUESTION_157_SENTENCE_1_1 = "If her fund was worth $ 1472 before .";
	private static final String QUESTION_157_SENTENCE_1_2 = "how much is it worth now ?";
	
	@Test
    public void question157_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_157_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_157_SENTENCE_1_1'", QUESTION_157_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_157_SENTENCE_1_2'", QUESTION_157_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_158_SENTENCE_1 = "If they sold 3867 tickets in the first half of the season , how many tickets did they sell in the second half ?";
	private static final String QUESTION_158_SENTENCE_1_1 = "If they sold 3867 tickets in the first half of the season .";
	private static final String QUESTION_158_SENTENCE_1_2 = "how many tickets did they sell in the second half ?";
	
	@Test
    public void question158_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_158_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_158_SENTENCE_1_1'", QUESTION_158_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_158_SENTENCE_1_2'", QUESTION_158_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_159_SENTENCE_1 = "A scientist let the bacteria grow and now there are 8917 of them .";
	private static final String QUESTION_159_SENTENCE_1_1 = "A scientist let the bacteria grow .";
	private static final String QUESTION_159_SENTENCE_1_2 = "now there are 8917 of bacteria .";
	
	@Test
    public void question159_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_159_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_159_SENTENCE_1_1'", QUESTION_159_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_159_SENTENCE_1_2'", QUESTION_159_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_160_SENTENCE_1 = "If she picked up 344 pieces of trash in the classrooms , how many pieces of trash did Tori pick up outside the classrooms ?";
	private static final String QUESTION_160_SENTENCE_1_1 = "If she picked up 344 pieces of trash in the classrooms .";
	private static final String QUESTION_160_SENTENCE_1_2 = "how many pieces of trash did Tori pick up outside the classrooms ?";
	
	@Test
    public void question160_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_160_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_160_SENTENCE_1_1'", QUESTION_160_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_160_SENTENCE_1_2'", QUESTION_160_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_161_SENTENCE_1 = "If her employees used a total of 1339 eggs today , how many eggs did they use in the afternoon ?";
	private static final String QUESTION_161_SENTENCE_1_1 = "If her employees used a total of 1339 eggs today .";
	private static final String QUESTION_161_SENTENCE_1_2 = "how many eggs did they use in the afternoon ?";
	
	@Test
    public void question161_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_161_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_161_SENTENCE_1_1'", QUESTION_161_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_161_SENTENCE_1_2'", QUESTION_161_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_163_SENTENCE_1 = "6922 coats were collected from the high schools , and the rest from the elementary schools .";
	private static final String QUESTION_163_SENTENCE_1_1 = "6922 coats were collected from the high schools .";
	private static final String QUESTION_163_SENTENCE_1_2 = "the rest coats were collected from the elementary schools .";
	
	@Test
    public void question163_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_163_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_163_SENTENCE_1_1'", QUESTION_163_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_163_SENTENCE_1_2'", QUESTION_163_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_164_SENTENCE_1 = "If they used 660 gallons of white paint , how many gallons of blue paint did the company use ?";
	private static final String QUESTION_164_SENTENCE_1_1 = "If they used 660 gallons of white paint .";
	private static final String QUESTION_164_SENTENCE_1_2 = "how many gallons of blue paint did the company use ?";
	
	@Test
    public void question164_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_164_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_164_SENTENCE_1_1'", QUESTION_164_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_164_SENTENCE_1_2'", QUESTION_164_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_166_SENTENCE_1 = "If 723 of its customers live in the United States , how many of its customers live in other countries ?";
	private static final String QUESTION_166_SENTENCE_1_1 = "If 723 of its customers live in the United States .";
	private static final String QUESTION_166_SENTENCE_1_2 = "how many of its customers live in other countries ?";
	
	@Test
    public void question166_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_166_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_166_SENTENCE_1_1'", QUESTION_166_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_166_SENTENCE_1_2'", QUESTION_166_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_168_SENTENCE_1 = "Before engineers started to fix the pipe , 2475 gallons of oil leaked into the water .";
	private static final String QUESTION_168_SENTENCE_1_1 = "Before engineers started to fix the pipe .";
	private static final String QUESTION_168_SENTENCE_1_2 = "2475 gallons of oil leaked into the water .";
	
	@Test
    public void question168_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_168_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_168_SENTENCE_1_1'", QUESTION_168_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_168_SENTENCE_1_2'", QUESTION_168_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_169_SENTENCE_1 = "45 of the gems were diamonds , and the rest were rubies .";
	private static final String QUESTION_169_SENTENCE_1_1 = "45 of the gems were diamonds .";
	private static final String QUESTION_169_SENTENCE_1_2 = "the rest of the gems were rubies .";
	
	@Test
    public void question169_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_169_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_169_SENTENCE_1_1'", QUESTION_169_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_169_SENTENCE_1_2'", QUESTION_169_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_170_SENTENCE_1 = "If they have 4518 grams of blueberry jelly , how many grams of strawberry jelly do they have ?";
	private static final String QUESTION_170_SENTENCE_1_1 = "If they have 4518 grams of blueberry jelly .";
	private static final String QUESTION_170_SENTENCE_1_2 = "how many grams of strawberry jelly do they have ?";
	
	@Test
    public void question170_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_170_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_170_SENTENCE_1_1'", QUESTION_170_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_170_SENTENCE_1_2'", QUESTION_170_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_171_SENTENCE_1 = "He and his cousin together have a total of 5816 points .";
	private static final String QUESTION_171_SENTENCE_1_1 = "He and his cousin together have a total of 5816 points .";
	
	@Test
    public void question171_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_171_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 1);
        assertEquals("First sentence should be equal to 'QUESTION_171_SENTENCE_1_1'", QUESTION_171_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
    }
	
	private static final String QUESTION_173_SENTENCE_1 = "Now there are 3263 algae plants , and the lake has turned green .";
	private static final String QUESTION_173_SENTENCE_1_1 = "Now there are 3263 algae plants .";
	private static final String QUESTION_173_SENTENCE_1_2 = "the lake has turned green .";
	
	@Test
    public void question173_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_173_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_173_SENTENCE_1_1'", QUESTION_173_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_173_SENTENCE_1_2'", QUESTION_173_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_174_SENTENCE_1 = "Oscar 's bus ride to school is 0.75 mile and Charlie 's bus ride is 0.25 mile .";
	private static final String QUESTION_174_SENTENCE_1_1 = "Oscar 's bus ride to school is 0.75 mile .";
	private static final String QUESTION_174_SENTENCE_1_2 = "Charlie 's bus ride is 0.25 mile .";
	
	@Test
    public void question174_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_174_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_174_SENTENCE_1_1'", QUESTION_174_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_174_SENTENCE_1_2'", QUESTION_174_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_176_SENTENCE_1 = "Kendall is learning to drive , so this weekend she practiced driving 0.16666666666666666 mile with her mother and another 0.5 mile with her father .";
	private static final String QUESTION_176_SENTENCE_1_1 = "Kendall is learning to drive .";
	private static final String QUESTION_176_SENTENCE_1_2 = "so this weekend she practiced driving 0.16666666666666666 mile with her mother .";
	private static final String QUESTION_176_SENTENCE_1_3 = "so this weekend she practiced driving 0.5 mile with her father .";
	
	@Test
    public void question176_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_176_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_176_SENTENCE_1_1'", QUESTION_176_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_176_SENTENCE_1_2'", QUESTION_176_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_176_SENTENCE_1_3'", QUESTION_176_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }
	
	private static final String QUESTION_178_SENTENCE_1 = "A tailor cut 0.75 inch off a skirt and 0.5 inch off a pair of pants .";
	private static final String QUESTION_178_SENTENCE_1_1 = "A tailor cut 0.75 inch off a skirt .";
	private static final String QUESTION_178_SENTENCE_1_2 = "A tailor cut 0.5 inch off a pair of pants .";
	
	@Test
    public void question178_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_178_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_178_SENTENCE_1_1'", QUESTION_178_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_178_SENTENCE_1_2'", QUESTION_178_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_180_SENTENCE_1 = "Darnel sprinted 0.875 lap and then took a break by jogging 0.75 lap .";
	private static final String QUESTION_180_SENTENCE_1_1 = "Darnel sprinted 0.875 lap .";
	private static final String QUESTION_180_SENTENCE_1_2 = "Darnel then took a break by jogging 0.75 lap .";
	
	@Test
    public void question180_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_180_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_180_SENTENCE_1_1'", QUESTION_180_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_180_SENTENCE_1_2'", QUESTION_180_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }
	
	private static final String QUESTION_301_SENTENCE_1 = "There are 9 pencils and 4 rulers in the drawer .";
    private static final String QUESTION_301_SENTENCE_1_1 = "There are 9 pencils in the drawer .";
    private static final String QUESTION_301_SENTENCE_1_2 = "There are 4 rulers in the drawer .";
    
    @Test
    public void question301_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_301_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_301_SENTENCE_1_1'", QUESTION_301_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_301_SENTENCE_1_2'", QUESTION_301_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_302_SENTENCE_1 = "Jason has 7 violet balloons and 4 red balloons .";
    private static final String QUESTION_302_SENTENCE_1_1 = "Jason has 7 violet balloons .";
    private static final String QUESTION_302_SENTENCE_1_2 = "Jason has 4 red balloons .";

    @Test
    public void question302_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_302_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_302_SENTENCE_1_1'", QUESTION_302_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_302_SENTENCE_1_2'", QUESTION_302_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_303_SENTENCE_1 = "Dan had 7 potatoes and 4 cantelopes in the garden .";
    private static final String QUESTION_303_SENTENCE_1_1 = "Dan had 7 potatoes in the garden .";
    private static final String QUESTION_303_SENTENCE_1_2 = "Dan had 4 cantelopes in the garden .";

    @Test
    public void question303_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_303_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_303_SENTENCE_1_1'", QUESTION_303_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_303_SENTENCE_1_2'", QUESTION_303_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_304_SENTENCE_1 = "Sara had 4 quarters and 8 dimes in her bank .";
    private static final String QUESTION_304_SENTENCE_1_1 = "Sara had 4 quarters in her bank .";
    private static final String QUESTION_304_SENTENCE_1_2 = "Sara had 8 dimes in her bank .";

    @Test
    public void question304_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_304_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_304_SENTENCE_1_1'", QUESTION_304_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_304_SENTENCE_1_2'", QUESTION_304_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_305_SENTENCE_1 = "Sandy 's dog had 8 puppies and 4 had spots .";
    private static final String QUESTION_305_SENTENCE_1_1 = "Sandy 's dog had 8 puppies .";
    private static final String QUESTION_305_SENTENCE_1_2 = "4 puppies had spots .";

    @Test
    public void question305_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_305_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_305_SENTENCE_1_1'", QUESTION_305_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_305_SENTENCE_1_2'", QUESTION_305_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_306_SENTENCE_1 = "Mike found 6 seashells and 4 starfish , but 4 of the seashells were broken .";
    private static final String QUESTION_306_SENTENCE_1_1 = "Mike found 6 seashells .";
    private static final String QUESTION_306_SENTENCE_1_2 = "Mike found 4 starfish .";
    private static final String QUESTION_306_SENTENCE_1_3 = "Mike found 4 of the seashells were broken .";

    @Test
    public void question306_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_306_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_306_SENTENCE_1_1'", QUESTION_306_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_306_SENTENCE_1_2'", QUESTION_306_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_306_SENTENCE_1_3'", QUESTION_306_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }

    private static final String QUESTION_307_SENTENCE_1 = "Melanie had 30 baseball cards , and 9 were torn .";
    private static final String QUESTION_307_SENTENCE_1_1 = "Melanie had 30 baseball cards .";
    private static final String QUESTION_307_SENTENCE_1_2 = "Melanie had 9 cards were torn .";

    @Test
    public void question307_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_307_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_307_SENTENCE_1_1'", QUESTION_307_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_307_SENTENCE_1_2'", QUESTION_307_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_308_SENTENCE_1 = "Sara picked 35 pears and 27 apples from the orchard .";
    private static final String QUESTION_308_SENTENCE_1_1 = "Sara picked 35 pears from the orchard .";
    private static final String QUESTION_308_SENTENCE_1_2 = "Sara picked 27 apples from the orchard .";

    @Test
    public void question308_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_308_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_308_SENTENCE_1_1'", QUESTION_308_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_308_SENTENCE_1_2'", QUESTION_308_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_309_SENTENCE_1 = "Jessica grew 35 watermelons and 30 carrots , but the rabbits ate 27 watermelons .";
    private static final String QUESTION_309_SENTENCE_1_1 = "Jessica grew 35 watermelons .";
    private static final String QUESTION_309_SENTENCE_1_2 = "Jessica grew 30 carrots .";
    private static final String QUESTION_309_SENTENCE_1_3 = "the rabbits ate 27 watermelons .";

    @Test
    public void question309_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_309_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_309_SENTENCE_1_1'", QUESTION_309_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_309_SENTENCE_1_2'", QUESTION_309_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_309_SENTENCE_1_3'", QUESTION_309_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }

    private static final String QUESTION_310_SENTENCE_1 = "Nancy found 35 seashells and 25 starfish on the beach .";
    private static final String QUESTION_310_SENTENCE_1_1 = "Nancy found 35 seashells on the beach .";
    private static final String QUESTION_310_SENTENCE_1_2 = "Nancy found 25 starfish on the beach .";

    @Test
    public void question310_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_310_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_310_SENTENCE_1_1'", QUESTION_310_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_310_SENTENCE_1_2'", QUESTION_310_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_311_SENTENCE_1 = "Joan has 47 green and 48 red marbles .";
    private static final String QUESTION_311_SENTENCE_1_1 = "Joan has 47 green marbles .";
    private static final String QUESTION_311_SENTENCE_1_2 = "Joan has 48 red marbles .";

    @Test
    public void question311_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_311_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_311_SENTENCE_1_1'", QUESTION_311_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_311_SENTENCE_1_2'", QUESTION_311_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_312_SENTENCE_1 = "There are 42 walnut trees and 12 orange trees currently in the park .";
    private static final String QUESTION_312_SENTENCE_1_1 = "There are 42 walnut trees in the park .";
    private static final String QUESTION_312_SENTENCE_1_2 = "There are 12 orange trees currently in the park .";

    @Test
    public void question312_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_312_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_312_SENTENCE_1_1'", QUESTION_312_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_312_SENTENCE_1_2'", QUESTION_312_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_313_SENTENCE_1 = "Sandy had 36 pennies and 31 nickels in her bank .";
    private static final String QUESTION_313_SENTENCE_1_1 = "Sandy had 36 pennies in her bank .";
    private static final String QUESTION_313_SENTENCE_1_2 = "Sandy had 31 nickels in her bank .";

    @Test
    public void question313_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_313_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_313_SENTENCE_1_1'", QUESTION_313_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_313_SENTENCE_1_2'", QUESTION_313_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_314_SENTENCE_1 = "There are 34 pencils and 49 crayons in the drawer .";
    private static final String QUESTION_314_SENTENCE_1_1 = "There are 34 pencils in the drawer .";
    private static final String QUESTION_314_SENTENCE_1_2 = "There are 49 crayons in the drawer .";

    @Test
    public void question314_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_314_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_314_SENTENCE_1_1'", QUESTION_314_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_314_SENTENCE_1_2'", QUESTION_314_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_315_SENTENCE_1 = "Sally paid $ 12.32 total for peaches , after a 3 dollar coupon , and $ 11.54 for cherries .";
    private static final String QUESTION_315_SENTENCE_1_1 = "Sally paid $ 12.32 total for peaches .";
    private static final String QUESTION_315_SENTENCE_1_2 = "Sally paid after a 3 dollar coupon .";
    private static final String QUESTION_315_SENTENCE_1_3 = "Sally paid $ 11.54 for cherries .";

    @Test
    public void question315_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_315_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_315_SENTENCE_1_1'", QUESTION_315_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_315_SENTENCE_1_2'", QUESTION_315_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_315_SENTENCE_1_3'", QUESTION_315_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }

    private static final String QUESTION_316_SENTENCE_1 = "Dan spent $ 11.76 on a snake toy , and a cage cost him $ 14.54 .";
    private static final String QUESTION_316_SENTENCE_1_1 = "Dan spent $ 11.76 on a snake toy .";
    private static final String QUESTION_316_SENTENCE_1_2 = "a cage cost him $ 14.54 .";

    @Test
    public void question316_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_316_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_316_SENTENCE_1_1'", QUESTION_316_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_316_SENTENCE_1_2'", QUESTION_316_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_317_SENTENCE_1 = "She spent $ 13.04 on a shirt and $ 12.27 on a jacket .";
    private static final String QUESTION_317_SENTENCE_1_1 = "She spent $ 13.04 on a shirt .";
    private static final String QUESTION_317_SENTENCE_1_2 = "She spent $ 12.27 on a jacket .";

    @Test
    public void question317_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_317_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_317_SENTENCE_1_1'", QUESTION_317_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_317_SENTENCE_1_2'", QUESTION_317_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_318_SENTENCE_1 = "He bought a clarinet for $ 130.30 , and a song book which was $ 11.24 .";
    private static final String QUESTION_318_SENTENCE_1_1 = "He bought a clarinet for $ 130.30 .";
    private static final String QUESTION_318_SENTENCE_1_2 = "He bought a song book which was $ 11.24 .";

    @Test
    public void question318_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_318_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_318_SENTENCE_1_1'", QUESTION_318_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_318_SENTENCE_1_2'", QUESTION_318_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_319_SENTENCE_1 = "Tom bought a skateboard for $ 9.46 , and spent $ 9.56 on marbles .";
    private static final String QUESTION_319_SENTENCE_1_1 = "Tom bought a skateboard for $ 9.46 .";
    private static final String QUESTION_319_SENTENCE_1_2 = "Tom spent $ 9.56 on marbles .";

    @Test
    public void question319_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_319_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_319_SENTENCE_1_1'", QUESTION_319_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_319_SENTENCE_1_2'", QUESTION_319_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_320_SENTENCE_1 = "Mary spent $ 1.08 on soup and $ 4.80 on a salad .";
    private static final String QUESTION_320_SENTENCE_1_1 = "Mary spent $ 1.08 on soup .";
    private static final String QUESTION_320_SENTENCE_1_2 = "Mary spent $ 4.80 on a salad .";

    @Test
    public void question320_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_320_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_320_SENTENCE_1_1'", QUESTION_320_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_320_SENTENCE_1_2'", QUESTION_320_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_321_SENTENCE_1 = "For his car , Mike spent $ 118.54 on speakers and $ 106.33 on new tires .";
    private static final String QUESTION_321_SENTENCE_1_1 = "For his car Mike spent $ 118.54 on speakers .";
    private static final String QUESTION_321_SENTENCE_1_2 = "For his car Mike spent $ 106.33 on new tires .";

    @Test
    public void question321_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_321_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_321_SENTENCE_1_1'", QUESTION_321_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_321_SENTENCE_1_2'", QUESTION_321_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_322_SENTENCE_1 = "Tom purchased a Batman game for $ 13.60 , and a Superman game for $ 5.06 .";
    private static final String QUESTION_322_SENTENCE_1_1 = "Tom purchased a Batman game for $ 13.60 .";
    private static final String QUESTION_322_SENTENCE_1_2 = "Tom purchased a Superman game for $ 5.06 .";

    @Test
    public void question322_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_322_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_322_SENTENCE_1_1'", QUESTION_322_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_322_SENTENCE_1_2'", QUESTION_322_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_323_SENTENCE_1 = "Joan spent $ 15 on shorts and $ 14.82 on a jacket , and $ 12.51 on a shirt .";
    private static final String QUESTION_323_SENTENCE_1_1 = "Joan spent $ 15 on shorts .";
    private static final String QUESTION_323_SENTENCE_1_2 = "Joan spent $ 14.82 on a jacket .";
    private static final String QUESTION_323_SENTENCE_1_3 = "Joan spent $ 12.51 on a shirt .";

    @Test
    public void question323_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_323_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_323_SENTENCE_1_1'", QUESTION_323_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_323_SENTENCE_1_2'", QUESTION_323_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_323_SENTENCE_1_3'", QUESTION_323_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }

    private static final String QUESTION_324_SENTENCE_1 = "She bought a trumpet for $ 149.16 , a music tool for $ 9.98 , and a song book which was $ 4.14 .";
    private static final String QUESTION_324_SENTENCE_1_1 = "She bought a trumpet for $ 149.16 .";
    private static final String QUESTION_324_SENTENCE_1_2 = "She bought a music tool for $ 9.98 .";
    private static final String QUESTION_324_SENTENCE_1_3 = "She bought a song book which was $ 4.14 .";

    @Test
    public void question324_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_324_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_324_SENTENCE_1_1'", QUESTION_324_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_324_SENTENCE_1_2'", QUESTION_324_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_324_SENTENCE_1_3'", QUESTION_324_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }

    private static final String QUESTION_325_SENTENCE_1 = "Melanie bought a Batman game for $ 6.95 , a strategy game for $ 7.90 , and a Superman game for $ 7.73 .";
    private static final String QUESTION_325_SENTENCE_1_1 = "Melanie bought a Batman game for $ 6.95 .";
    private static final String QUESTION_325_SENTENCE_1_2 = "Melanie bought a strategy game for $ 7.90 .";
    private static final String QUESTION_325_SENTENCE_1_3 = "Melanie bought a Superman game for $ 7.73 .";

    @Test
    public void question325_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_325_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_325_SENTENCE_1_1'", QUESTION_325_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_325_SENTENCE_1_2'", QUESTION_325_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_325_SENTENCE_1_3'", QUESTION_325_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }

    private static final String QUESTION_326_SENTENCE_1 = "Keith spent $ 6.51 on a rabbit toy , $ 5.79 on pet food , and a cage cost him $ 12.51 .";
    private static final String QUESTION_326_SENTENCE_1_1 = "Keith spent $ 6.51 on a rabbit toy .";
    private static final String QUESTION_326_SENTENCE_1_2 = "Keith spent $ 5.79 on pet food .";
    private static final String QUESTION_326_SENTENCE_1_3 = "a cage cost him $ 12.51 .";

    @Test
    public void question326_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_326_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_326_SENTENCE_1_1'", QUESTION_326_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_326_SENTENCE_1_2'", QUESTION_326_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_326_SENTENCE_1_3'", QUESTION_326_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }

    private static final String QUESTION_327_SENTENCE_1 = "Keith spent $ 136.01 on speakers , $ 139.38 on a CD player , and $ 112.46 on new tires .";
    private static final String QUESTION_327_SENTENCE_1_1 = "Keith spent $ 136.01 on speakers .";
    private static final String QUESTION_327_SENTENCE_1_2 = "Keith spent $ 139.38 on a CD player .";
    private static final String QUESTION_327_SENTENCE_1_3 = "Keith spent $ 112.46 on new tires .";

    @Test
    public void question327_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_327_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_327_SENTENCE_1_1'", QUESTION_327_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_327_SENTENCE_1_2'", QUESTION_327_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_327_SENTENCE_1_3'", QUESTION_327_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }

    private static final String QUESTION_328_SENTENCE_1 = "Joan bought toy cars for $ 14.88 , a skateboard for $ 4.88 , and got toy trucks for $ 5.86 .";
    private static final String QUESTION_328_SENTENCE_1_1 = "Joan bought toy cars for $ 14.88 .";
    private static final String QUESTION_328_SENTENCE_1_2 = "Joan bought a skateboard for $ 4.88 .";
    private static final String QUESTION_328_SENTENCE_1_3 = "Joan got toy trucks for $ 5.86 .";

    @Test
    public void question328_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_328_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_328_SENTENCE_1_1'", QUESTION_328_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_328_SENTENCE_1_2'", QUESTION_328_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_328_SENTENCE_1_3'", QUESTION_328_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }

    private static final String QUESTION_329_SENTENCE_1 = "After paying 6 dollars for the pie , Mary has 52 dollars.";
    private static final String QUESTION_329_SENTENCE_1_1 = "Mary paid 6 dollars for the pie .";
    private static final String QUESTION_329_SENTENCE_1_2 = "Mary has 52 dollars .";

    @Test
    public void question329_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_329_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_329_SENTENCE_1_1'", QUESTION_329_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_329_SENTENCE_1_2'", QUESTION_329_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_330_SENTENCE_1 = "There were 46 bales of hay in the barn and 32 bales in the shed .";
    private static final String QUESTION_330_SENTENCE_1_1 = "There were 46 bales of hay in the barn .";
    private static final String QUESTION_330_SENTENCE_1_2 = "There were 32 bales of hay in the shed .";

    @Test
    public void question330_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_330_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_330_SENTENCE_1_1'", QUESTION_330_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_330_SENTENCE_1_2'", QUESTION_330_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_331_SENTENCE_1 = "The recipe calls for 7 cups of flour and 3 cups of sugar .";
    private static final String QUESTION_331_SENTENCE_1_1 = "The recipe calls for 7 cups of flour .";
    private static final String QUESTION_331_SENTENCE_1_2 = "The recipe calls for 3 cups of sugar .";

    @Test
    public void question331_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_331_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_331_SENTENCE_1_1'", QUESTION_331_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_331_SENTENCE_1_2'", QUESTION_331_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_332_SENTENCE_1 = "Last week Fred had 23 dollars and Jason had 46 dollars .";
    private static final String QUESTION_332_SENTENCE_1_1 = "Last week Fred had 23 dollars .";
    private static final String QUESTION_332_SENTENCE_1_2 = "Last week Jason had 46 dollars .";

    @Test
    public void question332_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_332_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_332_SENTENCE_1_1'", QUESTION_332_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_332_SENTENCE_1_2'", QUESTION_332_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_333_SENTENCE_1 = "There are 31 short trees and 32 tall trees currently in the park .";
    private static final String QUESTION_333_SENTENCE_1_1 = "There are 31 short trees currently in the park .";
    private static final String QUESTION_333_SENTENCE_1_2 = "There are 32 tall trees currently in the park .";

    @Test
    public void question333_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_333_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_333_SENTENCE_1_1'", QUESTION_333_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_333_SENTENCE_1_2'", QUESTION_333_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_334_SENTENCE_1 = "There were 9 red orchids and 3 white orchids in the vase .";
    private static final String QUESTION_334_SENTENCE_1_1 = "There were 9 red orchids in the vase .";
    private static final String QUESTION_334_SENTENCE_1_2 = "There were 3 white orchids in the vase .";

    @Test
    public void question334_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_334_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_334_SENTENCE_1_1'", QUESTION_334_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_334_SENTENCE_1_2'", QUESTION_334_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_335_SENTENCE_1 = "Sara had 24 peaches and 37 pears at her fruit dish .";
    private static final String QUESTION_335_SENTENCE_1_1 = "Sara had 24 peaches at her fruit dish .";
    private static final String QUESTION_335_SENTENCE_1_2 = "Sara had 37 pears at her fruit dish .";

    @Test
    public void question335_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_335_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_335_SENTENCE_1_1'", QUESTION_335_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_335_SENTENCE_1_2'", QUESTION_335_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_336_SENTENCE_1 = "Joan found 72 seashells and 12 starfishes on the beach .";
    private static final String QUESTION_336_SENTENCE_1_1 = "Joan found 72 seashells on the beach .";
    private static final String QUESTION_336_SENTENCE_1_2 = "Joan found 12 starfishes on the beach .";

    @Test
    public void question336_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_336_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_336_SENTENCE_1_1'", QUESTION_336_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_336_SENTENCE_1_2'", QUESTION_336_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_337_SENTENCE_1 = "There are 6 pencils and 7 rulers in the drawer .";
    private static final String QUESTION_337_SENTENCE_1_1 = "There are 6 pencils in the drawer .";
    private static final String QUESTION_337_SENTENCE_1_2 = "There are 7 rulers in the drawer .";

    @Test
    public void question337_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_337_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_337_SENTENCE_1_1'", QUESTION_337_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_337_SENTENCE_1_2'", QUESTION_337_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_338_SENTENCE_1 = "Sara has 3 green and 5 red marbles .";
    private static final String QUESTION_338_SENTENCE_1_1 = "Sara has 3 green marbles .";
    private static final String QUESTION_338_SENTENCE_1_2 = "Sara has 5 red marbles .";

    @Test
    public void question338_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_338_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_338_SENTENCE_1_1'", QUESTION_338_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_338_SENTENCE_1_2'", QUESTION_338_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_339_SENTENCE_1 = "Joan grew 8 watermelons and 4 turnips .";
    private static final String QUESTION_339_SENTENCE_1_1 = "Joan grew 8 watermelons .";
    private static final String QUESTION_339_SENTENCE_1_2 = "Joan grew 4 turnips .";

    @Test
    public void question339_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_339_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_339_SENTENCE_1_1'", QUESTION_339_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_339_SENTENCE_1_2'", QUESTION_339_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_340_SENTENCE_1 = "There are 2 maple trees and 5 popular trees currently in the park .";
    private static final String QUESTION_340_SENTENCE_1_1 = "There are 2 maple trees currently in the park .";
    private static final String QUESTION_340_SENTENCE_1_2 = "There are 5 popular trees currently in the park .";

    @Test
    public void question340_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_340_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_340_SENTENCE_1_1'", QUESTION_340_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_340_SENTENCE_1_2'", QUESTION_340_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_341_MUL_SENTENCE_1_2 = "Mary found 2 seashells and Keith found 5 seashells on the beach . When they cleaned them , they discovered that 9 seashells were cracked .";
    private static final String QUESTION_341_SENTENCE_1_1 = "Mary found 2 seashells on the beach .";
    private static final String QUESTION_341_SENTENCE_1_2 = "Keith found 5 seashells on the beach .";
    private static final String QUESTION_341_SENTENCE_2_1 = "When they cleaned them .";
    private static final String QUESTION_341_SENTENCE_2_2 = "they discovered that 9 seashells were cracked .";

    @Test
    public void question341_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_341_MUL_SENTENCE_1_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_341_SENTENCE_1_1'", QUESTION_341_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_341_SENTENCE_1_2'", QUESTION_341_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());

        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_341_SENTENCE_2_1'", QUESTION_341_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_341_SENTENCE_2_2'", QUESTION_341_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_342_SENTENCE_1 = "Mike picked 8 pears and Jason picked 7 pears from the pear tree .";
    private static final String QUESTION_342_SENTENCE_1_1 = "Mike picked 8 pears from the pear tree .";
    private static final String QUESTION_342_SENTENCE_1_2 = "Keith found 5 seashells on the beach .";

    @Test
    public void question342_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_342_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_342_SENTENCE_1_1'", QUESTION_342_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_342_SENTENCE_1_2'", QUESTION_342_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_343_MUL_SENTENCE_1_2 = "Tim had 7 quarters and 9 nickels in his bank . His dad gave him 3 nickels and 5 pennies .";
    private static final String QUESTION_343_SENTENCE_1_1 = "Tim had 7 quarters in his bank .";
    private static final String QUESTION_343_SENTENCE_1_2 = "Tim had 9 nickels in his bank .";
    private static final String QUESTION_343_SENTENCE_2_1 = "His dad gave him 3 nickels .";
    private static final String QUESTION_343_SENTENCE_2_2 = "His dad gave him 5 pennies .";

    @Test
    public void question343_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_343_MUL_SENTENCE_1_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_343_SENTENCE_1_1'", QUESTION_343_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_343_SENTENCE_1_2'", QUESTION_343_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());

        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_343_SENTENCE_2_1'", QUESTION_343_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_343_SENTENCE_2_2'", QUESTION_343_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_344_SENTENCE_1 = "A restaurant served 7 slices of pie during lunch and 5 slices during dinner today .";
    private static final String QUESTION_344_SENTENCE_1_1 = "A restaurant served 7 slices of pie during lunch today .";
    private static final String QUESTION_344_SENTENCE_1_2 = "A restaurant served 5 slices of pie during dinner today .";

    @Test
    public void question344_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_344_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_344_SENTENCE_1_1'", QUESTION_344_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_344_SENTENCE_1_2'", QUESTION_344_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_345_SENTENCE_1 = "Tom went to 4 hockey games this year , but missed 7 games .";
    private static final String QUESTION_345_SENTENCE_1_1 = "Tom went to 4 hockey games this year .";
    private static final String QUESTION_345_SENTENCE_1_2 = "Tom missed 7 hockey games this year .";

    @Test
    public void question345_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_345_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_345_SENTENCE_1_1'", QUESTION_345_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_345_SENTENCE_1_2'", QUESTION_345_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_346_SENTENCE_1 = "Sam 's dog had puppies and 8 had spots .";
    private static final String QUESTION_346_SENTENCE_1_1 = "Sam 's dog had puppies .";
    private static final String QUESTION_346_SENTENCE_1_2 = "8 puppies had spots .";

    @Test
    public void question346_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_346_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_346_SENTENCE_1_1'", QUESTION_346_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_346_SENTENCE_1_2'", QUESTION_346_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_347_SENTENCE_1 = "Mike picked 7 apples , Nancy picked 3 apples , and Keith picked 6 apples and 4 pears , at the farm .";
    private static final String QUESTION_347_SENTENCE_1_1 = "Mike picked 7 apples at the farm .";
    private static final String QUESTION_347_SENTENCE_1_2 = "Nancy picked 3 apples at the farm .";
    private static final String QUESTION_347_SENTENCE_1_3 = "Keith picked 6 apples at the farm .";
    private static final String QUESTION_347_SENTENCE_1_4 = "Keith picked 4 pears at the farm .";

    @Test
    public void question347_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_347_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 4.", simplifiedSentences.size() == 4);
        assertEquals("First sentence should be equal to 'QUESTION_347_SENTENCE_1_1'", QUESTION_347_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_347_SENTENCE_1_2'", QUESTION_347_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("First sentence should be equal to 'QUESTION_347_SENTENCE_1_3'", QUESTION_347_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_347_SENTENCE_1_4'", QUESTION_347_SENTENCE_1_4, simplifiedSentences.get(3).getSentenceText());
    }

    private static final String QUESTION_348_SENTENCE_1 = "Park workers will plant 5 dogwood trees today and 4 dogwood trees tomorrow .";
    private static final String QUESTION_348_SENTENCE_1_1 = "Park workers will plant 5 dogwood trees today .";
    private static final String QUESTION_348_SENTENCE_1_2 = "Park workers will plant 4 dogwood trees tomorrow .";

    @Test
    public void question348_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_348_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_348_SENTENCE_1_1'", QUESTION_348_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_348_SENTENCE_1_2'", QUESTION_348_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_349_MUL_SENTENCE_1_2 = "Dan 's cat had kittens and 5 had spots . He gave 7 to Tim and 4 to Jason .";
    private static final String QUESTION_349_SENTENCE_1_1 = "Dan 's cat had kittens .";
    private static final String QUESTION_349_SENTENCE_1_2 = "5 kittens had spots .";
    private static final String QUESTION_349_SENTENCE_2_1 = "He gave 7 kittens to Tim .";
    private static final String QUESTION_349_SENTENCE_2_2 = "He gave 4 kittens to Jason .";

    @Test
    public void question349_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_349_MUL_SENTENCE_1_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_349_SENTENCE_1_1'", QUESTION_349_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_349_SENTENCE_1_2'", QUESTION_349_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());

        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_349_SENTENCE_2_1'", QUESTION_349_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_349_SENTENCE_2_2'", QUESTION_349_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_350_MUL_SENTENCE_1_2 = "There are 7 crayons in the drawer and 6 crayons on the desk . Sam placed 4 crayons and 8 scissors on the desk .";
    private static final String QUESTION_350_SENTENCE_1_1 = "There are 7 crayons in the drawer .";
    private static final String QUESTION_350_SENTENCE_1_2 = "There are 6 crayons on the desk .";
    private static final String QUESTION_350_SENTENCE_2_1 = "Sam placed 4 crayons on the desk .";
    private static final String QUESTION_350_SENTENCE_2_2 = "Sam placed 8 scissors on the desk .";

    @Test
    public void question350_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_350_MUL_SENTENCE_1_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_350_SENTENCE_1_1'", QUESTION_350_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_350_SENTENCE_1_2'", QUESTION_350_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());

        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_350_SENTENCE_2_1'", QUESTION_350_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_350_SENTENCE_2_2'", QUESTION_350_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_351_MUL_SENTENCE_1_2 = "Sally had 8 pennies and 7 nickels in her bank . Her dad gave her 9 nickels and her mother gave her 2 nickels .";
    private static final String QUESTION_351_SENTENCE_1_1 = "Sally had 8 pennies in her bank .";
    private static final String QUESTION_351_SENTENCE_1_2 = "Sally had 7 nickels in her bank .";
    private static final String QUESTION_351_SENTENCE_2_1 = "Her dad gave her 9 nickels .";
    private static final String QUESTION_351_SENTENCE_2_2 = "her mother gave her 2 nickels .";

    @Test
    public void question351_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_351_MUL_SENTENCE_1_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_351_SENTENCE_1_1'", QUESTION_351_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_351_SENTENCE_1_2'", QUESTION_351_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());

        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_351_SENTENCE_2_1'", QUESTION_351_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_351_SENTENCE_2_2'", QUESTION_351_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_352_MUL_SENTENCE_1_2 = "Nancy went to 9 football games this month . She went to 8 games last month , and plans to go to 7 games next month .";
    private static final String QUESTION_352_SENTENCE_1_1 = "Nancy went to 9 football games this month .";
    private static final String QUESTION_352_SENTENCE_2_1 = "She went to 8 football games last month .";
    private static final String QUESTION_352_SENTENCE_2_2 = "She plans to go to 7 football games next month .";

    @Test
    public void question352_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_352_MUL_SENTENCE_1_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 1.", firstSimplifiedSentences.size() == 1);
        assertEquals("First sentence should be equal to 'QUESTION_352_SENTENCE_1_1'", QUESTION_352_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());

        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_352_SENTENCE_2_1'", QUESTION_352_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_352_SENTENCE_2_2'", QUESTION_352_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_353_MUL_SENTENCE_1_2 = "Keith found 6 seashells , Jessica found 8 seashells , and Tim found 7 seashells on the beach . When they cleaned them , they discovered that 3 were cracked .";
    private static final String QUESTION_353_SENTENCE_1_1 = "Keith found 6 seashells on the beach .";
    private static final String QUESTION_353_SENTENCE_1_2 = "Jessica found 8 seashells on the beach .";
    private static final String QUESTION_353_SENTENCE_1_3 = "Tim found 7 seashells on the beach .";
    private static final String QUESTION_353_SENTENCE_2_1 = "When they cleaned them .";
    private static final String QUESTION_353_SENTENCE_2_2 = "they discovered that 3 seashells were cracked .";

    @Test
    public void question353_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_353_MUL_SENTENCE_1_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", firstSimplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_353_SENTENCE_1_1'", QUESTION_353_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_353_SENTENCE_1_2'", QUESTION_353_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_353_SENTENCE_1_3'", QUESTION_353_SENTENCE_1_3, firstSimplifiedSentences.get(2).getSentenceText());

        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_353_SENTENCE_2_1'", QUESTION_353_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_353_SENTENCE_2_2'", QUESTION_353_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_354_SENTENCE_1 = "Nancy grew 2 onions , Dan grew 9 onions , and Mike grew 4 onions .";
    private static final String QUESTION_354_SENTENCE_1_1 = "Nancy grew 2 onions .";
    private static final String QUESTION_354_SENTENCE_1_2 = "Dan grew 9 onions .";
    private static final String QUESTION_354_SENTENCE_1_3 = "Mike grew 4 onions .";

    @Test
    public void question354_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_354_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_354_SENTENCE_1_1'", QUESTION_354_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_354_SENTENCE_1_2'", QUESTION_354_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_354_SENTENCE_1_3'", QUESTION_354_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }

    private static final String QUESTION_355_SENTENCE_1 = "Fred has 5 yellow balloons , Sam has 6 yellow balloons , and Mary has 7 yellow balloons .";
    private static final String QUESTION_355_SENTENCE_1_1 = "Fred has 5 yellow balloons .";
    private static final String QUESTION_355_SENTENCE_1_2 = "Sam has 6 yellow balloons .";
    private static final String QUESTION_355_SENTENCE_1_3 = "Mary has 7 yellow balloons .";

    @Test
    public void question355_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_355_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_355_SENTENCE_1_1'", QUESTION_355_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_355_SENTENCE_1_2'", QUESTION_355_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_355_SENTENCE_1_3'", QUESTION_355_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }

    private static final String QUESTION_356_MUL_SENTENCE_1_2 = "A restaurant served 4 pies during lunch and 9 during dinner today . The restaurant served 7 pies and 2 pizzas yesterday .";
    private static final String QUESTION_356_SENTENCE_1_1 = "A restaurant served 4 pies during lunch today .";
    private static final String QUESTION_356_SENTENCE_1_2 = "A restaurant served 9 pies during dinner today .";
    private static final String QUESTION_356_SENTENCE_2_1 = "The restaurant served 7 pies yesterday .";
    private static final String QUESTION_356_SENTENCE_2_2 = "The restaurant served 2 pizzas yesterday .";

    @Test
    public void question356_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_356_MUL_SENTENCE_1_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_356_SENTENCE_1_1'", QUESTION_356_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_356_SENTENCE_1_2'", QUESTION_356_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());

        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_356_SENTENCE_2_1'", QUESTION_356_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_356_SENTENCE_2_2'", QUESTION_356_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_357_MUL_SENTENCE_1_2 = "Tim found 37 seashells and Sally found 13 seashells on the beach . When they cleaned them , they discovered that 25 were cracked .";
    private static final String QUESTION_357_SENTENCE_1_1 = "Tim found 37 seashells on the beach .";
    private static final String QUESTION_357_SENTENCE_1_2 = "Sally found 13 seashells on the beach .";
    private static final String QUESTION_357_SENTENCE_2_1 = "When they cleaned them .";
    private static final String QUESTION_357_SENTENCE_2_2 = "they discovered that 25 seashells were cracked .";

    @Test
    public void question357_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_357_MUL_SENTENCE_1_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_357_SENTENCE_1_1'", QUESTION_357_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_357_SENTENCE_1_2'", QUESTION_357_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());

        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_357_SENTENCE_2_1'", QUESTION_357_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_357_SENTENCE_2_2'", QUESTION_357_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_358_MUL_SENTENCE_1_2 = "Tom had 27 pennies and 15 dimes in his bank . His dad gave him 33 dimes and 49 nickels .";
    private static final String QUESTION_358_SENTENCE_1_1 = "Tom had 27 pennies in his bank .";
    private static final String QUESTION_358_SENTENCE_1_2 = "Tom had 15 dimes in his bank .";
    private static final String QUESTION_358_SENTENCE_2_1 = "His dad gave him 33 dimes .";
    private static final String QUESTION_358_SENTENCE_2_2 = "His dad gave him 49 nickels .";

    @Test
    public void question358_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_358_MUL_SENTENCE_1_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_358_SENTENCE_1_1'", QUESTION_358_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_358_SENTENCE_1_2'", QUESTION_358_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());

        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_358_SENTENCE_2_1'", QUESTION_358_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_358_SENTENCE_2_2'", QUESTION_358_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_359_SENTENCE_1 = "There are 39 scissors and 22 pencils in the drawer .";
    private static final String QUESTION_359_SENTENCE_1_1 = "There are 39 scissors in the drawer .";
    private static final String QUESTION_359_SENTENCE_1_2 = "There are 22 pencils in the drawer .";

    @Test
    public void question359_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_359_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_359_SENTENCE_1_1'", QUESTION_359_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_359_SENTENCE_1_2'", QUESTION_359_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_360_SENTENCE_1 = "Sam has 16 blue and 25 green balloons .";
    private static final String QUESTION_360_SENTENCE_1_1 = "Sam has 16 blue balloons .";
    private static final String QUESTION_360_SENTENCE_1_2 = "Sam has 25 green balloons .";

    @Test
    public void question360_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_360_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_360_SENTENCE_1_1'", QUESTION_360_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_360_SENTENCE_1_2'", QUESTION_360_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_361_SENTENCE_1 = "There are 22 orchid bushes and 40 orange trees currently in the park .";
    private static final String QUESTION_361_SENTENCE_1_1 = "There are 22 orchid bushes currently in the park .";
    private static final String QUESTION_361_SENTENCE_1_2 = "There are 40 orange trees currently in the park .";

    @Test
    public void question361_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_361_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_361_SENTENCE_1_1'", QUESTION_361_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_361_SENTENCE_1_2'", QUESTION_361_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_362_SENTENCE_1 = "Mary had 33 Pokemon cards , and 6 were torn .";
    private static final String QUESTION_362_SENTENCE_1_1 = "Mary had 33 Pokemon cards .";
    private static final String QUESTION_362_SENTENCE_1_2 = "6 Pokemon cards were torn .";

    @Test
    public void question362_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_362_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_362_SENTENCE_1_1'", QUESTION_362_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_362_SENTENCE_1_2'", QUESTION_362_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_363_SENTENCE_1 = "Mary picked 14 oranges and Jason picked 41 oranges .";
    private static final String QUESTION_363_SENTENCE_1_1 = "Mary picked 14 oranges .";
    private static final String QUESTION_363_SENTENCE_1_2 = "Jason picked 41 oranges .";

    @Test
    public void question363_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_363_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_363_SENTENCE_1_1'", QUESTION_363_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_363_SENTENCE_1_2'", QUESTION_363_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_364_SENTENCE_1 = "Jason grew 37 watermelons and 30 pumpkins .";
    private static final String QUESTION_364_SENTENCE_1_1 = "Jason grew 37 watermelons .";
    private static final String QUESTION_364_SENTENCE_1_2 = "Jason grew 30 pumpkins .";

    @Test
    public void question364_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_364_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_364_SENTENCE_1_1'", QUESTION_364_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_364_SENTENCE_1_2'", QUESTION_364_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_365_MUL_SENTENCE_1_2 = "Mike went to 15 basketball games this year , but missed 41 . He went to 39 games last year .";
    private static final String QUESTION_365_SENTENCE_1_1 = "Mike went to 15 basketball games this year .";
    private static final String QUESTION_365_SENTENCE_1_2 = "Mike missed 41 basketball games this year  .";
    private static final String QUESTION_365_SENTENCE_2_1 = "He went to 39 basketball games last year .";

    @Test
    public void question365_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_365_MUL_SENTENCE_1_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_365_SENTENCE_1_1'", QUESTION_365_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_365_SENTENCE_1_2'", QUESTION_365_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());

        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 1.", secondSimplifiedSentences.size() == 1);
        assertEquals("First sentence should be equal to 'QUESTION_365_SENTENCE_2_1'", QUESTION_365_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
    }

    private static final String QUESTION_366_MUL_SENTENCE_1_2 = "Melanie had 10 quarters and 17 pennies in her bank . Her dad gave her 27 pennies and her mother gave her 19 pennies .";
    private static final String QUESTION_366_SENTENCE_1_1 = "Melanie had 10 quarters in her bank .";
    private static final String QUESTION_366_SENTENCE_1_2 = "Melanie had 17 pennies in her bank .";
    private static final String QUESTION_366_SENTENCE_2_1 = "Her dad gave her 27 pennies .";
    private static final String QUESTION_366_SENTENCE_2_2 = "her mother gave her 19 pennies .";

    @Test
    public void question366_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_366_MUL_SENTENCE_1_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_366_SENTENCE_1_1'", QUESTION_366_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_366_SENTENCE_1_2'", QUESTION_366_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());

        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_366_SENTENCE_2_1'", QUESTION_366_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_366_SENTENCE_2_2'", QUESTION_366_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_367_SENTENCE_1 = "Joan grew 24 pumpkins , Keith grew 42 pumpkins , and Alyssa grew 13 pumpkins .";
    private static final String QUESTION_367_SENTENCE_1_1 = "Joan grew 24 pumpkins .";
    private static final String QUESTION_367_SENTENCE_1_2 = "Keith grew 42 pumpkins .";
    private static final String QUESTION_367_SENTENCE_1_3 = "Alyssa grew 13 pumpkins .";

    @Test
    public void question367_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_367_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'QUESTION_367_SENTENCE_1_1'", QUESTION_367_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_367_SENTENCE_1_2'", QUESTION_367_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'QUESTION_367_SENTENCE_1_3'", QUESTION_367_SENTENCE_1_3, simplifiedSentences.get(2).getSentenceText());
    }

    private static final String QUESTION_368_SENTENCE_1 = "Mary had 18 baseball cards , and 8 were torn .";
    private static final String QUESTION_368_SENTENCE_1_1 = "Mary had 18 baseball cards .";
    private static final String QUESTION_368_SENTENCE_1_2 = "8 baseball cards were torn .";

    @Test
    public void question368_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_368_SENTENCE_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_368_SENTENCE_1_1'", QUESTION_368_SENTENCE_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_368_SENTENCE_1_2'", QUESTION_368_SENTENCE_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_369_MUL_SENTENCE_1_2 = "Alyssa went to 11 soccer games this year , but missed 12 . She went to 13 games last year and plans to go to 15 games next year .";
    private static final String QUESTION_369_SENTENCE_1_1 = "Alyssa went to 11 soccer games this year .";
    private static final String QUESTION_369_SENTENCE_1_2 = "Alyssa missed 12 soccer games this year  .";
    private static final String QUESTION_369_SENTENCE_2_1 = "She went to 13 soccer games last year .";
    private static final String QUESTION_369_SENTENCE_2_2 = "She plans to go to 15 soccer games next year .";

    @Test
    public void question369_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_369_MUL_SENTENCE_1_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_369_SENTENCE_1_1'", QUESTION_369_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_369_SENTENCE_1_2'", QUESTION_369_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());

        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_369_SENTENCE_2_1'", QUESTION_369_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_369_SENTENCE_2_2'", QUESTION_369_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }

    private static final String QUESTION_370_MUL_SENTENCE_1_2 = "There are 48 erasers in the drawer and 30 erasers on the desk . Alyssa placed 39 erasers and 45 rulers on the desk .";
    private static final String QUESTION_370_SENTENCE_1_1 = "There are 48 erasers in the drawer .";
    private static final String QUESTION_370_SENTENCE_1_2 = "There are 30 erasers on the desk .";
    private static final String QUESTION_370_SENTENCE_2_1 = "Alyssa placed 39 erasers on the desk .";
    private static final String QUESTION_370_SENTENCE_2_2 = "Alyssa placed 45 rulers on the desk .";

    @Test
    public void question370_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(QUESTION_370_MUL_SENTENCE_1_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence firstQuestionSentence = questionSentences.get(0);
        final List<QuestionSentence> firstSimplifiedSentences = firstQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", firstSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_370_SENTENCE_1_1'", QUESTION_370_SENTENCE_1_1, firstSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_370_SENTENCE_1_2'", QUESTION_370_SENTENCE_1_2, firstSimplifiedSentences.get(1).getSentenceText());

        final QuestionSentence secondQuestionSentence = questionSentences.get(1);
        final List<QuestionSentence> secondSimplifiedSentences = secondQuestionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", secondSimplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'QUESTION_370_SENTENCE_2_1'", QUESTION_370_SENTENCE_2_1, secondSimplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'QUESTION_370_SENTENCE_2_2'", QUESTION_370_SENTENCE_2_2, secondSimplifiedSentences.get(1).getSentenceText());
    }

}