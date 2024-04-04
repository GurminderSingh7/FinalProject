package finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    private List<Location> locations = new ArrayList<>();
    private LayoutInflater inflater;

    public LocationAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new LocationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        Location currentLocation = locations.get(position);
        holder.locationTextView.setText("Lat: " + currentLocation.getLatitude() + ", Lng: " + currentLocation.getLongitude());
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
        notifyDataSetChanged();
    }

    static class LocationViewHolder extends RecyclerView.ViewHolder {
        private final TextView locationTextView;

        public LocationViewHolder(View itemView) {
            super(itemView);
            locationTextView = itemView.findViewById(android.R.id.text1);
        }
    }
}

