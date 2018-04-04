package com.demo_gallery_grid_view.com.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.demo_gallery_grid_view.com.R;
import com.demo_gallery_grid_view.com.model.Images;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by pulkit on 18/3/18.
 */

public class CustomGalleryAdapter extends BaseAdapter {

    private List<Drawable> plotsImages;
    private Context context;
    private ImageView imageView;
    private CustomGalleryViewHolder viewHolder;

    private onClickListener onClickListener;


    public interface onClickListener {
        void onClickButton(int position, int view, Images images);
    }

    public CustomGalleryAdapter(Context context, List<Drawable> drawableList) {
        this.context = context;
        this.plotsImages = drawableList;
        this.onClickListener = onClickListener;
    }

    @Override
    public int getCount() {
        return plotsImages.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        if (convertView == null) {
            viewHolder = new CustomGalleryViewHolder();
            imageView = new ImageView(context);
//            imageView.setPadding(3, 3, 3, 3);
            imageView.setPadding(10, 10, 10, 10);

            convertView = imageView;
            viewHolder.ivImageView = imageView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CustomGalleryViewHolder) convertView.getTag();
        }

        viewHolder.ivImageView.setImageDrawable(plotsImages.get(position));
        viewHolder.ivImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        viewHolder.ivImageView.setLayoutParams(new Gallery.LayoutParams(100, 100));
        viewHolder.ivImageView.setBackgroundResource(R.drawable.ic_image_black_border);

        return imageView;
    }

    class CustomGalleryViewHolder implements View.OnClickListener {

        private ImageView ivImageView;

        @Override
        public void onClick(View view) {

        }
    }

}
