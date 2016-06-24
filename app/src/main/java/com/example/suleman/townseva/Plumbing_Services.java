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
 * Created by suleman on 2/6/16.
 */

public class Plumbing_Services extends AppCompatActivity {
    private List<Card_Content> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.items_inflater_recyclerview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Plumbing");
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
        persons.add(new Card_Content("Leaks And Blocks","Let us fix and unblock all your clogged pipes", R.drawable.gray));
        persons.add(new Card_Content("Taps And Showers","Takes care of all your tap and shower issues", R.drawable.gray));
        persons.add(new Card_Content("Toilet Fittings","From the ordinary to the elite,installed in a jiffy", R.drawable.gray));
        persons.add(new Card_Content("Accessories","For all bathrooms fixtures, under the shower", R.drawable.gray));
        persons.add(new Card_Content("General Plumbing Services","Transparent hour based pricing for all kinds of work", R.drawable.gray));


    }

    private void initializeAdapter(){
        RVAdapter_Plumbing adapter = new RVAdapter_Plumbing(persons);
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
