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