package com.cuoiky.andoid.dictionaryapp.data.local;

import androidx.room.TypeConverter;

import com.cuoiky.andoid.dictionaryapp.data.model.wordsapi.Pronunciation;
import com.cuoiky.andoid.dictionaryapp.data.model.wordsapi.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Type converters for Room database.
 *
 * <p>This class provides type converters for converting custom data types
 * (such as lists of Result objects and Pronunciation objects) to and from
 * JSON strings, which can be stored in the Room database.</p>
 *
 * <p>Author: Gurminder Singh Badwal</p>
 * <p>Lab Section: 012</p>
 * <p>Creation Date: 4th of April 2024</p>
 */
public class Converters {

    /**
     * Convert a JSON string to a list of Result objects.
     *
     * @param value The JSON string representing the list of Result objects.
     * @return The list of Result objects.
     */
    @TypeConverter
    public static List<Result> toList(String value) {
        Type listType = new TypeToken<List<Result>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    /**
     * Convert a list of Result objects to a JSON string.
     *
     * @param list The list of Result objects to convert.
     * @return The JSON string representing the list of Result objects.
     */
    @TypeConverter
    public static String fromList(List<Result> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    /**
     * Convert a JSON string to a Pronunciation object.
     *
     * @param value The JSON string representing the Pronunciation object.
     * @return The Pronunciation object.
     */
    @TypeConverter
    public static Pronunciation toPron(String value) {
        Type pronType = new TypeToken<Pronunciation>() {}.getType();
        return new Gson().fromJson(value, pronType);
    }

    /**
     * Convert a Pronunciation object to a JSON string.
     *
     * @param pron The Pronunciation object to convert.
     * @return The JSON string representing the Pronunciation object.
     */
    @TypeConverter
    public static String fromPron(Pronunciation pron) {
        Gson gson = new Gson();
        String json = gson.toJson(pron);
        return json;
    }
}
