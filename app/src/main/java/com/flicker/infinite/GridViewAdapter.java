package com.flicker.infinite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private ArrayList<ImageItem> data = new ArrayList<>();

    public GridViewAdapter(Context context, int layoutResourceId, ArrayList data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View square = convertView;
        ViewHolder holder;

        if (square == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            square = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) square.findViewById(R.id.image);
            square.setTag(holder);
        } else {
            holder = (ViewHolder) square.getTag();
        }

        ImageItem item = data.get(position);
        holder.link = item.getLink();
        holder.image.setImageBitmap(item.getImage());
        return square;
    }

    static class ViewHolder {
        ImageView image;
        String link;
    }
}
