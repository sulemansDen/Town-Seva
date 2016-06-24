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

public class Laundry_Services extends AppCompatActivity {
    private List<Card_Content> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.items_inflater_recyclerview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Laundry");
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
        persons.add(new Card_Content("Wash And Fold", "", R.drawable.gray));
        persons.add(new Card_Content("Wash And Iron", "", R.drawable.gray));
        persons.add(new Card_Content("Premium Laundry", "", R.drawable.gray));
        persons.add(new Card_Content("Dry Clean", "", R.drawable.gray));
    }

    private void initializeAdapter(){
        RVAdapter_Laundry adapter = new RVAdapter_Laundry(persons);
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
