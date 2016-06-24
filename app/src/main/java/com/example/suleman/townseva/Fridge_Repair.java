package com.example.suleman.townseva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Fridge_Repair extends AppCompatActivity {
    int total = 0,countDirect=0,countFrost=0,countGeneral=0;
    TextView disp;
    TextView direct;
    TextView frost;
    TextView general;
    Button bsplit,bwindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge__repair);
        getSupportActionBar().setTitle("Fridge Repair");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView)findViewById(R.id.total);
        direct = (TextView)findViewById(R.id.directCool);
        frost = (TextView)findViewById(R.id.frostFree);
        general = (TextView)findViewById(R.id.generalService);
        bwindow = (Button)findViewById(R.id.minus);
        bsplit = (Button)findViewById(R.id.minusSplit);
    }
    public void result(View v)
    {
        if(v.getId() == R.id.add) {
            total += 475;
            countDirect++;
            disp.setText("Total : Rs " + total);
            direct.setText(countDirect + " Direct Cool");

        }
        else  if(v.getId() == R.id.minus) {
            if(countDirect==0)
            {
                //    countWindow=0;
            }
            else
            {
                total -= 475;
                countDirect--;
                disp.setText("Total : Rs " + total);
                direct.setText(countDirect + " Direct Cool");
            }
        }
        else  if(v.getId() == R.id.addFrost) {
            total += 475;
            countFrost++;
            disp.setText("Total : Rs " + total);
            frost.setText(countFrost + " Frost Free (Upto 400 Ltrs)");
        }
        else  if(v.getId() == R.id.minusFrost) {
            if(countFrost==0)
            {
                //countSplit=0;
            }
            else
            {
                total -= 475;
                countFrost--;
                disp.setText("Total : Rs " + total);
                frost.setText(countFrost + " Frost Free (Upto 400 Ltrs)");
            }
        }
        else  if(v.getId() == R.id.addgeneral) {
            total += 475;
            countGeneral++;
            disp.setText("Total : Rs " + total);
            general.setText(countGeneral + " General Service");
        }
        else  if(v.getId() == R.id.minusgeneral) {
            if(countGeneral==0)
            {
                //countSplit=0;
            }
            else
            {
                total -= 475;
                countGeneral--;
                disp.setText("Total : Rs " + total);
                general.setText(countGeneral + " General Service");
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

