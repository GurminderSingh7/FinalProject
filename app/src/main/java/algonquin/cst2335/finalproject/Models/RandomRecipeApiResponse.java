package algonquin.cst2335.finalproject.Models;

import java.util.List;

/**
 * Represents the response received from a random recipe search API call. This class encapsulates
 * the list of recipes returned by the search, along with the original search query string that was
 * used to perform the search. It provides a structured way to access the data returned by the API.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class RandomRecipeApiResponse {
    /** List of recipes returned by the API. */
    private List<Recipe> recipes;

    /** The search query string that led to these recipes being returned. */
    private String searchQuery;

    /**
     * Constructs a new RandomRecipeApiResponse with a specified list of recipes and search query.
     *
     * @param recipes The list of recipes returned by the API.
     * @param searchQuery The search query string that was used to fetch these recipes.
     */
    public RandomRecipeApiResponse(List<Recipe> recipes, String searchQuery) {
        this.recipes = recipes;
        this.searchQuery = searchQuery;
    }

    /**
     * Returns the list of recipes contained in this API response.
     *
     * @return A list of {@link Recipe} objects.
     */
    public List<Recipe> getRecipes() {
        return recipes;
    }

    /**
     * Sets the list of recipes for this API response.
     *
     * @param recipes A list of {@link Recipe} objects to be set.
     */
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    /**
     * Returns the search query string that led to the retrieval of these recipes.
     *
     * @return The search query string.
     */
    public String getSearchQuery() {
        return searchQuery;
    }

    /**
     * Sets the search query string for this API response.
     *
     * @param searchQuery The search query string to be set.
     */
    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }
}
