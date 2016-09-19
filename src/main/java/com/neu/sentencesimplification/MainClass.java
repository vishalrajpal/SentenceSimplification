package com.neu.sentencesimplification;

import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;

import java.util.Scanner;

/**
 * MainClass: The entry point of the project.
 */
public class MainClass {

    public static void main(String[] args) {

        //CrossValidation.createCrossValidationFolds("datasets/mawps/AdditionSubtraction.json", 5);
        //DependenciesParser.extractPartsOfSpeechFromDependencies("Jenny ran 0.6 mile and walked 0.4 mile . How much farther did Jenny run than walk ?");
        final Scanner scanner = new Scanner(System.in);
        String text;
        while((text = scanner.nextLine()) != null) {
            DependenciesParser.extractPartsOfSpeechFromDependencies(text);
        }
    }
}
