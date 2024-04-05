package algonquin.cst2335.finalproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;
import algonquin.cst2335.finalproject.Listeners.RecipeClickListener;
import algonquin.cst2335.finalproject.Models.SimilarRecipeResponse;
import algonquin.cst2335.finalproject.R;

/**
 * Adapter for displaying a list of similar recipes in a RecyclerView.
 * This adapter is responsible for creating view holders that hold the recipe details,
 * handling the binding of the recipes to the view holders, and managing click events on each recipe.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class SimilarRecipeAdapter extends RecyclerView.Adapter<SimilarRecipeAdapter.SimilarRecipeViewHolder> {

    Context context;
    List<SimilarRecipeResponse> list;
    RecipeClickListener listener;

    /**
     * Constructs a SimilarRecipeAdapter.
     *
     * @param context The context used for inflating layouts.
     * @param list    A list of SimilarRecipeResponse objects to be displayed.
     * @param listener A callback for when a recipe is clicked.
     */
    public SimilarRecipeAdapter(Context context, List<SimilarRecipeResponse> list, RecipeClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SimilarRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimilarRecipeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_similar_recipe, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarRecipeViewHolder holder, int position) {
        SimilarRecipeResponse recipe = list.get(position);
        holder.textView_similar_title.setText(recipe.title);
        holder.textView_similar_title.setSelected(true); // Enable marquee effect for long text
        holder.textView_similar_serving.setText(recipe.servings + " Persons");
        Picasso.get().load("https://spoonacular.com/recipeImages/" + recipe.id + "-556x370." + recipe.imageType).into(holder.imageView_similar);

        holder.similar_recipe_holder.setOnClickListener(view -> listener.onRecipeClicked(String.valueOf(recipe.id)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * ViewHolder class for similar recipes. Holds views for recipe image, title, and servings.
     */
    static class SimilarRecipeViewHolder extends RecyclerView.ViewHolder {
        CardView similar_recipe_holder;
        TextView textView_similar_title, textView_similar_serving;
        ImageView imageView_similar;

        public SimilarRecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            similar_recipe_holder = itemView.findViewById(R.id.similar_recipe_holder);
            textView_similar_title = itemView.findViewById(R.id.textView_similar_title);
            textView_similar_serving = itemView.findViewById(R.id.textView_similar_serving);
            imageView_similar = itemView.findViewById(R.id.imageView_similar);
        }
    }
}
