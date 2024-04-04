package algonquin.cst2335.finalproject.Listeners;

import java.util.List;
import algonquin.cst2335.finalproject.Models.SimilarRecipeResponse;

/**
 * An interface for handling the responses from requests to fetch similar recipes. This interface
 * allows implementing classes to define specific behaviors upon successfully receiving a list of similar
 * recipes or encountering errors during the fetch process.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public interface SimilarRecipesListener {

    /**
     * Called when a request to fetch similar recipes successfully completes. This method provides
     * the list of similar recipes, along with a success message to the implementing class.
     *
     * @param response A list of {@link SimilarRecipeResponse} objects, each representing a recipe similar
     *                 to the one queried.
     * @param message A message indicating the success of the operation, useful for logging or user feedback.
     */
    void didFetch(List<SimilarRecipeResponse> response, String message);

    /**
     * Called when there is an error during the attempt to fetch similar recipes. This method allows
     * for error handling logic to be defined by the implementing class.
     *
     * @param message A message describing the error encountered during the fetch operation.
     */
    void didError(String message);

}
