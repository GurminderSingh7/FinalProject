package algonquin.cst2335.finalproject.Models;

import java.util.ArrayList;

/**
 * Represents the root level of a JSON response structure that contains a list of recipes.
 * This class is typically used to encapsulate the initial parsing of JSON data from an API response,
 * where the key data element is a collection of recipes. The class simplifies access to the list of
 * recipes that are retrieved as part of the API call.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class Root {
    /** A list of {@link Recipe} objects representing the recipes contained in the JSON response. */
    public ArrayList<Recipe> recipes;

    /**
     * Constructs a new instance of {@code Root} with an empty list of recipes.
     * This constructor can be used to initialize a {@code Root} object before
     * filling it with data parsed from a JSON response.
     */
    public Root() {
        recipes = new ArrayList<>();
    }

    // Additional methods, such as getters and setters, can be added below for better encapsulation.
}
