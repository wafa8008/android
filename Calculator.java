package com.example.bodymass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
private TextView result;
private Button Addbtn,Subbtn,Mulbtn,Divbtn,Clearbtn;
private EditText num1,num2;
private float op1,op2,op3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        result=(TextView)findViewById(R.id.textresult);
        num1=(EditText)findViewById(R.id.num1);
        num2=(EditText)findViewById(R.id.num2);
        Addbtn=(Button)findViewById(R.id.addbtn);
        Subbtn=(Button)findViewById(R.id.subbtn);
        Divbtn=(Button)findViewById(R.id.divbtn);
        Mulbtn=(Button)findViewById(R.id.mulbtn);
        Clearbtn=(Button)findViewById(R.id.clearbtn);
        Addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1=Float.parseFloat(num1.getText().toString());
                op2=Float.parseFloat(num2.getText().toString());
               op3= op1 + op2;
               result.setText(Float.toString(op3));
            }
        });
        Subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1=Float.parseFloat(num1.getText().toString());
                op2=Float.parseFloat(num2.getText().toString());
                op3= op1 - op2;
                result.setText(Float.toString(op3));
            }
        });
        Mulbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1=Float.parseFloat(num1.getText().toString());
                op2=Float.parseFloat(num2.getText().toString());
                op3= op1 * op2;
                result.setText(Float.toString(op3));
            }
        });
        Divbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1=Float.parseFloat(num1.getText().toString());
                op2=Float.parseFloat(num2.getText().toString());
                op3= op1 / op2;
                result.setText(Float.toString(op3));
            }
        });
        Clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1.setText("");
                num2.setText("");
                result.setText("");
            }
        });
    }
}
