package com.neu.sentencesimplification.simplifier;

import org.junit.Test;

/**
 * ConjunctionSimplifierTests: Tests for ConjunctionSimplifier.
 */
public class ConjunctionSimplifierTests {

    private static final String SENTENCE_WITH_CONJUNCTION_1 = "He went to the orchard and picked peaches to stock up .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_1_1 = "He went to the orchard to stock up .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_1_2 = "He picked peaches to stock up .";

    private static final String SENTENCE_WITH_CONJUNCTION_2 = "A restaurant served 9 pizzas during lunch and 6 during dinner today .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_2_1 = "A restaurant served 9 pizzas during lunch .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_2_2 = "A restaurant served 6 pizzas during dinner .";

    private static final String SENTENCE_WITH_CONUNCTION_3 = "Joan found 6 seashells and Jessica found 8 seashells on the beach .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_3_1 = "Joan found 6 seashells on the beach .";
    private static final String SENTENCE_WITHOUT_CONJUNCTION_3_2 = "Jessica found 8 seashells on the beach .";


}
