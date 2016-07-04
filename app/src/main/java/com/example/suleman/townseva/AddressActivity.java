package com.example.suleman.townseva;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AddressActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {
    private EditText flatNumber;
    private EditText apartment;
    private EditText locality;
    private EditText pinCode;
    private String message;
    SharedPreferences sharedPreferences;
    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        getSupportActionBar().setTitle("Enter Address");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPreferences = getSharedPreferences(getResources().getString(R.string.pref_name), MODE_PRIVATE);
        checkConnection();
        flatNumber = (EditText) findViewById(R.id.flat_number);
        apartment = (EditText) findViewById(R.id.apartment);
        locality = (EditText) findViewById(R.id.locality);
        pinCode = (EditText) findViewById(R.id.pin_code);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            this.finish();

        }
        return super.onOptionsItemSelected(item);
    }

    public void addressSubmission() {

        showpDialog();
        final String flat = flatNumber.getText().toString();
        final String apart = apartment.getText().toString();
        final String location = locality.getText().toString();
        final String pinC = pinCode.getText().toString();
        final String address = flat + "%20" + apart + "%20" + location + "%20" + pinC;
        String ADDRESS_URL = "http://townsewa.com/api/insertaddressapi.php?" +
                "method=getaddress&user_id=" + sharedPreferences.getString(getResources().getString(R.string.pref_user_id_key), null) +
                "&sub_child_id=" + sharedPreferences.getString(getResources().getString(R.string.pref_sub_child_services_id_key), null) +
                "&sub_id=" + sharedPreferences.getString(getResources().getString(R.string.pref_sub_services_id_key), null) +
                "&main_id=" + sharedPreferences.getString(getResources().getString(R.string.pref_services_id_key), null) +
                "&service_address=" + address;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                ADDRESS_URL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    message = response.getString("message");
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                //  Toast.makeText(AddressActivity.this,response.toString() , Toast.LENGTH_SHORT).show();
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(AddressActivity.this);
                alertDialog.setTitle("Message");
                alertDialog.setMessage(message);
                alertDialog.setIcon(R.mipmap.app_icon);
                alertDialog.setCancelable(false);


                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(AddressActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(AddressActivity.this, MainActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                        finish();
                    }
                });


                AlertDialog alert = alertDialog.create();
                alert.show();


                hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);

    }


    public void submit(View v) {
        if (validation()) {
            if (MainActivity.connectionCheck) {
                if (sharedPreferences.getString(getResources().getString(R.string.pref_user_id_key), null) == null) {
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(AddressActivity.this);
                    alertDialog.setTitle("Message");
                    alertDialog.setMessage("Please Log In To Proceed Further");
                    alertDialog.setIcon(R.mipmap.app_icon);
                    alertDialog.setCancelable(false);


                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Toast.makeText(AddressActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AddressActivity.this, LoginActivity.class);
                            //i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                    });
                    alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Toast.makeText(AddressActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                            //Intent intent = new Intent(AddressActivity.this, AddressActivity.class);
                            //i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            //startActivity(intent);
                            //finish();
                        }
                    });
                    AlertDialog alert = alertDialog.create();
                    alert.show();
                } else {
                    addressSubmission();
                }
            } else {
                showSnack(MainActivity.connectionCheck);
            }
        }

    }

    public boolean validation() {

        boolean cancel = false;
        View focusView = null;
        if (TextUtils.isEmpty(flatNumber.getText().toString())) {
            flatNumber.setError("This Field Is Required");
            focusView = flatNumber;
            cancel = true;
            focusView.requestFocus();
        } else if (TextUtils.isEmpty(apartment.getText().toString())) {
            apartment.setError("This Field Is Required");
            focusView = apartment;
            cancel = true;
            focusView.requestFocus();
        } else if (TextUtils.isEmpty(locality.getText().toString())) {
            locality.setError("This Field Is Required");
            focusView = locality;
            cancel = true;
            focusView.requestFocus();
        } else {
            if (TextUtils.isEmpty(pinCode.getText().toString())) {
                pinCode.setError("This Field Is Required");
                focusView = pinCode;
                cancel = true;
                focusView.requestFocus();
            }
        }
        return !cancel;
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
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
        MainActivity.connectionCheck = isConnected;
        if (MainActivity.connectionCheck) {
            //
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
                .make(findViewById(R.id.activity_ac__installation), message, Snackbar.LENGTH_LONG);


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
