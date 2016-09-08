package com.neu.sentencesimplification.datasetreader;

import javax.json.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Merge all the available datasets.
 */
public class DatasetExtractor {

    private static final List<String> DATASET_FILE_PATHS = new ArrayList<>();
    private static final String DATASET_DIRECTORY = "datasets/mawps/";
    private static final String ADD_SUB_FILE_PATH = DATASET_DIRECTORY + "AddSub.json";
    private static final String MULTI_ARITH_FILE_PATH = DATASET_DIRECTORY + "MultiArithAddSub.json";
    private static final String SINGLE_EQ_FILE_PATH = DATASET_DIRECTORY + "SingleEQAddSub.json";
    private static final String SINGLE_OP_FILE_PATH = DATASET_DIRECTORY + "SingleOpAddSub.json";
    private static final String KEY_PARENT_INDEX = "ParentIndex";

    static {
        DATASET_FILE_PATHS.add(ADD_SUB_FILE_PATH);
        DATASET_FILE_PATHS.add(MULTI_ARITH_FILE_PATH);
        DATASET_FILE_PATHS.add(SINGLE_EQ_FILE_PATH);
        DATASET_FILE_PATHS.add(SINGLE_OP_FILE_PATH);
    }

    private static void extractDataset() {
        try {
            final String datasetDirPath = URLDecoder.decode(Thread.currentThread().getContextClassLoader().getResource(DATASET_DIRECTORY).getPath());
            final String outputFile = datasetDirPath + "AdditionSubtraction.json";
            final File datasetOutputFile = new File(outputFile);
            final FileOutputStream outputStream = new FileOutputStream(datasetOutputFile);
            final JsonArrayBuilder outputArray = Json.createArrayBuilder();
            int parentIndex = 1;
            for (final String filePath: DATASET_FILE_PATHS) {
                final String datasetFilePath = URLDecoder.decode(Thread.currentThread().getContextClassLoader().getResource(filePath).getPath());
                final InputStream inputFileSttream = new FileInputStream(datasetFilePath);
                final JsonReader jsonReader = Json.createReader(inputFileSttream);
                final JsonArray fileArray = jsonReader.readArray();
                final int datasetSize = fileArray.size();
                for (int questionCounter = 0; questionCounter < datasetSize; questionCounter++) {
                    final JsonObject question = fileArray.getJsonObject(questionCounter);
                    final JsonObjectBuilder newObjectBuilder = Json.createObjectBuilder();
                    newObjectBuilder.add(KEY_PARENT_INDEX, parentIndex++);
                    for (final String key: question.keySet()) {
                        newObjectBuilder.add(key, question.get(key));
                    }
                    final JsonObject outputObject = newObjectBuilder.build();
                    outputArray.add(outputObject);
                }

            }

            final JsonWriter writer = Json.createWriter(outputStream);
            writer.write(outputArray.build());
            writer.close();

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        extractDataset();
    }
}
