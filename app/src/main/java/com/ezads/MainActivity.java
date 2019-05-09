package com.ezads;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ezads.Interface.HashTagInterface;
import com.ezads.Pojo.HashTagsList;
import com.ezads.Retrofit.ApiClient;
import com.ezads.Sqllite.DbAdapter;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    CountDownTimer time;
    DbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        handler = new Handler();
        helper = new DbAdapter(this);
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
        fetchHahTags();
    }

    public void fetchHahTags(){
        //final DbAdapter dbAdapter = new DbAdapter(this);
        Retrofit retrofit = ApiClient.getRetrofitClient();
        HashTagInterface hashTags = retrofit.create(HashTagInterface.class);

        String version = helper.fetchVersion();
        if(version.equalsIgnoreCase("")){
            version = "initial";
        }
        Call<HashTagsList> call = hashTags.getHashtags(version);
        call.enqueue(new Callback<HashTagsList>() {
            @Override
            public void onResponse(Call<HashTagsList> call, Response<HashTagsList> response) {
                /*This is the success callback. Though the response type is JSON, with Retrofit we get the response in the form of WResponse POJO class
                 */
                if (response.body() != null) {
                    HashTagsList hashTagRes = response.body();
                    if(hashTagRes.getHashTags()!=null){
                        helper.loadWords(hashTagRes.getHashTags(),hashTagRes.getVersionName());
                    }

                }
            }
            @Override
            public void onFailure(Call<HashTagsList> call, Throwable t) {
                String errorType="";
                String errorDesc="";
                if (t instanceof IOException) {
                    errorType = "Timeout";
                    errorDesc = String.valueOf(t.getCause());
                }
                else if (t instanceof IllegalStateException) {
                    errorType = "ConversionError";
                    errorDesc = String.valueOf(t.getCause());
                } else {
                    errorType = "Other Error";
                    errorDesc = String.valueOf(t.getLocalizedMessage());
                }
            }
        });


    }
}
