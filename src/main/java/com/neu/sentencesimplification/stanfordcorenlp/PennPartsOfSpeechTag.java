package com.neu.sentencesimplification.stanfordcorenlp;

import java.util.ArrayList;
import java.util.List;

/**
 * Parts of Speech tags representing the Stanford dependencies.
 */
public enum PennPartsOfSpeechTag {

    CC,     /** Coordinating Conjunction */
    CD,     /** Cardinal Number */
    DT,     /** Determiner */
    EX,     /** Existential 'there' */
    FW,     /** Foreign Word */
    IN,     /** Preposition or subordinating conjunction */
    JJ,     /** Adjective */
    JJR,    /** Adjective Comparative */
    JJS,    /** Adjective Superlative */
    LS,     /** List item marker */
    MD,     /** Modal */
    NN,     /** Noun, singular or mass */
    NNS,    /** Noun Plural */
    NNP,    /** Proper singular noun */
    NNPS,   /** Proper plural noun */
    PDT,    /** Predeterminer */
    POS,    /** Possessive ending */
    PRP,    /** Personal Pronoun */
    PRP$,   /** Possessive Pronoun */
    RB,     /** Adverb */
    RBR,    /** Adverb comparative */
    RBS,    /** Adverb superlative */
    RP,     /** Particle */
    SYM,    /** Symbol */
    TO,     /** 'to' */
    UH,     /** Interjection */
    VB,     /** Verb, base form */
    VBD,    /** Verb, past tense */
    VBG,    /** Verb, gerund or present participle */
    VBN,    /** Verb, past participle */
    VBP,    /** Verb, non-3rd person singular present */
    VBZ,    /** Verb, 3rd person singular present */
    WDT,    /** Wh-determiner */
    WP,     /** Wh-pronoun */
    WP$,    /** Possessive wh-pronoun */
    WRB,    /** Wh-adverb */

    UNKNOWN;   /** NULL in case of Root's governer. */

    private static final List<PennPartsOfSpeechTag> PENN_NOUN_TAGS = new ArrayList<>();
    private static final List<PennPartsOfSpeechTag> PENN_VERB_TAGS = new ArrayList<>();
    private static final List<PennPartsOfSpeechTag> PENN_PREPOSITION_TAGS = new ArrayList<>();
    private static final List<PennPartsOfSpeechTag> PENN_CONJUNCTION_TAGS = new ArrayList<>();
    private static final List<PennPartsOfSpeechTag> PENN_WHADVERB_TAGS = new ArrayList<>();
    private static final List<PennPartsOfSpeechTag> PENN_EXPLETIVE_TAGS = new ArrayList<>();
    private static final List<PennPartsOfSpeechTag> PENN_CARDINAL_TAGS = new ArrayList<>();

    static {
        PENN_NOUN_TAGS.add(NN);
        PENN_NOUN_TAGS.add(NNS);
        PENN_NOUN_TAGS.add(NNP);
        PENN_NOUN_TAGS.add(NNPS);
        PENN_NOUN_TAGS.add(WP);
        PENN_NOUN_TAGS.add(WP$);
        PENN_NOUN_TAGS.add(PRP);
        PENN_NOUN_TAGS.add(PRP$);

        PENN_VERB_TAGS.add(VB);
        PENN_VERB_TAGS.add(VBD);
        PENN_VERB_TAGS.add(VBG);
        PENN_VERB_TAGS.add(VBN);
        PENN_VERB_TAGS.add(VBP);
        PENN_VERB_TAGS.add(VBZ);

        PENN_PREPOSITION_TAGS.add(IN);

        PENN_CONJUNCTION_TAGS.add(CC);

        PENN_WHADVERB_TAGS.add(WRB);

        PENN_EXPLETIVE_TAGS.add(EX);

        PENN_CARDINAL_TAGS.add(CD);
    }

    public static boolean isANoun(final PennPartsOfSpeechTag tag) {
        return PENN_NOUN_TAGS.contains(tag);
    }

    public static boolean isAVerb(final PennPartsOfSpeechTag tag) {
        return PENN_VERB_TAGS.contains(tag);
    }

    public static boolean isAPreposition(final PennPartsOfSpeechTag tag) {
        return PENN_PREPOSITION_TAGS.contains(tag);
    }

    public static boolean isAConjunction(final PennPartsOfSpeechTag tag) {
        return PENN_CONJUNCTION_TAGS.contains(tag);
    }

    public static boolean isAWHADverb(final PennPartsOfSpeechTag tag) {
        return PENN_WHADVERB_TAGS.contains(tag);
    }

    public static boolean isAExpletive(final PennPartsOfSpeechTag tag) {
        return PENN_EXPLETIVE_TAGS.contains(tag);
    }

    public static boolean isACardinal(final PennPartsOfSpeechTag tag) {
        return PENN_CARDINAL_TAGS.contains(tag);
    }

    public static PennPartsOfSpeechTag valueOfNullable(final String tagString) {
        PennPartsOfSpeechTag tag;

        try {
            tag = PennPartsOfSpeechTag.valueOf(tagString);
        } catch (final Exception e) {
            tag = PennPartsOfSpeechTag.UNKNOWN;
        }

        return tag;
    }
}
