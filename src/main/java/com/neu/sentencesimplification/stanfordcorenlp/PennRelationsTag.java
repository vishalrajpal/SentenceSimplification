package com.neu.sentencesimplification.stanfordcorenlp;

import edu.stanford.nlp.trees.GrammaticalRelation;
import edu.stanford.nlp.trees.TypedDependency;

public enum PennRelationsTag {

    nsubj,
    dobj,
    nummod,
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

    public static boolean isANummod(final TypedDependency dependency) {
        final GrammaticalRelation relation = dependency.reln();
        final PennRelationsTag relationTag = valueOfNullable(relation.getShortName());
        return relationTag.equals(PennRelationsTag.nummod);
    }
}
