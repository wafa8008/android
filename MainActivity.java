package com.example.part_time_jobs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] myTitle = {"Ministry of health", "Ministry of interior", "panda supermarket", "macDonalds", "burger king", "Roya", "king abdulaziz university", "city max", "herfy"};
    String[] mDes = {"100job", "52 job", "3 job", "2 job", "3 job", "1 job", "16 job", "5 job", "1 job"};
    int images[] = {R.drawable.seh, R.drawable.pp, R.drawable.pa, R.drawable.mac, R.drawable.king, R.drawable.roya, R.drawable.abdu, R.drawable.max, R.drawable.her};
    String mysk[] = {"Morning periodAge from 23 to35 in ALMedina", "Morning time age from 21 to 25 is required in the following cities: Al-Qassim, Riyadh, Hail, Al-Madina", "work two shifts age from 21 to 25", "work tow shifts age from 21 to 25 the salary 3000 Experience Qassim", "work tow shifts age from 21 to 25 the salary 1500 Experience RIYADH", "morning shifts age from 21 to 25 the salary 8000 Experience Madina", "work tow shifts age from 21 to 25 Experience hail", "work tow shifts age from 21 to 25", "work tow shifts age from 21 to 25"};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_fav){



            startActivity(new Intent(this,favoritelist.class));
        }

        if(id==R.id.action_profile){
            startActivity(new Intent(this,signup.class));
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





            listView = findViewById(R.id.ListView);
            MyAdapter adapter = new MyAdapter(MainActivity.this, myTitle, mDes, images);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {
                        Intent intent = new Intent(getApplicationContext(), webhtml.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("Image", images[0]);

                        intent.putExtras(bundle);
                        intent.putExtra("mysk", mysk[0]);
                        intent.putExtra("title", myTitle[0]);
                        intent.putExtra("position", "" + 0);
                        startActivity(intent);

                    }
                    if (position == 1) {
                        Intent intent = new Intent(getApplicationContext(), webhtml.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("Image", images[1]);
                        intent.putExtras(bundle);
                        intent.putExtra("mysk", mysk[1]);
                        intent.putExtra("title", myTitle[1]);
                        intent.putExtra("position", "" + 1);
                        startActivity(intent);

                    }
                    if (position == 2) {
                        Intent intent = new Intent(getApplicationContext(), webhtml.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("Image", images[2]);
                        intent.putExtras(bundle);
                        intent.putExtra("mysk", mysk[2]);
                        intent.putExtra("title", myTitle[2]);
                        intent.putExtra("position", "" + 2);
                        startActivity(intent);
                    }
                    if (position == 3) {
                        Intent intent = new Intent(getApplicationContext(), webhtml.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("Image", images[3]);
                        intent.putExtras(bundle);
                        intent.putExtra("mysk", mysk[3]);
                        intent.putExtra("title", myTitle[3]);
                        intent.putExtra("position", "" + 3);
                        startActivity(intent);
                    }
                    if (position == 4) {
                        Intent intent = new Intent(getApplicationContext(), webhtml.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("Image", images[4]);
                        intent.putExtras(bundle);
                        intent.putExtra("mysk", mysk[4]);
                        intent.putExtra("title", myTitle[4]);
                        intent.putExtra("position", "" + 4);
                        startActivity(intent);
                    }
                    if (position == 5) {
                        Intent intent = new Intent(getApplicationContext(), webhtml.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("Image", images[5]);
                        intent.putExtras(bundle);
                        intent.putExtra("mysk", mysk[5]);
                        intent.putExtra("title", myTitle[5]);
                        intent.putExtra("position", "" + 5);
                        startActivity(intent);
                    }
                    if (position == 6) {
                        Intent intent = new Intent(getApplicationContext(), webhtml.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("Image", images[6]);
                        intent.putExtras(bundle);
                        intent.putExtra("mysk", mysk[6]);
                        intent.putExtra("title", myTitle[6]);
                        intent.putExtra("position", "" + 6);
                        startActivity(intent);
                    }
                    if (position == 7) {
                        Intent intent = new Intent(getApplicationContext(), webhtml.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("Image", images[7]);
                        intent.putExtras(bundle);
                        intent.putExtra("mysk", mysk[7]);
                        intent.putExtra("title", myTitle[7]);
                        intent.putExtra("position", "" + 7);
                        startActivity(intent);
                    }
                    if (position == 8) {
                        Intent intent = new Intent(getApplicationContext(), webhtml.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("Image", images[8]);
                        intent.putExtras(bundle);
                        intent.putExtra("title", myTitle[8]);
                        intent.putExtra("mysk", mysk[8]);
                        intent.putExtra("position", "" + 8);
                        startActivity(intent);
                    }
                }
            });


        }

        class MyAdapter extends ArrayAdapter<String> {

            Context context;
            String rTitele[];
            String rDes[];
            int rImages[];

            MyAdapter(Context c, String title[], String des[], int imgs[]) {
                super(c, R.layout.row_item, R.id.textView1, title);
                this.context = c;
                this.rTitele = title;
                this.rDes = des;
                this.rImages = imgs;
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View row = layoutInflater.inflate(R.layout.row_item, parent, false);
                ImageView images = row.findViewById(R.id.imageView2);
                TextView myTitle = row.findViewById(R.id.textView1);
                TextView myDes = row.findViewById(R.id.textView2);

                images.setImageResource(rImages[position]);
                myTitle.setText(rTitele[position]);
                myDes.setText(rDes[position]);

                return row;
            }
        }

}
