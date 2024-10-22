package com.example.duoihinhbatchu.object;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CauDoDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "cau_do.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "caudo";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DAP_AN = "dapAn";
    public static final String COLUMN_ANH = "anh";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_DAP_AN + " TEXT, " +
            COLUMN_ANH + " TEXT)";

    public CauDoDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
