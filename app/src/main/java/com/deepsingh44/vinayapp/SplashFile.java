package com.deepsingh44.vinayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashFile extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_file);
        sharedPreferences = ((SingleTask)getApplication()).getSharedPreferences();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        ImageView im = findViewById(R.id.image);

        im.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                boolean status = sharedPreferences.getBoolean("status", false);
                if (status) {
                    Intent in = new Intent(SplashFile.this, MainActivity.class);
                    startActivity(in);
                    finish();
                } else {
                    Intent in = new Intent(SplashFile.this, Login.class);
                    startActivity(in);
                    finish();
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}