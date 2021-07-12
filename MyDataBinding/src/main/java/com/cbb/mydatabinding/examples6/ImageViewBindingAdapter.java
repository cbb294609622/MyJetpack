package com.cbb.mydatabinding.examples6;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.cbb.mydatabinding.R;
import com.squareup.picasso.Picasso;

public class ImageViewBindingAdapter {

    //加载网络图片
    @BindingAdapter("itemImage")
    public static void setImage(ImageView image,String url){
        if (!TextUtils.isEmpty(url)){
            Picasso.get()
                    .load(url)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(image);
        }else{
            image.setBackgroundColor(Color.GRAY);
        }
    }

}
