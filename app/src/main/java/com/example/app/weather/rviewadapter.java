package com.example.app.weather;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class rviewadapter extends RecyclerView.Adapter<rviewadapter.ViewHolder> {

    private List<String[]> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    rviewadapter(Context context, List<String[]> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_rviewadapter, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String[] animal = mData.get(position);
        holder.year.setText(animal[1]);
        holder.jandata.setText(animal[2]);
        holder.aprildata.setText(animal[5]);
        holder.julydata.setText(animal[8]);
        holder.octdata.setText(animal[11]);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id)[0];
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView year;
        TextView jandata;
        TextView aprildata;
        TextView julydata;
        TextView octdata;

        ViewHolder(View itemView) {
            super(itemView);
            year = itemView.findViewById(R.id.tvAnimalName);
            jandata = itemView.findViewById(R.id.jandata);
            aprildata = itemView.findViewById(R.id.aprildata);
            julydata = itemView.findViewById(R.id.julydata);
            octdata = itemView.findViewById(R.id.octdata);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}