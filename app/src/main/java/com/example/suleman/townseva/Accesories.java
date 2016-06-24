package com.example.suleman.townseva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Accesories extends AppCompatActivity {
    TextView disp;
    int total = 0,countBasin=0,countToilet=0,countDrain = 0,countFix = 0,countRepair=0;
    TextView cloggedBasin;
    TextView cloggedToilet;
    TextView cloggedDrain;
    TextView blockageFix;
    TextView leakageRepair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accesories);
        getSupportActionBar().setTitle("Leaks and Blocks");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView)findViewById(R.id.total);
        cloggedBasin = (TextView)findViewById(R.id.cloggedBasin);
        cloggedToilet = (TextView)findViewById(R.id.cloggedToilet);
        cloggedDrain = (TextView) findViewById(R.id.cloggedDrain);
        blockageFix = (TextView)findViewById(R.id.blockFix);
        leakageRepair = (TextView)findViewById(R.id.leakageRepair);
    }
    public void result(View v) {
        if (v.getId() == R.id.add) {
            if (countBasin == 0) {
                countBasin++;
                total += 250;
                disp.setText("Total : Rs " + total);
                cloggedBasin.setText(countBasin + " Mirror");
            } else if (countBasin == 1) {
                countBasin++;
                total += 100;
                disp.setText("Total : Rs " + total);
                cloggedBasin.setText(countBasin + " Mirror");
            } else if (countBasin == 2) {
                countBasin++;
                total += 75;
                disp.setText("Total : Rs " + total);
                cloggedBasin.setText(countBasin + " Mirror");
            } else if (countBasin == 3) {
                countBasin++;
                total += 50;
                disp.setText("Total : Rs " + total);
                cloggedBasin.setText(countBasin + " Mirror");
            } else if (countBasin == 4) {
                countBasin++;
                total += 50;
                disp.setText("Total : Rs " + total);
                cloggedBasin.setText(countBasin + " Mirror & above");
            }
        }
        else if (v.getId() == R.id.minus) {
            if (countBasin ==0)
            {

            }
            else if (countBasin == 1) {
                countBasin--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                cloggedBasin.setText(countBasin + " Mirror");
            } else if (countBasin == 2) {
                countBasin--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                cloggedBasin.setText(countBasin + " Mirror");
            } else if (countBasin == 3) {
                countBasin--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                cloggedBasin.setText(countBasin + " Mirror");
            } else if (countBasin == 4) {
                countBasin--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                cloggedBasin.setText(countBasin + " Mirror");
            } else if (countBasin == 5) {
                countBasin--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                cloggedBasin.setText(countBasin + " Mirror");
            }

        }
        else if (v.getId() == R.id.addToilet) {
            if (countToilet == 0) {
                countToilet++;
                total += 250;
                disp.setText("Total : Rs " + total);
                cloggedToilet.setText(countToilet + " Soap Stand");
            } else if (countToilet == 1) {
                countToilet++;
                total += 100;
                disp.setText("Total : Rs " + total);
                cloggedToilet.setText(countToilet + " Soap Stand");
            } else if (countToilet == 2) {
                countToilet++;
                total += 75;
                disp.setText("Total : Rs " + total);
                cloggedToilet.setText(countToilet + " Soap Stand");
            } else if (countToilet == 3) {
                countToilet++;
                total += 50;
                disp.setText("Total : Rs " + total);
                cloggedToilet.setText(countToilet + " Soap Stand");
            } else if (countToilet == 4) {
                countToilet++;
                total += 50;
                disp.setText("Total : Rs " + total);
                cloggedToilet.setText(countToilet + " Soap Stand & above");
            }
        }
        else if (v.getId() == R.id.minusToilet) {
            if (countToilet ==0)
            {

            }
            else if (countToilet == 1) {
                countToilet--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                cloggedToilet.setText(countToilet + " Soap Stand");
            } else if (countToilet == 2) {
                countToilet--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                cloggedToilet.setText(countToilet + " Soap Stand");
            } else if (countToilet == 3) {
                countToilet--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                cloggedToilet.setText(countToilet + " Soap Stand");
            } else if (countToilet == 4) {
                countToilet--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                cloggedToilet.setText(countToilet + " Soap Stand");
            } else if (countToilet == 5) {
                countToilet--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                cloggedToilet.setText(countToilet + " Soap Stand");
            }

        }
        else if (v.getId() == R.id.addDrain) {
            if (countDrain == 0) {
                countDrain++;
                total += 250;
                disp.setText("Total : Rs " + total);
                cloggedDrain.setText(countDrain + " Toilet Roll");
            } else if (countDrain == 1) {
                countDrain++;
                total += 100;
                disp.setText("Total : Rs " + total);
                cloggedDrain.setText(countDrain + " Toilet Roll");
            } else if (countDrain == 2) {
                countDrain++;
                total += 75;
                disp.setText("Total : Rs " + total);
                cloggedDrain.setText(countDrain + " Toilet Roll");
            } else if (countDrain == 3) {
                countDrain++;
                total += 50;
                disp.setText("Total : Rs " + total);
                cloggedDrain.setText(countDrain + " Toilet Roll");
            } else if (countDrain == 4) {
                countDrain++;
                total += 50;
                disp.setText("Total : Rs " + total);
                cloggedDrain.setText(countDrain + " Toilet Roll & above");
            }
        }
        else if (v.getId() == R.id.minusDrain) {
            if (countDrain ==0)
            {

            }
            else if (countDrain== 1) {
                countDrain--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                cloggedDrain.setText(countDrain + " Toilet Roll");
            } else if (countDrain == 2) {
                countDrain--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                cloggedDrain.setText(countDrain + " Toilet Roll");
            } else if (countDrain == 3) {
                countDrain--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                cloggedDrain.setText(countDrain+ " Toilet Roll");
            } else if (countDrain == 4) {
                countDrain--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                cloggedDrain.setText(countDrain + " Toilet Roll");
            } else if (countDrain == 5) {
                countDrain--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                cloggedDrain.setText(countDrain + " Toilet Roll");
            }

        }
        else if (v.getId() == R.id.addFix) {
            if (countFix == 0) {
                countFix++;
                total += 250;
                disp.setText("Total : Rs " + total);
                blockageFix.setText(countFix + " Towel Hanger");
            } else if (countFix == 1) {
                countFix++;
                total += 100;
                disp.setText("Total : Rs " + total);
                blockageFix.setText(countFix + " Towel Hanger");
            } else if (countFix == 2) {
                countFix++;
                total += 75;
                disp.setText("Total : Rs " + total);
                blockageFix.setText(countFix + " Towel Hanger ");
            } else if (countFix == 3) {
                countFix++;
                total += 50;
                disp.setText("Total : Rs " + total);
                blockageFix.setText(countFix + " Towel Hanger");
            } else if (countFix == 4) {
                countFix++;
                total += 50;
                disp.setText("Total : Rs " + total);
                blockageFix.setText(countFix + " Towel Hanger & above" );
            }
        }
        else if (v.getId() == R.id.minusfix) {
            if (countFix ==0)
            {

            }
            else if (countFix== 1) {
                countFix--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                blockageFix.setText(countFix + " Towel Hanger");
            } else if (countFix == 2) {
                countFix--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                blockageFix.setText(countFix + " Towel Hanger");
            } else if (countFix == 3) {
                countFix--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                blockageFix.setText(countFix+ " Towel Hanger");
            } else if (countFix == 4) {
                countFix--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                blockageFix.setText(countFix + " Towel Hanger");
            } else if (countFix == 5) {
                countFix--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                blockageFix.setText(countFix + " Towel Hanger");
            }

        }
        else if (v.getId() == R.id.addRepair) {
            if (countRepair == 0) {
                countRepair++;
                total += 250;
                disp.setText("Total : Rs " + total);
                leakageRepair.setText(countRepair + " Toilet Paper Holder");
            } else if (countRepair == 1) {
                countRepair++;
                total += 100;
                disp.setText("Total : Rs " + total);
                leakageRepair.setText(countRepair + " Toilet Paper Holder");
            } else if (countRepair == 2) {
                countRepair++;
                total += 75;
                disp.setText("Total : Rs " + total);
                leakageRepair.setText(countRepair + " Toilet Paper Holder ");
            } else if (countRepair == 3) {
                countRepair++;
                total += 50;
                disp.setText("Total : Rs " + total);
                leakageRepair.setText(countRepair + " Toilet Paper Holder");
            } else if (countRepair == 4) {
                countRepair++;
                total += 50;
                disp.setText("Total : Rs " + total);
                leakageRepair.setText(countRepair + " Toilet Paper Holder & above");
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
                leakageRepair.setText(countRepair + " Toilet Paper Holder");
            } else if (countRepair == 2) {
                countRepair--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                leakageRepair.setText(countRepair + " Toilet Paper Holder");
            } else if (countRepair == 3) {
                countRepair--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                leakageRepair.setText(countRepair+ " Toilet Paper Holder");
            } else if (countRepair == 4) {
                countRepair--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                leakageRepair.setText(countRepair + " Toilet Paper Holder");
            } else if (countRepair == 5) {
                countRepair--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                leakageRepair.setText(countRepair + " Toilet Paper Holder");
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




