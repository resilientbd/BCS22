package com.rubel.rubelrana.bcs2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button bngl;
    private Button eng;
    private Button cont;
    private Button math;
    private Button gk;
    private Button scnce;
    private Button exm;
    private Button about;
    private Button exit;
    private TextView top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gk = (Button) findViewById(R.id.bt4);
        bngl = (Button) findViewById(R.id.bt1);
        scnce = (Button) findViewById(R.id.bt9);
        cont = (Button) findViewById(R.id.bt5);
        math = (Button) findViewById(R.id.bt3);
        eng = (Button) findViewById(R.id.bt2);
        about = (Button) findViewById(R.id.bt7);
        exm = (Button) findViewById(R.id.bt6);
        exit = (Button) findViewById(R.id.bt8);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(getApplicationContext(),aboutActivity.class);
                startActivity(o);
            }
        });
        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(getApplicationContext(),englishActivity.class);
                startActivity(n);
            }
        });
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(getApplicationContext(),MathActivity.class);
                startActivity(m);
            }
        });
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(getApplicationContext(),constritutionActivity.class);
                startActivity(l);
            }
        });
        scnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(getApplicationContext(),scienceActivity.class);
                startActivity(k);
            }
        });
        bngl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });
        gk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent j = new Intent(getApplicationContext(),gkActivity.class);
                        startActivity(j);
                    }
        });
        exm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(getApplicationContext(),SelectSubActivity.class);
                startActivity(p);
            }
        });

    }
}
