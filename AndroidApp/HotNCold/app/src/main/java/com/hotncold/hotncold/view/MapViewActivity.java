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
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hotncold.hotncold.R;
import com.hotncold.hotncold.controller.LocationAdapter;
import com.hotncold.hotncold.dto.Location;
import com.hotncold.hotncold.model.LocationsModel;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState;

import java.util.List;

public class MapViewActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final String TAG = "MapViewActivity";
    private GoogleMap mGoogleMap;
    private LocationAdapter lAdapter;
    private LocationsModel lm;

    private SlidingUpPanelLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_detail));


        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        mLayout.setAnchorPoint(0.5f);
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

        initMap();
        initList();
    }

    public void initMap() {
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void initList(){
        lm = new LocationsModel();
        ListView listView = (ListView) findViewById(R.id.location_ListView);
        List<Location> locationList = lm.getAll();
        lAdapter = new LocationAdapter(this,locationList);
        listView.setAdapter(lAdapter);
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