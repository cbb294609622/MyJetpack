package com.cbb.mydatabinding.examples3;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.cbb.mydatabinding.R;
import com.squareup.picasso.Picasso;

public class ImageViewBindingAdapter {

    //加载网络图片
    @BindingAdapter("image")
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
    //加载本地图片
    @BindingAdapter("image")
    public static void setImage(ImageView image,int resID){
        image.setImageResource(resID);
    }

    /**
     * 参数可选
     * @param image
     * @param url
     * @param resID
     */
    @BindingAdapter(value = {"image","defaultImageResource"},requireAll = false)
    public static void setImage(ImageView image,String url,int resID){
        if (!TextUtils.isEmpty(url)){
            Picasso.get()
                    .load(url)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(image);
        }else{
            image.setImageResource(resID);
        }
    }

}
