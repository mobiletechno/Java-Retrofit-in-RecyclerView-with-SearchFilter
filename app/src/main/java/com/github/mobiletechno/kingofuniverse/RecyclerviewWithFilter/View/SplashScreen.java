package com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.Custom.MyApp.Constant;
import com.github.mobiletechno.kingofuniverse.RecyclerviewWithFilter.R;

/**
 * Created by A.Rajkumar on 18/08/2020.
 */
public class SplashScreen extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        TextView creatername = (TextView) findViewById(R.id.creatorTV);
        creatername.setText(Constant.CREATOR);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}