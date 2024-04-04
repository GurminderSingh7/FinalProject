package com.cuoiky.andoid.dictionaryapp.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cuoiky.andoid.dictionaryapp.data.model.wordsapi.Word;
import com.cuoiky.andoid.dictionaryapp.data.repository.WordQuizRepo;
import com.cuoiky.andoid.dictionaryapp.data.repository.WordsRepo;
import com.cuoiky.andoid.dictionaryapp.ui.main.MainActivity;
import com.cuoiky.andoid.dictionaryapp.util.QuizResponseListener;
import com.cuoiky.andoid.dictionaryapp.util.WordResponseListener;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * ViewModel for the MainActivity.
 *
 * <p>The MainViewModel provides data to the UI and survives configuration changes.
 * It interacts with the repository to fetch data and handles API requests for words
 * and quizzes.</p>
 *
 * <p>Author: Gurminder Singh Badwal</p>
 * <p>Lab Section: 012</p>
 * <p>Creation Date: 4th of April 2024</p>
 */
public class MainViewModel extends ViewModel {
    private WordsRepo mRepo;
    private WordQuizRepo mQuizRepo;
    private LiveData<List<Word>> mFavWords;

    /**
     * Initializes the MainViewModel with the application context.
     * @param application The application context.
     */
    public void init(@NonNull Application application){
        mRepo = WordsRepo.getInstance(application);
        mQuizRepo = WordQuizRepo.getInstance();
        mFavWords = mRepo.getFavWords();
    }

    /**
     * Retrieves the list of favorite words.
     * @return LiveData object containing the list of favorite words.
     */
    public LiveData<List<Word>> getFavWords(){
        return this.mFavWords;
    }

    /**
     * Retrieves a word from the API.
     * @param w The word to search for.
     * @param responseListener Callback for handling API responses.
     */
    public void getWord(String w, WordResponseListener responseListener){
        mRepo.getWordFromApi(w, responseListener);
    }

    /**
     * Inserts a word into the database.
     * @param w The word to insert.
     */
    public void insertWord(Word w){
        mRepo.insertWord(w);
    }

    /**
     * Removes a word from the database.
     * @param w The word to remove.
     */
    public void removeWord(Word w){
        mRepo.removeWord(w);
    }

    /**
     * Removes a list of words from the database.
     * @param w The list of words to remove.
     * @param mListener Callback for handling the removal operation.
     */
    public void removeListofWords(List<Word> w, MainActivity.OnRemoveSelectedWords mListener){
        mRepo.removeListofWords(w, mListener);
    }

    /**
     * Finds a word in the database.
     * @param w The word to find.
     * @return Single object containing the found word.
     */
    public Single<Word> findWord(String w){
        return mRepo.findWord(w);
    }

    /**
     * Retrieves a quiz from the API.
     * @param level The difficulty level of the quiz.
     * @param area The area of the quiz (e.g., vocabulary, grammar).
     * @param listener Callback for handling API responses.
     */
    public void getWordQuizFromApi(String level, String area, QuizResponseListener listener){
        mQuizRepo.getWordQuizFromApi(level, area, listener);
    }
}
