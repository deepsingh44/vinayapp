package com.deepsingh44.vinayapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RecylerDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_demo);
        employees=(ArrayList<Employee>) getIntent().getExtras().getSerializable("list");
        RecyclerView recyclerView = findViewById(R.id.myrecylcer);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
Log.e("error",employees.size()+"");


        CustomAdapter customAdapter=new CustomAdapter(employees);

        customAdapter.setDeepListener(new CustomAdapter.DeepListener() {
            @Override
            public void myItemClick(View view, int position) {
                Log.e("error",employees.get(position).getName());
            }
        });

        recyclerView.setAdapter(customAdapter);
    }

    List<Employee> employees;

    /*private void dummyData() {
        employees = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Employee e = new Employee();
            e.setId(i + 1);
            e.setName("Deep Singh" + i);
            employees.add(e);
        }

    }*/

}