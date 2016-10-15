package com.neu.sentencesimplification.simplifier;


import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;
import com.neu.sentencesimplification.stanfordcorenlp.QuestionSentence;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommaSimplifierTests {

    private static final String SENTENCE_WITH_COMMAS_1 = "He bought marbles for $ 9.05, a football for $ 4.95," +
            " and spent $ 6.52 on a basketball.";

    private static final String SENTENCE_WITHOUT_COMMA_1_1 = "He bought marbles for $ 9.05 .";
    private static final String SENTENCE_WITHOUT_COMMA_1_2 = "He bought a football for $ 4.95 .";
    private static final String SENTENCE_WITHOUT_COMMA_1_3 = "He spent $ 6.52 on a basketball .";

    private static final String SENTENCE_WITH_COMMAS_2 = "Sara grew 43 pumpkins, but the rabbits ate 23 pumpkins.";
    private static final String SENTENCE_WITHOUT_COMMA_2_1 = "Sara grew 43 pumpkins .";
    private static final String SENTENCE_WITHOUT_COMMA_2_2 = "the rabbits ate 23 pumpkins .";

    private static final String SENTENCE_WITH_COMMAS_3 = "Joan picked 43 apples from the orchard, and gave 27 apples to Melanie.";
    private static final String SENTENCE_WITHOUT_COMMA_3_1 = "Joan picked 43 apples from the orchard .";
    private static final String SENTENCE_WITHOUT_COMMA_3_2 = "Joan gave 27 apples to Melanie .";

    private static final String SENTENCE_WITH_COMMAS_4 = "Fred picked 36 limes , Alyssa picked 32 limes , and Nancy picked 35 limes and 18 pears.";
    private static final String SENTENCE_WITHOUT_COMMA_4_1 = "Fred picked 36 limes .";
    private static final String SENTENCE_WITHOUT_COMMA_4_2 = "Alyssa picked 32 limes .";
    private static final String SENTENCE_WITHOUT_COMMA_4_3 = "Nancy picked 35 limes .";
    private static final String SENTENCE_WITHOUT_COMMA_4_4 = "Nancy picked 18 pears .";

    @Test
    public void sentenceWithComma_1_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_COMMAS_1);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 3);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_COMMA_1_1'", SENTENCE_WITHOUT_COMMA_1_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_COMMA_1_2'", SENTENCE_WITHOUT_COMMA_1_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'SENTENCE_WITHOUT_COMMA_1_3'", SENTENCE_WITHOUT_COMMA_1_3, simplifiedSentences.get(2).getSentenceText());
    }

    @Test
    public void sentenceWithComma_2_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_COMMAS_2);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_COMMA_2_1'", SENTENCE_WITHOUT_COMMA_2_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_COMMA_2_2'", SENTENCE_WITHOUT_COMMA_2_2, simplifiedSentences.get(1).getSentenceText());
    }

    @Test
    public void sentenceWithComma_3_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_COMMAS_3);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 2.", simplifiedSentences.size() == 2);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_COMMA_3_1'", SENTENCE_WITHOUT_COMMA_3_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_COMMA_3_2'", SENTENCE_WITHOUT_COMMA_3_2, simplifiedSentences.get(1).getSentenceText());
    }

    @Test
    public void sentenceWithComma_4_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_COMMAS_4);
        assertTrue(questionSentences != null);
        assertTrue("Size should be equal to 1.", questionSentences.size() == 1);
        final QuestionSentence questionSentence = questionSentences.get(0);
        final List<QuestionSentence> simplifiedSentences = questionSentence.getSimplifiedSentences();
        assertTrue("Number of simplified sentences should be equal to 3.", simplifiedSentences.size() == 4);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_COMMA_4_1'", SENTENCE_WITHOUT_COMMA_4_1, simplifiedSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_COMMA_4_2'", SENTENCE_WITHOUT_COMMA_4_2, simplifiedSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'SENTENCE_WITHOUT_COMMA_4_3'", SENTENCE_WITHOUT_COMMA_4_3, simplifiedSentences.get(2).getSentenceText());
        assertEquals("Fourth sentence should be equal to 'SENTENCE_WITHOUT_COMMA_4_4'", SENTENCE_WITHOUT_COMMA_4_4, simplifiedSentences.get(3).getSentenceText());
    }
}

