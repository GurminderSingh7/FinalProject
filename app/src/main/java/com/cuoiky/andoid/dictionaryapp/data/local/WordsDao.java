package com.cuoiky.andoid.dictionaryapp.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.cuoiky.andoid.dictionaryapp.data.model.wordsapi.Word;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Data Access Object (DAO) for accessing Word entities in the Room database.
 *
 * <p>This interface defines methods for performing CRUD (Create, Read, Update, Delete) operations
 * on Word entities stored in the Room database.</p>
 *
 * <p>Author: Gurminder Singh Badwal</p>
 * <p>Lab Section: 012</p>
 * <p>Creation Date: 4th of April 2024</p>
 */
@Dao
public interface WordsDao {

    /**
     * Retrieve all favorite words from the database.
     *
     * @return A LiveData object containing a list of favorite words.
     */
    @Query("SELECT * FROM FavouriteWord")
    LiveData<List<Word>> getAllFavouriteWords();

    /**
     * Insert a word into the database.
     *
     * @param w The word to insert.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWord(Word w);

    /**
     * Remove a word from the database.
     *
     * @param w The word to remove.
     */
    @Delete
    void removeWord(Word w);

    /**
     * Remove a list of words from the database.
     *
     * @param w The list of words to remove.
     */
    @Delete
    void removeListofWords(List<Word> w);

    /**
     * Find a word in the database based on its name.
     *
     * @param w The name of the word to find.
     * @return A Single object containing the found word, if any.
     */
    @Query("SELECT * FROM FavouriteWord WHERE word LIKE :w LIMIT 1")
    Single<Word> findWord(String w);
}
