package com.example.suleman.townseva;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener, ConnectivityReceiver.ConnectivityReceiverListener {
    NavigationView navigationView = null;
    Toolbar toolbar = null;
    Menu nav_Menu;
    private LinearLayout mDotsLayout;
    private int mDotsCount;
    static TextView mDotsText[];
    private int mPosition = 0;
    SharedPreferences sharedPreferences;
    public static boolean connectionCheck;
    SharedPreferences.Editor editor;

    private SliderLayout mDemoSlider;

    ArrayList<ServiceItem> serviceItemArrayList;

    private static String TAG = MainActivity.class.getSimpleName();
    GridView myGrid;
    FloatingActionButton fab;
    DrawerLayout drawer;
    TextView email, userName;
    // Progress dialog
    private ProgressDialog pDialog;

    String url = "http://townsewa.com/api/getservicesapi.php?method=getservices";

    View header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        nav_Menu = navigationView.getMenu();
        View header = navigationView.getHeaderView(0);
        userName = (TextView) header.findViewById(R.id.user_name);
        email = (TextView) header.findViewById(R.id.email_id);

      //  fab = (FloatingActionButton) findViewById(R.id.fab);
        myGrid = (GridView) findViewById(R.id.gridview);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);


        // Manually checking internet connection
        checkConnection();

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.pref_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();


        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        checkLogin();
        getGridData();

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Kitchen Accessories", R.drawable.second);
        file_maps.put("Monsoon Offers", R.drawable.first);
        file_maps.put("Appliances", R.drawable.third);
        file_maps.put("Kitchen Ware", R.drawable.fourth);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


        myGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (connectionCheck) {
                    Intent intent = new Intent(MainActivity.this, ServicesActivity.class);
                    editor.putString(getResources().getString(R.string.pref_services_id_key), serviceItemArrayList.get(position).getId());
                    editor.commit();
                    intent.putExtra("ID", serviceItemArrayList.get(position).getId());
                    intent.putExtra("TITLE", serviceItemArrayList.get(position).getServiceName());
                    startActivity(intent);
                }
                else
                    showSnack(connectionCheck);
            }

        });


//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


    }

    private void checkLogin() {
        if (sharedPreferences.getString(getResources().getString(R.string.pref_user_id_key), null) != null) {
            nav_Menu.findItem(R.id.log_out).setVisible(true);
            nav_Menu.findItem(R.id.log_in).setVisible(false);
            nav_Menu.findItem(R.id.my_profile).setVisible(true);
            nav_Menu.findItem(R.id.booking_history).setVisible(true);
            userName.setText(sharedPreferences.getString(getResources().getString(R.string.pref_user_name_key), "Hello"));
            email.setText(sharedPreferences.getString(getResources().getString(R.string.pref_user_email_key), "example@abc.com"));
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        if (connectionCheck) {
        int id = item.getItemId();

        Intent i = null;
        if (id == R.id.log_in) {
            i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
        } else if (id == R.id.log_out) {
            editor.clear();
            editor.commit();
            Toast.makeText(MainActivity.this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();
            nav_Menu.findItem(R.id.log_out).setVisible(false);
            nav_Menu.findItem(R.id.log_in).setVisible(true);
            nav_Menu.findItem(R.id.my_profile).setVisible(false);
            nav_Menu.findItem(R.id.booking_history).setVisible(false);
            userName.setText("Hello Guest");
            email.setText("Please Sign-In/ Register");


        }
        else if (id == R.id.aboutus) {
            i = new Intent(MainActivity.this, AboutUs.class);
            startActivity(i);
        }
        else if (id == R.id.my_profile) {
            i = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_invite) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        } else if (id == R.id.booking_history) {
            i = new Intent(MainActivity.this, BookingActivity.class);
            startActivity(i);
        }
        else if (id == R.id.faq) {
            i = new Intent(MainActivity.this, FAQ.class);
            startActivity(i);
        }


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            showSnack(connectionCheck);

        }

        return true;
    }

    public void getGridData() {
        if (connectionCheck) {

            serviceItemArrayList = new ArrayList<ServiceItem>();

            showpDialog();

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                    url, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    Log.d(TAG, response.toString());

                    try {
//                    Toast.makeText(MainActivity.this,response.toString() , Toast.LENGTH_SHORT).show();

                        serviceItemArrayList = new ArrayList<ServiceItem>();

                        JSONArray jsonArray = response.getJSONArray("services");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            ServiceItem serviceItem = new ServiceItem();
                            serviceItem.setId(jsonObject.getString("id"));
                            serviceItem.setServiceName(jsonObject.getString("name"));
                            serviceItem.setImagLink(jsonObject.getString("imageurl"));
                            serviceItemArrayList.add(serviceItem);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),
                                "Error: " + e.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                    myGrid.setAdapter(new VivzAdapter(MainActivity.this, serviceItemArrayList));
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

        } else showSnack(connectionCheck);
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
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

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
                .make(findViewById(R.id.drawer_layout), message, Snackbar.LENGTH_LONG);


//        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();
    }

    private void checkConnection() {
//        boolean isConnected = ConnectivityReceiver.isConnected();
//        showSnack(isConnected);
        connectionCheck = ConnectivityReceiver.isConnected();
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
            showSnack(isConnected);
            connectionCheck = isConnected;
            if (connectionCheck) {
                getGridData();
            }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // register connection status listener
        AppController.getInstance().setConnectivityListener(this);
    }

}
