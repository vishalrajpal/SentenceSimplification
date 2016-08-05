package com.neu.sentencesimplification;

import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;

/**
 * MainClass: The entry point of the project.
 */
public class MainClass {

    public static void main(String[] args) {
        DependenciesParser.extractPartsOfSpeechFromDependencies("Joan found 6 seashells and Jessica found 8 seashells on the beach .");
    }
}
