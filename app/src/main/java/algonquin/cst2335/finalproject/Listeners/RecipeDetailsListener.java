package algonquin.cst2335.finalproject.Listeners;

import algonquin.cst2335.finalproject.Models.RecipeDetailsResponse;

/**
 * Defines the callback methods for handling responses from requests for detailed recipe information.
 * This interface facilitates the asynchronous handling of detailed recipe data retrieval,
 * allowing for the implementation of behavior upon successful data fetch or in case of an error.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public interface RecipeDetailsListener {
    /**
     * Called when the details of a recipe are successfully fetched. This method provides
     * the fetched recipe details to the implementing class, along with a success message.
     *
     * @param response The {@link RecipeDetailsResponse} containing the detailed information about the recipe.
     * @param message A message indicating the success of the fetch operation, potentially useful for logging or user feedback.
     */
    void didFetch(RecipeDetailsResponse response, String message);

    /**
     * Called when there is an error during the fetch operation for recipe details.
     * This method allows for error handling logic to be implemented by the consuming class.
     *
     * @param message A message describing the error encountered during the fetch operation.
     */
    void didError(String message);
}
