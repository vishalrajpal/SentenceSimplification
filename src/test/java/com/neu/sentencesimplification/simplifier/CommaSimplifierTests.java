package com.neu.sentencesimplification.simplifier;


import java.util.ArrayList;
import java.util.List;

public class CommaSimplifierTests {

    private static final String SENTENCE_WITH_COMMAS_1 = "He bought marbles for $ 9.05, a football for $ 4.95," +
            " and spent $ 6.52 on a basketball.";

    private static final List<String> SENTENCES_WITHOUT_COMMAS_1 = new ArrayList<>();
    private static final String SENTENCE_WITHOUT_COMMA_1_1 = "He bought marbles for $ 9.05.";
    private static final String SENTENCE_WITHOUT_COMMA_1_2 = "He bought a football for $ 4.95.";
    private static final String SENTENCE_WITHOUT_COMMA_1_3 = "He spent $ 6.52 on a baseball.";

    private static final String SENTENCE_WITH_COMMAS_2 = "Sara grew 43 pumpkins, but the rabbits ate 23 pumpkins.";
    private static final List<String> SENTENCES_WITHOUT_COMMAS_2 = new ArrayList<>();
    private static final String SENTENCE_WITHOUT_COMMA_2_1 = "Sara grew 43 pumpkins.";
    private static final String SENTENCE_WITHOUT_COMMA_2_2 = "the rabbits ate 23 pumpkins.";

    private static final String SENTENCE_WITH_COMMAS_3 = "Joan picked 43 apples from the orchard, and gave 27 apples to Melanie.";
    private static final List<String> SENTENCES_WITHOUT_COMMAS_3 = new ArrayList<>();
    private static final String SENTENCE_WITHOUT_COMMA_3_1 = "Joan picked 43 apples from the orchard.";
    private static final String SENTENCE_WITHOUT_COMMA_3_2 = "Joan gave 27 apples to Melanie.";

    static {
        SENTENCES_WITHOUT_COMMAS_1.add(SENTENCE_WITHOUT_COMMA_1_1);
        SENTENCES_WITHOUT_COMMAS_1.add(SENTENCE_WITHOUT_COMMA_1_2);
        SENTENCES_WITHOUT_COMMAS_1.add(SENTENCE_WITHOUT_COMMA_1_3);

        SENTENCES_WITHOUT_COMMAS_2.add(SENTENCE_WITHOUT_COMMA_2_1);
        SENTENCES_WITHOUT_COMMAS_2.add(SENTENCE_WITHOUT_COMMA_2_2);

        SENTENCES_WITHOUT_COMMAS_3.add(SENTENCE_WITHOUT_COMMA_3_1);
        SENTENCES_WITHOUT_COMMAS_3.add(SENTENCE_WITHOUT_COMMA_3_2);
    }
}

