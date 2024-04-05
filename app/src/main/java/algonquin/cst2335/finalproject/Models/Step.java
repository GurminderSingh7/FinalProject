package algonquin.cst2335.finalproject.Models;

import java.util.ArrayList;

/**
 * Represents a single step in the preparation of a recipe. This class includes details such as the
 * step number, a description of the action to be taken during this step, and lists of ingredients
 * and equipment required. Additionally, if applicable, the duration of the step is provided.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class Step {
    /** The sequential number of the step within the recipe's preparation process. */
    public int number;

    /** A detailed description of the preparation action to be taken in this step. */
    public String step;

    /** A list of ingredients involved in this particular step of the recipe. */
    public ArrayList<Ingredient> ingredients;

    /** A list of equipment needed to perform this step. */
    public ArrayList<Equipment> equipment;

    /** The duration of time this step is expected to take, if applicable. */
    public Length length;

    // Constructor, getters, and setters for better encapsulation and data manipulation might follow here.

    /**
     * Constructs a Step instance with default values for its fields.
     */
    public Step() {
        ingredients = new ArrayList<>();
        equipment = new ArrayList<>();
    }

    // Example of a getter for the step number
    /**
     * Gets the step number.
     *
     * @return The sequential number of this step within the recipe.
     */
    public int getNumber() {
        return number;
    }

    // Further getters and setters can be implemented for each field as needed.
}
