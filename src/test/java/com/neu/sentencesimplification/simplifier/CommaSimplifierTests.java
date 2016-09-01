package com.neu.sentencesimplification.simplifier;


import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;
import com.neu.sentencesimplification.stanfordcorenlp.QuestionSentence;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommaSimplifierTests {

    private static final String SENTENCE_WITH_COMMAS_1 = "He bought marbles for $ 9.05, a football for $ 4.95," +
            " and spent $ 6.52 on a basketball.";

    private static final List<String> SENTENCES_WITHOUT_COMMAS_1 = new ArrayList<>();
    private static final String SENTENCE_WITHOUT_COMMA_1_1 = "He bought marbles for $ 9.05 .";
    private static final String SENTENCE_WITHOUT_COMMA_1_2 = "He bought a football for $ 4.95 .";
    private static final String SENTENCE_WITHOUT_COMMA_1_3 = "He spent $ 6.52 on a basketball .";

    private static final String SENTENCE_WITH_COMMAS_2 = "Sara grew 43 pumpkins, but the rabbits ate 23 pumpkins.";
    private static final List<String> SENTENCES_WITHOUT_COMMAS_2 = new ArrayList<>();
    private static final String SENTENCE_WITHOUT_COMMA_2_1 = "Sara grew 43 pumpkins .";
    private static final String SENTENCE_WITHOUT_COMMA_2_2 = "the rabbits ate 23 pumpkins .";

    private static final String SENTENCE_WITH_COMMAS_3 = "Joan picked 43 apples from the orchard, and gave 27 apples to Melanie.";
    private static final List<String> SENTENCES_WITHOUT_COMMAS_3 = new ArrayList<>();
    private static final String SENTENCE_WITHOUT_COMMA_3_1 = "Joan picked 43 apples from the orchard .";
    private static final String SENTENCE_WITHOUT_COMMA_3_2 = "Joan gave 27 apples to Melanie .";

    static {
        SENTENCES_WITHOUT_COMMAS_1.add(SENTENCE_WITHOUT_COMMA_1_1);
        SENTENCES_WITHOUT_COMMAS_1.add(SENTENCE_WITHOUT_COMMA_1_2);
        SENTENCES_WITHOUT_COMMAS_1.add(SENTENCE_WITHOUT_COMMA_1_3);

        SENTENCES_WITHOUT_COMMAS_2.add(SENTENCE_WITHOUT_COMMA_2_1);
        SENTENCES_WITHOUT_COMMAS_2.add(SENTENCE_WITHOUT_COMMA_2_2);

        SENTENCES_WITHOUT_COMMAS_3.add(SENTENCE_WITHOUT_COMMA_3_1);
        SENTENCES_WITHOUT_COMMAS_3.add(SENTENCE_WITHOUT_COMMA_3_2);
    }

    @Test
    public void sentenceWithComma_1_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_COMMAS_1);

        assertTrue("Size should be equal to 3.", questionSentences.size() == 3);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_COMMA_1_1'", SENTENCE_WITHOUT_COMMA_1_1, questionSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_COMMA_1_2'", SENTENCE_WITHOUT_COMMA_1_2, questionSentences.get(1).getSentenceText());
        assertEquals("Third sentence should be equal to 'SENTENCE_WITHOUT_COMMA_1_3'", SENTENCE_WITHOUT_COMMA_1_3, questionSentences.get(2).getSentenceText());
    }

    @Test
    public void sentenceWithComma_2_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_COMMAS_2);

        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_COMMA_2_1'", SENTENCE_WITHOUT_COMMA_2_1, questionSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_COMMA_2_2'", SENTENCE_WITHOUT_COMMA_2_2, questionSentences.get(1).getSentenceText());
    }

    @Test
    public void sentenceWithComma_3_Test() throws Exception {
        final List<QuestionSentence> questionSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(SENTENCE_WITH_COMMAS_3);

        assertTrue("Size should be equal to 2.", questionSentences.size() == 2);
        assertEquals("First sentence should be equal to 'SENTENCE_WITHOUT_COMMA_3_1'", SENTENCE_WITHOUT_COMMA_3_1, questionSentences.get(0).getSentenceText());
        assertEquals("Second sentence should be equal to 'SENTENCE_WITHOUT_COMMA_3_2'", SENTENCE_WITHOUT_COMMA_3_2, questionSentences.get(1).getSentenceText());
    }
}

