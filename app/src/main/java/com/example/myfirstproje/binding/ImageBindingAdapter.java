package com.example.myfirstproje.binding;

import static com.example.myfirstproje.Constants.IMAGE_BASE_URL;
import static com.example.myfirstproje.Constants.IMAGE_W342;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageBindingAdapter {
    public static void loadImage(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(imageView.getContext())
                    .load(IMAGE_BASE_URL + IMAGE_W342 + url)
                    .into(imageView);
            //ImageBındıng
            //test1
        }
    }
}
