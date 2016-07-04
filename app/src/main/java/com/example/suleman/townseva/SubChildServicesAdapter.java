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
 * Created by suleman on 29/6/16.
 */

class SubChildServicesAdapter extends BaseAdapter {
    ArrayList<SubChildItem> list;
    Context context;

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    SubChildServicesAdapter(Context context, ArrayList<SubChildItem> list) {
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

        holder.text.setText(list.get(i).getServiceChildName());


        holder.imageView.setImageUrl(list.get(i).getImgLink(), imageLoader);


        return row;

    }
}


//public class SubChildServicesAdapter extends BaseAdapter {
//    Context context;
//    ArrayList<SubChildItem> subServicesItemArrayList = new ArrayList<SubChildItem>();
//    private static LayoutInflater inflater=null;
//
//
//    public SubChildServicesAdapter(Context context, ArrayList<SubChildItem> subServicesItemArrayList)
//    {
//        this.context =context;
//        this.subServicesItemArrayList = subServicesItemArrayList;
//
//        /***********  Layout inflator to call external xml layout () ***********/
//        inflater = ( LayoutInflater )context.
//                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//    }
//
//
//    @Override
//    public int getCount() {
//        return subServicesItemArrayList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return position;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        View vi = convertView;
//        ViewHolder viewHolder;
//
//        if(convertView == null)
//        {
//            vi = inflater.inflate(R.layout.services_row, null);
//
//            viewHolder = new ViewHolder();
//            viewHolder.txtUpper = (TextView)  vi.findViewById(R.id.txt);
//            viewHolder.txtLower= (TextView)  vi.findViewById(R.id.txt1);
//            vi.setTag( viewHolder );
//        }
//        else
//            viewHolder = (ViewHolder)vi.getTag();
//
//
//        viewHolder.txtUpper.setText(subServicesItemArrayList.get(position).getServiceChildName());
//        viewHolder.txtLower.setText(subServicesItemArrayList.get(position).getRate());
//
//        return vi;
//    }
//
//    /********* Create a holder Class to contain inflated xml file elements *********/
//    public static class ViewHolder{
//
//        public TextView txtUpper;
//        public TextView txtLower;
//
//    }
//
//
//}
//