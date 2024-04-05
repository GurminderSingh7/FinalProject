package algonquin.cst2335.finalproject;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algonquin.cst2335.finalproject.Models.RandomRecipeApiResponse;
import algonquin.cst2335.finalproject.Models.RecipeDetailsResponse;
import algonquin.cst2335.finalproject.Models.SimilarRecipeResponse;
import algonquin.cst2335.finalproject.Listeners.RandomRecipeResponseListeners;
import algonquin.cst2335.finalproject.Listeners.RecipeDetailsListener;
import algonquin.cst2335.finalproject.Listeners.SimilarRecipesListener;

/**
 * Manages network requests for the recipe application, including fetching random recipes,
 * recipe details, and similar recipes using the Spoonacular API. Utilizes Volley for network
 * operations and Gson for JSON parsing.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class RequestManager {
    Context context;
    RequestQueue requestQueue;

    /**
     * Initializes a new RequestManager instance.
     *
     * @param context Context for creating the request queue.
     */
    public RequestManager(Context context) {
        this.context = context;
        this.requestQueue = Volley.newRequestQueue(context);
    }

    /**
     * Fetches a list of random recipes based on the provided tags.
     *
     * @param listener Callback interface for response or error handling.
     * @param tags     List of tags to filter the recipes.
     */
    public void getRandomRecipes(final RandomRecipeResponseListeners listener, List<String> tags) {
        String url = "https://api.spoonacular.com/recipes/random?number=10&apiKey=" + context.getString(R.string.api_key) + "&tags=" + String.join(",", tags);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        RandomRecipeApiResponse apiResponse = gson.fromJson(response, RandomRecipeApiResponse.class);
                        listener.didFetch(apiResponse, "Success");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.didError(error.toString());
            }
        });

        requestQueue.add(stringRequest);
    }

    /**
     * Fetches the details of a recipe by its ID.
     *
     * @param listener Callback interface for response or error handling.
     * @param id       The ID of the recipe.
     */
    public void getRecipeDetails(final RecipeDetailsListener listener, int id) {
        String url = "https://api.spoonacular.com/recipes/" + id + "/information?apiKey=" + context.getString(R.string.api_key);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        RecipeDetailsResponse apiResponse = gson.fromJson(response, RecipeDetailsResponse.class);
                        listener.didFetch(apiResponse, "Success");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.didError(error.toString());
            }
        });

        requestQueue.add(stringRequest);
    }

    /**
     * Fetches a list of recipes similar to the one specified by its ID.
     *
     * @param listener Callback interface for response or error handling.
     * @param id       The ID of the recipe for which similar recipes are requested.
     */
    public void getSimilarRecipes(final SimilarRecipesListener listener, int id) {
        String url = "https://api.spoonacular.com/recipes/" + id + "/similar?number=4&apiKey=" + context.getString(R.string.api_key);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        Type listType = new TypeToken<List<SimilarRecipeResponse>>() {
                        }.getType();
                        List<SimilarRecipeResponse> apiResponse = gson.fromJson(response, listType);
                        listener.didFetch(apiResponse, "Success");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.didError(error.toString());
            }
        });

        requestQueue.add(stringRequest);
    }
}


