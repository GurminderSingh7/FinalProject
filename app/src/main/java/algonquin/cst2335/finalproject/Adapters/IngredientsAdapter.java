package algonquin.cst2335.finalproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;
import algonquin.cst2335.finalproject.Models.ExtendedIngredient;
import algonquin.cst2335.finalproject.R;

/**
 * Adapter for a RecyclerView that displays ingredients. Each item in the list shows the name,
 * quantity, and an image of the ingredient.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder> {

    Context context;
    List<ExtendedIngredient> list;

    /**
     * Constructs an IngredientsAdapter.
     *
     * @param context The current context, used to inflate the layout.
     * @param list A list of ExtendedIngredient objects to be displayed.
     */
    public IngredientsAdapter(Context context, List<ExtendedIngredient> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IngredientsViewHolder(LayoutInflater.from(context).inflate(R.layout.list_meal_ingredients, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder holder, int position) {
        ExtendedIngredient ingredient = list.get(position);
        holder.textView_ingredients_name.setText(ingredient.name);
        holder.textView_ingredients_quantity.setText(ingredient.amount + " " + ingredient.unit);
        Picasso.get().load("http://spoonacular.com/cdn/ingredients_100x100/" + ingredient.image).into(holder.imageView_ingredients);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * Provides a reference to the type of views used (ingredients) in the RecyclerView.
     */
    static class IngredientsViewHolder extends RecyclerView.ViewHolder {
        TextView textView_ingredients_quantity, textView_ingredients_name;
        ImageView imageView_ingredients;

        /**
         * Constructor for the IngredientsViewHolder.
         *
         * @param itemView The view in which the ingredients will be displayed.
         */
        public IngredientsViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_ingredients_quantity = itemView.findViewById(R.id.textview_ingredients_quantity);
            textView_ingredients_name = itemView.findViewById(R.id.textView_ingredients_name);
            imageView_ingredients = itemView.findViewById(R.id.imageview_ingredients);
        }
    }
}
