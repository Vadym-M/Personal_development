package com.vinade_app.personaldevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Image> testList =  new ArrayList<Image>();
    int[] images = {R.drawable.b,  R.drawable.a, R.drawable.c, R.drawable.index};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("debug","Main act" + images[0]);
       
    Init();
    MyAdapter myAdapter = new MyAdapter(this, "Test" ,images);
    listView.setAdapter(myAdapter);
    }
    void Init()
    {
        listView = findViewById(R.id.listView);
    }

}