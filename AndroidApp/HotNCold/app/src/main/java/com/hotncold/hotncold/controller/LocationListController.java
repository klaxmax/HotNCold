package com.hotncold.hotncold.controller;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hotncold.hotncold.R;
import com.hotncold.hotncold.dto.Location;
import com.hotncold.hotncold.model.LocationsModel;

import java.util.List;

/**
 * Created by Klaxmax on 01.05.2017.
 */

public class LocationListController extends ListActivity implements ActionMode.Callback {
    protected Object mActionMode;
    public int selectedItem = -1;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (mActionMode != null) {
                    return false;
                }
                selectedItem = position;

                // Start the CAB using the ActionMode.Callback defined above
                mActionMode = LocationListController.this.startActionMode(LocationListController.this);
                view.setSelected(true);
                return true;
            }
        });


    }

    private void show() {
        Toast.makeText(LocationListController.this, String.valueOf(selectedItem), Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }
}
