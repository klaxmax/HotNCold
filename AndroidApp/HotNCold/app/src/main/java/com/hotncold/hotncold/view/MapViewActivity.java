package com.hotncold.hotncold.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hotncold.hotncold.R;

/**
 * Created by Klaxmax on 01.05.2017.
 */

public class MapViewActivity extends AppCompatActivity implements OnMapReadyCallback {
    private Toolbar _toolbar;
    private GoogleMap mGoogleMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        setSupportActionBar(myToolbar);
        initMap();
    }

    public void initMap() {
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            if (googleMap != null) {
                mGoogleMap = googleMap;
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                LatLng alserStrasse = new LatLng(48.2167925,  16.341823400000067 );
                mGoogleMap.addMarker(new MarkerOptions().position(alserStrasse).title("Marker in Alser Strasse"));
                mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(alserStrasse));
                mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("ERROR", "GOOGLE MAPS NOT LOADED");
        }
    }
}
