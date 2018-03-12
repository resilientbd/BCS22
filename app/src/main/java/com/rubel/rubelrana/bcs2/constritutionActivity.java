package com.rubel.rubelrana.bcs2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class constritutionActivity extends AppCompatActivity {
    private Button cons1,cons2,cons3,cons4,next;
    private TextView score,qu;
    private constritutionq mQuestion = new constritutionq();
    private String mAnswer;
    private int mScore=0;
    private int mconstritutionqLength = mQuestion.mQuestion.length;
    Random r;
    String alertTitle;
    private int Questioncount = 0;
    static final private int Question =20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constritution);

        r = new Random();

        cons1 = (Button) findViewById(R.id.ans1);
        cons2 = (Button) findViewById(R.id.ans2);
        cons3 = (Button) findViewById(R.id.ans3);
        cons4 = (Button) findViewById(R.id.ans4);
        score = (TextView) findViewById(R.id.score);
        qu = (TextView) findViewById(R.id.qu);
        score.setText("Score: " + mScore);
        updateQuestion(r.nextInt(mconstritutionqLength));
        next=(Button) findViewById(R.id.nextBtn);
        final MediaPlayer mp = MediaPlayer.create(constritutionActivity.this,R.raw.correct_sky);
        final MediaPlayer mw = MediaPlayer.create(constritutionActivity.this,R.raw.wrong_sky);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),constritutionActivity.class);
                startActivity(intent);
                finish();
            }
        });
        cons1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (cons1.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    //updateQuestion(r.nextInt(mconstritutionqLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                   // updateQuestion(r.nextInt(mconstritutionqLength));
                    //gameOver();
                }
                checkAns(isAnsCorrect,cons1);
                checkCorrectAns();
            }
        });

        cons2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (cons2.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    //updateQuestion(r.nextInt(mconstritutionqLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                   // updateQuestion(r.nextInt(mconstritutionqLength));
                  //  gameOver();
                }
                checkAns(isAnsCorrect,cons2);
                checkCorrectAns();
            }
        });
        cons3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (cons3.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                   // updateQuestion(r.nextInt(mconstritutionqLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                    //updateQuestion(r.nextInt(mconstritutionqLength));
                   // gameOver();
                }
                checkAns(isAnsCorrect,cons3);
                checkCorrectAns();
            }
        });
        cons4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (cons4.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    //updateQuestion(r.nextInt(mconstritutionqLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                   // updateQuestion(r.nextInt(mconstritutionqLength));
                   // gameOver();
                }
                checkAns(isAnsCorrect,cons4);
                checkCorrectAns();
            }

        });
    }
    private boolean checkAns(boolean isCorrect,Button button)
    {
        boolean flag=false;
        if(isCorrect==false)
            button.setBackgroundColor(getResources().getColor(R.color.colorred));
        if(isCorrect==true)
            button.setBackgroundColor(getResources().getColor(R.color.colorlime));
        return flag;
    }
    private void checkCorrectAns()
    {
        String s=cons1.getText().toString();
        String s2=cons2.getText().toString();
        String s3=cons3.getText().toString();
        String s4=cons4.getText().toString();
        if(s.equals(mAnswer))
            cons1.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s2.equals(mAnswer))
            cons2.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s3.equals(mAnswer))
            cons3.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s4.equals(mAnswer))
            cons4.setBackgroundColor(getResources().getColor(R.color.colorlime));
    }

    private void updateQuestion(int num) {
        qu.setText(mQuestion.getQuestion(num));
        cons1.setText(mQuestion.getChoice1(num));
        cons2.setText(mQuestion.getChoice2(num));
        cons3.setText(mQuestion.getChoice3(num));
        cons4.setText(mQuestion.getChoice4(num));
        mAnswer = mQuestion.getCorrectAnswer(num);
    }
    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(constritutionActivity.this);
        alertDialogBuilder
                .setMessage("game Over ! Your score is" + mScore + "point.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                            }
                        })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }


                        });
    }

}
