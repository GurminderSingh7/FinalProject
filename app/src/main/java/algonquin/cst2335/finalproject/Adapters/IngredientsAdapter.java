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

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder> {

    Context context;
    List<ExtendedIngredient> list;

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

    static class IngredientsViewHolder extends RecyclerView.ViewHolder {
        TextView textView_ingredients_quantity, textView_ingredients_name;
        ImageView imageView_ingredients;

        public IngredientsViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_ingredients_quantity = itemView.findViewById(R.id.textview_ingredients_quantity); // Ensure ID matches
            textView_ingredients_name = itemView.findViewById(R.id.textView_ingredients_name); // Ensure ID matches
            imageView_ingredients = itemView.findViewById(R.id.imageview_ingredients); // Corrected ID to match XML
        }
    }
}
