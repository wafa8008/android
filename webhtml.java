package com.example.part_time_jobs;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class webhtml extends AppCompatActivity {

    ImageView imageView;
    TextView mysk;
    String title;
    int pec;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webhtml);
        ActionBar actionBar =getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        imageView =findViewById(R.id.anather_img);
        mysk = findViewById(R.id.mysktxt);
        if (position == 0) {

            Intent intent=getIntent();
            Bundle bundle=this.getIntent().getExtras();
            pec = bundle.getInt("Image");
            String sk =intent.getStringExtra("mysk");
            title=intent.getStringExtra("title");

            imageView.setImageResource(pec);
            mysk.setText(sk);
            actionBar.setTitle(sk);
        }
        if (position == 1) {

            Intent intent=getIntent();
            title=intent.getStringExtra("title");
            Bundle bundle=this.getIntent().getExtras();
            pec = bundle.getInt("Image");
            String sk =intent.getStringExtra("mysk");

            imageView.setImageResource(pec);
            mysk.setText(sk);
            actionBar.setTitle(sk);
        }if (position == 2) {
            Intent intent=getIntent();
            Bundle bundle=this.getIntent().getExtras();
            title=intent.getStringExtra("title");
            pec = bundle.getInt("Image");
            String sk =intent.getStringExtra("mysk");

            imageView.setImageResource(pec);
            mysk.setText(sk);
            actionBar.setTitle(sk);
        }if (position == 3) {
            Intent intent=getIntent();
            title=intent.getStringExtra("title");
            Bundle bundle=this.getIntent().getExtras();
            pec = bundle.getInt("Image");
            String sk =intent.getStringExtra("mysk");

            imageView.setImageResource(pec);
            mysk.setText(sk);
            actionBar.setTitle(sk);
        }if (position == 4) {
            Intent intent=getIntent();
            Bundle bundle=this.getIntent().getExtras();
            pec = bundle.getInt("Image");
            title=intent.getStringExtra("title");
            String sk =intent.getStringExtra("mysk");

            imageView.setImageResource(pec);
            mysk.setText(sk);
            actionBar.setTitle(sk);
        }if (position == 5) {
            Intent intent=getIntent();
            Bundle bundle=this.getIntent().getExtras();
            pec = bundle.getInt("Image");
            title=intent.getStringExtra("title");
            String sk =intent.getStringExtra("mysk");

            imageView.setImageResource(pec);
            mysk.setText(sk);
            actionBar.setTitle(sk);
        }if (position == 6) {
            Intent intent=getIntent();
            Bundle bundle=this.getIntent().getExtras();
            pec = bundle.getInt("Image");
            title=intent.getStringExtra("title");
            String sk =intent.getStringExtra("mysk");

            imageView.setImageResource(pec);
            mysk.setText(sk);
            actionBar.setTitle(sk);
        }if (position == 7) {
            Intent intent=getIntent();
            Bundle bundle=this.getIntent().getExtras();
            pec = bundle.getInt("Image");
            title=intent.getStringExtra("title");
            String sk =intent.getStringExtra("mysk");

            imageView.setImageResource(pec);
            mysk.setText(sk);
            actionBar.setTitle(sk);
        }if (position == 8) {
            Intent intent=getIntent();
            Bundle bundle=this.getIntent().getExtras();
            pec = bundle.getInt("Image");
            title=intent.getStringExtra("title");
            String sk =intent.getStringExtra("mysk");

            imageView.setImageResource(pec);
            mysk.setText(sk);
            title=intent.getStringExtra("title");
            actionBar.setTitle(sk);
        }

    }

    public void btn_add_data(View v) {
       /* Intent intent = new Intent(webhtml.this, main3.class);
        startActivity(intent);*/
        done done=new done(this);
        boolean b = done.insertFavorite(title, pec);
        if(b){
            Toast.makeText(this, "Added To Favorite", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

    }
    public void btn_app_data(View v){
      Intent bint=new Intent(Intent.ACTION_VIEW, Uri.parse("http://transition.taqat.sa/"));
      startActivity(bint);
    }
}


