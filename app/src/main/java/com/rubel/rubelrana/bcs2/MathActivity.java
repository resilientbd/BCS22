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

public class MathActivity extends AppCompatActivity {
    private Button ma1,ma2,ma3,ma4;
    private TextView score,qu;
    private mathq mQuestion = new mathq();
    private String mAnswer;
    private int mScore=0;
    private int mmathqLength = mQuestion.mQuestion.length;
    Random r;
    String alertTitle;
    Button next;
    private int Questioncount = 0;
    static final private int Question =20;
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_math);
        r = new Random();

        ma1 = (Button) findViewById(R.id.ans1);
        ma2 = (Button) findViewById(R.id.ans2);
        ma3 = (Button) findViewById(R.id.ans3);
        ma4 = (Button) findViewById(R.id.ans4);
        score = (TextView) findViewById(R.id.score);
        qu = (TextView) findViewById(R.id.qu);
        score.setText("Score: " + mScore);
        updateQuestion(r.nextInt(mmathqLength));
        final MediaPlayer mp = MediaPlayer.create(MathActivity.this,R.raw.correct_sky);
        final MediaPlayer mw = MediaPlayer.create(MathActivity.this,R.raw.wrong_sky);
        next=(Button) findViewById(R.id.nextBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MathActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ma1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (ma1.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    isAnsCorrect=true;
                    //updateQuestion(r.nextInt(mmathqLength));
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                  //  updateQuestion(r.nextInt(mmathqLength));
                    //gameOver();
                }
                checkAns(isAnsCorrect,ma1);

                   // ma1.setBackgroundColor(getResources().getColor(R.color.defaultcolor));
                 //   updateQuestion(r.nextInt(mmathqLength));
                checkCorrectAns();

            }
        });

        ma2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (ma2.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    isAnsCorrect=true;
                   // updateQuestion(r.nextInt(mmathqLength));
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                  //  updateQuestion(r.nextInt(mmathqLength));
                    //gameOver();
                }
                checkAns(isAnsCorrect,ma2);
                checkCorrectAns();
            }
        });
        ma3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (ma3.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    isAnsCorrect=true;
                    //updateQuestion(r.nextInt(mmathqLength));
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
                    //updateQuestion(r.nextInt(mmathqLength));
                   // gameOver();
                }
                checkAns(isAnsCorrect,ma3);
                checkCorrectAns();
            }
        });
        ma4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnsCorrect=false;
                if (ma4.getText() == mAnswer) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score: " + mScore);
                    //updateQuestion(r.nextInt(mmathqLength));
                    isAnsCorrect=true;
                }else {
                    mw.start();
                    Vibrator v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_SHORT).show();
                    mScore--;
//                    updateQuestion(r.nextInt(mmathqLength));
                    //gameOver();
                }
                checkAns(isAnsCorrect,ma4);
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
        String s=ma1.getText().toString();
        String s2=ma2.getText().toString();
        String s3=ma3.getText().toString();
        String s4=ma4.getText().toString();
        if(s.equals(mAnswer))
            ma1.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s2.equals(mAnswer))
            ma2.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s3.equals(mAnswer))
            ma3.setBackgroundColor(getResources().getColor(R.color.colorlime));
        else if(s4.equals(mAnswer))
            ma4.setBackgroundColor(getResources().getColor(R.color.colorlime));
    }
    private void updateQuestion(int num) {
        qu.setText(mQuestion.getQuestion(num));
        ma1.setText(mQuestion.getChoice1(num));
        ma2.setText(mQuestion.getChoice2(num));
        ma3.setText(mQuestion.getChoice3(num));
        ma4.setText(mQuestion.getChoice4(num));
        mAnswer = mQuestion.getCorrectAnswer(num);
    }
    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MathActivity.this);
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
