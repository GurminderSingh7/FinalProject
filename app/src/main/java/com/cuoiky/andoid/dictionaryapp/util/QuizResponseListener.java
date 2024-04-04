package com.cuoiky.andoid.dictionaryapp.util;

import com.cuoiky.andoid.dictionaryapp.data.model.wordquiz.WordQuiz;

/**
 * Interface for handling responses from quiz-related operations.
 *
 * <p>This interface defines methods for handling the success, failure, and error scenarios
 * when dealing with quiz-related operations, such as fetching word quizzes.</p>
 *
 * <p>Author: Gurminder Singh Badwal</p>
 * <p>Lab Section: 012</p>
 * <p>Creation Date: 4th of April 2024</p>
 */
public interface QuizResponseListener {
    /**
     * Called when the quiz data is successfully retrieved.
     *
     * @param word The WordQuiz object containing the quiz data.
     */
    void onSuccess(WordQuiz word);

    /**
     * Called when the quiz retrieval fails for some reason.
     *
     * @param e Error message indicating the reason for failure.
     */
    void onFail(String e);

    /**
     * Called when an error occurs while retrieving the quiz data.
     *
     * @param t Throwable object representing the error.
     */
    void onError(Throwable t);
}
