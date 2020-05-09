package com.example.part_time_jobs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

public class done extends SQLiteOpenHelper{
    public static final String BDname = "data.db";
    SessionManager sessionManager;

    public done(Context context) {
        super(context, BDname, null, 1);
        sessionManager = new SessionManager(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table mytable(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT,password Text)");
        db.execSQL("create table favorite(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, image  INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists mytable");
        onCreate(db);

    }

    public boolean insertUser(String name, String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = db.insert("mytable", null, contentValues);
        sessionManager.setId(result);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertFavorite(String name, int image) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("image", image);

        long result = db.insert("favorite", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public int deleteFavorite(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.delete("favorite", "id =" + id, null);
    }

    public long login(String email, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mytable = db.rawQuery("select * from mytable where email=? and password =?", new String[]{email, pass});
        if (mytable.moveToFirst()) {
            long id = mytable.getLong(mytable.getColumnIndex("id"));
            sessionManager.setId(id);
            return id;
        } else {
            return -1;
        }

    }

    public boolean check(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mytable = db.rawQuery("select * from mytable where email=?", new String[]{email});
        if (mytable.moveToFirst()) {
            sessionManager.setId(mytable.getInt(mytable.getColumnIndex("id")));
        }

        return mytable.moveToFirst();
    }

    public Cursor getUser() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mytable = db.rawQuery("select * from mytable where id=?", new String[]{String.valueOf(sessionManager.getId())});

        return mytable;
    }

    public boolean updateUser(String name, String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = db.update("mytable", contentValues, "id =" + sessionManager.getId(), null);
        if (result == -1)
            return false;
        else
            return true;
    }

    public List<favoritedata> getFavorite() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<favoritedata> favoriteData = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from favorite", null);


        if (cursor != null && cursor.moveToFirst()) {
            do {

                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int image = cursor.getInt(cursor.getColumnIndex("image"));
                favoritedata favoriteData1 = new favoritedata();
                favoriteData1.setId(id);
                favoriteData1.setName(name);
                favoriteData1.setImage(image);
                favoriteData.add(favoriteData1);
            }
            while (cursor.moveToNext());



        }
        return favoriteData;

    }


}
