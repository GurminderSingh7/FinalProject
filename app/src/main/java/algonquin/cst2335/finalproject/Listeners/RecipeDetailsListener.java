package algonquin.cst2335.finalproject.Listeners;

import algonquin.cst2335.finalproject.Models.RecipeDetailsResponse;

public interface RecipeDetailsListener {
    void didFetch(RecipeDetailsResponse response, String message);
    void didError(String message);
}
