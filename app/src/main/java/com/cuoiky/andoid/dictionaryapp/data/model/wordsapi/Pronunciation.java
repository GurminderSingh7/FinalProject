package com.cuoiky.andoid.dictionaryapp.data.model.wordsapi;

import com.google.gson.annotations.SerializedName;

/**
 * Model class representing pronunciation data.
 *
 * <p>This class represents the pronunciation of a word, including different
 * forms such as noun and verb.</p>
 *
 * <p>Author: Gurminder Singh Badwal</p>
 * <p>Lab Section: 012</p>
 * <p>Creation Date: 4th of April 2024</p>
 */
public class Pronunciation {
    @SerializedName("all")
    private String all;
    @SerializedName("noun")
    private String noun;
    @SerializedName("verb")
    private String verb;

    /**
     * Constructor to initialize a Pronunciation object.
     *
     * @param all  The pronunciation of the word.
     * @param noun The pronunciation of the word as a noun.
     * @param verb The pronunciation of the word as a verb.
     */
    public Pronunciation(String all, String noun, String verb) {
        this.all = all;
        this.noun = noun;
        this.verb = verb;
    }

    /**
     * Get the pronunciation of the word.
     *
     * @return The pronunciation of the word.
     */
    public String getAll() {
        return all;
    }

    /**
     * Set the pronunciation of the word.
     *
     * @param all The pronunciation of the word to set.
     */
    public void setAll(String all) {
        this.all = all;
    }

    /**
     * Get the pronunciation of the word as a noun.
     *
     * @return The pronunciation of the word as a noun.
     */
    public String getNoun() {
        return noun;
    }

    /**
     * Set the pronunciation of the word as a noun.
     *
     * @param noun The pronunciation of the word as a noun to set.
     */
    public void setNoun(String noun) {
        this.noun = noun;
    }

    /**
     * Get the pronunciation of the word as a verb.
     *
     * @return The pronunciation of the word as a verb.
     */
    public String getVerb() {
        return verb;
    }

    /**
     * Set the pronunciation of the word as a verb.
     *
     * @param verb The pronunciation of the word as a verb to set.
     */
    public void setVerb(String verb) {
        this.verb = verb;
    }

    @Override
    public String toString() {
        return "Pronunciation{" +
                "all='" + all + '\'' +
                ", noun='" + noun + '\'' +
                ", verb='" + verb + '\'' +
                '}';
    }
}
