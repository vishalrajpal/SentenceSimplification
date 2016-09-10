package com.neu.sentencesimplification.datasetreader;

import java.net.URLDecoder;

/**
 * Public Keys needed by the datasetreader package
 */
public class PublicKeys {

    public static final String KEY_PARENT_INDEX = "ParentIndex";
    public static final String DATASET_DIRECTORY = "datasets/mawps/";
    public static final String DATASET_DIRECTORY_ESCAPED_PATH = URLDecoder
            .decode(Thread.currentThread().getContextClassLoader().getResource(DATASET_DIRECTORY).getPath());
    public static final String KEY_S_QUESTION = "sQuestion";
    public static final String KEY_SENTENCE = "Sentence";
    public static final String KEY_LABEL = "label";
    public static final String KEY_SENTENCES = "Sentences";
    public static final String KEY_SYNTACTICPATTERN = "SyntacticPattern";
    public static final String KEY_SIMPLIFIED_SENTENCES = "SimplifiedSentences";
}
