package com.atry.pingme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread thread= new Thread() {
            @Override
            public void run() {
                try{
                    sleep(2000);
                }

                catch(Exception e){
                    e.printStackTrace();
                }

                finally {
                    Intent mainIntent = new Intent(SplashScreenActivity.this, StartActivity.class);
                    startActivity(mainIntent);
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
    }

