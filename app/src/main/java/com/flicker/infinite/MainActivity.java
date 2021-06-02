package com.flicker.infinite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private GridViewAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);
    }

    // Prepare some dummy data for gridview
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
            imageItems.add(new ImageItem(bitmap,
                    "https://img.favpng.com/21/6/7/cat-emoji-android-nougat-android-oreo-png-favpng-R7bcgx9cn6GKi3g00a8bHF53Y.jpg"));
        }
        return imageItems;
    }

}