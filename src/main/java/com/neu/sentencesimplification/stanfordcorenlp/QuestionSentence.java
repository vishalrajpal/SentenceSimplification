package com.neu.sentencesimplification.stanfordcorenlp;

import java.util.*;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.trees.TypedDependency;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * QuestionSentence: An individual sentence of a question.
 */
@Accessors(prefix = "m")
@Getter
public class QuestionSentence {

    private final String mQuestionText;
    private final String mSentenceText;
    private final Collection<TypedDependency> mDependencies;
    private final SortedSet<PartsOfSpeech> mPartsOfSpeech;
    private final Comparator<PartsOfSpeech> mPartsOfSpeechComparator;
    private final List<TaggedWord> mTaggedWords;

    private final Collection<Noun> mNouns;
    private final Collection<Verb> mVerbs;
    private final Collection<Conjunction> mConjunctions;
    private final Collection<Preposition> mPrepositions;
    private final Collection<WHAdverb> mWHAdverbs;
    private final Collection<Expletive> mExpletives;
    private final Collection<Cardinal> mCardinals;
    private final Collection<Adjective> mAdjectives;
    private final Collection<Determiner> mDeterminers;

    public QuestionSentence(final String questionText,
                            final String sentenceText,
                            final Collection<TypedDependency> dependencies,
                            final List<TaggedWord> taggedWords) {
        mQuestionText = questionText;
        mSentenceText = sentenceText;
        mDependencies = dependencies;
        mPartsOfSpeechComparator = getPartsOfSpeechComparator();

        mNouns = extractNouns(mDependencies);
        mVerbs = extractVerbs(mDependencies);
        mConjunctions = extractConjunctions(mDependencies);
        mPrepositions = extractPrepositions(mDependencies);
        mWHAdverbs = extractWHAdverbs(mDependencies);
        mExpletives = extractExpletives(mDependencies);
        mCardinals = extractCardinals(mDependencies);
        mAdjectives = extractAdjectives(mDependencies);
        mDeterminers = extractDeterminers(mDependencies);

        mPartsOfSpeech = extractSentencePartsOfSpeech();
        mTaggedWords = taggedWords;
    }

    private Comparator<PartsOfSpeech> getPartsOfSpeechComparator() {
        final Comparator<PartsOfSpeech> comparator = new Comparator<PartsOfSpeech>() {
            @Override
            public int compare(PartsOfSpeech o1, PartsOfSpeech o2) {
                return o1.getIndex() - o2.getIndex();
            }
        };
        return comparator;
    }

    private SortedSet<PartsOfSpeech> extractSentencePartsOfSpeech() {
        final SortedSet<PartsOfSpeech> partsOfSpeeches = new TreeSet<>(mPartsOfSpeechComparator);

        partsOfSpeeches.addAll(mNouns);
        partsOfSpeeches.addAll(mVerbs);
        partsOfSpeeches.addAll(mConjunctions);
        partsOfSpeeches.addAll(mPrepositions);
        partsOfSpeeches.addAll(mWHAdverbs);
        partsOfSpeeches.addAll(mExpletives);
        partsOfSpeeches.addAll(mCardinals);
        partsOfSpeeches.addAll(mAdjectives);
        partsOfSpeeches.addAll(mDeterminers);

        System.out.println(partsOfSpeeches);
        return partsOfSpeeches;
    }

