package com.example.audioplayer;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.security.Permissions;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    final int code = 101;
    private Uri filew = null;
    private Button mplay, mstop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mplay = findViewById(R.id.playbtn);
        mstop = findViewById(R.id.stopbtn);

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=
        PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},88);
        }
        else {

        }



        getSupportActionBar().setTitle("AudioPlayer");

        mplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfile();
            }
        });
        mstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent serviceIntent = new Intent(getApplicationContext(), myservices.class);
                    stopService(serviceIntent);
                } catch (Exception ex) {

                }
            }
        });

    }


    private void openfile () {

            Intent selectAudioIntent = new Intent(Intent.ACTION_GET_CONTENT);
            selectAudioIntent.setType("audio/*");


            startActivityForResult(selectAudioIntent, code);
        }



    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

            try {
                if (requestCode == code) {
                    if (resultCode == RESULT_OK) {

                        filew = data.getData();

                        Intent serviceIntent = new Intent(this, myservices.class);

                        serviceIntent.putExtra("inputExtra", filew.toString());
                        serviceIntent.setAction(myservices.ACTION_START_FOREGROUND_SERVICE);
                        startService(serviceIntent);
                    }
                }
            } catch (Exception ex) {

                Toast.makeText(MainActivity.this, "Exception: " + ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==88){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(),"Permission granted",Toast.LENGTH_SHORT).show();
            }
        }
    }
}



