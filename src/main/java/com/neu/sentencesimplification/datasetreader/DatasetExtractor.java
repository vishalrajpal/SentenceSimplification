package com.neu.sentencesimplification.datasetreader;

import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;
import com.neu.sentencesimplification.stanfordcorenlp.PartsOfSpeech;
import com.neu.sentencesimplification.stanfordcorenlp.QuestionSentence;

import javax.json.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

import static com.neu.sentencesimplification.datasetreader.PublicKeys.*;

/**
 * Merge all the available datasets.
 */
public class DatasetExtractor {

    private static final List<String> DATASET_FILE_PATHS = new ArrayList<>();

    private static final String ADD_SUB_FILE_PATH = DATASET_DIRECTORY + "AddSub.json";
    private static final String MULTI_ARITH_FILE_PATH = DATASET_DIRECTORY + "MultiArithAddSub.json";
    private static final String SINGLE_EQ_FILE_PATH = DATASET_DIRECTORY + "SingleEQAddSub.json";
    private static final String SINGLE_OP_FILE_PATH = DATASET_DIRECTORY + "SingleOpAddSub.json";


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
                    final JsonArrayBuilder sentencesArrayBuilder = Json.createArrayBuilder();
                    final String questionText = question.getString(KEY_S_QUESTION);

                    final List<QuestionSentence> sentences = DependenciesParser.extractPartsOfSpeechFromDependencies(questionText);

                    for (final QuestionSentence sentence: sentences) {
                        final JsonArrayBuilder simplifiedSentencesArrayBuilder = Json.createArrayBuilder();
                        for (final QuestionSentence simpleSentence : sentence.getSimplifiedSentences()) {
                            final SortedSet<PartsOfSpeech> partsOfSpeeches = simpleSentence.getPartsOfSpeech();
                            StringBuilder pattern = new StringBuilder();
                            for (final PartsOfSpeech part : partsOfSpeeches) {
                                String type =  part.getType().toString();
                                pattern.append(type.charAt(0));
                            }

                            final JsonObject simplifiedSentenceObject = Json.createObjectBuilder()
                                    .add(KEY_SENTENCE, simpleSentence.getSentenceText())
                                    .add(KEY_LABEL, "")
                                    .add(KEY_SYNTACTICPATTERN, pattern.toString())
                                    .build();
                            simplifiedSentencesArrayBuilder.add(simplifiedSentenceObject);
                        }

                        final JsonObject sentenceObject = Json.createObjectBuilder()
                                .add(KEY_SENTENCE, sentence.getSentenceText())
                                .add(KEY_SIMPLIFIED_SENTENCES, simplifiedSentencesArrayBuilder.build())
                                .build();
                        sentencesArrayBuilder.add(sentenceObject);
                    }
                    newObjectBuilder.add(KEY_SENTENCES, sentencesArrayBuilder.build());

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
