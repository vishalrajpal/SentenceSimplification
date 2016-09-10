package com.neu.sentencesimplification;

import com.neu.sentencesimplification.datasetreader.CrossValidation;

/**
 * MainClass: The entry point of the project.
 */
public class MainClass {

    public static void main(String[] args) {

        CrossValidation.createCrossValidationFolds("datasets/mawps/AdditionSubtraction.json", 5);
        //DependenciesParser.extractPartsOfSpeechFromDependencies("Joan picked 43 apples from the orchard, and gave 27 apples to Melanie.");
    }
}
