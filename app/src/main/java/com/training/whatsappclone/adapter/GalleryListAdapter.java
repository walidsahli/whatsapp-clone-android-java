package com.training.whatsappclone.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.training.whatsappclone.R;

import java.util.ArrayList;

public class GalleryListAdapter extends RecyclerView.Adapter<GalleryListAdapter.ViewHolder> {
    private ArrayList<String> mDataset;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;

        public ViewHolder(ViewGroup container) {
            super(container);
            this.image = container.findViewById(R.id.imageViewGallery);
        }
    }

    public GalleryListAdapter(ArrayList<String> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public GalleryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        ViewGroup v = (ViewGroup) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_gallery_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.get()
                .load("file://" + mDataset.get(position))
                .resize(150,150)
                .centerCrop()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}