package com.example.suleman.townseva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BathroomCleaning extends AppCompatActivity {
    TextView disp;
    int total = 0, countBhk = 0;
    TextView bhk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom_cleaning);
        getSupportActionBar().setTitle("Bathroom Cleaning");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView) findViewById(R.id.total);
        bhk = (TextView) findViewById(R.id.bhk);
    }
    public void result(View v) {
        if (v.getId() == R.id.add) {
            if (countBhk == 0) {
                countBhk++;
                total += 1000;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Bathroom");
            } else if (countBhk == 1) {
                countBhk++;
                total += 700;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Bathroom");
            } else if (countBhk == 2) {
                countBhk++;
                total += 600;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Bathroom");
            } else if (countBhk == 3) {
                countBhk++;
                total += 500;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Bathroom");
            } else if (countBhk == 4) {
                countBhk++;
                total += 400;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Bathroom & above");
            }
        }
        else if (v.getId() == R.id.minus) {
            if (countBhk ==0)
            {

            }
            else if (countBhk == 1) {
                countBhk--;
                total -= 1000;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Bathroom");
            } else if (countBhk == 2) {
                countBhk--;
                total -= 700;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Bathroom");
            } else if (countBhk == 3) {
                countBhk--;
                total -= 600;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Bathroom");
            } else if (countBhk == 4) {
                countBhk--;
                total -= 500;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Bathroom");
            } else if (countBhk == 5) {
                countBhk--;
                total -= 400;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Bathroom");
            }

        }
    }

    public void submit(View v)
    {
        if(total == 0)
        {
            Toast.makeText(getApplicationContext(),"Please Select The Quantity",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent i =new Intent(this,Address.class);
            startActivity(i);
        }
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

