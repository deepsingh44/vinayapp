package com.deepsingh44.vinayapp;

import android.app.Application;
import android.content.SharedPreferences;

public class SingleTask extends Application {
    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = getSharedPreferences("session", MODE_PRIVATE);
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
