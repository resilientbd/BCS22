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

public class gkActivity extends AppCompatActivity {
    private Button gk1,gk2,gk3,gk4,next;
    private TextView score,qu;
    private knowledge mQuestion = new knowledge();
    private String mAnswer;
    private int mScore=0;
    private int mknowledgeLength = mQuestion.mQuestion.length;
    Random r;
    String alertTitle;
    private int Questioncount = 0;
    static final private int Question =20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gk);
        r = new Random();

        gk1 = (Button) findViewById(R.id.ans1);
        gk2 = (Button) findViewById(R.id.ans2);
        gk3 = (Button) findViewById(R.id.ans3);
        gk4 = (Button) findViewById(R.id.ans4);
        score = (TextView) findViewById(R.id.score);
        qu = (TextView) findViewById(R.id.qu);
        score.setText("Score: " + mScore);
        updateQuestion(r.nextInt(mknowledgeLength));
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.correct_sky);
        final MediaPlayer mw = MediaPlayer.create(this,R.raw.wrong_sky);
        next=(Button) findViewById(R.id.nextBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(gkActivity.this,gkActivity.class);
                startActivity(intent7);
                finish();
            }
        });
        gk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (gk1.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    //updateQuestion(r.nextInt(mknowledgeLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                    //updateQuestion(r.nextInt(mknowledgeLength));
                    //gameOver();
                }
                checkAns(isAnsCorrect,gk1);
                checkCorrectAns();
            }
        });

        gk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (gk2.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                   // updateQuestion(r.nextInt(mknowledgeLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                   // updateQuestion(r.nextInt(mknowledgeLength));
                   // gameOver();
                }
                checkAns(isAnsCorrect,gk2);
                checkCorrectAns();
            }
        });
        gk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (gk3.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    //updateQuestion(r.nextInt(mknowledgeLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                   // updateQuestion(r.nextInt(mknowledgeLength));
                   // gameOver();
                }
                checkAns(isAnsCorrect,gk3);
                checkCorrectAns();
            }
        });
        gk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (gk4.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    //updateQuestion(r.nextInt(mknowledgeLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                    //updateQuestion(r.nextInt(mknowledgeLength));
                   // gameOver();
                }
                checkAns(isAnsCorrect,gk4);
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
        String s=gk1.getText().toString();
        String s2=gk2.getText().toString();
        String s3=gk3.getText().toString();
        String s4=gk4.getText().toString();
        if(s.equals(mAnswer))
            gk1.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s2.equals(mAnswer))
            gk2.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s3.equals(mAnswer))
            gk3.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s4.equals(mAnswer))
            gk4.setBackgroundColor(getResources().getColor(R.color.colorlime));
    }

    private void updateQuestion(int num) {
        qu.setText(mQuestion.getQuestion(num));
        gk1.setText(mQuestion.getChoice1(num));
        gk2.setText(mQuestion.getChoice2(num));
        gk3.setText(mQuestion.getChoice3(num));
        gk4.setText(mQuestion.getChoice4(num));
        mAnswer = mQuestion.getCorrectAnswer(num);
    }
    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(gkActivity.this);
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
