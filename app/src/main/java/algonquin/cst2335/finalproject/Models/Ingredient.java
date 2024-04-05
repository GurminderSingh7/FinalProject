package algonquin.cst2335.finalproject.Models;

/**
 * Represents a basic ingredient used in cooking or baking. This class holds information
 * about the ingredient's name and quantity, which are fundamental for recipe preparation.
 * Additional properties like nutritional information can be added to extend the class's utility.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class Ingredient {
    /** The name of the ingredient. */
    private String name;

    /** The amount of the ingredient needed. */
    private double quantity;

    /** The unit of measurement for the quantity (e.g., grams, cups). */
    private String unit;

    /**
     * Constructs an Ingredient with specified details.
     *
     * @param name The name of the ingredient.
     * @param quantity The quantity of the ingredient required.
     * @param unit The unit of measurement for the quantity.
     */
    public Ingredient(String name, double quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    // Getters and Setters

    /**
     * Gets the name of the ingredient.
     *
     * @return The name of the ingredient.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the ingredient.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the quantity of the ingredient.
     *
     * @return The quantity of the ingredient.
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the ingredient.
     *
     * @param quantity The quantity to set.
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the unit of measurement for the ingredient's quantity.
     *
     * @return The unit of measurement.
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the unit of measurement for the ingredient's quantity.
     *
     * @param unit The unit of measurement to set.
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    // Additional methods, such as a method to return a formatted string representation of the ingredient, could be added here.
}