    private Collection<Noun> extractNouns(final Collection<TypedDependency> dependencies) {
        final Collection<Noun> nouns = new ArrayList<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isANoun(depTag)) {
                final String word = dependency.dep().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Noun nounFromCurrentDependency = new Noun(dependency, dependency.dep().index(), word, mQuestionText, mSentenceText);
                nouns.add(nounFromCurrentDependency);
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isANoun(govTag)) {
                final String word = dependency.gov().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Noun nounFromCurrentDependency = new Noun(dependency, dependency.gov().index(), word, mQuestionText, mSentenceText);
                nouns.add(nounFromCurrentDependency);
            }
        }
        return nouns;
    }

    private Collection<Verb> extractVerbs(final Collection<TypedDependency> dependencies) {
        final Collection<Verb> verbs = new ArrayList<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isAVerb(depTag)) {
                final String word = dependency.dep().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Verb verbFromCurrentDependency = new Verb(dependency, dependency.dep().index(), word, mQuestionText, mSentenceText);
                verbs.add(verbFromCurrentDependency);
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isAVerb(govTag)) {
                final String word = dependency.gov().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Verb verbFromCurrentDependency = new Verb(dependency, dependency.gov().index(), word, mQuestionText, mSentenceText);
                verbs.add(verbFromCurrentDependency);
            }
        }
        return verbs;
    }

    private Collection<Preposition> extractPrepositions(final Collection<TypedDependency> dependencies) {
        final Collection<Preposition> prepositions = new ArrayList<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isAPreposition(depTag)) {
                final String word = dependency.dep().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Preposition prepositionFromCurrentDependency = new Preposition(dependency, dependency.dep().index(), word, mQuestionText, mSentenceText);
                prepositions.add(prepositionFromCurrentDependency);
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isAPreposition(govTag)) {
                final String word = dependency.gov().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Preposition prepositionFromCurrentDependency = new Preposition(dependency, dependency.gov().index(), word, mQuestionText, mSentenceText);
                prepositions.add(prepositionFromCurrentDependency);
            }
        }
        return prepositions;
    }

    private Collection<Conjunction> extractConjunctions(final Collection<TypedDependency> dependencies) {
        final Collection<Conjunction> conjunctions = new ArrayList<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isAConjunction(depTag)) {
                final String word = dependency.dep().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Conjunction conjunctionFromCurrentDependency = new Conjunction(dependency, dependency.dep().index(), word, mQuestionText, mSentenceText);
                conjunctions.add(conjunctionFromCurrentDependency);
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isAConjunction(govTag)) {
                final String word = dependency.gov().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Conjunction conjunctionFromCurrentDependency = new Conjunction(dependency, dependency.gov().index(), word, mQuestionText, mSentenceText);
                conjunctions.add(conjunctionFromCurrentDependency);
            }
        }
        return conjunctions;
    }

    private Collection<WHAdverb> extractWHAdverbs(final Collection<TypedDependency> dependencies) {
        final Collection<WHAdverb> whAdverbs = new ArrayList<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isAWHAdverb(depTag)) {
                final String word = dependency.dep().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final WHAdverb whAdverbFromCurrentDependency = new WHAdverb(dependency, dependency.dep().index(), word, mQuestionText, mSentenceText);
                whAdverbs.add(whAdverbFromCurrentDependency);
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isAWHAdverb(govTag)) {
                final String word = dependency.gov().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final WHAdverb whAdverbFromCurrentDependency = new WHAdverb(dependency, dependency.gov().index(), word, mQuestionText, mSentenceText);
                whAdverbs.add(whAdverbFromCurrentDependency);
            }
        }
        return whAdverbs;
    }

    private Collection<Expletive> extractExpletives(final Collection<TypedDependency> dependencies) {
        final Collection<Expletive> expletives = new ArrayList<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isAExpletive(depTag)) {
                final String word = dependency.dep().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Expletive expletiveFromCurrentDependency = new Expletive(dependency, dependency.dep().index(), word, mQuestionText, mSentenceText);
                expletives.add(expletiveFromCurrentDependency);
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isAExpletive(govTag)) {
                final String word = dependency.gov().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Expletive expletiveFromCurrentDependency = new Expletive(dependency, dependency.gov().index(), word, mQuestionText, mSentenceText);
                expletives.add(expletiveFromCurrentDependency);
            }
        }
        return expletives;
    }

    private Collection<Cardinal> extractCardinals(final Collection<TypedDependency> dependencies) {
        final Collection<Cardinal> cardinals = new ArrayList<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isACardinal(depTag)) {
                final String word = dependency.dep().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Cardinal cardinalFromCurrentDependency = new Cardinal(dependency, dependency.dep().index(), word, mQuestionText, mSentenceText);
                cardinals.add(cardinalFromCurrentDependency);
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isACardinal(govTag)) {
                final String word = dependency.gov().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Cardinal cardinalFromCurrentDependency = new Cardinal(dependency, dependency.gov().index(), word, mQuestionText, mSentenceText);
                cardinals.add(cardinalFromCurrentDependency);
            }
        }
        return cardinals;
    }

    private Collection<Adjective> extractAdjectives(final Collection<TypedDependency> dependencies) {
        final Collection<Adjective> adjectives = new ArrayList<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isAAdjective(depTag)) {
                final String word = dependency.dep().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Adjective adjectiveFromCurrentDependency = new Adjective(dependency, dependency.dep().index(), word, mQuestionText, mSentenceText);
                adjectives.add(adjectiveFromCurrentDependency);
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isAAdjective(govTag)) {
                final String word = dependency.gov().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Adjective adjectiveFromCurrentDependency = new Adjective(dependency, dependency.gov().index(), word, mQuestionText, mSentenceText);
                adjectives.add(adjectiveFromCurrentDependency);
            }
        }
        return adjectives;
    }

    private Collection<Determiner> extractDeterminers(final Collection<TypedDependency> dependencies) {
        final Collection<Determiner> determiners = new ArrayList<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isADeterminer(depTag)) {
                final String word = dependency.dep().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Determiner determinerFromCurrentDependency = new Determiner(dependency, dependency.dep().index(), word, mQuestionText, mSentenceText);
                determiners.add(determinerFromCurrentDependency);
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isADeterminer(govTag)) {
                final String word = dependency.gov().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final Determiner determinerFromCurrentDependency = new Determiner(dependency, dependency.gov().index(), word, mQuestionText, mSentenceText);
                determiners.add(determinerFromCurrentDependency);
            }
        }
        return determiners;
    }

    public boolean hasConjunction() {
        return mConjunctions.size() > 0;
    }
}
