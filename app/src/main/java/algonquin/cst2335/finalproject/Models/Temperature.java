package algonquin.cst2335.finalproject.Models;

/**
 * Represents a temperature, providing a value and a unit of measurement.
 * This class can be used wherever temperature values are required in the application,
 * such as in cooking instructions or ingredient storage information.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class Temperature {
    /** The numeric value of the temperature. */
    private double value;

    /** The unit of measurement for the temperature (e.g., "Celsius", "Fahrenheit"). */
    private String unit;

    /**
     * Constructs a Temperature with specified value and unit.
     *
     * @param value The temperature value.
     * @param unit The unit of measurement for the temperature.
     */
    public Temperature(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    // Getters and Setters

    /**
     * Gets the temperature value.
     *
     * @return The temperature value.
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the temperature value.
     *
     * @param value The temperature value to set.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Gets the unit of measurement for the temperature.
     *
     * @return The unit of measurement.
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the unit of measurement for the temperature.
     *
     * @param unit The unit of measurement to set.
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
