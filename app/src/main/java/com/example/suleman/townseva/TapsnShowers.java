package com.example.suleman.townseva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TapsnShowers extends AppCompatActivity {
    TextView disp;
    int total = 0,countTapRepair=0,countjetRepair=0,countshowerRepair= 0,countwallMixtureRepair = 0,counttapInstall=0,
    countjetInstall=0,countshowerInstall=0,countmixtureTapInstall=0;
    TextView taprepair;
    TextView jetRepair;
    TextView showerRepair;
    TextView wallMixtureRepair;
    TextView tapInstall;
    TextView showerInstall;
    TextView jetInstall;
    TextView mixtureTapInstall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tapsn_showers);
        getSupportActionBar().setTitle("Taps and Showers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView)findViewById(R.id.total);
        taprepair = (TextView)findViewById(R.id.tapRepair);
        jetRepair = (TextView)findViewById(R.id.jetRepair);
        showerRepair = (TextView) findViewById(R.id.showerRepair);
        wallMixtureRepair = (TextView)findViewById(R.id.MixtureRepair);
        tapInstall = (TextView)findViewById(R.id.tapInstall);
        showerInstall = (TextView)findViewById(R.id.showerInstall);
        jetInstall = (TextView)findViewById(R.id.jetInstall);
        mixtureTapInstall = (TextView)findViewById(R.id.mixtureInstall);
    }
    public void result(View v) {
        if (v.getId() == R.id.add) {
            if (countTapRepair == 0) {
                countTapRepair++;
                total += 250;
                disp.setText("Total : Rs " + total);
                taprepair.setText(countTapRepair + " Tap Repair");
            } else if (countTapRepair == 1) {
                countTapRepair++;
                total += 100;
                disp.setText("Total : Rs " + total);
                taprepair.setText(countTapRepair + " Tap Repair");
            } else if (countTapRepair == 2) {
                countTapRepair++;
                total += 75;
                disp.setText("Total : Rs " + total);
                taprepair.setText(countTapRepair + " Tap Repair");
            } else if (countTapRepair == 3) {
                countTapRepair++;
                total += 50;
                disp.setText("Total : Rs " + total);
                taprepair.setText(countTapRepair + " Tap Repair");
            } else if (countTapRepair == 4) {
                countTapRepair++;
                total += 50;
                disp.setText("Total : Rs " + total);
                taprepair.setText(countTapRepair + " Tap Repair & above");
            }
        }
        else if (v.getId() == R.id.minus) {
            if (countTapRepair ==0)
            {

            }
            else if (countTapRepair == 1) {
                countTapRepair--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                taprepair.setText(countTapRepair + " Tap Repair");
            } else if (countTapRepair == 2) {
                countTapRepair--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                taprepair.setText(countTapRepair + " Tap Repair");
            } else if (countTapRepair == 3) {
                countTapRepair--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                taprepair.setText(countTapRepair + " Tap Repair");
            } else if (countTapRepair == 4) {
                countTapRepair--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                taprepair.setText(countTapRepair + " Tap Repair");
            } else if (countTapRepair == 5) {
                countTapRepair--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                taprepair.setText(countTapRepair + " Tap Repair");
            }

        }
        else if (v.getId() == R.id.addJet) {
            if (countjetRepair == 0) {
                countjetRepair++;
                total += 250;
                disp.setText("Total : Rs " + total);
                jetRepair.setText(countjetRepair + " Jet Repair");
            } else if (countjetRepair == 1) {
                countjetRepair++;
                total += 100;
                disp.setText("Total : Rs " + total);
                jetRepair.setText(countjetRepair + " Jet Repair");
            } else if (countjetRepair == 2) {
                countjetRepair++;
                total += 75;
                disp.setText("Total : Rs " + total);
                jetRepair.setText(countjetRepair + " Jet Repair");
            } else if (countjetRepair == 3) {
                countjetRepair++;
                total += 50;
                disp.setText("Total : Rs " + total);
                jetRepair.setText(countjetRepair + " Jet Repair");
            } else if (countjetRepair == 4) {
                countjetRepair++;
                total += 50;
                disp.setText("Total : Rs " + total);
                jetRepair.setText(countjetRepair + " Jet Repair & above");
            }
        }
        else if (v.getId() == R.id.minusJet) {
            if (countjetRepair ==0)
            {

            }
            else if (countjetRepair == 1) {
                countjetRepair--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                jetRepair.setText(countjetRepair + " Jet Repair");
            } else if (countjetRepair == 2) {
                countjetRepair--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                jetRepair.setText(countjetRepair + " Jet Repair");
            } else if (countjetRepair == 3) {
                countjetRepair--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                jetRepair.setText(countjetRepair + " Jet Repair");
            } else if (countjetRepair == 4) {
                countjetRepair--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                jetRepair.setText(countjetRepair + " Jet Repair");
            } else if (countjetRepair == 5) {
                countjetRepair--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                jetRepair.setText(countjetRepair + " Jet Repair");
            }

        }
        else if (v.getId() == R.id.addShower) {
            if (countshowerRepair == 0) {
                countshowerRepair++;
                total += 250;
                disp.setText("Total : Rs " + total);
                showerRepair.setText(countshowerRepair + " Shower Repair");
            } else if (countshowerRepair == 1) {
                countshowerRepair++;
                total += 100;
                disp.setText("Total : Rs " + total);
                showerRepair.setText(countshowerRepair + " Shower Repair");
            } else if (countshowerRepair == 2) {
                countshowerRepair++;
                total += 75;
                disp.setText("Total : Rs " + total);
                showerRepair.setText(countshowerRepair + " Shower Repair");
            } else if (countshowerRepair == 3) {
                countshowerRepair++;
                total += 50;
                disp.setText("Total : Rs " + total);
                showerRepair.setText(countshowerRepair + " Shower Repair");
            } else if (countshowerRepair == 4) {
                countshowerRepair++;
                total += 50;
                disp.setText("Total : Rs " + total);
                showerRepair.setText(countshowerRepair + " Shower Repair & above");
            }
        }
        else if (v.getId() == R.id.minusShower) {
            if (countshowerRepair ==0)
            {

            }
            else if (countshowerRepair== 1) {
                countshowerRepair--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                showerRepair.setText(countshowerRepair + " Shower Repair");
            } else if (countshowerRepair == 2) {
                countshowerRepair--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                showerRepair.setText(countshowerRepair + " Shower Repair");
            } else if (countshowerRepair == 3) {
                countshowerRepair--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                showerRepair.setText(countshowerRepair+ " Shower Repair");
            } else if (countshowerRepair == 4) {
                countshowerRepair--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                showerRepair.setText(countshowerRepair + " Shower Repair");
            } else if (countshowerRepair == 5) {
                countshowerRepair--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                showerRepair.setText(countshowerRepair + " Shower Repair");
            }

        }
        else if (v.getId() == R.id.addMixture) {
            if (countwallMixtureRepair == 0) {
                countwallMixtureRepair++;
                total += 350;
                disp.setText("Total : Rs " + total);
                wallMixtureRepair.setText(countwallMixtureRepair + " Wall Mixture Repair");
            } else if (countwallMixtureRepair == 1) {
                countwallMixtureRepair++;
                total += 250;
                disp.setText("Total : Rs " + total);
                wallMixtureRepair.setText(countwallMixtureRepair + " Wall Mixture Repair");
            } else if (countwallMixtureRepair == 2) {
                countwallMixtureRepair++;
                total += 150;
                disp.setText("Total : Rs " + total);
                wallMixtureRepair.setText(countwallMixtureRepair + " Wall Mixture Repair ");
            } else if (countwallMixtureRepair == 3) {
                countwallMixtureRepair++;
                total += 150;
                disp.setText("Total : Rs " + total);
                wallMixtureRepair.setText(countwallMixtureRepair + " Wall Mixture Repair");
            } else if (countwallMixtureRepair == 4) {
                countwallMixtureRepair++;
                total += 150;
                disp.setText("Total : Rs " + total);
                wallMixtureRepair.setText(countwallMixtureRepair + " Wall Mixture Repair & above" );
            }
        }
        else if (v.getId() == R.id.minusMixture) {
            if (countwallMixtureRepair ==0)
            {

            }
            else if (countwallMixtureRepair== 1) {
                countwallMixtureRepair--;
                total -= 350;
                disp.setText("Total : Rs " + total);
                wallMixtureRepair.setText(countwallMixtureRepair + " Wall Mixture Repair");
            } else if (countwallMixtureRepair == 2) {
                countwallMixtureRepair--;
                total -= 200;
                disp.setText("Total : Rs " + total);
                wallMixtureRepair.setText(countwallMixtureRepair + " Wall Mixture Repair");
            } else if (countwallMixtureRepair == 3) {
                countwallMixtureRepair--;
                total -= 150;
                disp.setText("Total : Rs " + total);
                wallMixtureRepair.setText(countwallMixtureRepair+ " Wall Mixture Repair");
            } else if (countwallMixtureRepair == 4) {
                countwallMixtureRepair--;
                total -= 150;
                disp.setText("Total : Rs " + total);
                wallMixtureRepair.setText(countwallMixtureRepair + " Wall Mixture Repair");
            } else if (countwallMixtureRepair == 5) {
                countwallMixtureRepair--;
                total -= 150;
                disp.setText("Total : Rs " + total);
                wallMixtureRepair.setText(countwallMixtureRepair + " Wall Mixture Repair");
            }

        }
        else if (v.getId() == R.id.addTapInstall) {
            if (counttapInstall == 0) {
                counttapInstall++;
                total += 250;
                disp.setText("Total : Rs " + total);
                tapInstall.setText(counttapInstall + " Tap install");
            } else if (counttapInstall == 1) {
                counttapInstall++;
                total += 100;
                disp.setText("Total : Rs " + total);
                tapInstall.setText(counttapInstall + " Tap install");
            } else if (counttapInstall == 2) {
                counttapInstall++;
                total += 75;
                disp.setText("Total : Rs " + total);
                tapInstall.setText(counttapInstall + " Tap install ");
            } else if (counttapInstall == 3) {
                counttapInstall++;
                total += 50;
                disp.setText("Total : Rs " + total);
                tapInstall.setText(counttapInstall + " Tap install");
            } else if (counttapInstall == 4) {
                counttapInstall++;
                total += 50;
                disp.setText("Total : Rs " + total);
                tapInstall.setText(counttapInstall + " Tap install & above");
            }
        }
        else if (v.getId() == R.id.minusTapInstall) {
            if (counttapInstall ==0)
            {

            }
            else if (counttapInstall== 1) {
                counttapInstall--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                tapInstall.setText(counttapInstall + " Tap install");
            } else if (counttapInstall == 2) {
                counttapInstall--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                tapInstall.setText(counttapInstall + " Tap install");
            } else if (counttapInstall == 3) {
                counttapInstall--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                tapInstall.setText(counttapInstall+ " Tap install");
            } else if (counttapInstall == 4) {
                counttapInstall--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                tapInstall.setText(counttapInstall + " Tap install");
            } else if (counttapInstall == 5) {
                counttapInstall--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                tapInstall.setText(counttapInstall + " Tap install");
            }

        }
        else if (v.getId() == R.id.addShowerInstall) {
            if (countshowerInstall == 0) {
                countshowerInstall++;
                total += 250;
                disp.setText("Total : Rs " + total);
                showerInstall.setText(countshowerInstall + " Shower install");
            } else if (countshowerInstall == 1) {
                countshowerInstall++;
                total += 100;
                disp.setText("Total : Rs " + total);
                showerInstall.setText(countshowerInstall + " Shower install");
            } else if (countshowerInstall == 2) {
                countshowerInstall++;
                total += 75;
                disp.setText("Total : Rs " + total);
                showerInstall.setText(countshowerInstall + " Shower install");
            } else if (countshowerInstall == 3) {
                countshowerInstall++;
                total += 50;
                disp.setText("Total : Rs " + total);
                showerInstall.setText(countshowerInstall + " Shower install");
            } else if (countshowerInstall == 4) {
                countshowerInstall++;
                total += 50;
                disp.setText("Total : Rs " + total);
                showerInstall.setText(countshowerInstall + " Shower install & above");
            }
        }
        else if (v.getId() == R.id.minusShowerInstall) {
            if (countshowerInstall ==0)
            {

            }
            else if (countshowerInstall== 1) {
                countshowerInstall--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                showerInstall.setText(countshowerInstall + " Shower install");
            } else if (countshowerInstall == 2) {
                countshowerInstall--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                showerInstall.setText(countshowerInstall + " Shower install");
            } else if (countshowerInstall == 3) {
                countshowerInstall--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                showerInstall.setText(countshowerInstall+ " Shower install");
            } else if (countshowerInstall == 4) {
                countshowerInstall--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                showerInstall.setText(countshowerInstall + " Shower install");
            } else if (countshowerInstall == 5) {
                countshowerInstall--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                showerInstall.setText(countshowerInstall + " Shower install");
            }

        }



        else if (v.getId() == R.id.addJetInstall) {
            if (countjetInstall == 0) {
                countjetInstall++;
                total += 250;
                disp.setText("Total : Rs " + total);
                jetInstall.setText(countjetInstall + " Jet / Handshower Install");
            } else if (countjetInstall == 1) {
                countjetInstall++;
                total += 100;
                disp.setText("Total : Rs " + total);
                jetInstall.setText(countjetInstall + " Jet / Handshower Install");
            } else if (countjetInstall == 2) {
                countjetInstall++;
                total += 75;
                disp.setText("Total : Rs " + total);
                jetInstall.setText(countjetInstall + " Jet / Handshower Install");
            } else if (countjetInstall == 3) {
                countjetInstall++;
                total += 50;
                disp.setText("Total : Rs " + total);
                jetInstall.setText(countjetInstall + " Jet / Handshower Install");
            } else if (countjetInstall == 4) {
                countjetInstall++;
                total += 50;
                disp.setText("Total : Rs " + total);
                jetInstall.setText(countjetInstall + " Jet / Handshower Install & above");
            }
        }
        else if (v.getId() == R.id.minusJetInstall) {
            if (countjetInstall ==0)
            {

            }
            else if (countjetInstall== 1) {
                countjetInstall--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                jetInstall.setText(countjetInstall + " Jet / Handshower Install");
            } else if (countjetInstall == 2) {
                countjetInstall--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                jetInstall.setText(countjetInstall + " Jet / Handshower Install");
            } else if (countjetInstall == 3) {
                countjetInstall--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                jetInstall.setText(countjetInstall+ " Jet / Handshower Install");
            } else if (countjetInstall == 4) {
                countjetInstall--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                jetInstall.setText(countjetInstall + " Jet / Handshower Install");
            } else if (countjetInstall == 5) {
                countjetInstall--;
                total -= 50;
                disp.setText("Total : Rs " + total);
                jetInstall.setText(countjetInstall+ " Jet / Handshower Install");
            }

        }




        else if (v.getId() == R.id.addMixtureInstall) {
            if (countmixtureTapInstall == 0) {
                countmixtureTapInstall++;
                total += 350;
                disp.setText("Total : Rs " + total);
                mixtureTapInstall.setText(countmixtureTapInstall + " Mixture Tap Install");
            } else if (countmixtureTapInstall == 1) {
                countmixtureTapInstall++;
                total += 250;
                disp.setText("Total : Rs " + total);
                mixtureTapInstall.setText(countmixtureTapInstall + " Mixture Tap Install");
            } else if (countmixtureTapInstall == 2) {
                countmixtureTapInstall++;
                total += 150;
                disp.setText("Total : Rs " + total);
                mixtureTapInstall.setText(countmixtureTapInstall + " Mixture Tap Install");
            } else if (countmixtureTapInstall == 3) {
                countmixtureTapInstall++;
                total += 150;
                disp.setText("Total : Rs " + total);
                mixtureTapInstall.setText(countmixtureTapInstall + " Mixture Tap Install");
            } else if (countmixtureTapInstall == 4) {
                countmixtureTapInstall++;
                total += 150;
                disp.setText("Total : Rs " + total);
                mixtureTapInstall.setText(countmixtureTapInstall + " Mixture Tap Install & above");
            }
        }
        else if (v.getId() == R.id.minusMixtureInstall) {
            if (countmixtureTapInstall == 0) {

            } else if (countmixtureTapInstall == 1) {
                countmixtureTapInstall--;
                total -= 350;
                disp.setText("Total : Rs " + total);
                mixtureTapInstall.setText(countmixtureTapInstall + " Mixture Tap Install");
            } else if (countmixtureTapInstall == 2) {
                countmixtureTapInstall--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                mixtureTapInstall.setText(countmixtureTapInstall + " Mixture Tap Install");
            } else if (countmixtureTapInstall == 3) {
                countmixtureTapInstall--;
                total -= 150;
                disp.setText("Total : Rs " + total);
                mixtureTapInstall.setText(countmixtureTapInstall + " Mixture Tap Install");
            } else if (countmixtureTapInstall == 4) {
                countmixtureTapInstall--;
                total -= 150;
                disp.setText("Total : Rs " + total);
                mixtureTapInstall.setText(countmixtureTapInstall + " Mixture Tap Install");
            } else if (countmixtureTapInstall == 5) {
                countmixtureTapInstall--;
                total -= 150;
                disp.setText("Total : Rs " + total);
                mixtureTapInstall.setText(countmixtureTapInstall + " Mixture Tap Install");
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
