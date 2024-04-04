package com.cuoiky.andoid.dictionaryapp.data.model.wordquiz;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Model class representing a word quiz.
 *
 * <p>This class represents a quiz consisting of multiple quiz questions.
 * It includes the quiz area, level, and a list of quiz questions.</p>
 *
 * <p>Author: Gurminder Singh Badwal</p>
 * <p>Lab Section: 012</p>
 * <p>Creation Date: 4th of April 2024</p>
 */
public class WordQuiz {
    @SerializedName("area")
    private String area;
    @SerializedName("level")
    private int level;
    @SerializedName("quizlist")
    private List<Quiz> quizList;

    /**
     * Constructor to initialize a WordQuiz object.
     *
     * @param area     The area/topic of the quiz.
     * @param level    The difficulty level of the quiz.
     * @param quizList The list of quiz questions.
     */
    public WordQuiz(String area, int level, List<Quiz> quizList) {
        this.area = area;
        this.level = level;
        this.quizList = quizList;
    }

    /**
     * Get the area/topic of the quiz.
     *
     * @return The area/topic of the quiz.
     */
    public String getArea() {
        return area;
    }

    /**
     * Set the area/topic of the quiz.
     *
     * @param area The area/topic of the quiz to set.
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Get the difficulty level of the quiz.
     *
     * @return The difficulty level of the quiz.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set the difficulty level of the quiz.
     *
     * @param level The difficulty level of the quiz to set.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Get the list of quiz questions.
     *
     * @return The list of quiz questions.
     */
    public List<Quiz> getQuizList() {
        return quizList;
    }

    /**
     * Set the list of quiz questions.
     *
     * @param quizList The list of quiz questions to set.
     */
    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    @Override
    public String toString() {
        return "WordQuiz{" +
                "area='" + area + '\'' +
                ", level=" + level +
                ", quizList=" + quizList +
                '}';
    }
}
