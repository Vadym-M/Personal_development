package com.vinade_app.personaldevelopment;

import java.util.ArrayList;

public class Card {
    ArrayList<String>imageName;
    String idCard, text;

    public Card(ArrayList<String> imageName, String idCard, String text) {
        this.imageName = imageName;
        this.idCard = idCard;
        this.text = text;
    }

    public ArrayList<String> getImageName() {
        return imageName;
    }

    public void setImageName(ArrayList<String> imageName) {
        this.imageName = imageName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
