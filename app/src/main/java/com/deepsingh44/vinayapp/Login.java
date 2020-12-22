package com.deepsingh44.vinayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText tid, tname;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new Database(this);
        tid = findViewById(R.id.email);
        tname = findViewById(R.id.pass);
    }

    public void login(View view) {
        Employee employee = db.login(Integer.parseInt(tid.getText().toString()), tname.getText().toString());
        if (employee != null) {
            SharedPreferences.Editor et = ((SingleTask)getApplication()).getSharedPreferences().edit();
            et.putBoolean("status", true);
            et.commit();
            startActivity(new Intent(this,MainActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Failed Login", Toast.LENGTH_SHORT).show();
        }

    }
}