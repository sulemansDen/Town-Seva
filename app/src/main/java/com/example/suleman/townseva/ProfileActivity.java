package com.example.suleman.townseva;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {
EditText userName,oldPassword,newPassword,mobile;
            TextView email;
    SharedPreferences sharedPreferences;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Edit Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPreferences = getSharedPreferences(getResources().getString(R.string.pref_name), MODE_PRIVATE);
        userName = (EditText)findViewById(R.id.username);
        email = (TextView) findViewById(R.id.email);
        oldPassword = (EditText)findViewById(R.id.old_password);
        newPassword = (EditText)findViewById(R.id.new_password);
        mobile = (EditText) findViewById(R.id.mobile);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        userName.setText(sharedPreferences.getString(getResources().getString(R.string.pref_user_name_key), null));
        email.setText(sharedPreferences.getString(getResources().getString(R.string.pref_user_email_key), null));
        mobile.setText(sharedPreferences.getString(getResources().getString(R.string.pref_user_mobile_key), null));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(android.R.id.home == item.getItemId())
        {
            this.finish();

        }
        return super.onOptionsItemSelected(item);
    }
    public void addressSubmission() {

        final String user = userName.getText().toString();
        final String emailId = email.getText().toString();
        final String oldpass = oldPassword.getText().toString();
        final String newpass = newPassword.getText().toString();
        final String mobil = mobile.getText().toString();
        String UPDATE_URL = "http://townsewa.com/api/edituserapi.php?method=edituserdetails&user_id="+
                sharedPreferences.getString(getResources().getString(R.string.pref_user_id_key), null)+
                "&oldpassword="+oldpass+"&newpassword="+newpass+"&contact="+mobil+"&username="+user;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                UPDATE_URL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    String result = response.getString("result");
                    String message = response.getString("message");
                    Toast.makeText(ProfileActivity.this, message, Toast.LENGTH_SHORT).show();

                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

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


    public void update(View v) {
        showpDialog();
        addressSubmission();

    }


    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}

