package com.example.student.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Main extends AppCompatActivity {
public static final int SPLASH_TIME_OUT=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView=(TextView)findViewById(R.id.textView);
        textView.setTranslationY(-3000f);
        textView.animate().translationYBy(3000f).setDuration(2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i=new Intent(Main.this,MainActivity.class);
               finish();
            }
        },SPLASH_TIME_OUT);
    }
}
