package com.midhun.hawkssolutions.transport.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.midhun.hawkssolutions.transport.R;
import com.midhun.hawkssolutions.transport.Utils.MidhunUtils;

public class SplashActivity extends AppCompatActivity {
String UID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        UID= MidhunUtils.localData(SplashActivity.this,"login","UID");
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(UID.isEmpty()){
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    finish();
                }
                else{
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                    finish();
                }
            }
        },1500);

    }
}