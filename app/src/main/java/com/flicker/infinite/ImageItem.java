package com.flicker.infinite;

import android.graphics.Bitmap;

public class ImageItem {
    private Bitmap image;
    private String link;

    public ImageItem(Bitmap image, String link) {
        super();
        this.image = image;
        this.link = link;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
