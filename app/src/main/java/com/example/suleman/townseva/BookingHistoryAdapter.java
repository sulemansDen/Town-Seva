package com.example.suleman.townseva;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by suleman on 1/7/16.
 */
public class BookingHistoryAdapter extends BaseAdapter{

    ArrayList<BookingHistoryItem> bookingHistoryItemArrayList = new ArrayList<BookingHistoryItem>();

    private static LayoutInflater inflater = null;

    Context context;

    public BookingHistoryAdapter(Context context, ArrayList<BookingHistoryItem> bookingHistoryItemArrayList)
    {

        this.context = context;
        this.bookingHistoryItemArrayList = bookingHistoryItemArrayList;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return bookingHistoryItemArrayList.size();
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
        if (convertView == null) {
            vi = inflater.inflate(R.layout.booking_row, null);

            viewHolder = new ViewHolder();
            viewHolder.orderId = (TextView) vi.findViewById(R.id.order_id);
            viewHolder.serviceName = (TextView) vi.findViewById(R.id.service_name);
            viewHolder.subCategoryName = (TextView) vi.findViewById(R.id.sub_cat_name);
            viewHolder.requestedItem = (TextView) vi.findViewById(R.id.requested_item);
            viewHolder.status = (TextView) vi.findViewById(R.id.status);
            vi.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) vi.getTag();


        viewHolder.orderId.setText(bookingHistoryItemArrayList.get(position).getOrderId());
        viewHolder.serviceName.setText(bookingHistoryItemArrayList.get(position).getServiceName());
        viewHolder.subCategoryName.setText(bookingHistoryItemArrayList.get(position).getSubCategoryName());
        viewHolder.requestedItem.setText(bookingHistoryItemArrayList.get(position).getSubChildCategoryName());
        viewHolder.status.setText(bookingHistoryItemArrayList.get(position).getStatus());

        return vi;
    }

    /*********
     * Create a holder Class to contain inflated xml file elements
     *********/
    public static class ViewHolder {

        public TextView orderId;
        public TextView serviceName;
        public TextView subCategoryName;
        public TextView requestedItem;
        public TextView status;
    }


}


