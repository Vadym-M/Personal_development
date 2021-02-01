package com.vinade_app.personaldevelopment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class AdapterImages extends BaseAdapter {
    int[] id;
    Context context;

    public AdapterImages(int[] id, Context context) {
        this.id = id;
        this.context = context;
    }
    public AdapterImages(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return id.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return id[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       /* LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.image_item,parent, false);

        }

        */
        Log.d("debug","AdapterImages " + id);
        View view;
       // ImageView img = (ImageView) convertView.findViewById(R.id.imageView);
        ImageView img = new ImageView(context);
        img.setImageResource(id[position]);
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img.setLayoutParams(new ViewGroup.LayoutParams(340, 350));
        return img;
    }
}
