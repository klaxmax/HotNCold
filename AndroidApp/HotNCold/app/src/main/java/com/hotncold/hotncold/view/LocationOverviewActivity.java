package com.hotncold.hotncold.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.hotncold.hotncold.R;
import com.hotncold.hotncold.controller.LocationAdapter;
import com.hotncold.hotncold.controller.LocationListController;
import com.hotncold.hotncold.dto.Location;
import com.hotncold.hotncold.model.LocationsModel;

import java.util.List;

/**
 * Created by Klaxmax on 01.05.2017.
 */

public class LocationOverviewActivity extends AppCompatActivity {

    LocationAdapter lAdapter;
    LocationsModel lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lm = new LocationsModel();

        setContentView(R.layout.activity_location_overview);
        ListView listView = (ListView) findViewById(R.id.location_ListView);
        List<Location> locationList = lm.getAll();
        lAdapter = new LocationAdapter(this,locationList);
        listView.setAdapter(lAdapter);


    }
}
