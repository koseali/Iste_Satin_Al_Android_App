package com.example.iste_satin_al;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

class Remember {
    private static final String PREF_NAME="DATA";
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    Remember(Context context) {

        Remember.context = context;
    }



    void Save(String key, String value){
        SharedPreferences settings=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =settings.edit();
        editor.putString(key,value);
        editor.apply();
    }

    String  Load(String key){
        SharedPreferences settings=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        String txt="";
        if (settings.contains(key))
            txt=settings.getString(key,null);
        return txt;
    }


    void Remove(String key){
        SharedPreferences settings=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        if (settings.contains(key))
            editor.remove(key);
        editor.apply();
    }
}







