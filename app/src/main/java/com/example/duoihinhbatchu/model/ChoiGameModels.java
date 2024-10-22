package com.example.duoihinhbatchu.model;

import com.example.duoihinhbatchu.ChoiGameActivity;
import com.example.duoihinhbatchu.object.CauDo;
import com.example.duoihinhbatchu.object.NguoiDung;

import java.util.ArrayList;

public class ChoiGameModels {
    private ChoiGameActivity c;
    private ArrayList<CauDo> arr;
    private NguoiDung nguoiDung;

    public ArrayList<CauDo> getArr() {
        return arr;
    }

    public void setArr(ArrayList<CauDo> arr) {
        this.arr = arr;
    }

    public ChoiGameModels(ChoiGameActivity c) {
        this.c = c;
        nguoiDung = new NguoiDung();
        this.arr = new ArrayList<>();
    }

    public CauDo layCauDo(int id) {
        for (CauDo cauDo : arr) {
            if (cauDo.getId() == id) {
                return cauDo;
            }
        }
        return null;
    }
    public void layThongTin(){
        nguoiDung.getTT(c);
    }
    public void luuThongTin(){
        nguoiDung.saveTT(c);
    }
    public void xoaThongTin(){
        nguoiDung.deleteTT(c);
    }
    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }
}

