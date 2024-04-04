package finalproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import android.view.Menu;
import org.json.JSONObject;

import java.util.List;

public class AdiMainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "AppPrefs";
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";
    private EditText latitudeEditText, longitudeEditText;
    private Button lookupButton;
    private RecyclerView favoritesRecyclerView;
    private RequestQueue requestQueue;
    private LocationAdapter locationAdapter;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latitudeEditText = findViewById(R.id.latitudeEditText);
        longitudeEditText = findViewById(R.id.longitudeEditText);
        lookupButton = findViewById(R.id.lookupButton);
        favoritesRecyclerView = findViewById(R.id.favoritesRecyclerView);

        requestQueue = Volley.newRequestQueue(this);
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "location_database")
                .allowMainThreadQueries()  // For simplicity, allowing main thread queries. Consider using Async tasks or coroutines in Kotlin for production.
                .build();
        SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        latitudeEditText.setText(prefs.getString("latitude", ""));
        longitudeEditText.setText(prefs.getString("longitude", ""));

        locationAdapter = new LocationAdapter(this);
        favoritesRecyclerView.setAdapter(locationAdapter);
        favoritesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadFavoriteLocations();

        lookupButton.setOnClickListener(view -> {
            String latitude = latitudeEditText.getText().toString();
            String longitude = longitudeEditText.getText().toString();
            if (!latitude.isEmpty() && !longitude.isEmpty()) {
                fetchSunriseSunset(latitude, longitude);
            } else {
                Toast.makeText(this, "Please enter latitude and longitude", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchSunriseSunset(String latitude, String longitude) {
        String url = "https://api.sunrisesunset.io/json?lat=" + latitude + "&lng=" + longitude + "&date=today";

        SharedPreferences.Editor editor = getSharedPreferences("AppPrefs", MODE_PRIVATE).edit();
        editor.putString("latitude", latitude);
        editor.putString("longitude", longitude);
        editor.apply();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONObject results = response.getJSONObject("results");
                        String sunrise = results.getString("sunrise");
                        String sunset = results.getString("sunset");
                        // Save the location to the database
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


    private void saveLocation(String latitude, String longitude, String sunrise, String sunset) {
        Location location = new Location(latitude, longitude, sunrise, sunset);
        db.locationDao().insert(location);
        loadFavoriteLocations();
        Snackbar.make(favoritesRecyclerView, "Location saved", Snackbar.LENGTH_LONG).show();
    }

    private void showResults(String sunrise, String sunset) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sunrise and Sunset Times")
                .setMessage("Sunrise: " + sunrise + "\nSunset: " + sunset)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void loadFavoriteLocations() {
        List<Location> locations = db.locationDao().getAllLocations();
        locationAdapter.setLocations(locations);
    }

    private void saveToPreferences(String latitude, String longitude) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_LATITUDE, latitude);
        editor.putString(KEY_LONGITUDE, longitude);
        editor.apply();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_help) {
            showHelpDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showHelpDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.help_title)  // Make sure you have help_title in your strings.xml
                .setMessage(R.string.help_message)  // Make sure you have help_message in your strings.xml
                .setPositiveButton(android.R.string.ok, (dialog, which) -> dialog.dismiss())
                .show();
    }
}