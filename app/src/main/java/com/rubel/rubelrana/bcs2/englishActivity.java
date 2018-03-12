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

public class englishActivity extends AppCompatActivity {
    private Button eng1,eng2,eng3,eng4,next;
    private TextView score,qu;
    private englishq mQuestion = new englishq();
    private String mAnswer;
    private int mScore=0;
    private int menglishqLength = mQuestion.mQuestion.length;
    Random r;
    String alertTitle;
    private int Questioncount = 0;
    static final private int Question =20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        r = new Random();

        eng1 = (Button) findViewById(R.id.ans1);
        eng2 = (Button) findViewById(R.id.ans2);
        eng3 = (Button) findViewById(R.id.ans3);
        eng4 = (Button) findViewById(R.id.ans4);
        score = (TextView) findViewById(R.id.score);
        qu = (TextView) findViewById(R.id.qu);
        score.setText("Score: " + mScore);
        updateQuestion(r.nextInt(menglishqLength));
        final MediaPlayer mp = MediaPlayer.create(englishActivity.this,R.raw.correct_sky);
        final MediaPlayer mw = MediaPlayer.create(englishActivity.this,R.raw.wrong_sky);
        next=(Button) findViewById(R.id.nextBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(englishActivity.this,englishActivity.class);
               startActivity(i);
               finish();
                }
        });
        eng1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (eng1.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                   // updateQuestion(r.nextInt(menglishqLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                    //updateQuestion(r.nextInt(menglishqLength));
                   // gameOver();
                }
                checkAns(isAnsCorrect,eng1);
                checkCorrectAns();
            }
        });

        eng2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (eng2.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    //updateQuestion(r.nextInt(menglishqLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                    //updateQuestion(r.nextInt(menglishqLength));
                   // gameOver();
                }
                checkAns(isAnsCorrect,eng2);
                checkCorrectAns();
            }
        });
        eng3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (eng3.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    //updateQuestion(r.nextInt(menglishqLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                   // updateQuestion(r.nextInt(menglishqLength));
                   // gameOver();
                }
                checkAns(isAnsCorrect,eng3);
                checkCorrectAns();
            }
        });
        eng4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (eng4.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    //updateQuestion(r.nextInt(menglishqLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                    //updateQuestion(r.nextInt(menglishqLength));
                    //gameOver();
                }
                checkAns(isAnsCorrect,eng4);
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
        String s=eng1.getText().toString();
        String s2=eng2.getText().toString();
        String s3=eng3.getText().toString();
        String s4=eng4.getText().toString();
        if(s.equals(mAnswer))
            eng1.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s2.equals(mAnswer))
            eng2.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s3.equals(mAnswer))
            eng3.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s4.equals(mAnswer))
            eng4.setBackgroundColor(getResources().getColor(R.color.colorlime));
    }

    private void updateQuestion(int num) {
        qu.setText(mQuestion.getQuestion(num));
        eng1.setText(mQuestion.getChoice1(num));
        eng2.setText(mQuestion.getChoice2(num));
        eng3.setText(mQuestion.getChoice3(num));
        eng4.setText(mQuestion.getChoice4(num));
        mAnswer = mQuestion.getCorrectAnswer(num);
    }
    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(englishActivity.this);
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
