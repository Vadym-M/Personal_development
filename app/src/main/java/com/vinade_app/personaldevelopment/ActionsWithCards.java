package com.vinade_app.personaldevelopment;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class ActionsWithCards {
    DatabaseReference dbRef;
    Card Card;
    ArrayList<Card> cards = new ArrayList<Card>();

    public ActionsWithCards(DatabaseReference dbRef) {

        this.dbRef = dbRef;
    }

    public ArrayList<com.vinade_app.personaldevelopment.Card> getAllCards() {
        dbRef.child("Cards").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){

                    if(ds.getValue() != null)
                    {
                        cards.add(ds.getValue(Card.class));
                        Log.d("debug","Find files called: " + ds.getValue(Card.class));
                    }else
                    {
                       Log.d("debug","can't find a Card with the name:" );
                    }
                }
               Log.d("debug","Find files called: " + cards.get(1).getText());
                }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return cards;
    }

    public Card getCardByName(String cardName) {
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.child("Cards").child(cardName).getValue(Card.class) != null)
                {
                    Card card  = snapshot.child("Cards").child(cardName).getValue(Card.class);
                    Card = card;
                }else
                {
                    Log.d("debug","can't find a Card with the name:" + cardName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return Card;
    }

}
