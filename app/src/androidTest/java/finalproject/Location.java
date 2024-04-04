package finalproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "location_table")
public class Location {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String latitude;
    private String longitude;
    private String sunrise;
    private String sunset;

    // Constructor, getters, and setters...
    public Location(String latitude, String longitude, String sunrise, String sunset) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLatitude() { return latitude; }
    public String getLongitude() { return longitude; }
    public String getSunrise() { return sunrise; }
    public String getSunset() { return sunset; }
}

