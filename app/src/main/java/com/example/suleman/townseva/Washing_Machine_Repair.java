package com.example.suleman.townseva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Washing_Machine_Repair extends AppCompatActivity {
    int total = 0,countFull=0,countSemi=0,countFront=0;
    TextView disp;
    TextView full;
    TextView semi;
    TextView  front;
    Button bsplit,bwindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washing__machine__repair);
        getSupportActionBar().setTitle("AC Installation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView)findViewById(R.id.total);
        full = (TextView)findViewById(R.id.fullyAutomatic);
        semi = (TextView)findViewById(R.id.semiAutomatic);
        front = (TextView)findViewById(R.id.frontLoading);
        bwindow = (Button)findViewById(R.id.minus);
        bsplit = (Button)findViewById(R.id.minusSplit);
    }
    public void result(View v)
    {
        if(v.getId() == R.id.add) {
            total += 450;
            countFull++;
            disp.setText("Total : Rs " + total);
            full.setText(countFull + " Fully Automatic");
        }
        else  if(v.getId() == R.id.minus) {
            if(countFull==0)
            {
                //    countWindow=0;
            }
            else
            {
                total -= 450;
                countFull--;
                disp.setText("Total : Rs " + total);
                full.setText(countFull + " Fully Automatic");
            }
        }
        else  if(v.getId() == R.id.addSemi) {
            total += 450;
            countSemi++;
            disp.setText("Total : Rs " + total);
            semi.setText(countSemi + " Semi Automatic");
        }
        else  if(v.getId() == R.id.minusSemi) {
            if(countSemi==0)
            {
                //countSplit=0;
            }
            else
            {
                total -= 450;
                countSemi--;
                disp.setText("Total : Rs " + total);
                semi.setText(countSemi + " Semi Automatic");
            }
        }
        else  if(v.getId() == R.id.addFront) {
            total += 550;
            countFront++;
            disp.setText("Total : Rs " + total);
            front.setText(countFront + " Front Loading");
        }
        else  if(v.getId() == R.id.minusFront) {
            if(countFront==0)
            {
                //countSplit=0;
            }
            else
            {
                total -= 550;
                countFront--;
                disp.setText("Total : Rs " + total);
                front.setText(countFront + " Front Loading");
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
