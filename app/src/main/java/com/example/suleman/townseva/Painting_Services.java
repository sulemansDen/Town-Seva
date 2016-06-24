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

public class Painting_Services extends AppCompatActivity {
    private List<Card_Content> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.items_inflater_recyclerview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Painting");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        initializeData();
        initializeAdapter();
    }
    private void initializeData() {
        persons = new ArrayList<>();
        persons.add(new Card_Content("Interior Fresh Painting", "Bring your interiors alive!", R.drawable.gray));
        persons.add(new Card_Content("Interior Re-Painting", "Paint your interior back to life!", R.drawable.gray));
        persons.add(new Card_Content("Exterior Fresh Painting", "Let your home show a bright face!", R.drawable.gray));
        persons.add(new Card_Content("Exterior Re-Painting", "Make a new face of your home!", R.drawable.gray));
        persons.add(new Card_Content("Wood Polishing", "Shiny wood, whether it's in or out!", R.drawable.gray));

    }

    private void initializeAdapter(){
        RVAdapter_Painting adapter = new RVAdapter_Painting(persons);
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
