package algonquin.cst2335.finalproject.Models;

/**
 * Represents the duration or length of an activity, such as cooking or preparation time in a recipe.
 * This class is designed to store the length along with its unit of measurement, making it versatile
 * for various applications where duration needs to be expressed.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class Length {

    /** The numeric value of the length or duration. */
    public int number;

    /** The unit of measurement for the length (e.g., minutes, hours). */
    public String unit;

    // Constructors, getters, and setters can be added here to manage access and encapsulate the data more effectively.

    /**
     * Default constructor for creating an instance of Length without setting fields initially.
     */
    public Length() {
    }

    /**
     * Constructs a Length instance with specified number and unit.
     *
     * @param number The numeric value representing the length or duration.
     * @param unit The unit of measurement for the length (e.g., "minutes", "hours").
     */
    public Length(int number, String unit) {
        this.number = number;
        this.unit = unit;
    }

    // Example getters and setters

    /**
     * Gets the numeric value of the length or duration.
     *
     * @return The numeric value of the length.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the numeric value of the length or duration.
     *
     * @param number The numeric value to set for the length.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Gets the unit of measurement for the length.
     *
     * @return The unit of measurement.
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the unit of measurement for the length.
     *
     * @param unit The unit of measurement to set.
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
