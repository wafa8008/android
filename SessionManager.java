package com.example.part_time_jobs;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context _context;
    //  1

    // Shared pref mode
    int PRIVATE_MODE = 0;


    // Shared preferences file name
    private static final String PREF_NAME = "inspirations";


    private static final String USER_ID = "id";
    private static final String BCP_ID = "bcp";
    private static final String USER_TYPE = "user_type";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }



    public void setId(long id){
        editor.putLong(USER_ID, id);

        // commit changes
        editor.commit();
    }

    public long getId(){
        return pref.getLong(USER_ID,-1);
    }

    public void clear(){
        editor.clear();
    }



}


