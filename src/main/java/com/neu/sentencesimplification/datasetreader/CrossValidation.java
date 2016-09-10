package com.neu.sentencesimplification.datasetreader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import static com.neu.sentencesimplification.datasetreader.PublicKeys.DATASET_DIRECTORY_ESCAPED_PATH;
import static com.neu.sentencesimplification.datasetreader.PublicKeys.KEY_PARENT_INDEX;

/** Creates k folds from the dataset. */
public class CrossValidation {


    public static void createCrossValidationFolds(final String dataFilePath, final int numberOfFolds) {

        try {
            /** Create appropriate lists for k-folds.*/
            final List<List<Integer>> foldsIndices = new ArrayList<>();
            for (int foldCounter = 1; foldCounter <= numberOfFolds; foldCounter++) {
                final List<Integer> foldList = new ArrayList<>();
                foldsIndices.add(foldList);
            }

            /** Read the data file as a json array.*/
            final String escapedDataFilePath = URLDecoder
                    .decode(Thread.currentThread().getContextClassLoader().getResource(dataFilePath).getPath());
            final InputStream inputFileSttream = new FileInputStream(escapedDataFilePath);
            final JsonReader jsonReader = Json.createReader(inputFileSttream);
            final JsonArray fileArray = jsonReader.readArray();
            jsonReader.close();

            final int dataSize = fileArray.size();

            for (int questionCounter = 0; questionCounter < dataSize; questionCounter++) {
                final JsonObject question = fileArray.getJsonObject(questionCounter);
                final int randomFoldIndex = (int) Math.round(Math.random() * (numberOfFolds - 1));

                final List<Integer> currentFoldList = foldsIndices.get(randomFoldIndex);
                currentFoldList.add(question.getInt(KEY_PARENT_INDEX));
            }


            for (int foldCounter = 0; foldCounter < numberOfFolds; foldCounter++) {
                System.out.println("Current Fold: " + foldCounter + ":" + foldsIndices.get(foldCounter).size());
                final String foldFilePath = DATASET_DIRECTORY_ESCAPED_PATH + "/folds/fold-" + (foldCounter + 1) + ".txt";
                final FileOutputStream foldFileOutputStream = new FileOutputStream(foldFilePath);
                foldFileOutputStream.write(foldsIndices.get(foldCounter).toString().getBytes());
                foldFileOutputStream.close();
            }

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
