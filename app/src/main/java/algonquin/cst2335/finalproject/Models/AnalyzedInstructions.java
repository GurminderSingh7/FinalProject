package algonquin.cst2335.finalproject.Models;

import java.util.ArrayList;

/**
 * Represents the analyzed instructions of a recipe, detailing each step involved in the recipe's preparation.
 * This class contains a name, typically indicating the part or aspect of the recipe these instructions pertain to,
 * along with a list of steps, each describing a specific action or part of the recipe preparation process.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class AnalyzedInstructions {

    /** The name of the instruction set, often relating to a portion of the recipe or a specific cooking technique. */
    public String name;

    /** A list of steps involved in this part of the recipe, each step detailed in a {@link Step} object. */
    public ArrayList<Step> steps;

    // You might consider adding constructors, getters, and setters here for encapsulation and better data management.
}
