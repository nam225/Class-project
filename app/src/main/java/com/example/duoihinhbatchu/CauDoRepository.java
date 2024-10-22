package com.example.duoihinhbatchu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duoihinhbatchu.object.CauDo;
import com.example.duoihinhbatchu.object.CauDoDatabaseHelper;

import java.util.ArrayList;

public class CauDoRepository {
    private final CauDoDatabaseHelper dbHelper;

    public CauDoRepository(Context context) {
        dbHelper = new CauDoDatabaseHelper(context);
    }

    public void addCauDo(String dapAn, String anh) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CauDoDatabaseHelper.COLUMN_DAP_AN, dapAn);
        values.put(CauDoDatabaseHelper.COLUMN_ANH, anh);
        db.insert(CauDoDatabaseHelper.TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<CauDo> getAllCauDo() {
        ArrayList<CauDo> cauDoList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.rawQuery("SELECT * FROM " + CauDoDatabaseHelper.TABLE_NAME, null);

            // Kiểm tra nếu `Cursor` có dữ liệu
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    // Lấy chỉ số cột
                    int idIndex = cursor.getColumnIndex(CauDoDatabaseHelper.COLUMN_ID);
                    int dapAnIndex = cursor.getColumnIndex(CauDoDatabaseHelper.COLUMN_DAP_AN);
                    int anhIndex = cursor.getColumnIndex(CauDoDatabaseHelper.COLUMN_ANH);

                    // Đảm bảo chỉ số cột hợp lệ
                    if (idIndex != -1 && dapAnIndex != -1 && anhIndex != -1) {
                        int id = cursor.getInt(idIndex);
                        String dapAn = cursor.getString(dapAnIndex);
                        String anh = cursor.getString(anhIndex);

                        // Tạo đối tượng CauDo và thêm vào danh sách
                        CauDo cauDo = new CauDo(id, dapAn, anh);
                        cauDoList.add(cauDo);
                    } else {
                        // Log cảnh báo nếu có vấn đề với cột
                        Log.w("Database", "Không tìm thấy một hoặc nhiều cột trong Cursor");
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra
            Log.e("Database", "Lỗi khi truy vấn dữ liệu: " + e.getMessage());
        } finally {
            // Đảm bảo đóng Cursor và Database sau khi hoàn thành
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return cauDoList;
    }


}
