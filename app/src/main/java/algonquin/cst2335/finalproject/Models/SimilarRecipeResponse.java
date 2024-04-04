package algonquin.cst2335.finalproject.Models;

/**
 * Encapsulates the data related to a similar recipe response, often used when fetching recipes
 * that are similar to a particular recipe. This class holds information such as the recipe's
 * unique identifier, title, image type, preparation time, number of servings, and the source URL
 * where more information about the recipe can be found.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class SimilarRecipeResponse {

    /** The unique identifier for the recipe. */
    public int id;

    /** The title of the recipe. */
    public String title;

    /** The type of image representing the recipe (e.g., "jpg" or "png"). */
    public String imageType;

    /** The estimated time in minutes required to prepare the recipe. */
    public int readyInMinutes;

    /** The number of servings the recipe yields. */
    public int servings;

    /** The URL to the source of the recipe, where users can find more detailed information. */
    public String sourceUrl;

    // Constructors, getters, and setters can be included here for better data management and encapsulation.
}
