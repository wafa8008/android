package com.example.part_time_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateuser extends AppCompatActivity {

    private EditText text_name,text_email,text_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateuser);
        text_name=findViewById(R.id.text_name);
        text_email=findViewById(R.id.text_email);
        text_password=findViewById(R.id.text_password);
        done=new done(this);
        Cursor user = done.getUser();
        if(user.moveToFirst()){
            String name=user.getString(user.getColumnIndex("name"));
            String email=user.getString(user.getColumnIndex("email"));
            String pass=user.getString(user.getColumnIndex("password"));

            text_email.setText(email);
            text_name.setText(name);
            text_password.setText(pass);
        }

        Button materialButton=findViewById(R.id.btn_update);
        materialButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                update();
            }
        });
    }



    public void update() {
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
        done=new done(this);
        boolean check = done.check(email);
        if(check){
            Toast.makeText(this, "Email is Registred befor", Toast.LENGTH_SHORT).show();
        }else {
            done.updateUser(name,email,password);
            Toast.makeText(this, "User Updated", Toast.LENGTH_SHORT).show();
        }


    }
    done done;

}



