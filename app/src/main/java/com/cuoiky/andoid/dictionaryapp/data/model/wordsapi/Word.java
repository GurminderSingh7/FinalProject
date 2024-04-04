package com.cuoiky.andoid.dictionaryapp.data.model.wordsapi;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Model class representing a word from a dictionary API.
 *
 * <p>This class represents a word along with its definition, pronunciation,
 * and other details obtained from a dictionary API.</p>
 *
 * <p>Author: Gurminder Singh Badwal</p>
 * <p>Lab Section: 012</p>
 * <p>Creation Date: 4th of April 2024</p>
 */
@Entity(tableName = "FavouriteWord", indices = {@Index(value = {"word"}, unique = true)})
public class Word implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "word")
    @SerializedName("word")
    private String word;

    @ColumnInfo(name = "results")
    @SerializedName("results")
    private List<Result> results;

    @ColumnInfo(name = "pronunciation")
    @SerializedName("pronunciation")
    private Pronunciation pronunciation;

    /**
     * Constructor to initialize a Word object.
     *
     * @param word          The word itself.
     * @param results       List of results associated with the word.
     * @param pronunciation Pronunciation data of the word.
     */
    public Word(String word, List<Result> results, Pronunciation pronunciation) {
        this.word = word;
        this.results = results;
        this.pronunciation = pronunciation;
    }

    public Word() {

    }

    /**
     * Get the word itself.
     *
     * @return The word.
     */
    public String getWord() {
        return word;
    }

    /**
     * Set the word.
     *
     * @param word The word to set.
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Get the list of results associated with the word.
     *
     * @return The list of results.
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * Set the list of results associated with the word.
     *
     * @param results The list of results to set.
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     * Get the pronunciation data of the word.
     *
     * @return The pronunciation data.
     */
    public Pronunciation getPronunciation() {
        return pronunciation;
    }

    /**
     * Set the pronunciation data of the word.
     *
     * @param pronunciation The pronunciation data to set.
     */
    public void setPronunciation(Pronunciation pronunciation) {
        this.pronunciation = pronunciation;
    }

    /**
     * Get the ID of the word.
     *
     * @return The ID of the word.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID of the word.
     *
     * @param id The ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Word{" +
                "\nword='" + word + '\'' +
                ",\n results=" + results +
                ",\n pronunciation=" + pronunciation +
                '}';
    }

    public void setPhonetic(String phonetic) {
    }

    public void setDefinition(String string) {
    }
}
