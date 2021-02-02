package com.vinade_app.personaldevelopment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AdapterImages extends BaseAdapter {
    ArrayList<Bitmap> cards;
    Context context;


    public AdapterImages(ArrayList<Bitmap> cards, Context context) {
        this.cards = cards;
        this.context = context;
    }
    public AdapterImages(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return cards.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {


        ImageView img = new ImageView(context);
        img.setImageBitmap(cards.get(position));
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img.setLayoutParams(new ViewGroup.LayoutParams(340, 350));


        Log.d("debug", "Second ");
        return img;
    }
    void getImg()
    {


    }
}
