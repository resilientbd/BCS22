package com.rubel.rubelrana.bcs2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ExamActivity extends AppCompatActivity {
    private Button ex1,ex2,ex3,ex4,next;
    private TextView score,qu;
    private examq mQuestion = new examq();
    private String mAnswer;
    private double mScore=0;
    private int mexamlength = mQuestion.mQuestion.length;
    Random r;
    String alertTitle;
    private int Questioncount = 0;
    static final private int Question =20;
    int count;
    private double nScore =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        count = 0;
        r = new Random();
        ex1 = (Button) findViewById(R.id.ans1);
        ex2 = (Button) findViewById(R.id.ans2);
        ex3 = (Button) findViewById(R.id.ans3);
        ex4 = (Button) findViewById(R.id.ans4);
        score = (TextView) findViewById(R.id.score);
        qu = (TextView) findViewById(R.id.qu);
        score.setText("Score: " + mScore);
        updateQuestion(r.nextInt(mexamlength++));
        final MediaPlayer mp = MediaPlayer.create(ExamActivity.this,R.raw.correct_sky);
        final MediaPlayer mw = MediaPlayer.create(ExamActivity.this,R.raw.wrong_sky);
        next=(Button) findViewById(R.id.nextBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count==50){
                    Snackbar.make(view,"Game Over",Snackbar.LENGTH_LONG)
                            .setAction("Action",null).show();
                }else{
                    ex1.setBackgroundColor(getResources().getColor(R.color.colorbtn));
                    ex2.setBackgroundColor(getResources().getColor(R.color.colorbtn));
                    ex3.setBackgroundColor(getResources().getColor(R.color.colorbtn));
                    ex4.setBackgroundColor(getResources().getColor(R.color.colorbtn));
                    updateQuestion(r.nextInt(mexamlength));
                    count++;
                }

            }
        });
        ex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (ex1.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore=mScore+1;
                    updatdScore(mScore);
                  // updateQuestion(r.nextInt(mexamlength ++));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore=mScore-.25;
                    updatdScore(mScore);
                 //  updateQuestion(r.nextInt(mexamlength ++));
                    //gameOver();
                }
                checkAns(isAnsCorrect,ex1);
                checkCorrectAns();
            }


        });

        ex2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (ex2.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore=mScore+1;
                    updatdScore(mScore);
                // updateQuestion(r.nextInt(mexamlength ++));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore=mScore-.25;
                    updatdScore(mScore);
                  // updateQuestion(r.nextInt(mexamlength ++));
                    // gameOver();
                }
                checkAns(isAnsCorrect,ex2);
                checkCorrectAns();

            }
        });
        ex3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (ex3.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore=mScore+1;
                    updatdScore(mScore);
                   // updateQuestion(r.nextInt(mexamlength ++));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore=mScore-.25;
                    updatdScore(mScore);
                  //  updateQuestion(r.nextInt(mexamlength ++));
                    // gameOver();
                }
                checkAns(isAnsCorrect,ex3);
                checkCorrectAns();
            }
        });
        ex4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (ex4.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore=mScore+1;
                    updatdScore(mScore);
                  //  updateQuestion(r.nextInt(mexamlength ++));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore=mScore-.25;
                    updatdScore(mScore);
                    //updateQuestion(r.nextInt(mexamlength ++));
                    // gameOver();
                }
                checkAns(isAnsCorrect,ex4);
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
        String s=ex1.getText().toString();
        String s2=ex2.getText().toString();
        String s3=ex3.getText().toString();
        String s4=ex4.getText().toString();
        if(s.equals(mAnswer))
            ex1.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s2.equals(mAnswer))
            ex2.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s3.equals(mAnswer))
            ex3.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s4.equals(mAnswer))
            ex4.setBackgroundColor(getResources().getColor(R.color.colorlime));
    }


    private void updateQuestion(int num) {
        qu.setText(mQuestion.getQuestion(num));
        ex1.setText(mQuestion.getChoice1(num));
        ex2.setText(mQuestion.getChoice2(num));
        ex3.setText(mQuestion.getChoice3(num));
        ex4.setText(mQuestion.getChoice4(num));
        mAnswer = mQuestion.getCorrectAnswer(num);
    }
    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ExamActivity.this);
        alertDialogBuilder
                .setMessage("game Over ! Your score is" + mScore + "point.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                startActivity(new Intent(getApplicationContext(), ExamActivity.class));

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
    private void updatdScore(double point){
        score.setText("" + mScore);
    }

}
