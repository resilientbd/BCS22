package com.rubel.rubelrana.bcs2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BcsmainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT =4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcsmain);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent r = new Intent(BcsmainActivity.this,SelectSubActivity.class);
                startActivity(r);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
