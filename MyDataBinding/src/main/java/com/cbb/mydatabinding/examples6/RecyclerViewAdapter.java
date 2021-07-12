package com.cbb.mydatabinding.examples6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cbb.mydatabinding.R;
import com.cbb.mydatabinding.databinding.ItemSixBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    List<Idol> idol;

    public RecyclerViewAdapter(List<Idol> idol){
        this.idol = idol;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemSixBinding sixBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_six,
                parent,
                false);

        return new MyViewHolder(sixBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, int position) {
        Idol idol = this.idol.get(position);
        holder.sixBinding.setIdol(idol);
    }

    @Override
    public int getItemCount() {
        return idol.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        private ItemSixBinding sixBinding;

        public MyViewHolder(View itemView) {
            super(itemView);
        }

        public MyViewHolder(ItemSixBinding sixBinding) {
            super(sixBinding.getRoot());
            this.sixBinding = sixBinding;
        }
    }

}
