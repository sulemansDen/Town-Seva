package com.example.suleman.townseva;

/**
 * Created by suleman on 31/5/16.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Appliances_Services extends AppCompatActivity {

    private List<Card_Content> persons;
    private RecyclerView rv;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.items_inflater_recyclerview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        text = (TextView) findViewById(R.id.textbox);
        text.setText("New Here? Get 10% off on your first service. Use Coupen Code WED10");
        getSupportActionBar().setTitle("Appliances");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        initializeData();
        initializeAdapter();
    }
    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Card_Content("AC Installation", "Get Your AC Installed And Beat The Heat", R.drawable.gray));
        persons.add(new Card_Content("AC UnInstallation", "UnInstall Existing Ac", R.drawable.gray));
        persons.add(new Card_Content("AC Servicing", "Facing Problem With Your AC? We Will Fix It", R.drawable.gray));
        persons.add(new Card_Content("Washing Machine Repair", "For All Your Washing Machine Prblems", R.drawable.gray));
        persons.add(new Card_Content("Oven Repair", "Let's Get Those Healthy Meal Cooking Again", R.drawable.gray));
        persons.add(new Card_Content("Fridge Repair", "Services For Your Fridge", R.drawable.gray));
        persons.add(new Card_Content("Fridge Gas Charging", "Fridge Losts Its Cool! We Will Pump It Up", R.drawable.gray));
    }

    private void initializeAdapter(){
        RVAdapter_Appliances adapter = new RVAdapter_Appliances(persons);
        rv.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(android.R.id.home == item.getItemId())
        {
            this.finish();

        }
        return super.onOptionsItemSelected(item);
    }
}
