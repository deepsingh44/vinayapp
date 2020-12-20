package com.deepsingh44.vinayapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] names = {"sonu","abhi", "suresh","ajay"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MultiAutoCompleteTextView ac=findViewById(R.id.multi);
        ac.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names));
        ac.setThreshold(1);
        ac.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        ac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=parent.getItemAtPosition(position).toString();

                //Toast.makeText(MainActivity.this,name, Toast.LENGTH_SHORT).show();
                Log.e("error",name);
            }
        });

        /*AutoCompleteTextView ac=findViewById(R.id.auto);
        ac.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names));
        ac.setThreshold(1);


        ac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=parent.getItemAtPosition(position).toString();

                //Toast.makeText(MainActivity.this,name, Toast.LENGTH_SHORT).show();
                Log.e("error",name);
            }
        });*/


        /*Spinner spn = findViewById(R.id.spn);
        spn.setAdapter(new ArrayAdapter<String>(this,R.layout.item,names));

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=parent.getItemAtPosition(position).toString();
                //parent.setSelection(1);
                if(!item.equalsIgnoreCase("select name")){
                    Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/

    }

}