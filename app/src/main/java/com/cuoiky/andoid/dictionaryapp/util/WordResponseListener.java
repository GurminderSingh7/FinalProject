package com.cuoiky.andoid.dictionaryapp.util;

import com.cuoiky.andoid.dictionaryapp.data.model.wordsapi.Word;

/**
 * Interface for handling responses from operations related to retrieving word definitions.
 *
 * <p>This interface defines methods for handling the success, failure, and error scenarios
 * when dealing with operations related to retrieving word definitions.</p>
 * <p>Author: Gurminder Singh Badwal</p>
 * <p>Lab Section: 012</p>
 * <p>Creation Date: 4th of April 2024</p>
 */
public interface WordResponseListener {
    /**
     * Called when the word definition is successfully retrieved.
     *
     * @param word The Word object containing the definition of the word.
     */
    void onSuccess(Word word);

    /**
     * Called when the operation to retrieve the word definition fails for some reason.
     *
     * @param e Error message indicating the reason for failure.
     */
    void onFail(String e);

    /**
     * Called when an error occurs while retrieving the word definition.
     *
     * @param t Throwable object representing the error.
     */
    void onError(Throwable t);
}
