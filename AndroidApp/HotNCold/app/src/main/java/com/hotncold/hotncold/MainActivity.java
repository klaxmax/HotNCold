package com.hotncold.hotncold;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hotncold.hotncold.view.LocationOverviewActivity;
import com.hotncold.hotncold.view.MapViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openFilterActivity(View v){
        ColorTheme colTheme = ColorTheme.getInstance();

        colTheme.setColBackground(getResources().getColor(R.color.background));
        colTheme.setColBackgroundTheme(getResources().getColor(R.color.redbackground));
        colTheme.setColLogo(getResources().getColor(R.color.redlogobackground));
        colTheme.setColText(getResources().getColor(R.color.redtext));

        Intent intent = new Intent(getApplicationContext(),MapViewActivity.class);
        startActivity(intent);
    }

    public void openFilterActivityCold(View v){
        Intent intent = new Intent(getApplicationContext(), LocationOverviewActivity.class);
        startActivity(intent);
    }

}
