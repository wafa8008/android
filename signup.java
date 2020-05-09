package com.example.part_time_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    private EditText text_name,text_email,text_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setContentView(R.layout.activity_signup);
        text_name=findViewById(R.id.text_name);
        text_email=findViewById(R.id.text_email);
        text_password=findViewById(R.id.text_password);

        Button materialButton=findViewById(R.id.btn_register);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }



    public void register() {
        final String name=text_name.getText().toString().trim();
        final String email=text_email.getText().toString().trim();
        final String password=text_password.getText().toString().trim();

        if(name.isEmpty()){
            text_name.setError("Enter Your Name");
            return;
        }

        if(email.isEmpty()){
            text_email.setError("Enter Your Email");
            return;
        }

        if(password.isEmpty()){
            text_password.setError("Enter Your Password");
            return;
        }
        done done=new done(this);
        boolean check = done.check(email);
        if(check){
            Toast.makeText(this, "Email is Registred befor", Toast.LENGTH_SHORT).show();
        }else {
            done.insertUser(name, email, password);
            startActivity(new Intent(this,MainActivity.class));
        }


    }

    public void gologin(View view) {
        startActivity(new Intent(this,signin.class));
    }

}

