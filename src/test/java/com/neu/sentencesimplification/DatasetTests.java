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
    private static final String QUESTION_313_SENTENCE_1_2 = "Sandy had 31 nickles in her bank .";

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
}