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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    ImageView mImageView;
    StorageReference storageRef;
    DatabaseReference dbRef;
    boolean run = true;
    ArrayList<Card> cards;
    int[] images = {R.drawable.b,  R.drawable.a, R.drawable.c, R.drawable.index};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.imageView2);
        Log.d("debug","1");
        InitFirebaseData();


        /*
        ArrayList<String> test = new ArrayList<String>();
        test.add("image1.jpg");
        test.add("image2.jpg");
        Card card1 = new Card(test, "30", "Hello World");
        Card card2 = new Card(test, "30", "Hello World2");
        // DATABASE
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();
        ref.child("Cards").child("Card").setValue(card1);
        ref.child("Cards").child("Card2").setValue(card2);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            Card card = snapshot.child("Cards").child("Card2").getValue(Card.class);
            Log.d("debug", "Parsed data : " + card.getImageName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////
         */
        //DATABASE STORAGE EXAMPLE
        /*FirebaseStorage storage = FirebaseStorage.getInstance();
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

         */

        Init();
        InitDatabaseStorage();
        getAllCards();


    }



    void Init()
    {
        listView = findViewById(R.id.listView);
    }
    void InitDatabaseStorage()
    {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
    }
    void InitFirebaseData()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        dbRef = database.getReference();
    }
    void InitAdapter()
    {
        MyAdapter myAdapter = new MyAdapter(this, cards);
        listView.setAdapter(myAdapter);

    }

    void getAllCards()
    {
                dbRef.child("Cards").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                       cards = new ArrayList<>();
                        for(DataSnapshot ds: snapshot.getChildren()){

                            if(ds.getValue() != null)
                            {
                                cards.add(ds.getValue(Card.class));
                                //Log.d("debug","Find files called: " + ds.getValue(Card.class));
                            }else
                            {
                               // Log.d("debug","can't find a Card with the name:" );
                            }
                        }
                        InitAdapter();



                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }


    }




