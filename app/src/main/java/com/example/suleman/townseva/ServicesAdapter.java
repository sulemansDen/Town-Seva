package com.example.suleman.townseva;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by suleman on 27/6/16.
 */
public class ServicesAdapter extends BaseAdapter {

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    Context context;
    ArrayList<SubServicesItem> subServicesItemArrayList = new ArrayList<SubServicesItem>();
    private static LayoutInflater inflater = null;
    public ServicesAdapter(Context context, ArrayList<SubServicesItem> subServicesItemArrayList) {
        this.context = context;
        this.subServicesItemArrayList = subServicesItemArrayList;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return subServicesItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder viewHolder;
        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        if (convertView == null) {
            vi = inflater.inflate(R.layout.services_row, null);

            viewHolder = new ViewHolder();
            viewHolder.txtUpper = (TextView) vi.findViewById(R.id.txt);
            viewHolder.txtLower = (TextView) vi.findViewById(R.id.txt1);
            viewHolder.image = (NetworkImageView) vi.findViewById(R.id.img);

            vi.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) vi.getTag();


        viewHolder.txtUpper.setText(subServicesItemArrayList.get(position).getSubCategoryName());
        viewHolder.txtLower.setText(subServicesItemArrayList.get(position).getDescription());
        viewHolder.image.setImageUrl(subServicesItemArrayList.get(position).getImgUrl(),imageLoader);

        return vi;
    }

    /*********
     * Create a holder Class to contain inflated xml file elements
     *********/
    public static class ViewHolder {

        public TextView txtUpper;
        public TextView txtLower;
        public NetworkImageView image;

    }


}
