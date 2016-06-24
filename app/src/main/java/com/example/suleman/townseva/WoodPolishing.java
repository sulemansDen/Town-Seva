package com.example.suleman.townseva;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suleman on 8/6/16.
 */

public class WoodPolishing extends AppCompatActivity {
    private List<Card_Content> persons;
    private RecyclerView rv;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_inflater_recyclerview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        text = (TextView) findViewById(R.id.textbox);
        text.setText("New Here? Get 10% OFF on your first service. Use coupon code WED10.");
        getSupportActionBar().setTitle("Wood Polishing");
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
        persons.add(new Card_Content("Interior Wood Polishing", "So that wood compliments your interior", R.drawable.gray));
        persons.add(new Card_Content("Exterior Wood Polishing", "Let the wood wear bad weather", R.drawable.gray));

    }

    private void initializeAdapter(){
        RVAdapterWood adapter = new RVAdapterWood(persons);
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

