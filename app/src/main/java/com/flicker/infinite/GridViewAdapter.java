package com.flicker.infinite;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;


import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

import static com.flicker.infinite.Utils.getJSON;

public class GridViewAdapter extends ArrayAdapter {
    private static final String FLICKR_BASE_URL =  "https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&extras=url_s";
    private static final String APIKEY_SEARCH_STRING = "&api_key=aabca25d8cd75f676d3a74a72dcebf21";
    private static final int NUMBER_OF_PHOTOS = 20;
    private static final String TAG = "TAGGING_FUN";

    private Context context;
    private int layoutResourceId;
    private int pageNumber;
    private ArrayList<String> data = new ArrayList<>();

    public GridViewAdapter(Context context, int layoutResourceId, ArrayList<String> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
        getURLArray();
        pageNumber = 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
            convertView = (ImageView) convertView.findViewById(R.id.image);
        }
        Log.d(TAG, "getView: "+position);
        if(position+20 >= data.size()) {
            getURLArray();
        }

        Glide.with(context)
                .load(data.get(position))
                .centerCrop()
                .override(100)
                .placeholder(R.drawable.cat)
                .into((ImageView)convertView);

        return convertView;
    }

    public void getURLArray(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String rl = FLICKR_BASE_URL + APIKEY_SEARCH_STRING + "&page=" + pageNumber++ +"&per_page=" + NUMBER_OF_PHOTOS + "&format=json&nojsoncallback=1";
                    JSONArray imageArray = new JSONObject(getJSON(rl)).getJSONObject("photos").getJSONArray("photo");
                    Log.d(TAG, "onCreate: " + rl + "\n" + imageArray);
                    for (int i = 0; i < imageArray.length(); i++) {
                        JSONObject item = imageArray.getJSONObject(i);
                        Log.d(TAG, "onCreate: \n" + item.getString("url_s"));
                        data.add(item.getString("url_s"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ((MainActivity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        notifyDataSetInvalidated();
                    }
                });
            }
        }).start();

    }
}
