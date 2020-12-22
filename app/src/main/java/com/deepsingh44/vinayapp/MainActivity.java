package com.deepsingh44.vinayapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Database db;
    EditText tid, tname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Database(this);
        tid = findViewById(R.id.id);
        tname = findViewById(R.id.name);

    }

    public void addEmployee(View view) {
        Employee e = new Employee();
        e.setId(Integer.parseInt(tid.getText().toString()));
        e.setName(tname.getText().toString());
        long l = db.insert(e);
        if (l > 0) {
            Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
        }
    }

    public void removeEmployee(View view) {
        //Employee employee=db.getEmployee(Integer.parseInt(tid.getText().toString()));
        long l = db.delete(Integer.parseInt(tid.getText().toString()));
        if (l > 0) {
            Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateEmployee(View view) {
        Employee employee = db.getEmployee(Integer.parseInt(tid.getText().toString()));
        employee.setName(tname.getText().toString());
        long l = db.update(employee);
        if (l > 0) {
            Toast.makeText(this, "update", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
        }
    }

    public void fetchEmployee(View view) {
        Log.e("error", db.getEmployee(Integer.parseInt(tid.getText().toString())).getName());
    }

    public void allEmployee(View view) {
        ArrayList<Employee> list = (ArrayList<Employee>) db.getAllEmployee();
        Log.e("error", list.size() + "");
        Intent in = new Intent(this, RecylerDemo.class);
        in.putExtra("list", list);
        startActivity(in);
        //finish();
    }

    public void logout(View view) {
        ((SingleTask) getApplication()).getSharedPreferences().edit().remove("status").commit();
        startActivity(new Intent(this, Login.class));
        finish();
    }


}