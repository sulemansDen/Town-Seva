package com.example.suleman.townseva;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.TwirlEffect;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BookingActivity extends AppCompatActivity {
    JazzyListView listView;
    private ProgressDialog pDialog;
    ArrayList<BookingHistoryItem> bookingHistoryItemArrayList;
    String arr[];
    private static String TAG = ServicesActivity.class.getSimpleName();
    String id;
    String title;
    TextView headerText, noBooking;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        setTitle("Booking History");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPreferences = getSharedPreferences(getResources().getString(R.string.pref_name), MODE_PRIVATE);
        headerText = (TextView) findViewById(R.id.header_text);
        noBooking = (TextView) findViewById(R.id.no_history);
        listView = (JazzyListView) findViewById(R.id.list_view);
        listView.setTransitionEffect(new TwirlEffect());
        String header = sharedPreferences.getString(getResources().getString(R.string.pref_user_name_key), null);
        headerText.setText("Hii " + header + ", Your Booking History");
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        getSubServices();
        arr = getResources().getStringArray(R.array.servicesName);
    }

    public void getSubServices() {

        showpDialog();
        String BOOKING_URL = "http://townsewa.com/api/getorderapi.php?method=getorderhistory&user_id="
                + sharedPreferences.getString(getResources().getString(R.string.pref_user_id_key), null);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                BOOKING_URL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {

                    bookingHistoryItemArrayList = new ArrayList<BookingHistoryItem>();

                    JSONArray jsonArray = response.getJSONArray("order_details");
                    if (jsonArray.length() != 0) {
                        noBooking.setVisibility(View.GONE);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            BookingHistoryItem bookingHistoryItem = new BookingHistoryItem();
                            bookingHistoryItem.setOrderId(jsonObject.getString("order_id"));
                            bookingHistoryItem.setServiceName(jsonObject.getString("service_name"));
                            bookingHistoryItem.setSubCategoryName(jsonObject.getString("sub_category_name"));
                            bookingHistoryItem.setSubChildCategoryName(jsonObject.getString("sub_child_category_name"));
                            bookingHistoryItemArrayList.add(bookingHistoryItem);
                        }
                    }
                    else
                    {
                        noBooking.setVisibility(View.VISIBLE);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
                listView.setAdapter(new BookingHistoryAdapter(BookingActivity.this, bookingHistoryItemArrayList));
                hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);

    }


    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            this.finish();

        }
        return super.onOptionsItemSelected(item);
    }


}
