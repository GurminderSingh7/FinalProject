package algonquin.cst2335.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for the RecyclerView that displays Location objects.
 *
 * @author Aditya Hirpara
 */
public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    private List<Location> locations = new ArrayList<>();
    private final LayoutInflater inflater;

    /**
     * Constructs the LocationAdapter with the specified context.
     *
     * @param context The context used to inflate the layout of each item.
     */
    public LocationAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    /**
     * Called when RecyclerView needs a new {@link LocationViewHolder} of the given type to represent an item.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new LocationViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new LocationViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     *
     * @param holder The LocationViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        Location currentLocation = locations.get(position);
        holder.locationTextView.setText("Lat: " + currentLocation.getLatitude() + ", Lng: " + currentLocation.getLongitude());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return locations.size();
    }

    /**
     * Updates the list of locations and notifies the adapter to refresh the view.
     *
     * @param locations The new list of locations to display.
     */
    public void setLocations(List<Location> locations) {
        this.locations = locations;
        notifyDataSetChanged();
    }

    /**
     * Provides a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    static class LocationViewHolder extends RecyclerView.ViewHolder {
        private final TextView locationTextView;

        /**
         * Constructs the LocationViewHolder, initializing the view components.
         *
         * @param itemView The View that you inflated in {@link #onCreateViewHolder(ViewGroup, int)}.
         */
        public LocationViewHolder(View itemView) {
            super(itemView);
            locationTextView = itemView.findViewById(android.R.id.text1);
        }
    }
}
