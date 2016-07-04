package com.example.suleman.townseva;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, ConnectivityReceiver.ConnectivityReceiverListener {


    public static final String KEY_USERNAME = "Username";
    public static final String KEY_EMAIL = "Email";
    public static final String KEY_PASSWORD = "Password";
    public static final String KEY_MOBILE = "Mobile";

    private AutoCompleteTextView Username;
    private AutoCompleteTextView Email;
    private AutoCompleteTextView Password;
    private AutoCompleteTextView cpass;
    private AutoCompleteTextView Mobile;
    private Button buttonRegister;

    private ProgressDialog progressBar;
    private Handler progressBarbHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Username = (AutoCompleteTextView) findViewById(R.id.username);
        Email = (AutoCompleteTextView) findViewById(R.id.email);
        Password = (AutoCompleteTextView) findViewById(R.id.password);
        cpass = (AutoCompleteTextView) findViewById(R.id.cpass);
        Mobile = (AutoCompleteTextView) findViewById(R.id.mobile);
        buttonRegister = (Button) findViewById(R.id.register);
        buttonRegister.setOnClickListener(this);
    }

    private void registerUser() {
        final String username = Username.getText().toString().trim();
        final String email = Email.getText().toString().trim();
        final String password = Password.getText().toString().trim();
        final String mobile = Mobile.getText().toString().trim();
        String REGISTER_URL = "http://townsewa.com/api/insertuserapi.php?method=insertuser&contact=" +
                mobile + "&name=" + username + "&email=" + email + "&password=" + password;

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                REGISTER_URL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("RegisterActivity", response.toString());

                try {
                    int result = response.getInt("result");
                    String message = response.getString("message");

                    progressBar.dismiss();
                    if (result == 0) {
                        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        finish();
                        startActivity(intent);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "User exists", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME, username);
                params.put(KEY_PASSWORD, password);
                params.put(KEY_EMAIL, email);
                params.put(KEY_MOBILE, mobile);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonRegister) {
            progressBar = new ProgressDialog(v.getContext());
            progressBar.setCancelable(false);
            progressBar.setMessage("Loading Please Wait");
            progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            if (validation()) {
                if(MainActivity.connectionCheck) {
                    progressBar.show();
                    registerUser();
                }
                else
                {
                    showSnack(MainActivity.connectionCheck);
                }
            }
        }
    }

    public void Guest(View v) {
        if(MainActivity.connectionCheck) {
            Intent i = new Intent(this, LoginActivity.class);
            this.finish();
            startActivity(i);
        }
        else
        {
            showSnack(MainActivity.connectionCheck);
        }
    }

    public boolean validation() {

        boolean cancel = false;
        View focusView = null;
        if (TextUtils.isEmpty(Username.getText().toString())) {

            Username.setError("This Field Is Required");
            focusView = Username;
            cancel = true;
            focusView.requestFocus();
        } else if (TextUtils.isEmpty(Email.getText().toString()) || (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email.getText().toString()).matches())) {

            Email.setError("Email Address Is Not Valid");
            focusView = Email;
            cancel = true;
            focusView.requestFocus();
        } else if (TextUtils.isEmpty(Password.getText().toString())) {

            Password.setError("This Field Is Required");
            focusView = Password;
            cancel = true;
            focusView.requestFocus();
        } else if (!Password.getText().toString().trim().equals(cpass.getText().toString().trim())) {

            cpass.setError("Password Doesn't Match");
            cancel = true;
            cpass.requestFocus();
        } else {
            if (TextUtils.isEmpty(Mobile.getText().toString())) {

                Mobile.setError("This Field Is Required");
                focusView = Mobile;
                cancel = true;
                focusView.requestFocus();
            }
        }
        return !cancel;
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
        MainActivity.connectionCheck = isConnected;
        if (MainActivity.connectionCheck) {
           // registerUser();
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
                .make(findViewById(R.id.lin_register), message, Snackbar.LENGTH_LONG);


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

