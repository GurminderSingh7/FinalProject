package com.cuoiky.andoid.dictionaryapp.data.model.wordquiz;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Model class representing a quiz.
 *
 * <p>This class represents a quiz question, including the correct answer index,
 * options, and the question itself.</p>
 *
 * <p>Author: Gurminder Singh Badwal</p>
 * <p>Lab Section: 012</p>
 * <p>Creation Date: 4th of April 2024</p>
 */
public class Quiz {
    @SerializedName("correct")
    private int correct;
    @SerializedName("option")
    private List<String> option;
    @SerializedName("quiz")
    private List<String> quiz;

    /**
     * Constructor to initialize a Quiz object.
     *
     * @param correct The index of the correct answer.
     * @param option  The list of options for the quiz question.
     * @param quiz    The list containing the quiz question.
     */
    public Quiz(int correct, List<String> option, List<String> quiz) {
        this.correct = correct;
        this.option = option;
        this.quiz = quiz;
    }

    /**
     * Get the index of the correct answer.
     *
     * @return The index of the correct answer.
     */
    public int getCorrect() {
        return correct;
    }

    /**
     * Set the index of the correct answer.
     *
     * @param correct The index of the correct answer to set.
     */
    public void setCorrect(int correct) {
        this.correct = correct;
    }

    /**
     * Get the list of options for the quiz question.
     *
     * @return The list of options for the quiz question.
     */
    public List<String> getOption() {
        return option;
    }

    /**
     * Set the list of options for the quiz question.
     *
     * @param option The list of options to set.
     */
    public void setOption(List<String> option) {
        this.option = option;
    }

    /**
     * Get the list containing the quiz question.
     *
     * @return The list containing the quiz question.
     */
    public List<String> getQuiz() {
        return quiz;
    }

    /**
     * Set the list containing the quiz question.
     *
     * @param quiz The list containing the quiz question to set.
     */
    public void setQuiz(List<String> quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "correct='" + correct + '\'' +
                ", option=" + option +
                ", quiz=" + quiz +
                '}';
    }
}
