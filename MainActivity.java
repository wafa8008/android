package com.example.bodymass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void callfirst(View v){
        Intent i =new Intent(this,Calculator.class);
        startActivity(i);
        finish();
    }
    public void callsecond(View v){
        Intent i =new Intent(this,BMI.class);
        startActivity(i);
        finish();
    }
}
