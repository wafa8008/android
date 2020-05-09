package com.example.bodymass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity {
private EditText H,W;
private TextView Result;
private Button cal,clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        H= (EditText) findViewById(R.id.hight);
        W= (EditText) findViewById(R.id.wight);
        Result=(TextView) findViewById(R.id.txtresult);
        cal=(Button) findViewById(R.id.cal);
        clear=(Button) findViewById(R.id.btnclear);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmi();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                H.setText("");
                W.setText("");
                Result.setText("");
            }
        });

    }
    private void bmi(){
        Float Kg,m2,BMI;
        m2=Float.parseFloat(H.getText().toString())/100;
        Kg=Float.parseFloat(W.getText().toString());
        BMI=Kg / (m2*m2);
        Result.setText("" + BMI);
    }
}
