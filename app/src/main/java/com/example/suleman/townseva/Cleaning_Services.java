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

public class Cleaning_Services extends AppCompatActivity {
    private List<Card_Content> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.items_inflater_recyclerview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cleaning");
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
        persons.add(new Card_Content("Express Cleaning", "Get a quick make over for your house", R.drawable.gray));
        persons.add(new Card_Content("Deep Home Cleaning", "Get your home a sparkling new makeover", R.drawable.gray));
        persons.add(new Card_Content("Sofa Shampooing", "Get rid of dust and gems from your sofa", R.drawable.gray));
        persons.add(new Card_Content("Bathroom Cleaning", "Get a clean bathroom free of stains", R.drawable.gray));
        persons.add(new Card_Content("Kitchen Cleaning", "Keep your kitchen clean and hygienic", R.drawable.gray));
        persons.add(new Card_Content("Move In Cleaning", "Move into a sparkling clean home with our move-in cleaning service!", R.drawable.gray));
        persons.add(new Card_Content("Cleaning Inspection", "We will visit, inspect and give you a reasonable quote", R.drawable.gray));
    }

    private void initializeAdapter(){
        RVAdapter_Cleaning adapter = new RVAdapter_Cleaning(persons);
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
