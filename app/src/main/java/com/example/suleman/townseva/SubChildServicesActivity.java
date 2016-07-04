package com.example.suleman.townseva;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
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

public class SubChildServicesActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    GridView myGrid;

    // Progress dialog
    private ProgressDialog pDialog;

    ArrayList<SubChildItem> subChildItemArrayList;

    String arr[];

    String url = "http://townsewa.com/api/getsubchildservicesapi.php?method=getsubchildservices";

    private static String TAG = ServicesActivity.class.getSimpleName();

    String id, title;

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkConnection();
        setContentView(R.layout.sub_child_services_row);
        message = (TextView) findViewById(R.id.message);
        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        title = intent.getStringExtra("TITLE");
        setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.pref_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();

        url = "http://townsewa.com/api/getsubchildservicesapi.php?method=getsubchildservices&id=" + Integer.parseInt(id);
        myGrid = (GridView) findViewById(R.id.gridview);
//        adapter = new ServicesAdapter(ServicesActivity.this, getResources().getStringArray(R.array.servicesName), getResources().getStringArray(R.array.description));


        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        getGridData();

        arr = getResources().getStringArray(R.array.servicesName);
        myGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(SubChildServicesActivity.this, arr[position], Toast.LENGTH_SHORT).show();
                if(MainActivity.connectionCheck) {
                    Intent i = new Intent(SubChildServicesActivity.this, AddressActivity.class);
                    editor.putString(getResources().getString(R.string.pref_sub_child_services_id_key), subChildItemArrayList.get(position).getId());
                    editor.commit();
                    startActivity(i);
                }
                else {
                    showSnack(MainActivity.connectionCheck);
                }
            }


        });

    }

    public void getGridData() {
        subChildItemArrayList = new ArrayList<SubChildItem>();

        showpDialog();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
//                    Toast.makeText(MainActivity.this,response.toString() , Toast.LENGTH_SHORT).show();
                    String mess = response.getString("message");
                    //         String mess = "<html> <head> <title></title> </head> <body> <h3>Rate list</h3> <ul> <li>Window AC at Rs:690/AC</li> <li>Split AC at Rs: 1850/AC</li> </ul> <h3>What's included?</h3> <ul> <li>Includes labour charges only</li> <li>Any parts that requires replacement will be extra</li> <li>Minimum visiting charges are Rs.199 </li> </ul> </body> </html>";


                    message.setText(Html.fromHtml(mess));
                    subChildItemArrayList = new ArrayList<SubChildItem>();

                    JSONArray jsonArray = response.getJSONArray("subchildservices");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        SubChildItem subChildItem = new SubChildItem();
                        subChildItem.setId(jsonObject.getString("id"));
                        subChildItem.setServiceChildName(jsonObject.getString("sub_child_category_name"));
                        subChildItem.setImgLink(jsonObject.getString("imgurl"));

                        subChildItemArrayList.add(subChildItem);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
                myGrid.setAdapter(new SubChildServicesAdapter(SubChildServicesActivity.this, subChildItemArrayList));
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

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
        MainActivity.connectionCheck = isConnected;
        if (MainActivity.connectionCheck) {
            getGridData();
        }
    }

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
                .make(findViewById(R.id.lin_layout), message, Snackbar.LENGTH_LONG);


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
