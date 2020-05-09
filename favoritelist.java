package com.example.part_time_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class favoritelist extends AppCompatActivity {
    private ListView list;

    private done done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritelist);
        list=findViewById(R.id.list);

        getList();

    }
    private void getList(){
        done=new done(this);

        new MyTask(done).execute();

    }


    class MyAdapter extends BaseAdapter{

        private List<favoritedata> favoriteData;

        public MyAdapter(List<favoritedata> favoriteData) {
            this.favoriteData = favoriteData;
        }

        @Override
        public int getCount() {
            return favoriteData.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return favoriteData.get(i).getId();
        }



        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fav_row, viewGroup, false);
            ImageView imageView=view1.findViewById(R.id.imageView2);
            TextView textView1=view1.findViewById(R.id.textView1);
            ImageView delete=view1.findViewById(R.id.imageView);

            final favoritedata data=favoriteData.get(i);
            imageView.setImageResource(data.getImage());
            textView1.setText(data.getName());
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    done.deleteFavorite(data.getId());
                    Toast.makeText(favoritelist.this, "Deleted", Toast.LENGTH_SHORT).show();
                    getList();
                }
            });

            return view1;
        }
    }

    class MyTask extends AsyncTask<Void,Void, List<favoritedata>> {

        done done;

        public MyTask(com.example.part_time_jobs.done done) {
            this.done = done;
        }

        @Override
        protected List<favoritedata> doInBackground(Void... voids) {
            return done.getFavorite();
        }

        @Override
        protected void onPostExecute(List<favoritedata> favoriteData) {
            super.onPostExecute(favoriteData);

            MyAdapter myAdapter=new MyAdapter(favoriteData);
            list.setAdapter(myAdapter);
        }
    }
}



