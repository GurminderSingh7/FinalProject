package algonquin.cst2335.finalproject.Models;

import java.util.ArrayList;

/**
 * Represents an ingredient used in a recipe, providing detailed information about the ingredient
 * such as its name, amount, and the unit of measurement. This class is part of the application's
 * model layer, which structures the data related to recipes and their components.
 * <p>
 * The information includes both general descriptions of the ingredient (e.g., name, aisle, consistency)
 * and specific details (e.g., amount, unit, original string as provided in the recipe). It also includes
 * a list of meta-information about the ingredient and a {@link Measures} object detailing the measurements
 * in various units.
 * </p>
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class ExtendedIngredient{
    /** The unique identifier for the ingredient. */
    public int id;

    /** The store aisle associated with the ingredient. */
    public String aisle;

    /** URL or relative path to an image of the ingredient. */
    public String image;

    /** The consistency of the ingredient (e.g., liquid, solid). */
    public String consistency;

    /** The name of the ingredient. */
    public String name;

    /** A cleaned version of the ingredient name, potentially for display purposes. */
    public String nameClean;

    /** The original description of the ingredient as provided in the recipe source. */
    public String original;

    /** The base name of the ingredient, excluding quantities and preparation details. */
    public String originalName;

    /** The amount of the ingredient needed for the recipe. */
    public double amount;

    /** The unit of measurement for the amount (e.g., cups, teaspoons). */
    public String unit;

    /** Additional meta-information about the ingredient (e.g., "chopped", "fresh"). */
    public ArrayList<String> meta;

    /** Measurement details for the ingredient in various units. */
    public Measures measures;

    // Constructors, getters, and setters can be added here to manage access and provide encapsulation.
}
