package com.example.suleman.townseva;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

class VivzAdapter extends BaseAdapter {
    ArrayList<ServiceItem> list;
    Context context;

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    VivzAdapter(Context context, ArrayList<ServiceItem> list) {
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

        TextView text;
        NetworkImageView imageView;

        ViewHolder(View v) {
            text = (TextView) v.findViewById(R.id.text);
            imageView = (NetworkImageView) v.findViewById(R.id.imageView);
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = null;

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_item, viewGroup, false);
            holder = new ViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        holder.text.setText(list.get(i).getServiceName());

        // thumbnail image
        holder.imageView.setImageUrl(list.get(i).getImagLink(), imageLoader);


//        holder.myColor.setImageResource(list.get(i).getImageId());
//        holder.text.setText(list.get(i).getCountryName());
        return row;

    }
}