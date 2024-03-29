package algonquin.cst2335.finalproject.Listeners;

import algonquin.cst2335.finalproject.Models.RandomRecipeApiResponse;

    public interface RandomRecipeResponseListeners {
        void didFetch(RandomRecipeApiResponse response, String message);
        void didError(String message);
    }