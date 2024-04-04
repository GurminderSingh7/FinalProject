package algonquin.cst2335.finalproject.Models;

/**
 * Represents a piece of equipment used in a recipe, detailing its properties and, if applicable,
 * the temperature at which it should be used. This class is part of the model layer, which structures
 * the recipe data in the application.
 * <p>
 * Each instance of Equipment may include an ID, name, localized name, an image URL, and, for some
 * equipment, a specific {@link Temperature} indicating the required temperature settings.
 * </p>
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class Equipment {
    /** Unique identifier for the equipment. */
    public int id;

    /** The standard name of the equipment. */
    public String name;

    /** The localized name of the equipment, potentially used for internationalization. */
    public String localizedName;

    /** URL or relative path to an image representing the equipment. */
    public String image;

    /** The temperature at which the equipment should be used, if applicable. */
    public Temperature temperature;

    // Constructors, getters, and setters can be added here to manage access and provide encapsulation.
}
