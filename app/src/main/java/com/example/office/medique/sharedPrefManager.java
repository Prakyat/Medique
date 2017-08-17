package com.example.office.medique;

import android.content.Context;
import android.content.SharedPreferences;

import static android.R.attr.id;

/**
 * Created by OFFICE on 8/16/2017.
 */

public class sharedPrefManager {


    private static sharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME ="mysharedpref";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_HOSPNAME = "hospname";
    private static final String KEY_EMAIL = "userid";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_ID = "id";
    private sharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized sharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new sharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean userLogin(int id, String username,String email)
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID,id);
        editor.putString(KEY_USERNAME,username);
        editor.putString(KEY_EMAIL,email);
        editor.apply();
        return true;

    }
    public boolean hospitalDetails(String hospitalname,String password)
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID,id);
        editor.putString(KEY_HOSPNAME,hospitalname);
        editor.putString(KEY_PASSWORD,password);
        editor.apply();
        return true;
    }

    public boolean isLoggedIn()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USERNAME,null) != null){
            return true;
        }
        return false;
    }
    public String getHospital()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return  sharedPreferences.getString(KEY_HOSPNAME,null);
    }


    public boolean logout()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
    public String getUsername()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME,null);

    }

    public String getKeyEmail()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_EMAIL,null);

    }
}
