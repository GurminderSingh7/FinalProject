package com.cuoiky.andoid.dictionaryapp.util;

/**
 * Constants class containing API base URLs and headers.
 *
 * <p>This class holds static final fields representing various constants used in the application,
 * such as the base URLs for the WordsAPI and WordQuizAPI, and the X-RapidAPI-Key for authentication.</p>
 *
 * <p>Author: Gurminder Singh Badwal</p>
 * <p>Lab Section: 012</p>
 * <p>Creation Date: 4th of April 2024</p>
 */
public class Constants {
    // Base URL for the WordsAPI
    public static final String WORDSAPI_BASE_URL = "https://wordsapiv1.p.rapidapi.com/words/";

    // Base URL for the WordQuizAPI
    public static final String WORDQUIZ_BASE_URL = "https://twinword-word-association-quiz.p.rapidapi.com/";

    // Host for WordsAPI requests
    public static final String WORDS_X_RAPID_API_HOST = "wordsapiv1.p.rapidapi.com";

    // Host for WordQuizAPI requests
    public static final String WORDQUIZ_X_RAPID_API_HOST = "twinword-word-association-quiz.p.rapidapi.com";

    // API key for authentication
    public static final String X_RAPID_API_KEY = "3118daf208mshde824c93cf95e8ep163e44jsn7ea48634a86b";
}
