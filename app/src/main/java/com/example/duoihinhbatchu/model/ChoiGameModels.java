package com.example.duoihinhbatchu.model;

import com.example.duoihinhbatchu.ChoiGameActivity;
import com.example.duoihinhbatchu.object.CauDo;
import com.example.duoihinhbatchu.object.NguoiDung;

import java.util.ArrayList;

public class ChoiGameModels {
    private ChoiGameActivity c;
    private ArrayList<CauDo> arr;
    private NguoiDung nguoiDung;
    public ChoiGameModels(ChoiGameActivity c) {
        this.c = c;
        nguoiDung = new NguoiDung();
        taoData();
    }
    private void taoData(){
        arr = new ArrayList<>();
        arr.add(new CauDo(1, "obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg"));
        arr.add(new CauDo(2, "tienganh", "https://i.ytimg.com/vi/3UQdkHEKJnw/maxresdefault.jpg"));
        arr.add(new CauDo(3, "baocao", "https://3.bp.blogspot.com/-pzQILmYu4Jw/U8ePEjoEW2I/AAAAAAAACq8/QN8KosNpR70/s1600/2014-07-17+00.43.58-1.png"));
        arr.add(new CauDo(4, "yeuot", "https://i.pinimg.com/originals/bc/78/f2/bc78f2d35cba826e5a24ac8b7d0cb2dd.png"));
        arr.add(new CauDo(5,"cavoi", "https://i.ytimg.com/vi/DDU_gtuLhy4/maxresdefault.jpg" ));
        arr.add(new CauDo(6, "danhrang", "https://i.ytimg.com/vi/x_VLDsQnY-U/maxresdefault.jpg"));
        arr.add(new CauDo(7, "hoahoc", "https://i.ytimg.com/vi/_JaIoN9sKLo/maxresdefault.jpg"));
        arr.add(new CauDo(8, "bahoa", "https://4.bp.blogspot.com/-T_-FcxYAQQQ/U8ePkOP1LXI/AAAAAAAACrA/oE1jx5ahNe0/s1600/2014-07-17+00.44.19-1.png"));
        arr.add(new CauDo(9, "capsach", "https://i.ytimg.com/vi/J6zl-zaxARk/maxresdefault.jpg"));
        arr.add(new CauDo(10, "mangcut", " https://i.ytimg.com/vi/ffetwXwmngc/maxresdefault.jpg"));
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
    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

}
