package com.example.suleman.townseva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Fans extends AppCompatActivity {
    TextView disp;
    int total = 0, countCeiling = 0, countWall=0, countExhaust=0, countRepair=0;
    TextView ceiling,wall,exhaust,repair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fans);
        getSupportActionBar().setTitle("Fans");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView) findViewById(R.id.total);
        ceiling = (TextView) findViewById(R.id.ceiling);
        wall = (TextView) findViewById(R.id.wall);
        exhaust = (TextView) findViewById(R.id.exhaust);
        repair = (TextView) findViewById(R.id.repair);
    }
    public void result(View v) {
        if (v.getId() == R.id.add) {
            if (countCeiling == 0) {
                countCeiling++;
                total += 250;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Ceiling Fan Installation");
            } else if (countCeiling == 1) {
                countCeiling++;
                total += 100;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Ceiling Fan Installation");
            } else if (countCeiling == 2) {
                countCeiling++;
                total += 75;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Ceiling Fan Installation");
            } else if (countCeiling == 3) {
                countCeiling++;
                total += 50;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Ceiling Fan Installation");
            } else if (countCeiling == 4) {
                countCeiling++;
                total += 50;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Ceiling Fan Installation & above");
            }
        }
        else if (v.getId() == R.id.minus) {
            if (countCeiling ==0)
            {

            }
            else if (countCeiling == 1) {
                countCeiling--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Ceiling Fan Installation");
            } else if (countCeiling == 2) {
                countCeiling--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Ceiling Fan Installation");
            } else if (countCeiling == 3) {
                countCeiling--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Ceiling Fan Installation");
            } else if (countCeiling == 4) {
                countCeiling--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Ceiling Fan Installation");
            } else if (countCeiling == 5) {
                countCeiling--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Ceiling Fan Installation");
            }

        }
        else if (v.getId() == R.id.addWall) {
            if (countWall == 0) {
                countWall++;
                total += 250;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Wall Mounted Fan Installation");
            } else if (countWall == 1) {
                countWall++;
                total += 100;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Wall Mounted Fan Installation");
            } else if (countWall == 2) {
                countWall++;
                total += 75;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Wall Mounted Fan Installation");
            } else if (countWall == 3) {
                countWall++;
                total += 50;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Wall Mounted Fan Installation");
            } else if (countWall == 4) {
                countWall++;
                total += 50;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Wall Mounted Fan Installation & above");
            }
        }
        else if (v.getId() == R.id.minusWall) {
            if (countWall ==0)
            {

            }
            else if (countWall == 1) {
                countWall--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Wall Mounted Fan Installation");
            } else if (countWall == 2) {
                countWall--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Wall Mounted Fan Installation");
            } else if (countWall == 3) {
                countWall--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Wall Mounted Fan Installation");
            } else if (countWall == 4) {
                countWall--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Wall Mounted Fan Installation");
            } else if (countWall == 5) {
                countWall--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " Wall Mounted Fan Installation");
            }

        }
        else if (v.getId() == R.id.addExhaust) {
            if (countExhaust == 0) {
                countExhaust++;
                total += 250;
                disp.setText("Total : Rs " + total);
                exhaust.setText(countExhaust + " Exhaust Fan Installation");
            } else if (countExhaust == 1) {
                countExhaust++;
                total += 100;
                disp.setText("Total : Rs " + total);
                exhaust.setText(countExhaust + " Exhaust Fan Installation");
            } else if (countExhaust == 2) {
                countExhaust++;
                total += 75;
                disp.setText("Total : Rs " + total);
                exhaust.setText(countExhaust + " Exhaust Fan Installation");
            } else if (countExhaust == 3) {
                countExhaust++;
                total += 50;
                disp.setText("Total : Rs " + total);
                exhaust.setText(countExhaust + " Exhaust Fan Installation");
            } else if (countExhaust == 4) {
                countExhaust++;
                total += 50;
                disp.setText("Total : Rs " + total);
                exhaust.setText(countExhaust + " Exhaust Fan Installation & above");
            }
        }
        else if (v.getId() == R.id.minusExhaust) {
            if (countExhaust ==0)
            {

            }
            else if (countExhaust== 1) {
                countExhaust--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                exhaust.setText(countExhaust + " Exhaust Fan Installation");
            } else if (countExhaust == 2) {
                countExhaust--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                exhaust.setText(countExhaust + " Exhaust Fan Installation");
            } else if (countExhaust == 3) {
                countExhaust--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                exhaust.setText(countExhaust+ " Exhaust Fan Installation");
            } else if (countExhaust == 4) {
                countExhaust--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                exhaust.setText(countExhaust + " Exhaust Fan Installation");
            } else if (countExhaust == 5) {
                countExhaust--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                exhaust.setText(countExhaust + " Exhaust Fan Installation");
            }

        }
        else if (v.getId() == R.id.addRepair) {
            if (countRepair == 0) {
                countRepair++;
                total += 250;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Fan-Repair - Capacitor Change");
            } else if (countRepair == 1) {
                countRepair++;
                total += 100;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Fan-Repair - Capacitor Change");
            } else if (countRepair == 2) {
                countRepair++;
                total += 75;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Fan-Repair - Capacitor Change ");
            } else if (countRepair == 3) {
                countRepair++;
                total += 50;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Fan-Repair - Capacitor Change");
            } else if (countRepair == 4) {
                countRepair++;
                total += 50;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Fan-Repair - Capacitor Change & above");
            }
        }
        else if (v.getId() == R.id.minusRepair) {
            if (countRepair ==0)
            {

            }
            else if (countRepair== 1) {
                countRepair--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Fan-Repair - Capacitor Change");
            } else if (countRepair == 2) {
                countRepair--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Fan-Repair - Capacitor Change");
            } else if (countRepair == 3) {
                countRepair--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair+ " Fan-Repair - Capacitor Change");
            } else if (countRepair == 4) {
                countRepair--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Fan-Repair - Capacitor Change");
            } else if (countRepair == 5) {
                countRepair--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Fan-Repair - Capacitor Change");
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



