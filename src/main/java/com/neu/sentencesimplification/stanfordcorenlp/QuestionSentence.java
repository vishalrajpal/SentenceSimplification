package com.neu.sentencesimplification.stanfordcorenlp;

import java.util.*;

import edu.stanford.nlp.trees.TypedDependency;
import lombok.Getter;

/**
 * QuestionSentence: An individual sentence of a question.
 */
@Getter
public class QuestionSentence {

    private final String mQuestionText;
    private final String mSentenceText;
    private final Collection<TypedDependency> mDependencies;
    private final SortedSet<PartsOfSpeech> mPartsOfSpeech;
    private final Comparator<PartsOfSpeech> mPartsOfSpeechComparator;
    public QuestionSentence(final String questionText, final String sentenceText, final Collection<TypedDependency> dependencies) {
        mQuestionText = questionText;
        mSentenceText = sentenceText;
        mDependencies = dependencies;
        mPartsOfSpeechComparator = getPartsOfSpeechComparator();
        mPartsOfSpeech = extractSentencePartsOfSpeech();
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
        //TODO extract parts of speech from dependencies.

        final Collection<Noun> nouns = extractNouns(mDependencies);
        partsOfSpeeches.addAll(nouns);

        final Collection<Verb> verbs = extractVerbs(mDependencies);
        partsOfSpeeches.addAll(verbs);

        final Collection<Conjunction> conjunctions = extractConjunctions(mDependencies);
        partsOfSpeeches.addAll(conjunctions);

        final Collection<Preposition> prepositions = extractPrepositions(mDependencies);
        partsOfSpeeches.addAll(prepositions);

        final Collection<WHAdverb> whAdverbs = extractWHAdverbs(mDependencies);
        partsOfSpeeches.addAll(whAdverbs);

        final Collection<Expletive> expletives = extractExpletives(mDependencies);
        partsOfSpeeches.addAll(expletives);

        final Collection<Cardinal> cardinals = extractCardinals(mDependencies);
        partsOfSpeeches.addAll(cardinals);

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
            if (PennPartsOfSpeechTag.isAWHADverb(depTag)) {
                final String word = dependency.dep().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final WHAdverb whAdverbFromCurrentDependency = new WHAdverb(dependency, dependency.dep().index(), word, mQuestionText, mSentenceText);
                whAdverbs.add(whAdverbFromCurrentDependency);
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isAWHADverb(govTag)) {
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
}
