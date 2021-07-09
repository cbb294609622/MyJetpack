package com.cbb.mydatabinding.examples1;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class EventHandlerListener {
    private Context mContext;

    public EventHandlerListener(Context mContext) {
        this.mContext = mContext;
    }

    public void buttonOnClick(View v){
        Toast.makeText(mContext,"喜欢",Toast.LENGTH_SHORT).show();
    }
}
