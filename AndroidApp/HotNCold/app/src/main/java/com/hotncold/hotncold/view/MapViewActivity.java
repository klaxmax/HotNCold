package com.hotncold.hotncold.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hotncold.hotncold.R;
import com.hotncold.hotncold.controller.LocationAdapter;
import com.hotncold.hotncold.dto.Location;
import com.hotncold.hotncold.model.LocationsModel;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState;

import java.util.HashMap;
import java.util.List;

public class MapViewActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final String TAG = "MapViewActivity";
    private GoogleMap mGoogleMap;
    private HashMap<Marker,Location> locationMarkerMap;
    private List<Location> locationList;
    private LocationAdapter lAdapter;
    private LocationsModel lm;

    private SlidingUpPanelLayout mLayout;
    private ImageButton filter_Button;
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        locationMarkerMap = new HashMap<>();

        setContentView(R.layout.activity_map_view);
        //viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
        //viewFlipper.setDisplayedChild(1);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_menue));

        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        filter_Button = (ImageButton) findViewById(R.id.FilterFunnelButton);
        mLayout.setAnchorPoint(0.5f);

        lm = new LocationsModel();
        locationList = lm.getAll();
        updateEntries();
        initMap();
        initListener();
    }

    private void initMap() {
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void updateEntries(){
        ListView listView = (ListView) findViewById(R.id.location_ListView);
        lAdapter = new LocationAdapter(this,locationList);
        listView.setAdapter(lAdapter);
    }

    private void initListener(){
        mLayout.addPanelSlideListener(new PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i(TAG, "onPanelSlide, offset " + slideOffset);
            }

            private boolean isCollapsed;
            @Override
            public void onPanelStateChanged(View panel, PanelState previousState, PanelState newState) {
                if(newState == PanelState.DRAGGING && previousState == PanelState.EXPANDED){
                    isCollapsed = false;
                } else if (!isCollapsed && (newState == PanelState.ANCHORED && previousState == PanelState.DRAGGING)) {
                    mLayout.setPanelState(PanelState.COLLAPSED);
                } else if (newState == PanelState.DRAGGING && previousState == PanelState.COLLAPSED) {
                    isCollapsed = true;
                }
                Log.i(TAG, "onPanelStateChanged " + newState);
            }
        });

        mLayout.setFadeOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setPanelState(PanelState.COLLAPSED);
            }
        });

        filter_Button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FilterActivity.class);
                startActivity(intent);
            }
        });

    }

    private void updatePointsOnMap(){
        for(Location l:locationList) {
            Marker marker = mGoogleMap.addMarker(new MarkerOptions()
                    .position(l.getLatLng())
                    .title(l.getStrName()));
            locationMarkerMap.put(marker,l);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            if (googleMap != null) {
                mGoogleMap = googleMap;
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                updatePointsOnMap();
                mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(48.2167925, 16.341823400000067)));
                mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
            }

            mGoogleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(marker.getPosition()));
                    mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
                    Location l = locationMarkerMap.get(marker);
                    updateDetails(l.getStrName(),l.getStrdescription(),l.getStradress(),l.getStrWebPage());
                    mLayout.setPanelState(PanelState.ANCHORED);
                    return false;
                }
            });

            mGoogleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("ERROR", "GOOGLE MAPS NOT LOADED");
        }
    }

    private void updateDetails(String name,String description,String adress,String webpage){
        TextView detail_Name = (TextView) findViewById(R.id.detail_Name);
        detail_Name.setText(name);

        TextView detail_description = (TextView) findViewById(R.id.detail_description);
        detail_description.setText(description);

        TextView detail_Adress = (TextView) findViewById(R.id.detail_Adress);
        detail_Adress.setText(adress);

        TextView detail_Webpage = (TextView) findViewById(R.id.detail_Webpage);
        detail_Webpage.setText(webpage);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (mLayout != null &&
                (mLayout.getPanelState() == PanelState.EXPANDED || mLayout.getPanelState() == PanelState.ANCHORED)) {
            mLayout.setPanelState(PanelState.COLLAPSED);
        } else {
            super.onBackPressed();
        }
    }
}