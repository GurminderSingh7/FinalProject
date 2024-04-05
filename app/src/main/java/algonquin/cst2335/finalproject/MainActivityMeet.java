/**
 * Main activity class for the recipe finding application. This class handles the initialization
 * and setup of the UI components, including a search view, a spinner for tags, and a recycler view
 * for displaying recipes. It also handles search queries and user interactions.
 *
 * @author Meet Maheta
 * @version 1.0
 * @since 3 April 2024
 * @labSession 012
 */
package algonquin.cst2335.finalproject;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;

import algonquin.cst2335.finalproject.Adapters.RandomRecipeAdapter;
import algonquin.cst2335.finalproject.Listeners.RandomRecipeResponseListeners;
import algonquin.cst2335.finalproject.Listeners.RecipeClickListener;
import algonquin.cst2335.finalproject.Models.RandomRecipeApiResponse;

public class MainActivityMeet extends AppCompatActivity {

    private ProgressDialog dialog;
    private RequestManager manager;
    private RandomRecipeAdapter randomRecipeAdapter;
    private RecyclerView recyclerView;
    private Spinner spinner;
    private List<String> tags = new ArrayList<>();
    private SearchView searchView;
    private Button clearButton;

    /**
     * Called when the activity is starting. This is where most initialization should go:
     * calling setContentView(int) to inflate the activity's UI, using findViewById to
     * programmatically interact with widgets in the UI.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down
     *                           then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     *                           Note: Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_meet);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeViews();
        setupSearchView();
        setupSpinner();
        setupRecyclerView();
        setupClearButton();
    }

    /**
     * Initializes the main views in the activity.
     */
    private void initializeViews() {
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading...");

        searchView = findViewById(R.id.searchView_home);
        spinner = findViewById(R.id.spinner_tags);
        recyclerView = findViewById(R.id.recycler_random);
        manager = new RequestManager(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        randomRecipeAdapter = new RandomRecipeAdapter(this, new ArrayList<>(), recipeClickListener);
        recyclerView.setAdapter(randomRecipeAdapter);
    }

    /**
     * Sets up the search view with functionality to handle search queries and save the last query.
     */
    private void setupSearchView() {
        SharedPreferences sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        String lastSearchQuery = sharedPreferences.getString("lastSearchQuery", "");
        searchView.setQuery(lastSearchQuery, false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                tags.clear();
                tags.add(query);
                manager.getRandomRecipes(randomRecipeResponseListeners, tags);
                dialog.show();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("lastSearchQuery", query);
                editor.apply();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    /**
     * Sets up the spinner with a list of tags for recipe filtering.
     */
    private void setupSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.tags, R.layout.spinner_text);
        adapter.setDropDownViewResource(R.layout.spinner_inner_text);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tags.clear();
                tags.add(parent.getItemAtPosition(position).toString());
                manager.getRandomRecipes(randomRecipeResponseListeners, tags);
                dialog.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Snackbar.make(recyclerView, "No tag selected. Please select a tag.", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Sets up the RecyclerView which will display the list of recipes. This includes setting
     * the layout manager and attaching the adapter.
     */
    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        randomRecipeAdapter = new RandomRecipeAdapter(this, new ArrayList<>(), recipeClickListener);
        recyclerView.setAdapter(randomRecipeAdapter);
    }

    /**
     * Sets up the clear button which allows users to clear the current list of recipes displayed.
     */
    private void setupClearButton() {
        clearButton = findViewById(R.id.button_clear);
        clearButton.setOnClickListener(v -> showClearConfirmationDialog());
    }

    private final RandomRecipeResponseListeners randomRecipeResponseListeners = new RandomRecipeResponseListeners() {
        @Override
        public void didFetch(RandomRecipeApiResponse response, String message) {
            dialog.dismiss();
            randomRecipeAdapter.updateRecipesList(response.getRecipes());
            Snackbar.make(recyclerView, "Recipes loaded successfully!", Snackbar.LENGTH_LONG).show();
        }

        @Override
        public void didError(String message) {
            Toast.makeText(MainActivityMeet.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private final RecipeClickListener recipeClickListener = id -> {
        Intent intent = new Intent(MainActivityMeet.this, RecipeDetailsActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    };

    /**
     * Displays a confirmation dialog to the user before clearing all recipes from the display.
     */
    private void showClearConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Clear Recipes")
                .setMessage("Are you sure you want to clear all recipes?")
                .setPositiveButton("Yes", (dialog, which) -> clearRecipes())
                .setNegativeButton("No", null)
                .show();
    }

    /**
     * Clears all recipes from the display.
     */
    private void clearRecipes() {
        if (randomRecipeAdapter != null) {
            randomRecipeAdapter.updateRecipesList(new ArrayList<>());
            Snackbar.make(recyclerView, "All recipes cleared.", Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_help) {
            showHelpDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Displays a help dialog to the user with instructions on how to use the app.
     */
    private void showHelpDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Help")
                .setMessage("Here's how to use the app:\n\n" +
                        "- Use the search bar to find recipes.\n" +
                        "- Select a tag to filter recipes.\n" +
                        "- Tap a recipe for more details.")
                .setPositiveButton("Got it", null)
                .show();
    }
}
