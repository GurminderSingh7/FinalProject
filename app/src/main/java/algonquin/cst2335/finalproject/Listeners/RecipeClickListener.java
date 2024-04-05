package algonquin.cst2335.finalproject.Listeners;

/**
 * An interface designed for handling click events on recipes. This allows for a modular way
 * of responding to user interactions with recipe items within the application, facilitating
 * navigation to detailed views of selected recipes or any other related actions.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public interface RecipeClickListener {
    /**
     * Called when a recipe item is clicked. Implementations of this method can define
     * how the application should respond to the click, typically by navigating to a detailed
     * view of the clicked recipe.
     *
     * @param id The unique identifier of the clicked recipe, allowing the application
     *           to retrieve and display detailed information about the recipe.
     */
    void onRecipeClicked(String id);
}
