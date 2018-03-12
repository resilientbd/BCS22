package com.rubel.rubelrana.bcs2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class SelectSubActivity extends AppCompatActivity {
    private Button selct,practice,exam,about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sub);
        practice = (Button) findViewById(R.id.pracid);
        exam = (Button) findViewById(R.id.examid);
        about = (Button) findViewById(R.id.aboutid);
        selct = (Button)findViewById(R.id.slct2);
        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pr = new Intent(SelectSubActivity.this,PracticeActivity.class);
                startActivity(pr);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ab = new Intent(SelectSubActivity.this,aboutActivity.class);
                startActivity(ab);
            }
        });
        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ex = new Intent(SelectSubActivity.this,ExamActivity.class);
                startActivity(ex);
            }
        });
        selct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(SelectSubActivity.this,selct);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getTitle().equals("বাংলা"))
                        {
                            Intent intent=new Intent(SelectSubActivity.this,Main2Activity.class);
                            startActivity(intent);
                        }
                       else if(item.getTitle().equals("ইংরেজী"))
                        {
                            Intent intent=new Intent(SelectSubActivity.this,englishActivity.class);
                            startActivity(intent);
                        }
                        else if(item.getTitle().equals("গনিত"))
                        {
                            Intent intent=new Intent(SelectSubActivity.this,MathActivity.class);
                            startActivity(intent);
                        }
                        else if(item.getTitle().equals("বিজ্ঞান"))
                        {
                            Intent intent=new Intent(SelectSubActivity.this,scienceActivity.class);
                            startActivity(intent);
                        }
                        else if(item.getTitle().equals("সংবিধান"))
                        {
                            Intent intent=new Intent(SelectSubActivity.this,constritutionActivity.class);
                            startActivity(intent);
                        }
                        else if(item.getTitle().equals("আন্তর্জাতিক"))
                        {
                            Intent intent=new Intent(SelectSubActivity.this,gkActivity.class);
                            startActivity(intent);
                        }
                        Toast.makeText(SelectSubActivity.this,"You clicked:"+ item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}
