package com.example.suleman.townseva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DeepHomeCleaning extends AppCompatActivity {
    TextView disp;
    int total = 0,countBhk=0,countWater=0;
    TextView bhk;
    TextView water;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_home_cleaning);
        getSupportActionBar().setTitle("Deep Home Cleaning");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView)findViewById(R.id.total);
        bhk = (TextView)findViewById(R.id.bhk);
        water = (TextView)findViewById(R.id.water);
    }
    public void result(View v)
    {
        if(v.getId() == R.id.add) {
            if(countBhk == 0)
            {countBhk++;
                total+=3600;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " BHK");
            }
            else if(countBhk == 1)
            {countBhk++;
                total+=1400;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " BHK");
            }
            else if(countBhk == 2)
            {
                countBhk++;
                total += 2200;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " BHK");
            }
            else if(countBhk == 3)
            {
                countBhk++;
                total += 2800;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " BHK");
            }
            else if (countBhk == 4)
            {
                countBhk++;
                total += 1800;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " BHK & above");
            }

        }
        else  if(v.getId() == R.id.minus) {
            {
                if(countBhk == 0)
                {

                }
                else if(countBhk == 1)
                {
                        countBhk--;
                        total -= 3600;
                        disp.setText("Total : Rs " + total);
                        bhk.setText(countBhk + " BHK");

                }
                else if(countBhk == 2)
                {
                    countBhk--;
                    total -=1400;
                    disp.setText("Total : Rs " + total);
                    bhk.setText(countBhk + " BHK");
                }
                else if(countBhk == 3)
                {
                    countBhk--;
                    total -= 2200;
                    disp.setText("Total : Rs " + total);
                    bhk.setText(countBhk + " BHK");
                }
                else if(countBhk == 4)
                {
                    countBhk--;
                    total -= 2800;
                    disp.setText("Total : Rs " + total);
                    bhk.setText(countBhk + " BHK");
                }
                else if (countBhk == 5)
                {
                    countBhk--;
                    total -= 1800;
                    disp.setText("Total : Rs " + total);
                    bhk.setText(countBhk + " BHK & above");
                }
            }
        }
        else  if(v.getId() == R.id.addWater) {
            total += (500*1.5);
            countWater+=500;
            disp.setText("Total : Rs " + total);
            water.setText(countWater + " Ltr Water Tank");
        }
        else  if(v.getId() == R.id.minusWater) {
            if(countWater==0)
            {
                //countSplit=0;
            }
            else
            {
                total -= (500*1.5);
                countWater-=500;
                disp.setText("Total : Rs " + total);
                water.setText(countWater + " Ltr Water Tank");
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
