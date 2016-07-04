package com.example.suleman.townseva;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;


public class SplashActivity extends Activity {

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.pref_name), MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                if (sharedPreferences.getString(getResources().getString(R.string.pref_user_id_key), null) == null)
//                {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
//                } else {
//                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
            }
        }, 3000);


    }
}
