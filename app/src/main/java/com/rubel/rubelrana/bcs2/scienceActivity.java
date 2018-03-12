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

public class scienceActivity extends AppCompatActivity {
    private Button sc1,sc2,sc3,sc4,next;
    private TextView score,qu;
    private scienceq mQuestion= new scienceq();
    private String mAnswer;
    private int mScore=0;
    private int mscienceqLength = mQuestion.mQuestion.length;
    Random r;
    String alertTitle;
    private int Questioncount = 0;
    static final private int Question =20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);
        r = new Random();

        sc1 = (Button) findViewById(R.id.ans1);
        sc2 = (Button) findViewById(R.id.ans2);
        sc3 = (Button) findViewById(R.id.ans3);
        sc4 = (Button) findViewById(R.id.ans4);
        score = (TextView) findViewById(R.id.score);
        qu = (TextView) findViewById(R.id.qu);
        score.setText("Score: " + mScore);
        updateQuestion(r.nextInt(mscienceqLength));
        final MediaPlayer mp = MediaPlayer.create(scienceActivity.this,R.raw.correct_sky);
        final MediaPlayer mw = MediaPlayer.create(scienceActivity.this,R.raw.wrong_sky);
        next=(Button) findViewById(R.id.nextBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(scienceActivity.this,scienceActivity.class);
                startActivity(intent);
                finish();
            }
        });

        sc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (sc1.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    //updateQuestion(r.nextInt(mscienceqLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                    //updateQuestion(r.nextInt(mscienceqLength));
                    //gameOver();
                }
                checkAns(isAnsCorrect,sc1);
                checkCorrectAns();
            }
        });

        sc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (sc2.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                   // updateQuestion(r.nextInt(mscienceqLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                   // updateQuestion(r.nextInt(mscienceqLength));
                    //gameOver();
                }
                checkAns(isAnsCorrect,sc2);
                checkCorrectAns();
            }
        });
        sc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (sc3.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                   // updateQuestion(r.nextInt(mscienceqLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                    //updateQuestion(r.nextInt(mscienceqLength));
                   // gameOver();
                }
                checkAns(isAnsCorrect,sc3);
                checkCorrectAns();
            }
        });
        sc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (sc4.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    //updateQuestion(r.nextInt(mscienceqLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                   // updateQuestion(r.nextInt(mscienceqLength));
                    //gameOver();
                }
                checkAns(isAnsCorrect,sc4);
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
        String s=sc1.getText().toString();
        String s2=sc2.getText().toString();
        String s3=sc3.getText().toString();
        String s4=sc4.getText().toString();
        if(s.equals(mAnswer))
            sc1.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s2.equals(mAnswer))
            sc2.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s3.equals(mAnswer))
            sc3.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s4.equals(mAnswer))
            sc4.setBackgroundColor(getResources().getColor(R.color.colorlime));
    }

    private void updateQuestion(int num) {
        qu.setText(mQuestion.getQuestion(num));
        sc1.setText(mQuestion.getChoice1(num));
        sc2.setText(mQuestion.getChoice2(num));
        sc3.setText(mQuestion.getChoice3(num));
        sc4.setText(mQuestion.getChoice4(num));
        mAnswer = mQuestion.getCorrectAnswer(num);
    }
    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(scienceActivity.this);
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
