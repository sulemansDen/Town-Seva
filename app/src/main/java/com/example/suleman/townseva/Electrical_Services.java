package com.example.suleman.townseva;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suleman on 1/6/16.
 */

public class Electrical_Services extends AppCompatActivity {
    private List<Card_Content> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.items_inflater_recyclerview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Electrical");
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
        persons.add(new Card_Content("Lights & Fittings", "Install all kinds of lights and light accessories", R.drawable.gray));
        persons.add(new Card_Content("Fans", "Repair your fan today and beat the heat", R.drawable.gray));
        persons.add(new Card_Content("Plug and Switch", "Let us make all your electrical items work efficiently", R.drawable.gray));
        persons.add(new Card_Content("TV and Entertainment", "Installation as perfect as the perfect image!", R.drawable.gray));
        persons.add(new Card_Content("UPS", "Seize the power to have power with our UPS services", R.drawable.gray));
        persons.add(new Card_Content("General Electrical Services", "Transparent hour based pricing for all kinds of work", R.drawable.gray));

    }

    private void initializeAdapter(){
        RVAdapter_Electrical adapter = new RVAdapter_Electrical(persons);
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


