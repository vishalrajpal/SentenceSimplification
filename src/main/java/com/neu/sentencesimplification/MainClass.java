package com.neu.sentencesimplification;

import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;

/**
 * MainClass: The entry point of the project.
 */
public class MainClass {

    public static void main(String[] args) {
        DependenciesParser.extractPartsOfSpeechFromDependencies(" He bought marbles for $ 9.05 , a football for $ 4.95 , and spent $ 6.52 on a baseball .");
    }
}
