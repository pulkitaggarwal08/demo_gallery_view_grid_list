package com.demo_gallery_grid_view.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demo_gallery_grid_view.com.activities.CustomGalleryActivity;
import com.demo_gallery_grid_view.com.activities.GalleryActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn_gallery_view, btn_custom_gallery_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findIds();
        init();
    }

    private void findIds() {

        btn_gallery_view = (Button) findViewById(R.id.btn_gallery_view);
        btn_custom_gallery_view = (Button) findViewById(R.id.btn_custom_gallery_view);
    }

    private void init() {

        btn_gallery_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                startActivity(intent);
            }
        });
        btn_custom_gallery_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomGalleryActivity.class);
                startActivity(intent);
            }
        });

    }

}

