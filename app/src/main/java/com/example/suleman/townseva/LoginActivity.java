package com.example.suleman.townseva;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, ConnectivityReceiver.ConnectivityReceiverListener {


    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    private String username;
    private String password;


    private ProgressDialog progressBar;

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        editTextUsername = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);
        buttonLogin = (Button) findViewById(R.id.email_sign_in_button);

        checkConnection();

        editTextUsername.clearFocus();
        editTextPassword.clearFocus();
        sharedPreferences = getSharedPreferences(getResources().getString(R.string.pref_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();

        buttonLogin.setOnClickListener(this);
    }


    private void userLogin() {
        username = editTextUsername.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();
        String LOGIN_URL = "http://townsewa.com/api/loginapi.php?method=login&email=" + username + "&password=" + password;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                LOGIN_URL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("LoginActivity", response.toString());

                try {
                    int result = response.getInt("result");
                    String message = response.getString("message");


                    progressBar.dismiss();
                    if (result == 0) {
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                    } else {
                        progressBar.dismiss();
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                        JSONObject jsonObject = response.getJSONObject("user_details");
                        String id = jsonObject.getString("id");
                        String userName = jsonObject.getString("username");
                        String mobileNumber = jsonObject.getString("Phone_number");

                        editor.putString(getResources().getString(R.string.pref_user_name_key), userName);
                        editor.putString(getResources().getString(R.string.pref_user_email_key), username);
                        editor.putString(getResources().getString(R.string.pref_user_password_key), password);
                        editor.putString(getResources().getString(R.string.pref_user_id_key), id);
                        editor.putString(getResources().getString(R.string.pref_user_mobile_key), mobileNumber);
                        editor.commit();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
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
                        Toast.makeText(LoginActivity.this, "Email or Password Is Not Valid", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(KEY_USERNAME, username);
                map.put(KEY_PASSWORD, password);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
    }

    private void openProfile() {
        progressBar.dismiss();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        progressBar = new ProgressDialog(v.getContext());
        progressBar.setCancelable(false);
        progressBar.setMessage("Loading Please Wait");
        if (validate()) {
            if(MainActivity.connectionCheck){
                progressBar.show();
                userLogin();
            }

           else
                showSnack(MainActivity.connectionCheck);

        }
    }

    /* goto particular activity */
    public void gotoActivity(View v) {
        Intent i = null;
        if (MainActivity.connectionCheck) {
                i = new Intent(this, RegisterActivity.class);
            finish();
            startActivity(i);
        } else {
            showSnack(MainActivity.connectionCheck);

        }
    }

    public boolean validate() {
        boolean cancel = false;
        View focusView = null;
        if (TextUtils.isEmpty(editTextUsername.getText().toString()) || (!android.util.Patterns.EMAIL_ADDRESS.matcher(editTextUsername.getText().toString()).matches())) {
            progressBar.dismiss();
            editTextUsername.setError("Enter A Valid Email");
            focusView = editTextUsername;
            cancel = true;
            focusView.requestFocus();
        } else if (TextUtils.isEmpty(editTextPassword.getText().toString())) {
            progressBar.dismiss();
            editTextPassword.setError("Enter A Valid Password");
            focusView = editTextPassword;
            cancel = true;
            focusView.requestFocus();
        }
        return !cancel;
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
        MainActivity.connectionCheck = isConnected;
        if (MainActivity.connectionCheck) {
          //  userLogin();
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
                .make(findViewById(R.id.lin_login), message, Snackbar.LENGTH_LONG);


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



