package com.neu.sentencesimplification.stanfordcorenlp;

public enum PennRelationsTag {

    nsubj,
    dobj,
    other;

    public static PennRelationsTag valueOfNullable (final String relation) {
        PennRelationsTag relationTag;
        try {
            relationTag = PennRelationsTag.valueOf(relation);
        } catch (final Exception e) {
            relationTag = PennRelationsTag.other;
        }
        return relationTag;
    }
}
