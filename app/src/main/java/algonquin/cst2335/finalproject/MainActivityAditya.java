package algonquin.cst2335.finalproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONObject;

import java.util.List;

/**
 * Main activity class of the application, responsible for displaying the user interface,
 * handling user interactions, and performing network and database operations.
 * * @author Aditya Hirpara
 */
public class MainActivityAditya extends AppCompatActivity {

    private EditText latitudeEditText, longitudeEditText;
    private Button lookupButton, clearButton;
    private RecyclerView favoritesRecyclerView;
    private RequestQueue requestQueue;
    private LocationAdapter locationAdapter;
    private AppDatabase db;

    /**
     * Initializes the activity, setting up the user interface, database, and network components.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     *                           Note: Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        latitudeEditText = findViewById(R.id.latitudeEditText);
        longitudeEditText = findViewById(R.id.longitudeEditText);
        lookupButton = findViewById(R.id.lookupButton);
        clearButton = findViewById(R.id.clearButton);
        favoritesRecyclerView = findViewById(R.id.favoritesRecyclerView);

        requestQueue = Volley.newRequestQueue(this);
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "location_database")
                .allowMainThreadQueries()
                .build();

        locationAdapter = new LocationAdapter(this);
        favoritesRecyclerView.setAdapter(locationAdapter);
        favoritesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadFavoriteLocations();

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        latitudeEditText.setText(prefs.getString(KEY_LATITUDE, ""));
        longitudeEditText.setText(prefs.getString(KEY_LONGITUDE, ""));

        lookupButton.setOnClickListener(view -> {
            String latitude = latitudeEditText.getText().toString();
            String longitude = longitudeEditText.getText().toString();
            if (!latitude.isEmpty() && !longitude.isEmpty()) {
                fetchSunriseSunset(latitude, longitude);
            } else {
                Toast.makeText(this, "Please enter latitude and longitude", Toast.LENGTH_SHORT).show();
            }
        });

        clearButton.setOnClickListener(view -> {
            latitudeEditText.setText("");
            longitudeEditText.setText("");
        });
    }

    /**
     * Fetches sunrise and sunset times from the API based on the given latitude and longitude.
     * @param latitude The latitude coordinate for which to fetch sunrise and sunset times.
     * @param longitude The longitude coordinate for which to fetch sunrise and sunset times.
     */
    private void fetchSunriseSunset(String latitude, String longitude) {
        String url = "https://api.sunrisesunset.io/json?lat=" + latitude + "&lng=" + longitude + "&date=today";

        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(KEY_LATITUDE, latitude);
        editor.putString(KEY_LONGITUDE, longitude);
        editor.apply();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONObject results = response.getJSONObject("results");
                        String sunrise = results.getString("sunrise");
                        String sunset = results.getString("sunset");
                        saveLocation(latitude, longitude, sunrise, sunset);
                        showResults(sunrise, sunset);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Error parsing the response", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> Toast.makeText(this, "Error fetching data", Toast.LENGTH_SHORT).show());
        requestQueue.add(jsonObjectRequest);
    }

    /**
     * Saves a location to the database and updates the displayed list of favorite locations.
     * @param latitude Latitude of the location.
     * @param longitude Longitude of the location.
     * @param sunrise Sunrise time at the location.
     * @param sunset Sunset time at the location.
     */
    private void saveLocation(String latitude, String longitude, String sunrise, String sunset) {
        Location location = new Location(latitude, longitude, sunrise, sunset);
        db.locationDao().insert(location);
        loadFavoriteLocations();
        Snackbar.make(favoritesRecyclerView, "Location saved", Snackbar.LENGTH_LONG).show();
    }

    /**
     * Displays the results of sunrise and sunset times in a dialog.
     * @param sunrise The sunrise time to display.
     * @param sunset The sunset time to display.
     */
    private void showResults(String sunrise, String sunset) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sunrise and Sunset Times")
                .setMessage("Sunrise: " + sunrise + "\nSunset: " + sunset)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> dialog.dismiss())
                .show();
    }

    /**
     * Loads favorite locations from the database and displays them in the RecyclerView.
     */
    private void loadFavoriteLocations() {
        List<Location> locations = db.locationDao().getAllLocations();
        locationAdapter.setLocations(locations);
    }

    /**
     * Inflates the menu for the activity.
     * @param menu The menu in which you place your items.
     * @return You must return true for the menu to be displayed; if you return false it will not be shown.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Handles menu item selections.
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to proceed, true to consume it here.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_help) {
            showHelpDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Shows a help dialog that provides instructions for using the app.
     */
    private void showHelpDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.help_title)
                .setMessage(R.string.help_message)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> dialog.dismiss())
                .show();
    }

    private static final String PREFS_NAME = "AppPrefs";
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";
}
