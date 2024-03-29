package algonquin.cst2335.finalproject.Listeners;

import java.util.List;

import algonquin.cst2335.finalproject.Models.SimilarRecipeResponse;

public interface SimilarRecipesListener {

    void didFetch(List<SimilarRecipeResponse> response, String message);
    void didError(String message);

}
