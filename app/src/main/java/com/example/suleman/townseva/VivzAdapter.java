package com.example.suleman.townseva;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class VivzAdapter extends BaseAdapter {
    ArrayList<ColorItem> list;
    Context context;

    VivzAdapter(Context context, ArrayList<ColorItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ViewHolder {
        ImageView myColor;
        TextView text;

        ViewHolder(View v) {
            myColor = (ImageView) v.findViewById(R.id.imageView);
            text = (TextView) v.findViewById(R.id.text);
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_item, viewGroup, false);
            holder = new ViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        holder.myColor.setImageResource(list.get(i).getImageId());
        holder.text.setText(list.get(i).getCountryName());
        return row;


    }
}