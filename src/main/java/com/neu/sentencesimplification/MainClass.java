package com.neu.sentencesimplification;

import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;

/**
 * MainClass: The entry point of the project.
 */
public class MainClass {

    public static void main(String[] args) {

        //CrossValidation.createCrossValidationFolds("datasets/mawps/AdditionSubtraction.json", 5);
        DependenciesParser.extractPartsOfSpeechFromDependencies("A restaurant served 9 pizzas during lunch and 6 during dinner today .");
    }
}
