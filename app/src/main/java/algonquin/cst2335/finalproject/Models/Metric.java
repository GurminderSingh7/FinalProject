package algonquin.cst2335.finalproject.Models;

/**
 * Represents metric measurements for ingredients or other measurable aspects of a recipe. This class
 * holds the amount in metric units along with short and long descriptions of the unit of measurement.
 * It's utilized within the application to provide standardized measurements for international use
 * or for users who prefer metric units.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class Metric {
    /** The numeric value of the measurement in metric units. */
    public double amount;

    /** The abbreviated form of the metric unit (e.g., "ml" for milliliters). */
    public String unitShort;

    /** The full name of the metric unit (e.g., "milliliters"). */
    public String unitLong;

    // Constructors, getters, and setters can be included here for better encapsulation and flexibility.

    /**
     * Default constructor for creating a Metric instance without initializing fields.
     */
    public Metric() {
    }

    /**
     * Constructs a Metric instance with specified amount and units.
     *
     * @param amount The amount of the ingredient or item being measured.
     * @param unitShort The abbreviated form of the metric unit.
     * @param unitLong The full name of the metric unit.
     */
    public Metric(double amount, String unitShort, String unitLong) {
        this.amount = amount;
        this.unitShort = unitShort;
        this.unitLong = unitLong;
    }

    // Example getters and setters

    /**
     * Gets the amount of the metric measurement.
     *
     * @return The amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the metric measurement.
     *
     * @param amount The amount to set.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the abbreviated form of the metric unit.
     *
     * @return The abbreviated unit.
     */
    public String getUnitShort() {
        return unitShort;
    }

    /**
     * Sets the abbreviated form of the metric unit.
     *
     * @param unitShort The abbreviated unit to set.
     */
    public void setUnitShort(String unitShort) {
        this.unitShort = unitShort;
    }

    /**
     * Gets the full name of the metric unit.
     *
     * @return The full unit name.
     */
    public String getUnitLong() {
        return unitLong;
    }

    /**
     * Sets the full name of the metric unit.
     *
     * @param unitLong The full unit name to set.
     */
    public void setUnitLong(String unitLong) {
        this.unitLong = unitLong;
    }
}
