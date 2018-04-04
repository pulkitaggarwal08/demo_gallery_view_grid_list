package com.demo_gallery_grid_view.com.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.demo_gallery_grid_view.com.R;
import com.demo_gallery_grid_view.com.adapters.ShowGalleryAdapter;
import com.demo_gallery_grid_view.com.model.Images;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    private RecyclerView rv_gallery;
    private List<Images> arrayList = new ArrayList<>();
    private ShowGalleryAdapter showGalleryAdapter;

    private final Integer imagesId[] = {
            R.mipmap.a_1,
            R.mipmap.a_2,
            R.mipmap.a_3,
            R.mipmap.a_4,
            R.mipmap.a_5,
            R.mipmap.a_6,
            R.mipmap.a_7,
            R.mipmap.a_8,
            R.mipmap.a_9,
            R.mipmap.a_10
    };

    private final String imageTitles[] = {
            "Img1",
            "Img2",
            "Img3",
            "Img4",
            "Img5",
            "Img6",
            "Img7",
            "Img8",
            "Img9",
            "Img10"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        findIds();
        init();

    }

    private void findIds() {

        rv_gallery = (RecyclerView) findViewById(R.id.rv_gallery);
    }

    private void init() {

        rv_gallery.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        prepareData();

        setAdapter();
    }

    public void prepareData() {

        arrayList = new ArrayList<>();

        for (int i = 0; i < imagesId.length; i++) {

            Images images = new Images();

//            images.setImageTitle(imageTitles[i]);
//            images.setImageId(imagesId[i]);

            String imageTitle = imageTitles[i];
            Integer imageId = imagesId[i];

            arrayList.add(new Images(imageTitle, imageId));
        }

    }

    private void setAdapter() {

        showGalleryAdapter = new ShowGalleryAdapter(getApplicationContext(), arrayList, new ShowGalleryAdapter.onClickListener() {
            @Override
            public void onClickButton(int position, int view, Images images) {

                if (view == R.id.iv_imageView) {

                    Toast.makeText(GalleryActivity.this, position + "", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), ImageViewActivity.class);
                    startActivity(intent);

                }
            }
        });
        rv_gallery.setAdapter(showGalleryAdapter);
    }


}
