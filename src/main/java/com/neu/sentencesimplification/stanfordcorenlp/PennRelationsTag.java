package com.neu.sentencesimplification.stanfordcorenlp;

import edu.stanford.nlp.trees.GrammaticalRelation;
import edu.stanford.nlp.trees.TypedDependency;

public enum PennRelationsTag {

    nsubj,
    dobj,
    nummod,
    nmodof,
    other;

    private final static String COLON = ":";

    public static PennRelationsTag valueOfNullable (final String relation) {
        PennRelationsTag relationTag;
        try {
            if (relation.contains(COLON)){
                final String relationWithoutColon = relation.replace(COLON, "");
                relationTag = PennRelationsTag.valueOf(relationWithoutColon);
            } else {
                relationTag = PennRelationsTag.valueOf(relation);
            }

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

    public static boolean isNmodOf(final TypedDependency dependency){
        final GrammaticalRelation relation = dependency.reln();
        final PennRelationsTag relationsTag = valueOfNullable(relation.toString());
        return relationsTag.equals(PennRelationsTag.nmodof);
    }
}
