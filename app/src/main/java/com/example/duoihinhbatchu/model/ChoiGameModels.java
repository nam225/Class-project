package com.example.duoihinhbatchu.model;

import com.example.duoihinhbatchu.ChoiGameActivity;
import com.example.duoihinhbatchu.object.CauDo;
import com.example.duoihinhbatchu.object.NguoiDung;

import java.util.ArrayList;

public class ChoiGameModels {
    ChoiGameActivity c;
    ArrayList<CauDo> arr;
    int cauSo = -1 ;
    public NguoiDung nguoiDung;
    public ChoiGameModels(ChoiGameActivity c) {
        this.c = c;
        nguoiDung = new NguoiDung();
        taoData();
    }
    private void taoData(){
        arr = new ArrayList<>();
//        arr.add(new CauDo("", "", ""));
        arr.add(new CauDo("Màn 4", "cavoi", "https://i.ytimg.com/vi/DDU_gtuLhy4/maxresdefault.jpg"));
        arr.add(new CauDo("Màn 3", "tienganh", "https://i.ytimg.com/vi/3UQdkHEKJnw/maxresdefault.jpg"));
        arr.add(new CauDo("Màn 2", "baocao", "https://3.bp.blogspot.com/-pzQILmYu4Jw/U8ePEjoEW2I/AAAAAAAACq8/QN8KosNpR70/s1600/2014-07-17+00.43.58-1.png"));
        arr.add(new CauDo("Màn 1", "yeuot", "https://i.pinimg.com/originals/bc/78/f2/bc78f2d35cba826e5a24ac8b7d0cb2dd.png"));
    }
    public CauDo layCauDo(){
        cauSo++;
        if(cauSo >= arr.size()){
            cauSo = arr.size() - 1;
        }
        return arr.get(cauSo);
    }
    public void layThongTin(){
        nguoiDung.getTT(c);
    }
    public void luuThongTin(){
        nguoiDung.saveTT(c);
    }
}
