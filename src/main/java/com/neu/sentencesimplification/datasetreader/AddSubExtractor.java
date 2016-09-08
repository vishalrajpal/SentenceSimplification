package com.neu.sentencesimplification.datasetreader;

import javax.json.*;
import java.io.*;
import java.net.URLDecoder;

/**
 * Reads a dataset file and extracts addition and subtraction problems from it.
 */
public class AddSubExtractor {

    private static final String EQUATION_STRING = "lEquations";

    public static void extractAddSubFromJSON(final String jsonFilePath, final String outputFilePath) {

        try {
            final InputStream inputFileSttream = new FileInputStream(jsonFilePath);
            final JsonReader jsonReader = Json.createReader(inputFileSttream);
            final JsonArray fileArray = jsonReader.readArray();
            jsonReader.close();

            final int numberOfQuestions = fileArray.size();
            final OutputStream fileOutputStream = new FileOutputStream(outputFilePath);
            final JsonArrayBuilder outputArray = Json.createArrayBuilder();

            for(int questionCounter = 0; questionCounter < numberOfQuestions; questionCounter++) {
                final JsonObject questionObject = fileArray.getJsonObject(questionCounter);
                final JsonArray equationString = questionObject.getJsonArray(EQUATION_STRING);
                final int noOfEquations = equationString.size();
                boolean containsMulDiv = false;
                for (int equationCounter = 0; equationCounter < noOfEquations; equationCounter++) {
                    final String equation = equationString.getString(equationCounter);
                    if (equation.contains("*") || equation.contains("/")) {
                        containsMulDiv = true;
                    }
                }
                if (!containsMulDiv) {
                    outputArray.add(questionObject);
                }
            }

            fileOutputStream.write(outputArray.build().toString().getBytes());

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final String sourceJsonFilePath = URLDecoder.decode(Thread.currentThread().getContextClassLoader().getResource("datasets/mawps/SingleOp.json").getPath());
        final String destinationJsonFilePath = URLDecoder.decode(Thread.currentThread().getContextClassLoader().getResource("datasets/mawps/").getPath()) + "SingleOpAddSub.json";

        extractAddSubFromJSON(sourceJsonFilePath, destinationJsonFilePath);
    }
}
