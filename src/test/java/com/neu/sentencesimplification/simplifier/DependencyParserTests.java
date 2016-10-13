package com.neu.sentencesimplification.simplifier;

import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;
import com.neu.sentencesimplification.stanfordcorenlp.QuestionSentence;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * DependencyParserTests: Tests the proper formation of QuestionSentences from the dependency
 * parser output.
 */
public class DependencyParserTests {

    private static final String SENTENCE_WITH_CONJUNCTION_1 = "He went to the orchard and picked peaches to stock up .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_1_1 = "He went to the orchard .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_1_2 = "He picked peaches to stock up .";

    private static final String SENTENCE_WITH_CONJUNCTION_2 = "A restaurant served 9 pizzas during lunch and 6 during dinner today .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_2_1 = "A restaurant served 9 pizzas during lunch today .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_2_2 = "A restaurant served 6 pizzas during dinner today .";

    private static final String SENTENCE_WITH_CONJUNCTION_3 = "Joan found 6 seashells and Jessica found 8 seashells on the beach .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_3_1 = "Joan found 6 seashells on the beach .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_3_2 = "Jessica found 8 seashells on the beach .";

    @Test
    public void sentenceWithConjunction1_Test() throws Exception {
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
    public void sentenceWithConjunction2_Test() throws Exception {
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
    public void sentenceWithConjunction3_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_CONJUNCTION_3);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_3_1'", SENTENCE_WITHOUT_CONJUNCTION_3_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_CONJUNCTION_3_2'", SENTENCE_WITHOUT_CONJUNCTION_3_2, simplifiedSentences.get(1).getSentenceText());
    }
}
