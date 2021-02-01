package com.vinade_app.personaldevelopment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    ImageView mImageView;
    ArrayList<Image> testList =  new ArrayList<Image>();
    int[] images = {R.drawable.b,  R.drawable.a, R.drawable.c, R.drawable.index};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.imageView2);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("image1");
        
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference rootRef = storage.getReference().child("test1.jpg");
        try{
            File localFile = File.createTempFile("images", "jpg");
        rootRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                mImageView.setImageBitmap(bitmap);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
            }
        });
    } catch (IOException e ) {}
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