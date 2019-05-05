package com.ezads;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    CountDownTimer time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        handler = new Handler();
        time=new CountDownTimer(4000,200) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(getApplicationContext(), menu.class);
                        startActivity(i);
                        finish();
                    }
                });

            }
        }.start();

    }
}
