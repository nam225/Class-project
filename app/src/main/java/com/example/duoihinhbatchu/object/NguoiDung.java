package com.example.duoihinhbatchu.object;

import android.content.Context;
import android.content.SharedPreferences;

public class NguoiDung {
    private final String nameData = "appData";
    public int tien;
    public int currentId;

    public void saveTT(Context ct){
        SharedPreferences settings = ct.getSharedPreferences(nameData, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("tien",tien);
        editor.putInt("currentId", currentId);
        editor.apply();
    }
    public void getTT(Context ct){
        SharedPreferences settings = ct.getSharedPreferences(nameData, 0);
        tien = settings.getInt("tien", 5000);
        currentId = settings.getInt("currentId", 1);
    }
}
