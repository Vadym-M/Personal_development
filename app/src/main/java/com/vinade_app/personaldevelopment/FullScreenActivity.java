package com.vinade_app.personaldevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class FullScreenActivity extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        img = findViewById(R.id.imageView);
        getSupportActionBar().hide();
        getSupportActionBar().setTitle("Full Screen Image");
        Intent intent = getIntent();
        int position = intent.getExtras().getInt("id");
       // AdapterImages adapterImages = new AdapterImages(this);
       // img.setImageResource(adapterImages.id[position]);
    }
}