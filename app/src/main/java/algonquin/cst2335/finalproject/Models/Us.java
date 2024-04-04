package algonquin.cst2335.finalproject.Models;

/**
 * Represents measurements using the United States customary system. This class is typically used
 * for ingredients or cooking measurements in recipes that specify quantities in US customary units.
 * It includes the measurement amount and both the short and long forms of the unit of measurement.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class Us {
    /** The numeric value of the measurement. */
    public double amount;

    /** The abbreviated form of the unit of measurement (e.g., "cup", "tbsp"). */
    public String unitShort;

    /** The full name of the unit of measurement (e.g., "cups", "tablespoons"). */
    public String unitLong;

    // Constructors, getters, and setters can be added here for better encapsulation and flexibility.

    /**
     * Default constructor for creating a Us instance without initializing fields.
     */
    public Us() {
    }

    /**
     * Constructs a Us instance with specified amount and units.
     *
     * @param amount The amount of the ingredient or item being measured.
     * @param unitShort The abbreviated form of the US customary unit.
     * @param unitLong The full name of the US customary unit.
     */
    public Us(double amount, String unitShort, String unitLong) {
        this.amount = amount;
        this.unitShort = unitShort;
        this.unitLong = unitLong;
    }

    // Example getters and setters

    /**
     * Gets the amount of the US customary measurement.
     *
     * @return The amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the US customary measurement.
     *
     * @param amount The amount to set.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the abbreviated form of the US customary unit.
     *
     * @return The abbreviated unit.
     */
    public String getUnitShort() {
        return unitShort;
    }

    /**
     * Sets the abbreviated form of the US customary unit.
     *
     * @param unitShort The abbreviated unit to set.
     */
    public void setUnitShort(String unitShort) {
        this.unitShort = unitShort;
    }

    /**
     * Gets the full name of the US customary unit.
     *
     * @return The full unit name.
     */
    public String getUnitLong() {
        return unitLong;
    }

    /**
     * Sets the full name of the US customary unit.
     *
     * @param unitLong The full unit name to set.
     */
    public void setUnitLong(String unitLong) {
        this.unitLong = unitLong;
    }
}
