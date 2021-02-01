package com.vinade_app.personaldevelopment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

import java.util.ArrayList;
import java.util.Collections;

import static android.R.layout.simple_spinner_dropdown_item;

public class MyAdapter extends BaseAdapter {
    Context context;
    int[] images;
    String text;
    GridView gridView;

    public MyAdapter(Context context, String text, int[] images) {
        this.context = context;
        this.images = images;
        this.text = text;
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
        AdapterImages imagess = new AdapterImages(images, gridView.getContext());
        gridView.setAdapter(imagess);

        onClickGridView();
        tvName.setText(text);



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
