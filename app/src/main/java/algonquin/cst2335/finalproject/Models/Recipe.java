package algonquin.cst2335.finalproject.Models;

import java.util.ArrayList;

/**
 * Represents a recipe, detailing its characteristics, ingredients, and nutritional information.
 * This class includes a wide range of properties that describe a recipe's dietary classifications,
 * preparation times, popularity metrics, source information, and more. It also contains a list of
 * extended ingredients, providing detailed information about each ingredient required for the recipe.
 *
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */

public class Recipe {
    public boolean vegetarian;
    public boolean vegan;
    public boolean glutenFree;
    public boolean dairyFree;
    public boolean veryHealthy;
    public boolean cheap;
    public boolean veryPopular;
    public boolean sustainable;
    public boolean lowFodmap;
    public int weightWatcherSmartPoints;
    public String gaps;
    public int preparationMinutes;
    public int cookingMinutes;
    public int aggregateLikes;
    public int healthScore;
    public String creditsText;
    public String license;
    public String sourceName;
    public double pricePerServing;
    public ArrayList<ExtendedIngredient> extendedIngredients;
    public int id;
    public String title;
    public int readyInMinutes;
    public int servings;
    public String sourceUrl;
    public String image;
    public String imageType;
    public String summary;
    public ArrayList<String> cuisines;
    public ArrayList<String> dishTypes;
    public ArrayList<String> diets;
    public ArrayList<String> occasions;
    public Object originalId;
    public double spoonacularScore;
    public String spoonacularSourceUrl;

    /**
     * Gets the title of the recipe.
     *
     * @return The title of the recipe.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the total number of likes for the recipe.
     *
     * @return The aggregate likes.
     */
    public int getAggregateLikes() {
        return aggregateLikes;
    }

    /**
     * Gets the number of servings the recipe provides.
     *
     * @return The number of servings.
     */
    public int getServings() {
        return servings;
    }

    /**
     * Gets the estimated time in minutes required to have the recipe ready.
     *
     * @return The readiness time in minutes.
     */
    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    /**
     * Gets the URL of the image associated with the recipe.
     *
     * @return The image URL.
     */
    public String getImage() {
        return image;
    }

    // Additional setters for setting properties of the Recipe
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
