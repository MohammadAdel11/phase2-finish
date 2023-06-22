package com.example.quizmath;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivitystart extends AppCompatActivity {

    private Button btStart;
    private EditText edName;



    private Animation animation;
    private Animation animation2;


    @SuppressLint({"ResourceType", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitystart);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        animation= AnimationUtils.loadAnimation(this,R.drawable.animation_butt);
        animation2= AnimationUtils.loadAnimation(this,R.drawable.animation_text);

        btStart = findViewById(R.id.btStart);
        edName=findViewById(R.id.edname);

        btStart.setAnimation(animation);
        edName.setAnimation(animation2);

        btStart.setEnabled(false);




        edName.addTextChangedListener(startTextWatcer);



    }
    private TextWatcher startTextWatcer = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {




        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String name = edName.getText().toString().trim();

            if (!name.isEmpty()){
            btStart.setEnabled(true);
            btStart.setBackgroundResource(R.drawable.button_round);


            }else {
                btStart.setEnabled(false);
                btStart.setBackgroundResource(R.drawable.button_start);

            }


        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void onClickStart(View view) {
        String name = edName.getText().toString().trim();

        if (name.matches("")) {
            edName.setError("Enter Name");
        }

        else {
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("name",name);
            startActivity(intent);

        }

    }


}