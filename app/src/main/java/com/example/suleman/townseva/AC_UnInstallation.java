package com.example.suleman.townseva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AC_UnInstallation extends AppCompatActivity {
    TextView disp;
    int total = 0,countWindow=0,countSplit=0;
    TextView window;
    TextView split;
    Button bsplit,bwindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac__un_installation);
        getSupportActionBar().setTitle("AC UnInstallation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView)findViewById(R.id.total);
        window = (TextView)findViewById(R.id.windowAC);
        split = (TextView)findViewById(R.id.splitAC);
        bwindow = (Button)findViewById(R.id.minus);
        bsplit = (Button)findViewById(R.id.minusSplit);
    }


    public void result(View v)
    {
        if(v.getId() == R.id.add) {
            total += 650;
            countWindow++;
            disp.setText("Total : Rs " + total);
            window.setText(countWindow + " Window AC");
        }
        else  if(v.getId() == R.id.minus) {
            if(countWindow==0)
            {
                //    countWindow=0;
            }
            else
            {
                total -= 650;
                countWindow--;
                disp.setText("Total : Rs " + total);
                window.setText(countWindow + " Window AC");
            }
        }
        else  if(v.getId() == R.id.addSplit) {
            total += 900;
            countSplit++;
            disp.setText("Total : Rs " + total);
            split.setText(countSplit + " Split AC");
        }
        else  if(v.getId() == R.id.minusSplit) {
            if(countSplit==0)
            {
                //countSplit=0;
            }
            else
            {
                total -= 900;
                countSplit--;
                disp.setText("Total : Rs " + total);
                split.setText(countSplit + " Split AC");
            }
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
}
