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
import algonquin.cst2335.finalproject.Models.Recipe;
import algonquin.cst2335.finalproject.R;

/**
 * Adapter for displaying random recipes in a RecyclerView. This adapter uses
 * a CardView layout to display each recipe's image, title, likes, servings, and cooking time.
 * Interactions are handled via a click listener.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class RandomRecipeAdapter extends RecyclerView.Adapter<RandomRecipeAdapter.RandomRecipeViewHolder> {
    Context context;
    List<Recipe> list;
    RecipeClickListener listener;

    /**
     * Constructs a new RandomRecipeAdapter.
     *
     * @param context The context used to inflate the layout.
     * @param list A list of Recipe objects to be displayed.
     * @param recipeClickListener Listener for recipe click events.
     */
    public RandomRecipeAdapter(Context context, List<Recipe> list, RecipeClickListener recipeClickListener) {
        this.context = context;
        this.list = list;
        this.listener = recipeClickListener;
    }

    @NonNull
    @Override
    public RandomRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RandomRecipeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_random_recipe, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RandomRecipeViewHolder holder, int i) {
        holder.textView_title.setText(list.get(i).getTitle()); // Assuming getters are used
        holder.textView_title.setSelected(true); // To enable marquee
        holder.textView_likes.setText(list.get(i).getAggregateLikes() + " Likes");
        holder.textView_servings.setText(list.get(i).getServings() + " Servings");
        holder.textView_time.setText(list.get(i).getReadyInMinutes() + " Minutes");
        Picasso.get().load(list.get(i).getImage()).into(holder.imageView_food);
        holder.random_list_container.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                listener.onRecipeClicked(String.valueOf(list.get(holder.getAdapterPosition()).id));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * Updates the list of recipes displayed by the adapter.
     *
     * @param recipeList The new list of recipes to display.
     */
    public void updateRecipesList(List<Recipe> recipeList) {
        this.list = recipeList;
        notifyDataSetChanged();
    }

    /**
     * ViewHolder class for recipe items in the RecyclerView.
     */
    class RandomRecipeViewHolder extends RecyclerView.ViewHolder {
        CardView random_list_container;
        TextView textView_title, textView_servings, textView_likes, textView_time;
        ImageView imageView_food;

        public RandomRecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            random_list_container = itemView.findViewById(R.id.random_list_container);
            textView_title = itemView.findViewById(R.id.textView_title);
            textView_servings = itemView.findViewById(R.id.textView_servings);
            textView_likes = itemView.findViewById(R.id.textView_likes);
            textView_time = itemView.findViewById(R.id.textView_time);
            imageView_food = itemView.findViewById(R.id.imageView_food);
        }
    }
}
