package com.example.suleman.townseva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SofaCleaning extends AppCompatActivity {
    TextView disp;
    int total = 0, countBhk = 0;
    TextView bhk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sofa_cleaning);
        getSupportActionBar().setTitle("Sofa Shampooing");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView) findViewById(R.id.total);
        bhk = (TextView) findViewById(R.id.bhk);
    }
    public void result(View v) {
        if (v.getId() == R.id.add) {
            if (countBhk == 0) {
                countBhk+=5;
                total += 1500;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
            } else if (countBhk == 5) {
                countBhk++;
                total += 300;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
            } else if (countBhk == 6) {
                countBhk++;
                total += 300;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
            } else if (countBhk == 7) {
                countBhk++;
                total += 300;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
            } else if (countBhk == 8) {
                countBhk++;
                total += 300;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
            }
            else if (countBhk == 9) {
                countBhk++;
                total += 300;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
            }
            else if (countBhk == 10) {
                countBhk++;
                total += 300;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
            }
            else if (countBhk == 11) {
                countBhk++;
                total += 300;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa & above");
            }

        }
        else if (v.getId() == R.id.minus) {
           if (countBhk ==0)
           {

           }
            else if (countBhk == 5) {
                countBhk-=5;
                total -= 1500;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
            } else if (countBhk == 6) {
                countBhk--;
                total -= 300;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
            } else if (countBhk == 7) {
                countBhk--;
                total -= 300;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
            } else if (countBhk == 8) {
                countBhk--;
                total -= 300;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
            } else if (countBhk == 9) {
                countBhk--;
                total -= 300;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
            }
            else if (countBhk == 10) {
                countBhk--;
                total -= 300;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
            }
            else if (countBhk == 11) {
                countBhk--;
                total -= 300;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
            }
            else if (countBhk == 12) {
                countBhk--;
                total -= 300;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " Seater Sofa");
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
