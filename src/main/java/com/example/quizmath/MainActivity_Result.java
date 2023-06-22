package com.example.quizmath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity_Result extends AppCompatActivity {
    private TextView text1;

    ListView lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_result);
        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

        String name = mPreferences.getString(getString(R.string.name), "");
        String gread = mPreferences.getString(getString(R.string.grade),"");
        // text1.setText(name+" --> You answered  "+gread +" / 10"+"\n"+"The Right Answered is :");


        RecyclerView res1 = findViewById(R.id.res);


        String[] cap = new String[10];
        for (int i=0;i<10;i++) {
            cap[i]=mPreferences.getString(getString(R.string.qustion),"");
            System.out.println(cap[i]+" dddfdfdfddf");
        }
        res1.setLayoutManager(new LinearLayoutManager(this));
        Adabters adapter1 = new Adabters(cap);
        res1.setAdapter(adapter1);




    }
}