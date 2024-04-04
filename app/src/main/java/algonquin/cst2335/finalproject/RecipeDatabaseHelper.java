package algonquin.cst2335.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * This class assists in managing the recipe database for the application. It includes functionality
 * to create the database, upgrade it, and perform CRUD operations on the recipes table.
 * <p>
 * Purpose: To handle database operations for the recipes application.
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 * </p>
 */
public class RecipeDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "recipes.db";
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link RecipeDatabaseHelper}.
     *
     * @param context the context of the caller.
     */
    public RecipeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE recipes (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, summary TEXT)");
    }

    /**
     * Called when the database needs to be upgraded. This method will only be called if
     * a database already exists on disk with the same DATABASE_NAME, but the DATABASE_VERSION
     * has changed.
     *
     * @param db The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS recipes");
        onCreate(db);
    }

    /**
     * Inserts a new recipe into the database.
     *
     * @param title The title of the recipe.
     * @param summary The summary of the recipe.
     */
    public void addRecipe(String title, String summary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("summary", summary);
        db.insert("recipes", null, values);
        db.close();
    }

    /**
     * Deletes a recipe from the database.
     *
     * @param id The id of the recipe to delete.
     */
    public void deleteRecipe(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("recipes", "_id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    /**
     * Retrieves all recipes from the database.
     *
     * @return A Cursor object, which is positioned before the first entry. Note that Cursors are not synchronized,
     * so care must be taken when using them on multi-threaded applications.
     */
    public Cursor getAllRecipes() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query("recipes", new String[]{"_id", "title", "summary"}, null, null, null, null, null);
    }
}
