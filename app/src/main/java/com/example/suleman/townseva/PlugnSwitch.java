package com.example.suleman.townseva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PlugnSwitch extends AppCompatActivity {
    TextView disp;
    int total = 0, countCeiling = 0, countWall=0;
    TextView ceiling,wall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugn_switch);
        getSupportActionBar().setTitle("Plug And Switch");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView) findViewById(R.id.total);
        ceiling = (TextView) findViewById(R.id.ceiling);
        wall = (TextView) findViewById(R.id.wall);
    }
    public void result(View v) {
        if (v.getId() == R.id.add) {
            if (countCeiling == 0) {
                countCeiling++;
                total += 250;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Plug And Switch Repair");
            } else if (countCeiling == 1) {
                countCeiling++;
                total += 25;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Plug And Switch Repair");
            } else if (countCeiling == 2) {
                countCeiling++;
                total += 25;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Plug And Switch Repair");
            } else if (countCeiling == 3) {
                countCeiling++;
                total += 25;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Plug And Switch Repair");
            } else if (countCeiling == 4) {
                countCeiling++;
                total += 25;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Plug And Switch Repair & above");
            }
        } else if (v.getId() == R.id.minus) {
            if (countCeiling == 0) {

            } else if (countCeiling == 1) {
                countCeiling--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Plug And Switch Repair");
            } else if (countCeiling == 2) {
                countCeiling--;
                total -= 25;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Plug And Switch Repair");
            } else if (countCeiling == 3) {
                countCeiling--;
                total -= 25;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Plug And Switch Repair");
            } else if (countCeiling == 4) {
                countCeiling--;
                total -= 25;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Plug And Switch Repair");
            } else if (countCeiling == 5) {
                countCeiling--;
                total -= 25;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Plug And Switch Repair");
            }

        } else if (v.getId() == R.id.addWall) {
            if (countWall == 0) {
                countWall++;
                total += 250;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Plug And Switch Installation");
            } else if (countWall == 1) {
                countWall++;
                total += 25;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Plug And Switch Installation");
            } else if (countWall == 2) {
                countWall++;
                total += 25;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Plug And Switch Installation");
            } else if (countWall == 3) {
                countWall++;
                total += 25;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Plug And Switch Installation");
            } else if (countWall == 4) {
                countWall++;
                total += 25;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Plug And Switch Installation & above");
            }
        } else if (v.getId() == R.id.minusWall) {
            if (countWall == 0) {

            } else if (countWall == 1) {
                countWall--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Plug And Switch Installation");
            } else if (countWall == 2) {
                countWall--;
                total -= 25;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Plug And Switch Installation");
            } else if (countWall == 3) {
                countWall--;
                total -= 25;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Plug And Switch Installation");
            } else if (countWall == 4) {
                countWall--;
                total -= 25;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Plug And Switch Installation");
            } else if (countWall == 5) {
                countWall--;
                total -= 25;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Plug And Switch Installation");
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
