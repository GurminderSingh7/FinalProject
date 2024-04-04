package algonquin.cst2335.finalproject.Listeners;

import algonquin.cst2335.finalproject.Models.RandomRecipeApiResponse;

/**
 * An interface defining the callback methods for responses received from random recipe fetch requests.
 * Implementations of this interface can handle successful fetches of random recipes as well as errors.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public interface RandomRecipeResponseListeners {
    /**
     * Called when a random recipe fetch request is successfully completed.
     *
     * @param response The response object containing the list of random recipes and associated data.
     * @param message A message indicating the success of the fetch operation.
     */
    void didFetch(RandomRecipeApiResponse response, String message);

    /**
     * Called when an error occurs during the fetch request for random recipes.
     *
     * @param message A message describing the error that occurred.
     */
    void didError(String message);
}
