package com.hotncold.hotncold.controller;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotncold.hotncold.R;
import com.hotncold.hotncold.dto.Location;
import java.util.List;

/**
 * Created by Klaxmax on 01.05.2017.
 */

public class LocationAdapter extends ArrayAdapter<Location> {
    private final Context context;
    private final List<Location> values;

    public LocationAdapter(Context context, List<Location> values) {
        super(context, R.layout.activity_location_entry, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Location location = getItem(position);
        Log.i("Putting Item", location.getStrName() + " " + position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_location_entry, parent, false);
        }
        // Lookup view for data population
        TextView lDescription = (TextView) convertView.findViewById(R.id.locationEntry_Description);
        TextView lDistance = (TextView) convertView.findViewById(R.id.locationEntry_Distance);
        // Populate the data into the template view using the data object
        lDescription.setText(location.getStrName());
        lDistance.setText(location.getStrDistance());
        // Return the completed view to render on screen
        return convertView;
    }
}