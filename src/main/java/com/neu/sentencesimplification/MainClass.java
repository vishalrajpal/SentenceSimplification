package com.neu.sentencesimplification;

import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;

/**
 * MainClass: The entry point of the project.
 */
public class MainClass {

    public static void main(String[] args) {
        DependenciesParser.extractPartsOfSpeechFromDependencies("He went to the orchard and picked peaches to stock up .");
    }
}
