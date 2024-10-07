package com.example.duoihinhbatchu.object;

public class CauDo {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String dapAn;
    private String anh;
    public CauDo(){}

    public String getDapAn() {
        return dapAn;
    }

    public void setDapAn(String dapAn) {
        this.dapAn = dapAn;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public CauDo(int id, String dapAn, String anh) {
        this.id = id;
        this.dapAn = dapAn;
        this.anh = anh;
    }
}
