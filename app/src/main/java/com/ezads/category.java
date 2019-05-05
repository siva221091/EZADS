package com.ezads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

    }
    //insert here;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Toast.makeText(this,"back key is pressed", Toast.LENGTH_SHORT).show();

    }

}

