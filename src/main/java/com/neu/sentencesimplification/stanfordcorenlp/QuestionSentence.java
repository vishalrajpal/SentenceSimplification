package com.neu.sentencesimplification.stanfordcorenlp;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.trees.TypedDependency;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.*;

/**
 * QuestionSentence: An individual sentence of a question.
 */
@Accessors(prefix = "m")
@Getter
@ToString(of = {"mSentenceText"})
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
    private final TypedDependency mSubjectVerbDependency;

    private final boolean mStartingWithWHAdverb;
    private PartsOfSpeech mSubjectNounPartsOfSpeech;
    private PartsOfSpeech mVerbPartsOfSpeech;

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
        mStartingWithWHAdverb = startsWithWHAdverb();

        mSubjectVerbDependency = extractSubjectVerbDependency(mDependencies);
    }

    private Comparator<PartsOfSpeech> getPartsOfSpeechComparator() {
        final Comparator<PartsOfSpeech> comparator = new Comparator<PartsOfSpeech>() {
            @Override
            public int compare(PartsOfSpeech o1, PartsOfSpeech o2) {
                return o1.getLowestIndex() - o2.getLowestIndex();
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

        return partsOfSpeeches;
    }

    /**
     * Extract Nouns based on dependent and governer. If the index of the Noun has already been encountered,
     * it associates the dependency with the existing Noun.
     * @param dependencies: The dependencies from which the Nouns will be extracted.
     * @return the extracted Nouns.
     */
    private Collection<Noun> extractNouns(final Collection<TypedDependency> dependencies) {
        final Collection<Noun> nouns = new ArrayList<>();

        final Map<Integer, Noun> indexToNounMap = new HashMap<>();

        for (final TypedDependency dependency: dependencies) {

            if (isAMergeableNounDependency(dependency)) {



            } else {
                final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
                if (PennPartsOfSpeechTag.isANoun(depTag)) {
                    final String word = dependency.dep().backingLabel().
                            getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                    final int index = dependency.dep().index();

                    createOrUpdateNoun(nouns, indexToNounMap, dependency, word, index);

                    /** Extract the Subject form the current sentence.*/
                    final String relation = dependency.reln().getShortName();
                    if (PennRelationsTag.valueOfNullable(relation).equals(PennRelationsTag.nsubj)
                            && indexToNounMap.containsKey(index)) {
                        mSubjectNounPartsOfSpeech = indexToNounMap.get(index);
                    }
                }

                final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
                if (PennPartsOfSpeechTag.isANoun(govTag)) {
                    final String word = dependency.gov().backingLabel().
                            getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                    final int index = dependency.gov().index();

                    createOrUpdateNoun(nouns, indexToNounMap, dependency, word, index);
                }
            }
        }
        return nouns;
    }

    /**
     *
     * @param nouns
     * @param indexToNounMap
     * @param dependency
     * @param word
     * @param index
     */
    private void createOrUpdateNoun(final Collection<Noun> nouns,
                                    final Map<Integer, Noun> indexToNounMap,
                                    final TypedDependency dependency,
                                    final String word,
                                    final int index) {
        if (indexToNounMap.containsKey(index)) {
            final Noun nounAlreadySeen = indexToNounMap.get(index);
            nounAlreadySeen.associateDependency(dependency);
        } else {
            final SortedSet<Integer> indices = new TreeSet<>();
            indices.add(index);
            final Noun nounFromCurrentDependency = new Noun(dependency, indices,
                    word, mQuestionText, mSentenceText);
            nouns.add(nounFromCurrentDependency);
            indexToNounMap.put(index, nounFromCurrentDependency);
        }
    }

    /**
     * If the dependent and governer of the dependency can be merged to single string.
     * @param dependency the dependency
     * @return is the dependent and governer can be merged.
     */
    private boolean isAMergeableNounDependency(final TypedDependency dependency) {
        boolean isAMergeableNounDependency = false;
        final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
        final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());

        if (PennPartsOfSpeechTag.isANoun(depTag)
                && PennPartsOfSpeechTag.isANoun(govTag)
                && PennRelationsTag.isAMergeableNoun(dependency)) {
            isAMergeableNounDependency = true;
        }

        return isAMergeableNounDependency;
    }
    /**
     * Extract Verbs based on dependent and governer. If the index of the Verb has already been encountered,
     * it associates the dependency with the existing Verb.
     * @param dependencies: The dependencies from which the Verbs will be extracted.
     * @return the extracted Verbs.
     */
    private Collection<Verb> extractVerbs(final Collection<TypedDependency> dependencies) {
        final Collection<Verb> verbs = new ArrayList<>();

        final Map<Integer, Verb> indexToVerbMap = new HashMap<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isAVerb(depTag)) {
                final String word = dependency.dep().backingLabel().
                        getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final int index = dependency.dep().index();

                if (indexToVerbMap.containsKey(index)) {
                    final Verb verbAlreadySeen = indexToVerbMap.get(index);
                    verbAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final Verb verbFromCurrentDependency = new Verb(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    verbs.add(verbFromCurrentDependency);
                    indexToVerbMap.put(index, verbFromCurrentDependency);
                }
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isAVerb(govTag)) {
                final String word = dependency.gov().backingLabel().
                        getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final int index = dependency.gov().index();

                if (indexToVerbMap.containsKey(index)) {
                    final Verb verbAlreadySeen = indexToVerbMap.get(index);
                    verbAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final Verb verbFromCurrentDependency = new Verb(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    verbs.add(verbFromCurrentDependency);
                    indexToVerbMap.put(index, verbFromCurrentDependency);
                }

                final String relation = dependency.reln().getShortName();
                final PennRelationsTag verbTag = PennRelationsTag.valueOfNullable(relation);
                if ((verbTag.equals(PennRelationsTag.dobj) || verbTag.equals(PennRelationsTag.nsubj))
                        && indexToVerbMap.containsKey(index)) {
                    mVerbPartsOfSpeech = indexToVerbMap.get(index);
                }
            }
        }
        return verbs;
    }

    private Collection<Preposition> extractPrepositions(final Collection<TypedDependency> dependencies) {
        final Collection<Preposition> prepositions = new ArrayList<>();

        final Map<Integer, Preposition> indexToPrepositionMap = new HashMap<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isAPreposition(depTag)) {
                final String word = dependency.dep().backingLabel().
                        getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final int index = dependency.dep().index();

                if (indexToPrepositionMap.containsKey(index)) {
                    final Preposition prepositionAlreadySeen = indexToPrepositionMap.get(index);
                    prepositionAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final Preposition prepositionFromCurrentDependency = new Preposition(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    prepositions.add(prepositionFromCurrentDependency);
                    indexToPrepositionMap.put(index, prepositionFromCurrentDependency);
                }
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isAPreposition(govTag)) {
                final String word = dependency.gov().backingLabel().
                        getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final int index = dependency.gov().index();

                if (indexToPrepositionMap.containsKey(index)) {
                    final Preposition prepositionAlreadySeen = indexToPrepositionMap.get(index);
                    prepositionAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final Preposition prepositionFromCurrentDependency = new Preposition(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    prepositions.add(prepositionFromCurrentDependency);
                    indexToPrepositionMap.put(index, prepositionFromCurrentDependency);
                }
            }
        }
        return prepositions;
    }

    private Collection<Conjunction> extractConjunctions(final Collection<TypedDependency> dependencies) {
        final Collection<Conjunction> conjunctions = new ArrayList<>();

        final Map<Integer, Conjunction> indexToConjunctionMap = new HashMap<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isAConjunction(depTag)) {
                final String word = dependency.dep().backingLabel().
                        getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final int index = dependency.dep().index();

                if (indexToConjunctionMap.containsKey(index)) {
                    final Conjunction conjunctionAlreadySeen = indexToConjunctionMap.get(index);
                    conjunctionAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final Conjunction conjunctionFromCurrentDependency = new Conjunction(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    conjunctions.add(conjunctionFromCurrentDependency);
                    indexToConjunctionMap.put(index, conjunctionFromCurrentDependency);
                }
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isAConjunction(govTag)) {
                final String word = dependency.gov().backingLabel().
                        getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);

                final int index = dependency.gov().index();
                if (indexToConjunctionMap.containsKey(index)) {
                    final Conjunction conjunctionAlreadySeen = indexToConjunctionMap.get(index);
                    conjunctionAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final Conjunction conjunctionFromCurrentDependency = new Conjunction(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    conjunctions.add(conjunctionFromCurrentDependency);
                    indexToConjunctionMap.put(index, conjunctionFromCurrentDependency);
                }
            }
        }
        return conjunctions;
    }

    private Collection<WHAdverb> extractWHAdverbs(final Collection<TypedDependency> dependencies) {
        final Collection<WHAdverb> whAdverbs = new ArrayList<>();

        final Map<Integer, WHAdverb> indexToWHAdverbMap = new HashMap<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isAWHAdverb(depTag)) {
                final String word = dependency.dep().backingLabel().
                        getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final int index = dependency.dep().index();

                if (indexToWHAdverbMap.containsKey(index)) {
                    final WHAdverb whAdverbAlreadySeen = indexToWHAdverbMap.get(index);
                    whAdverbAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final WHAdverb whAdverbFromCurrentDependency = new WHAdverb(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    whAdverbs.add(whAdverbFromCurrentDependency);
                    indexToWHAdverbMap.put(index, whAdverbFromCurrentDependency);
                }
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isAWHAdverb(govTag)) {
                final String word = dependency.gov().backingLabel().
                        getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);
                final int index = dependency.gov().index();

                if (indexToWHAdverbMap.containsKey(index)) {
                    final WHAdverb whAdverbAlreadySeen = indexToWHAdverbMap.get(index);
                    whAdverbAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final WHAdverb whAdverbFromCurrentDependency = new WHAdverb(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    whAdverbs.add(whAdverbFromCurrentDependency);
                    indexToWHAdverbMap.put(index, whAdverbFromCurrentDependency);
                }
            }
        }
        return whAdverbs;
    }

    private Collection<Expletive> extractExpletives(final Collection<TypedDependency> dependencies) {
        final Collection<Expletive> expletives = new ArrayList<>();

        final Map<Integer, Expletive> indexToExpletiveMap = new HashMap<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isAExpletive(depTag)) {
                final String word = dependency.dep().backingLabel().
                        getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);

                final int index = dependency.dep().index();
                if (indexToExpletiveMap.containsKey(index)) {
                    final Expletive expletiveAlreadySeen = indexToExpletiveMap.get(index);
                    expletiveAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final Expletive expletiveFromCurrentDependency = new Expletive(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    expletives.add(expletiveFromCurrentDependency);
                    indexToExpletiveMap.put(index, expletiveFromCurrentDependency);
                }
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isAExpletive(govTag)) {
                final String word = dependency.gov().backingLabel().
                        getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);

                final int index = dependency.gov().index();
                if (indexToExpletiveMap.containsKey(index)) {
                    final Expletive expletiveAlreadySeen = indexToExpletiveMap.get(index);
                    expletiveAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final Expletive expletiveFromCurrentDependency = new Expletive(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    expletives.add(expletiveFromCurrentDependency);
                    indexToExpletiveMap.put(index, expletiveFromCurrentDependency);
                }
            }
        }
        return expletives;
    }

    private Collection<Cardinal> extractCardinals(final Collection<TypedDependency> dependencies) {
        final Collection<Cardinal> cardinals = new ArrayList<>();

        final Map<Integer, Cardinal> indexToCardinalMap = new HashMap<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isACardinal(depTag)) {
                final String word = dependency.dep().backingLabel().
                        getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);

                final int index = dependency.dep().index();
                if (indexToCardinalMap.containsKey(index)) {
                    final Cardinal cardinalAlreadySeen = indexToCardinalMap.get(index);
                    cardinalAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final Cardinal cardinalFromCurrentDependency = new Cardinal(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    cardinals.add(cardinalFromCurrentDependency);
                    indexToCardinalMap.put(index, cardinalFromCurrentDependency);
                }
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isACardinal(govTag)) {
                final String word = dependency.gov().backingLabel().
                        getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);

                final int index = dependency.gov().index();
                if (indexToCardinalMap.containsKey(index)) {
                    final Cardinal cardinalAlreadySeen = indexToCardinalMap.get(index);
                    cardinalAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final Cardinal cardinalFromCurrentDependency = new Cardinal(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    cardinals.add(cardinalFromCurrentDependency);
                    indexToCardinalMap.put(index, cardinalFromCurrentDependency);
                }
            }
        }
        return cardinals;
    }

    private Collection<Adjective> extractAdjectives(final Collection<TypedDependency> dependencies) {
        final Collection<Adjective> adjectives = new ArrayList<>();

        final Map<Integer, Adjective> indexToAdjectiveMap = new HashMap<>();

        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isAAdjective(depTag)) {
                final String word = dependency.dep().backingLabel().
                        getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);

                final int index = dependency.dep().index();
                if (indexToAdjectiveMap.containsKey(index)) {
                    final Adjective adjectiveAlreadySeen = indexToAdjectiveMap.get(index);
                    adjectiveAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final Adjective adjectiveFromCurrentDependency = new Adjective(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    adjectives.add(adjectiveFromCurrentDependency);
                    indexToAdjectiveMap.put(index, adjectiveFromCurrentDependency);
                }
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isAAdjective(govTag)) {
                final String word = dependency.gov().backingLabel().
                        getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);

                final int index = dependency.gov().index();
                if (indexToAdjectiveMap.containsKey(index)) {
                    final Adjective adjectiveAlreadySeen = indexToAdjectiveMap.get(index);
                    adjectiveAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final Adjective adjectiveFromCurrentDependency = new Adjective(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    adjectives.add(adjectiveFromCurrentDependency);
                    indexToAdjectiveMap.put(index, adjectiveFromCurrentDependency);
                }
            }
        }
        return adjectives;
    }

    private Collection<Determiner> extractDeterminers(final Collection<TypedDependency> dependencies) {
        final Collection<Determiner> determiners = new ArrayList<>();

        final Map<Integer, Determiner> indexToDeterminerMap = new HashMap<>();
        for (final TypedDependency dependency: dependencies) {
            final PennPartsOfSpeechTag depTag = PennPartsOfSpeechTag.valueOfNullable(dependency.dep().tag());
            if (PennPartsOfSpeechTag.isADeterminer(depTag)) {
                final String word = dependency.dep().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);

                final int index = dependency.dep().index();
                if (indexToDeterminerMap.containsKey(index)) {
                    final Determiner determinerAlreadySeen = indexToDeterminerMap.get(index);
                    determinerAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final Determiner determinerFromCurrentDependency = new Determiner(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    determiners.add(determinerFromCurrentDependency);
                    indexToDeterminerMap.put(index, determinerFromCurrentDependency);
                }
            }

            final PennPartsOfSpeechTag govTag = PennPartsOfSpeechTag.valueOfNullable(dependency.gov().tag());
            if (PennPartsOfSpeechTag.isADeterminer(govTag)) {
                final String word = dependency.gov().backingLabel().getString(edu.stanford.nlp.ling.CoreAnnotations.ValueAnnotation.class);

                final int index = dependency.gov().index();
                if (indexToDeterminerMap.containsKey(index)) {
                    final Determiner determinerAlreadySeen = indexToDeterminerMap.get(index);
                    determinerAlreadySeen.associateDependency(dependency);
                } else {
                    final SortedSet<Integer> indices = new TreeSet<>();
                    indices.add(index);
                    final Determiner determinerFromCurrentDependency = new Determiner(dependency, indices,
                            word, mQuestionText, mSentenceText);
                    determiners.add(determinerFromCurrentDependency);
                    indexToDeterminerMap.put(index, determinerFromCurrentDependency);
                }
            }
        }
        return determiners;
    }

    private TypedDependency extractSubjectVerbDependency (final Collection<TypedDependency> dependencies) {
        TypedDependency subjectVerbDependency = null;
        for (final TypedDependency dependency: dependencies) {
            final String relation = dependency.reln().getShortName();
            if (PennRelationsTag.valueOfNullable(relation).equals(PennRelationsTag.nsubj)) {
                subjectVerbDependency = dependency;
                break;
            }
        }
        return subjectVerbDependency;
    }

    private boolean startsWithWHAdverb() {
        boolean startsWithWhAdverb = false;
        for(final WHAdverb whAdverb: mWHAdverbs) {
            if (whAdverb.getLowestIndex() == 1) {
                startsWithWhAdverb = true;
                break;
            }
        }
        return startsWithWhAdverb;
    }

    public boolean hasConjunction() {
        return mConjunctions.size() > 0;
    }
}
