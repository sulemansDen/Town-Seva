package com.example.suleman.townseva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LightsAndFittings extends AppCompatActivity {
    TextView disp;
    int total = 0, countRepair = 0, countInstall=0, countFancy=0, countChandlier=0;
    TextView repair,install,fancy,chandlier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights_and_fittings);
        getSupportActionBar().setTitle("Lights & Fittings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView) findViewById(R.id.total);
        repair = (TextView) findViewById(R.id.repair);
        install = (TextView) findViewById(R.id.install);
        fancy = (TextView) findViewById(R.id.fancy);
        chandlier = (TextView) findViewById(R.id.chandlier);
    }
    public void result(View v) {
        if (v.getId() == R.id.add) {
            if (countRepair == 0) {
                countRepair++;
                total += 250;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Lights Repair");
            } else if (countRepair == 1) {
                countRepair++;
                total += 100;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Lights Repair");
            } else if (countRepair == 2) {
                countRepair++;
                total += 75;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Lights Repair");
            } else if (countRepair == 3) {
                countRepair++;
                total += 50;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Lights Repair");
            } else if (countRepair == 4) {
                countRepair++;
                total += 50;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Lights Repair & above");
            }
        }
        else if (v.getId() == R.id.minus) {
            if (countRepair ==0)
            {

            }
            else if (countRepair == 1) {
                countRepair--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Lights Repair");
            } else if (countRepair == 2) {
                countRepair--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Lights Repair");
            } else if (countRepair == 3) {
                countRepair--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Lights Repair");
            } else if (countRepair == 4) {
                countRepair--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Lights Repair");
            } else if (countRepair == 5) {
                countRepair--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                repair.setText(countRepair + " Lights Repair");
            }

        }
        else if (v.getId() == R.id.addInstall) {
            if (countInstall == 0) {
                countInstall++;
                total += 250;
                disp.setText("Total : Rs " + total);
                install.setText(countInstall + " Lights Installation");
            } else if (countInstall == 1) {
                countInstall++;
                total += 100;
                disp.setText("Total : Rs " + total);
                install.setText(countInstall + " Lights Installation");
            } else if (countInstall == 2) {
                countInstall++;
                total += 75;
                disp.setText("Total : Rs " + total);
                install.setText(countInstall + " Lights Installation");
            } else if (countInstall == 3) {
                countInstall++;
                total += 50;
                disp.setText("Total : Rs " + total);
                install.setText(countInstall + " Lights Installation");
            } else if (countInstall == 4) {
                countInstall++;
                total += 50;
                disp.setText("Total : Rs " + total);
                install.setText(countInstall + " Lights Installation & above");
            }
        }
        else if (v.getId() == R.id.minusInstall) {
            if (countInstall ==0)
            {

            }
            else if (countInstall == 1) {
                countInstall--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                install.setText(countInstall + " Lights Installation");
            } else if (countInstall == 2) {
                countInstall--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                install.setText(countInstall + " Lights Installation");
            } else if (countInstall == 3) {
                countInstall--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                install.setText(countInstall + " Lights Installation");
            } else if (countInstall == 4) {
                countInstall--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                install.setText(countInstall + " Lights Installation");
            } else if (countInstall == 5) {
                countInstall--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                install.setText(countInstall + " Lights Installation");
            }

        }
        else if (v.getId() == R.id.addFancy) {
            if (countFancy == 0) {
                countFancy++;
                total += 250;
                disp.setText("Total : Rs " + total);
                fancy.setText(countFancy + " Fancy Lights");
            } else if (countFancy == 1) {
                countFancy++;
                total += 100;
                disp.setText("Total : Rs " + total);
                fancy.setText(countFancy + " Fancy Lights");
            } else if (countFancy == 2) {
                countFancy++;
                total += 75;
                disp.setText("Total : Rs " + total);
                fancy.setText(countFancy + " Fancy Lights");
            } else if (countFancy == 3) {
                countFancy++;
                total += 50;
                disp.setText("Total : Rs " + total);
                fancy.setText(countFancy + " Fancy Lights");
            } else if (countFancy == 4) {
                countFancy++;
                total += 50;
                disp.setText("Total : Rs " + total);
                fancy.setText(countFancy + " Fancy Lights & above");
            }
        }
    else if (v.getId() == R.id.minusFancy) {
            if (countFancy ==0)
            {

            }
            else if (countFancy == 1) {
            countFancy--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                fancy.setText(countFancy + " Fancy Lights");
            } else if (countFancy == 2) {
                countFancy--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                fancy.setText(countFancy + " Fancy Lights");
            } else if (countFancy == 3) {
            countFancy--;
                total -= 75;
                disp.setText("Total : Rs " + total);
            fancy.setText(countFancy+ " Fancy Lights");
            } else if (countFancy == 4) {
            countFancy--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                fancy.setText(countFancy + " Fancy Lights");
        } else if (countFancy == 5) {
                countFancy--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                fancy.setText(countFancy + " Fancy Lights");
            }

        }
        else if (v.getId() == R.id.addChandler)
        {
            countChandlier++;
                total += 500;
                disp.setText("Total : Rs " + total);
                chandlier.setText(countChandlier + " Chandlier");
        }
        else if (v.getId() == R.id.minusChandler) {
            if (countChandlier == 0) {

            } else {
                countChandlier--;
                total -= 500;
                disp.setText("Total : Rs " + total);
                chandlier.setText(countChandlier + " Chandlier");
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



