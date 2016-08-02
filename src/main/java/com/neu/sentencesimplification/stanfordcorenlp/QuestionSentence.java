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

        System.out.println(partsOfSpeeches);
        return partsOfSpeeches;
    }

    private Collection<Noun> extractNouns(final Collection<TypedDependency> dependencies) {
        final Collection<Noun> nouns = new HashSet<>();

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
}
