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
public class Carpentry_Services extends AppCompatActivity {
    private List<Card_Content> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.items_inflater_recyclerview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Carpentry");
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
        persons.add(new Card_Content("General Carpentry", "Get all your furniture issues fixed", R.drawable.gray));
        persons.add(new Card_Content("Furniture Repair", "Get all your furniture issues fixed", R.drawable.gray));
        persons.add(new Card_Content("Door or Window Repair", "Havig trouble with broken doors or windows? We'll fix it", R.drawable.gray));
        persons.add(new Card_Content("Curtain Roll Fixture", "Need to fix curtain rods in your living & bathroom? We'll do it", R.drawable.gray));
        persons.add(new Card_Content("Lock repair", "Broken locks? Stay safe by fixing it", R.drawable.gray));
    }

    private void initializeAdapter(){
        RVAdapter_Carpentry adapter = new RVAdapter_Carpentry(persons);
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
