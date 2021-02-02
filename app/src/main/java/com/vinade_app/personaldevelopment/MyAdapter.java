package com.vinade_app.personaldevelopment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static android.R.layout.simple_spinner_dropdown_item;

public class MyAdapter extends BaseAdapter {
    Context context;
    GridView gridView;
    ArrayList<Card> cards;
    ArrayList<Bitmap> images = new ArrayList<>();
    FirebaseStorage storage = FirebaseStorage.getInstance();

    public MyAdapter(Context context, ArrayList<Card> cards) {
        this.context = context;
       this.cards = cards;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.card_template,parent, false);
        }
        gridView = (GridView) convertView.findViewById(R.id.gridView);
        TextView tvName = (TextView) convertView.findViewById(R.id.textView);


        onClickGridView();
        tvName.setText(cards.get(position).getText());
        ImageView img = new ImageView(context);
        for(int i = 0; i<cards.get(position).getImageName().size(); i++) {
            StorageReference rootRef = storage.getReference().child(cards.get(position).imageName.get(i));
            Log.d("debug", "Listener cardsName: " + cards.get(position));
            try {
                File localFile = File.createTempFile("images", "jpg");
                rootRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        Log.d("debug", "First ");
                        images.add(BitmapFactory.decodeFile(localFile.getAbsolutePath()));
                        AdapterImages imagess = new AdapterImages(images, gridView.getContext());
                        gridView.setAdapter(imagess);

                        //mImageView.setImageBitmap(bitmap);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                    }
                });
            } catch (IOException e) {
            }
        }


        return convertView;
    }
 void onClickGridView(){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, FullScreenActivity.class);
                intent.putExtra("id", position);
                context.startActivity(intent);

            }
        });
 }
}
