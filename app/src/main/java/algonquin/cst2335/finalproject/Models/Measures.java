package algonquin.cst2335.finalproject.Models;

/**
 * Represents the measurement units for ingredients or other measurable aspects of a recipe,
 * including both US customary units and metric units. This class serves as a container for
 * the measurement values in different systems, facilitating the presentation and conversion
 * of measurements within the application.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class Measures{
    /** Measurement values expressed in US customary units. */
    public Us us;

    /** Measurement values expressed in metric units. */
    public Metric metric;

    // Constructors, getters, and setters can be included here for better encapsulation and flexibility.

    /**
     * Default constructor for creating an instance of Measures without initializing fields.
     */
    public Measures() {
    }

    /**
     * Constructs a Measures instance with specified US and metric measurements.
     *
     * @param us The US customary units measurement.
     * @param metric The metric units measurement.
     */
    public Measures(Us us, Metric metric) {
        this.us = us;
        this.metric = metric;
    }

    // Example getters and setters

    /**
     * Gets the US customary units measurement.
     *
     * @return The US measurement.
     */
    public Us getUs() {
        return us;
    }

    /**
     * Sets the US customary units measurement.
     *
     * @param us The US measurement to set.
     */
    public void setUs(Us us) {
        this.us = us;
    }

    /**
     * Gets the metric units measurement.
     *
     * @return The metric measurement.
     */
    public Metric getMetric() {
        return metric;
    }

    /**
     * Sets the metric units measurement.
     *
     * @param metric The metric measurement to set.
     */
    public void setMetric(Metric metric) {
        this.metric = metric;
    }
}
