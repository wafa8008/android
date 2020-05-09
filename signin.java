package com.example.part_time_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signin extends AppCompatActivity {
    private EditText text_email,text_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        text_email=findViewById(R.id.text_email);
        text_password=findViewById(R.id.text_password);

        Button materialButton=findViewById(R.id.btn_login);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }



    public void login() {

        final String email=text_email.getText().toString().trim();
        final String password=text_password.getText().toString().trim();


        if(email.isEmpty()){
            text_email.setError("Enter Your Email");
            return;
        }

        if(password.isEmpty()){
            text_password.setError("Enter Your Password");
            return;
        }
        done done=new done(this);
        long check = done.login(email,password);
        if(check==-1){
            Toast.makeText(this, "Wrong Password Or Email", Toast.LENGTH_SHORT).show();
        }else {
            startActivity(new Intent(this,updateuser.class));
        }


    }


    public void go_register(View view) {
        startActivity(new Intent(this,signup.class));
    }
    }

