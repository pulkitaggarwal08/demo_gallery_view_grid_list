package com.demo_gallery_grid_view.com.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import com.demo_gallery_grid_view.com.R;
import com.demo_gallery_grid_view.com.adapters.CustomGalleryAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomGalleryActivity extends AppCompatActivity {

    private ImageView selectedImageView;
    private ImageView leftArrowImageView;
    private ImageView rightArrowImageView;

    private Gallery gallery;
    private int selectedImagePosition = 0;
    private List<Drawable> drawableList;
    private CustomGalleryAdapter galleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_gallery);

        findIds();
        getDrawableList();
        init();

    }

    private void getDrawableList() {

        drawableList = new ArrayList<>();

        drawableList.add(getResources().getDrawable(R.mipmap.a_1));
        drawableList.add(getResources().getDrawable(R.mipmap.a_2));
        drawableList.add(getResources().getDrawable(R.mipmap.a_3));
        drawableList.add(getResources().getDrawable(R.mipmap.a_4));
        drawableList.add(getResources().getDrawable(R.mipmap.a_5));
        drawableList.add(getResources().getDrawable(R.mipmap.a_6));
        drawableList.add(getResources().getDrawable(R.mipmap.a_7));
        drawableList.add(getResources().getDrawable(R.mipmap.a_8));
        drawableList.add(getResources().getDrawable(R.mipmap.a_9));
        drawableList.add(getResources().getDrawable(R.mipmap.a_10));
    }

    private void findIds() {
        selectedImageView = findViewById(R.id.iv_selected);
        leftArrowImageView = findViewById(R.id.iv_left_arrow);
        rightArrowImageView = findViewById(R.id.iv_right_arrow);

        gallery = findViewById(R.id.gallery);
    }

    private void init() {

        leftArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedImagePosition > 0) {
                    --selectedImagePosition;
                }
                gallery.setSelection(selectedImagePosition, true);
            }
        });

        rightArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedImagePosition < drawableList.size() - 1) {
                    ++selectedImagePosition;
                }
                gallery.setSelection(selectedImagePosition, true);
            }
        });

        itemSelected();
    }

    public void itemSelected() {

        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                selectedImagePosition = position;
                if (selectedImagePosition > 0 && selectedImagePosition < drawableList.size() - 1) {
                    leftArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_left_black_enabled));
                    rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_right_black_enabled));
                } else if (selectedImagePosition == 0) {
                    leftArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_left_white_disabled));
                } else if (selectedImagePosition == drawableList.size() - 1) {
                    rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_right_white_disabled));
                }

                changeBorderForSelectedImage(selectedImagePosition);
                setSelectedImage(selectedImagePosition);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        setAdapter();

        if (drawableList.size() == 0) {
            gallery.setSelection(selectedImagePosition, true);
        }
        if (drawableList.size() == 1) {
            rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_right_white_disabled));
        }
    }

    private void setAdapter() {

        galleryAdapter = new CustomGalleryAdapter(getApplicationContext(), drawableList);
        gallery.setAdapter(galleryAdapter);
    }

    private void changeBorderForSelectedImage(int selectedImagePosition) {
        int count = gallery.getChildCount();
        for (int i = 0; i < count; i++) {
            ImageView imageView = (ImageView) gallery.getChildAt(i);
            imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_image_grey_border));
            imageView.setPadding(10, 10, 10, 10);
            imageView.setLayoutParams(new Gallery.LayoutParams(110, 110));
        }
        ImageView imageView = (ImageView) gallery.getSelectedView();
        imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_image_black_border));
        imageView.setPadding(10, 10, 10, 10);
        imageView.setLayoutParams(new Gallery.LayoutParams(110, 110));
    }

    private void setSelectedImage(int selectedImagePosition) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawableList.get(selectedImagePosition);
//        Bitmap bitmap = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(),
//                (int) (bitmapDrawable.getIntrinsicHeight() * 0.9),
//                (int) (bitmapDrawable.getIntrinsicWidth() * 0.9), false);

        Bitmap bitmap = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), 200, 200, false);
        selectedImageView.setImageBitmap(bitmap);
        selectedImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

}
