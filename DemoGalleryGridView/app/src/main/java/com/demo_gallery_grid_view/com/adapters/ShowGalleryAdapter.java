package com.demo_gallery_grid_view.com.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.demo_gallery_grid_view.com.R;
import com.demo_gallery_grid_view.com.model.Images;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by pulkit on 12/1/18.
 */

public class ShowGalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Images> imagesList;
    private Context context;
    private onClickListener onClickListener;

    public interface onClickListener {
        void onClickButton(int position, int view, Images images);
    }

    public ShowGalleryAdapter(Context context, List<Images> imagesList, onClickListener onClickListener) {
        this.context = context;
        this.imagesList = imagesList;
        this.onClickListener = onClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GalleryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_show_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        GalleryViewHolder holder = (GalleryViewHolder) viewHolder;

        Integer imageUrl = imagesList.get(position).getImageId();

//        holder.ivImageView.setImageResource(imageUrl);

        Picasso.with(context)
                .load(imageUrl)
                .resize(200, 200)
                .centerCrop()
                .into(holder.ivImageView);

    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView ivImageView;

        public GalleryViewHolder(View itemView) {
            super(itemView);

            ivImageView = (ImageView) itemView.findViewById(R.id.iv_imageView);

            ivImageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClickButton(getLayoutPosition(), view.getId(), imagesList.get(getLayoutPosition()));
        }
    }

}
