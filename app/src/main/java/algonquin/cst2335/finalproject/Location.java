package algonquin.cst2335.finalproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Entity class representing a location with latitude, longitude, sunrise, and sunset information.
 * This class is used by Room to create a table in the database.
 *
 * @author Aditya Hirpara
 */
@Entity(tableName = "location_table")
public class Location {
    @PrimaryKey(autoGenerate = true)
    private int id; // Unique ID for each location

    private String latitude;  // Latitude coordinate of the location
    private String longitude; // Longitude coordinate of the location
    private String sunrise;   // Sunrise time at the location
    private String sunset;    // Sunset time at the location

    /**
     * Constructs a new Location object with the specified latitude, longitude, sunrise, and sunset times.
     *
     * @param latitude  The latitude coordinate of the location.
     * @param longitude The longitude coordinate of the location.
     * @param sunrise   The sunrise time at the location.
     * @param sunset    The sunset time at the location.
     */
    public Location(String latitude, String longitude, String sunrise, String sunset) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    // Getters and setters
    /**
     * Gets the ID of the location.
     * @return The ID of the location.
     */
    public int getId() { return id; }

    /**
     * Sets the ID of the location.
     * @param id The ID to set for the location.
     */
    public void setId(int id) { this.id = id; }

    /**
     * Gets the latitude of the location.
     * @return The latitude of the location.
     */
    public String getLatitude() { return latitude; }

    /**
     * Gets the longitude of the location.
     * @return The longitude of the location.
     */
    public String getLongitude() { return longitude; }

    /**
     * Gets the sunrise time of the location.
     * @return The sunrise time of the location.
     */
    public String getSunrise() { return sunrise; }

    /**
     * Gets the sunset time of the location.
     * @return The sunset time of the location.
     */
    public String getSunset() { return sunset; }
}
