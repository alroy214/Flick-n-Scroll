package com.flicker.infinite;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private GridViewAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Gallery");
        gridView = (GridView) findViewById(R.id.gridView);
        Context context = this;
        gridAdapter = new GridViewAdapter(context, R.layout.grid_item_layout, new ArrayList<>());
        gridView.setAdapter(gridAdapter);
    }
}