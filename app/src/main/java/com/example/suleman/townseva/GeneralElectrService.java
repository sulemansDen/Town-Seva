package com.example.suleman.townseva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GeneralElectrService extends AppCompatActivity {
    TextView disp;
    int total = 0;
    float countCeiling = 0;
    TextView ceiling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_electr_service);
        getSupportActionBar().setTitle("General Electrical Service");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView) findViewById(R.id.total);
        ceiling = (TextView) findViewById(R.id.ceiling);
    }
    public void result(View v) {
        if (v.getId() == R.id.add) {
            if (countCeiling == 0) {
                countCeiling+=2;
                total += 350;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Hour(s)");
            }

            else if(countCeiling<8)
            {
                countCeiling+=0.5;
                total += 50;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Hour(s)");
            }
            else if(countCeiling == 8)
            {
                countCeiling+=0.5;
                total += 50;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Hour(s) & above");
            }
        }
        else if (v.getId() == R.id.minus) {
            if (countCeiling == 0) {

            }
            else if(countCeiling ==2)
            {
                countCeiling-=2;
                total -= 350;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Hour(s)");
            }
            else if (countCeiling <= 8.5 ) {
                countCeiling-=0.5;
                total -= 50;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Hour(s)");
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



