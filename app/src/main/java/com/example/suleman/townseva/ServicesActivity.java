package com.example.suleman.townseva;

/**
 * Created by suleman on 27/6/16.
 */

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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

public class ServicesActivity extends AppCompatActivity  implements ConnectivityReceiver.ConnectivityReceiverListener{

    JazzyListView listView;
    private ProgressDialog pDialog;
    ArrayList<SubServicesItem> subServicesItemArrayList;
    String arr[];
    String url = "http://townsewa.com/api/getsubservicesapi.php?method=getsubservices";
    private static String TAG = ServicesActivity.class.getSimpleName();
    String id;
    String title;

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        title = intent.getStringExtra("TITLE");
        setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.pref_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();

        url = "http://townsewa.com/api/getsubservicesapi.php?method=getsubservices&id=" + Integer.parseInt(id);

        // Manually checking internet connection
        checkConnection();

        listView = (JazzyListView) findViewById(R.id.list_view);
        listView.setTransitionEffect(new TwirlEffect());

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        getSubServices();

        arr = getResources().getStringArray(R.array.servicesName);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Toast.makeText(ServicesActivity.this, arr[position], Toast.LENGTH_SHORT).show();
                  if(MainActivity.connectionCheck) {
                      Intent intent = new Intent(ServicesActivity.this, SubChildServicesActivity.class);
                      intent.putExtra("ID", subServicesItemArrayList.get(position).getId());
                      editor.putString(getResources().getString(R.string.pref_sub_services_id_key), subServicesItemArrayList.get(position).getId());
                      editor.commit();
                      intent.putExtra("TITLE", subServicesItemArrayList.get(position).getSubCategoryName());
                      startActivity(intent);
                  }else
                      showSnack(MainActivity.connectionCheck);
                }
        });


    }


    public void getSubServices() {

        if(MainActivity.connectionCheck) {

            showpDialog();

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                    url, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    Log.d(TAG, response.toString());

                    try {
//                    Toast.makeText(MainActivity.this,response.toString() , Toast.LENGTH_SHORT).show();

                        subServicesItemArrayList = new ArrayList<SubServicesItem>();

                        JSONArray jsonArray = response.getJSONArray("subservices");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            SubServicesItem subServicesItem = new SubServicesItem();
                            subServicesItem.setId(jsonObject.getString("id"));
                            subServicesItem.setSubCategoryName(jsonObject.getString("sub_category_name"));
                            subServicesItem.setDescription(jsonObject.getString("description"));
                            subServicesItem.setImgUrl(jsonObject.getString("imgurl"));
                            subServicesItemArrayList.add(subServicesItem);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),
                                "Error: " + e.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                    listView.setAdapter(new ServicesAdapter(ServicesActivity.this, subServicesItemArrayList));
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
        else
            showSnack(MainActivity.connectionCheck);
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

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

        showSnack(isConnected);
        MainActivity.connectionCheck = isConnected;
        if (MainActivity.connectionCheck) {
            getSubServices();
        }
    }

    // Showing the status in Snackbar
    private void showSnack(boolean isConnected) {
        String message;
        int color;
        if (isConnected) {
            message = "Good! Connected to Internet";
            color = Color.WHITE;
        } else {
            message = "Sorry! Not connected to internet";
            color = Color.RED;
        }

        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.rel_service), message, Snackbar.LENGTH_LONG);


//        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();
    }

    private void checkConnection() {
//        boolean isConnected = ConnectivityReceiver.isConnected();
//        showSnack(isConnected);
        MainActivity.connectionCheck = ConnectivityReceiver.isConnected();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // register connection status listener
        AppController.getInstance().setConnectivityListener(this);
    }
}