package com.example.duoihinhbatchu.object;

import android.content.Context;
import android.content.SharedPreferences;

public class NguoiDung {
    private final String nameData = "appData";
    public int tien;
    public int currentId;
    private SharedPreferences settings;

    public void saveTT(Context ct){
        settings = ct.getSharedPreferences(nameData, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("tien",tien);
        editor.putInt("currentId", currentId);
        editor.apply();
    }
    public void getTT(Context ct){
        settings = ct.getSharedPreferences(nameData, 0);
        tien = settings.getInt("tien", 50);
        currentId = settings.getInt("currentId", 1);
    }

    public void deleteTT(Context ct) {
        settings = ct.getSharedPreferences(nameData, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove("tien");
        editor.remove("currentId");
        editor.apply();
    }

}
