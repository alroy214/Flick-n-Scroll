package com.flicker.infinite;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Glide.with(this)
                .load(getIntent().getExtras().getString("IMG"))
                .fitCenter()
                .placeholder(R.drawable.cat)
                .into((ImageView)findViewById(R.id.imageView));
    }
}
