package com.neu.sentencesimplification.simplifier;

import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;
import com.neu.sentencesimplification.stanfordcorenlp.QuestionSentence;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * ConjunctionSimplifierTests: Tests for ConjunctionSimplifier.
 */
public class ConjunctionSimplifierTests {

    private static final String SENTENCE_WITH_CONJUNCTION_1 = "He went to the orchard and picked peaches to stock up .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_1_1 = "He went to the orchard .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_1_2 = "He picked peaches to stock up .";

    private static final String SENTENCE_WITH_CONJUNCTION_2 = "A restaurant served 9 pizzas during lunch and 6 during dinner today .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_2_1 = "A restaurant served 9 pizzas during lunch today .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_2_2 = "A restaurant served 6 pizzas during dinner today .";

    private static final String SENTENCE_WITH_CONJUNCTION_3 = "Joan found 6 seashells and Jessica found 8 seashells on the beach .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_3_1 = "Joan found 6 seashells on the beach .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_3_2 = "Jessica found 8 seashells on the beach .";

    private static final String SENTENCE_WITH_CONJUNCTION_4 = "He bought marbles for $9.05, a football for $4.95, and spent $6.52 on a baseball.";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_4_1 = "He bought marbles for $ 9.05 .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_4_2 = "He bought a football for $ 4.95 .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_4_3 = "He spent $ 6.52 on a baseball .";

    private static final String SENTENCE_WITH_CONJUNCTION_5 = "Jessica spent $10.22 on a cat toy, and a cage cost her $11.73.";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_5_1 = "Jessica spent $ 10.22 on a cat toy .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_5_2 = "a cage cost her $ 11.73 .";

    private static final String SENTENCE_WITH_CONJUNCTION_6 = "She made 36 red cookies and the rest are pink.";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_6_1 = "She made 36 red cookies .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_6_2 = "the rest are pink cookies .";

    private static final String SENTENCE_WITH_CONJUNCTION_7 = "She added some shells and now has 28 pounds of shells.";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_7_1 = "She added some shells .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_7_2 = "She now has 28 pounds of shells .";

    private static final String SENTENCE_WITH_CONJUNCTION_8 = "Dan had 14 peaches and 10 pears at his roadside fruit dish .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_8_1 = "Dan had 14 peaches at his dish .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_8_2 = "Dan had 10 pears at his roadside fruit dish .";

    private static final String SENTENCE_WITH_CONJUNCTION_9 = "There are 43 maple trees and 22 orange trees currently in the park .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_9_1 = "There are 43 maple trees in the park .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_9_2 = "There are 22 orange trees currently in the park .";

    private static final String SENTENCE_WITH_CONJUNCTION_10 = "There are 48 erasers in the drawer and 30 erasers on the desk . Alyssa placed 39 erasers and 45 rulers on the desk .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_10_1 = "There are 48 erasers in the drawer .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_10_2 = "There are 30 erasers on the desk .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_10_3 = "Alyssa placed 39 erasers on the desk .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_10_4 = "Alyssa placed 45 rulers on the desk .";

    @Test
    public void sentenceWithConjunction_1_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_CONJUNCTION_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_1_1'", SENTENCE_WITHOUT_CONJUNCTION_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_1_2'", SENTENCE_WITHOUT_CONJUNCTION_1_2, simplifiedSentences.get(1).getSentenceText());
    }

    @Test
    public void sentenceWithConjunction_2_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_CONJUNCTION_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_2_1'", SENTENCE_WITHOUT_CONJUNCTION_2_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_2_2'", SENTENCE_WITHOUT_CONJUNCTION_2_2, simplifiedSentences.get(1).getSentenceText());
    }

    @Test
    public void sentenceWithConjunction_3_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_CONJUNCTION_3);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_3_1'", SENTENCE_WITHOUT_CONJUNCTION_3_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_3_2'", SENTENCE_WITHOUT_CONJUNCTION_3_2, simplifiedSentences.get(1).getSentenceText());
    }

    @Test
    public void sentenceWithConjunction_4_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_CONJUNCTION_4);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_4_1'", SENTENCE_WITHOUT_CONJUNCTION_4_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_4_2'", SENTENCE_WITHOUT_CONJUNCTION_4_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_4_3'", SENTENCE_WITHOUT_CONJUNCTION_4_3, simplifiedSentences.get(2).getSentenceText());
    }

    @Test
    public void sentenceWithConjunction_5_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_CONJUNCTION_5);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_5_1'", SENTENCE_WITHOUT_CONJUNCTION_5_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_5_2'", SENTENCE_WITHOUT_CONJUNCTION_5_2, simplifiedSentences.get(1).getSentenceText());
    }

    @Test
    public void sentenceWithConjunction_6_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_CONJUNCTION_6);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_6_1'", SENTENCE_WITHOUT_CONJUNCTION_6_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_6_2'", SENTENCE_WITHOUT_CONJUNCTION_6_2, simplifiedSentences.get(1).getSentenceText());
    }

    @Test
    public void sentenceWithConjunction_7_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_CONJUNCTION_7);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_7_1'", SENTENCE_WITHOUT_CONJUNCTION_7_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_7_2'", SENTENCE_WITHOUT_CONJUNCTION_7_2, simplifiedSentences.get(1).getSentenceText());
    }

    @Test
    public void sentenceWithConjunction_8_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_CONJUNCTION_8);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_8_1'", SENTENCE_WITHOUT_CONJUNCTION_8_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_8_2'", SENTENCE_WITHOUT_CONJUNCTION_8_2, simplifiedSentences.get(1).getSentenceText());
    }

    @Test
    public void sentenceWithConjunction_9_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_CONJUNCTION_9);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_9_1'", SENTENCE_WITHOUT_CONJUNCTION_9_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_9_2'", SENTENCE_WITHOUT_CONJUNCTION_9_2, simplifiedSentences.get(1).getSentenceText());
    }

    @Test
    public void sentenceWithConjunction_10_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_CONJUNCTION_10);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        final QuestionSentence questionSentence_1 = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences_1 = questionSentence_1.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences_1.size() == 2);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_10_1'", SENTENCE_WITHOUT_CONJUNCTION_10_1, simplifiedSentences_1.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_10_2'", SENTENCE_WITHOUT_CONJUNCTION_10_2, simplifiedSentences_1.get(1).getSentenceText());

        final QuestionSentence questionSentence_2 = questionSentences.get(1);
        final List<QuestionSentence> simplifiedSentences_2 = questionSentence_2.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences_2.size() == 2);
        assertEquals("Third sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_10_3'", SENTENCE_WITHOUT_CONJUNCTION_10_3, simplifiedSentences_2.get(0).getSentenceText());
        assertEquals("Fourth sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_10_4'", SENTENCE_WITHOUT_CONJUNCTION_10_4, simplifiedSentences_2.get(1).getSentenceText());
    }
}
