package com.neu.sentencesimplification.stanfordcorenlp;

import edu.stanford.nlp.trees.GrammaticalRelation;
import edu.stanford.nlp.trees.TypedDependency;

import java.util.ArrayList;
import java.util.List;

public enum PennRelationsTag {

    nsubj, /** Nominal Subject*/
    dobj,  /** Direct Object */
    nummod, /** Numeric Modifier */
    nmodof, /** nominal modifier with preposition of*/
    compound, /** Compound Noun*/
    amod, /** */
    other;

    private final static String COLON = ":";
    private final static List<PennRelationsTag> MERGEABLE_NOUN_RELATIONS = new ArrayList<>();

    static {
        MERGEABLE_NOUN_RELATIONS.add(compound);
        MERGEABLE_NOUN_RELATIONS.add(amod);

    }

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
        final PennRelationsTag relationsTag = valueOfTypedDependency(dependency);
        return relationsTag.equals(PennRelationsTag.nmodof);
    }

    public static boolean isAMergeableNoun(final TypedDependency dependency) {
        final PennRelationsTag relationsTag = valueOfTypedDependency(dependency);
        return MERGEABLE_NOUN_RELATIONS.contains(relationsTag);
    }

    public static PennRelationsTag valueOfTypedDependency(final TypedDependency dependency) {
        final GrammaticalRelation relation = dependency.reln();
        return valueOfNullable(relation.toString());
    }
}
