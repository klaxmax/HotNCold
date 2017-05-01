package com.hotncold.hotncold.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.hotncold.hotncold.R;

/**
 * Created by Klaxmax on 30.04.2017.
 */

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        setSupportActionBar(myToolbar);
    }
}
