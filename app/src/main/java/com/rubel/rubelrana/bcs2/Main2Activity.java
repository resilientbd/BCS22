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

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    private Button ans1,ans2,ans3,ans4,next;
    private TextView score,qu;
    private Questions mQuestion = new Questions();
    private String mAnswer;
    private int mScore=0;
    private int mQuestionsLength = mQuestion.mQuestion.length;
    Random r;
    String alertTitle;
    private int Questioncount = 0;
    static final private int Question =20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        r = new Random();

        ans1 = (Button) findViewById(R.id.ans1);
        ans2 = (Button) findViewById(R.id.ans2);
        ans3 = (Button) findViewById(R.id.ans3);
        ans4 = (Button) findViewById(R.id.ans4);
        score = (TextView) findViewById(R.id.score);
        qu = (TextView) findViewById(R.id.qu);
        score.setText("Score: " + mScore);
        updateQuestion(r.nextInt(mQuestionsLength));
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.correct_sky);
        final MediaPlayer mw = MediaPlayer.create(this, R.raw.wrong_sky);
        next = (Button) findViewById(R.id.nextBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(Main2Activity.this, Main2Activity.class);
                startActivity(intent7);
                updateScore(mScore);
                finish();
            }
        });
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect = false;
                if (ans1.getText() == mAnswer) {
                    mp.start();
                    score.setText("Score: " + mScore);
                    //updateQuestion(r.nextInt(mQuestionsLength));
                    isAnsCorrect = true;
                } else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    mScore--;
                    //     updateQuestion(r.nextInt(mQuestionsLength));
                    //  gameOver();
                }
                checkAns(isAnsCorrect, ans1);
                checkCorrectAns();
            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect = false;
                if (ans2.getText() == mAnswer) {
                    mp.start();
                    mScore++;
                    score.setText("Score: " + mScore);
                    // updateQuestion(r.nextInt(mQuestionsLength));
                    isAnsCorrect = true;
                } else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    mScore--;
                    // updateQuestion(r.nextInt(mQuestionsLength));
                    //  gameOver();

                }
                checkAns(isAnsCorrect, ans2);
                checkCorrectAns();
            }
        });
        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect = false;
                if (ans3.getText() == mAnswer) {
                    mp.start();
                    mScore++;
                    score.setText("Score: " + mScore);
                    // updateQuestion(r.nextInt(mQuestionsLength));
                    isAnsCorrect = true;
                } else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    mScore--;
                    // updateQuestion(r.nextInt(mQuestionsLength));
                    //  gameOver();

                }
                checkAns(isAnsCorrect, ans3);
                checkCorrectAns();
            }
        });
        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect = false;
                if (ans4.getText() == mAnswer) {
                    mp.start();
                    mScore++;
                    score.setText("Score: " + mScore);
                    // updateQuestion(r.nextInt(mQuestionsLength));
                    isAnsCorrect = true;
                } else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    mScore--;
                    // updateQuestion(r.nextInt(mQuestionsLength));
                    //  gameOver();

                }
                checkAns(isAnsCorrect, ans4);
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
        String s=ans1.getText().toString();
        String s2=ans2.getText().toString();
        String s3=ans3.getText().toString();
        String s4=ans4.getText().toString();
        if(s.equals(mAnswer))
            ans1.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s2.equals(mAnswer))
            ans2.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s3.equals(mAnswer))
            ans3.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s4.equals(mAnswer))
            ans4.setBackgroundColor(getResources().getColor(R.color.colorlime));
    }

    private void updateQuestion(int num) {
        qu.setText(mQuestion.getQuestion(num));
        ans1.setText(mQuestion.getChoice1(num));
        ans2.setText(mQuestion.getChoice2(num));
        ans3.setText(mQuestion.getChoice3(num));
        ans4.setText(mQuestion.getChoice4(num));
        mAnswer = mQuestion.getCorrectAnswer(num);
       Questioncount++;
    }
    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Main2Activity.this);
        alertDialogBuilder
                .setMessage("game Over ! Your score is" + mScore + "point")
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
    private void updateScore(int point){
        score.setText("Score" + mScore);
    }
}
