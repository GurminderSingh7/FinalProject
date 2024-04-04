package algonquin.cst2335.finalproject.Models;

import java.util.ArrayList;

/**
 * Represents the detailed response from a recipe query, encapsulating all relevant information
 * about a recipe. This includes comprehensive details such as dietary information, ingredients,
 * cooking instructions, and even wine pairing suggestions. It is designed to be a complete
 * representation of a recipe as returned by a recipe detail API endpoint.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class RecipeDetailsResponse {

    /** The unique identifier for the recipe. */
    public int id;

    /** The title of the recipe. */
    public String title;

    /** URL of the recipe's image. */
    public String image;

    /** The file type of the recipe's image (e.g., "jpg" or "png"). */
    public String imageType;

    /** The number of servings the recipe makes. */
    public int servings;

    /** The time, in minutes, required to prepare and cook the recipe. */
    public int readyInMinutes;

    /** The license under which the recipe is provided. */
    public String license;

    /** The name of the source where the recipe was found. */
    public String sourceName;

    /** The URL of the webpage where the recipe is located. */
    public String sourceUrl;

    /** The Spoonacular URL for the recipe. */
    public String spoonacularSourceUrl;

    /** A score indicating how healthy the recipe is. */
    public double healthScore;

    /** Spoonacular's own score rating the recipe. */
    public double spoonacularScore;

    /** The cost per serving of the recipe. */
    public double pricePerServing;

    /** A list containing the cooking instructions divided into steps. */
    public ArrayList<Object> analyzedInstructions;

    /** Indicates if the recipe is considered cheap to make. */
    public boolean cheap;

    /** Credits for the recipe's author. */
    public String creditsText;

    /** A list of cuisines the recipe belongs to. */
    public ArrayList<Object> cuisines;

    /** Indicates if the recipe is dairy-free. */
    public boolean dairyFree;

    /** A list of diets that the recipe accommodates. */
    public ArrayList<Object> diets;

    /** The GAPs diet classification of the recipe, if applicable. */
    public String gaps;

    /** Indicates if the recipe is gluten-free. */
    public boolean glutenFree;

    /** Cooking instructions as a single string. */
    public String instructions;

    /** Indicates if the recipe is suitable for a ketogenic diet. */
    public boolean ketogenic;

    /** Indicates if the recipe is low FODMAP. */
    public boolean lowFodmap;

    /** Occasions for which the recipe is suitable. */
    public ArrayList<Object> occasions;

    /** Indicates if the recipe is considered sustainable. */
    public boolean sustainable;

    /** Indicates if the recipe is vegan. */
    public boolean vegan;

    /** Indicates if the recipe is vegetarian. */
    public boolean vegetarian;

    /** Indicates if the recipe is considered very healthy. */
    public boolean veryHealthy;

    /** Indicates if the recipe is very popular. */
    public boolean veryPopular;

    /** Indicates if the recipe complies with the Whole30 diet. */
    public boolean whole30;

    /** The number of Weight Watcher Smart Points. */
    public int weightWatcherSmartPoints;

    /** The types of dishes suitable for the recipe (e.g., "dessert", "main course"). */
    public ArrayList<String> dishTypes;

    /** A list of ingredients needed for the recipe. */
    public ArrayList<ExtendedIngredient> extendedIngredients;

    /** A summary of the recipe, possibly including HTML tags. */
    public String summary;

    /** Wine pairing suggestions for the recipe. */
    public WinePairing winePairing;

    // Constructor, getters, and setters could be added here for better encapsulation and data manipulation.
}
