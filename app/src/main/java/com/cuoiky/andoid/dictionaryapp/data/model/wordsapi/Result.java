package com.cuoiky.andoid.dictionaryapp.data.model.wordsapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Model class representing a result from a dictionary API.
 *
 * <p>This class represents a word definition along with its part of speech,
 * examples, and synonyms.</p>
 *
 * <p>Author: Gurminder Singh Badwal</p>
 * <p>Lab Section: 012</p>
 * <p>Creation Date: 4th of April 2024</p>
 */
public class Result {
    @SerializedName("definition")
    private String definition;
    @SerializedName("partOfSpeech")
    private String partOfSpeech;
    @SerializedName("examples")
    private List<String> examples;
    @SerializedName("synonyms")
    private List<String> synonyms;

    /**
     * Constructor to initialize a Result object.
     *
     * @param definition   The definition of the word.
     * @param partOfSpeech The part of speech of the word.
     * @param examples     List of examples illustrating the word usage.
     * @param synonyms     List of synonyms for the word.
     */
    public Result(String definition, String partOfSpeech, List<String> examples, List<String> synonyms) {
        this.definition = definition;
        this.partOfSpeech = partOfSpeech;
        this.examples = examples;
        this.synonyms = synonyms;
    }

    /**
     * Get the definition of the word.
     *
     * @return The definition of the word.
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * Set the definition of the word.
     *
     * @param definition The definition of the word to set.
     */
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    /**
     * Get the part of speech of the word.
     *
     * @return The part of speech of the word.
     */
    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    /**
     * Set the part of speech of the word.
     *
     * @param partOfSpeech The part of speech of the word to set.
     */
    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    /**
     * Get the list of examples illustrating the word usage.
     *
     * @return The list of examples illustrating the word usage.
     */
    public List<String> getExamples() {
        return examples;
    }

    /**
     * Set the list of examples illustrating the word usage.
     *
     * @param examples The list of examples to set.
     */
    public void setExamples(List<String> examples) {
        this.examples = examples;
    }

    /**
     * Get the list of synonyms for the word.
     *
     * @return The list of synonyms for the word.
     */
    public List<String> getSynonyms() {
        return synonyms;
    }

    /**
     * Set the list of synonyms for the word.
     *
     * @param synonyms The list of synonyms to set.
     */
    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    @Override
    public String toString() {
        return "\nResult{" +
                "definition='" + definition + '\'' +
                ", partOfSpeech='" + partOfSpeech + '\'' +
                ", examples=" + examples +
                ", synonyms=" + synonyms +
                '}';
    }
}
