package com.example.duoihinhbatchu;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.duoihinhbatchu.adapter.DapAnAdapter;
import com.example.duoihinhbatchu.model.ChoiGameModels;
import com.example.duoihinhbatchu.object.CauDo;
import com.example.duoihinhbatchu.object.SoundManager;

import java.util.ArrayList;
import java.util.Random;

public class ChoiGameActivity extends AppCompatActivity {
    private ChoiGameModels models;
    private String dapAn;
    private ArrayList<String> arrCauTraLoi;
    private GridView gdvCauTraLoi;
    private ArrayList<String> arrDapAn;
    private GridView gdvDapAn;
    private ImageView imgCauDo;
    private TextView txvTienNguoiDung;
    private ImageView home;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_game);
        init();
        anhXa();
        setOnClick();
        hienCauDo();
        SoundManager.playBackgroundMusic(ChoiGameActivity.this, R.raw.background_music);

        home.setOnClickListener(v -> {
            SoundManager.playSoundEffect(ChoiGameActivity.this, R.raw.click_sound);
            Intent intent = new Intent(ChoiGameActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void anhXa() {
        gdvCauTraLoi = findViewById(R.id.gdvCauTraLoi);
        gdvDapAn = findViewById(R.id.gdvDapAn);
        imgCauDo = findViewById(R.id.imgCauDo);
        txvTienNguoiDung = findViewById(R.id.txvTienNguoiDung);
        home = findViewById(R.id.home_icon);
    }

    private void init() {
        models = new ChoiGameModels(this);
        models.setArr(new CauDoRepository(this).getAllCauDo());
//        models.xoaThongTin();
        arrCauTraLoi = new ArrayList<>();
        arrDapAn = new ArrayList<>();
    }

    private void hienCauDo() {
        models.layThongTin();
        int id = models.getNguoiDung().currentId;
        CauDo cauDo = models.layCauDo(id);
        if(cauDo == null){
            models.getNguoiDung().currentId = 1;
            cauDo = models.layCauDo(0);
        }
        dapAn = cauDo.getDapAn();
        bamData();
        hienThiCauTraLoi();
        hienThiDapAn();

        Glide
                .with(this)
                .load(cauDo.getAnh())
                .into(imgCauDo);
        txvTienNguoiDung.setText(models.getNguoiDung().tien + "$");
    }

    private void hienThiCauTraLoi() {
        gdvCauTraLoi.setNumColumns(arrCauTraLoi.size());
        gdvCauTraLoi.setAdapter(new DapAnAdapter(this, 0, arrCauTraLoi));
    }

    private void hienThiDapAn() {
        gdvDapAn.setNumColumns(arrDapAn.size() / 2);
        gdvDapAn.setAdapter(new DapAnAdapter(this, 0, arrDapAn));
    }

    private void setOnClick() {
        gdvDapAn.setOnItemClickListener((parent, view, position, id) -> {
            SoundManager.playSoundEffect(ChoiGameActivity.this, R.raw.click_sound);
            String s = (String) parent.getItemAtPosition(position);
            if (s.length() != 0 && index < arrCauTraLoi.size()) {
                for (int i = 0; i < arrCauTraLoi.size(); i++) {
                    if (arrCauTraLoi.get(i).length() == 0) {
                        index = i;
                        break;
                    }
                }
                arrDapAn.set(position, "");
                arrCauTraLoi.set(index, s);
                index++;
                hienThiCauTraLoi();
                hienThiDapAn();
                checkWin();
            }
        });
        gdvCauTraLoi.setOnItemClickListener((parent, view, position, id) -> {
            SoundManager.playSoundEffect(ChoiGameActivity.this, R.raw.click_sound);
            String s = (String) parent.getItemAtPosition(position);
            if (s.length() != 0) {
                index = position;
                arrCauTraLoi.set(position, "");
                for (int i = 0; i < arrDapAn.size(); i++) {
                    if (arrDapAn.get(i).length() == 0) {
                        arrDapAn.set(i, s);
                        break;
                    }
                }
                hienThiCauTraLoi();
                hienThiDapAn();
            }
        });
    }

    private void bamData() {
        index = 0;
        arrCauTraLoi.clear();
        arrDapAn.clear();

        gdvCauTraLoi.clearAnimation();
        for (int i = 0; i < gdvCauTraLoi.getChildCount(); i++) {
            View gridItem = gdvCauTraLoi.getChildAt(i);
            if (gridItem != null) {
                gridItem.clearAnimation();
                gridItem.setBackgroundColor(Color.TRANSPARENT);
            }
        }

        Random r = new Random();
        for (int i = 0; i < dapAn.length(); i++) {
            arrCauTraLoi.add("");
            String s = String.valueOf((char) (r.nextInt(26) + 65));
            arrDapAn.add(s);
            String s1 = String.valueOf((char) (r.nextInt(26) + 65));
            arrDapAn.add(s1);
        }
        for (int i = 0; i < dapAn.length(); i++) {
            String s = String.valueOf(dapAn.charAt(i));
            arrDapAn.set(i, s.toUpperCase());
        }
        for (int i = 0; i < arrDapAn.size(); i++) {
            String s = arrDapAn.get(i);
            int vt = r.nextInt(arrDapAn.size());
            arrDapAn.set(i, arrDapAn.get(vt));
            arrDapAn.set(vt, s);
        }
    }

    private void checkWin() {
        StringBuilder s = new StringBuilder();
        for (String s1 : arrCauTraLoi) {
            s.append(s1);
        }
        s = new StringBuilder(s.toString().toUpperCase());
        if (s.toString().equals(dapAn.toUpperCase())) {
            models.layThongTin();
            models.getNguoiDung().currentId++;
            models.luuThongTin();
            congTien(10);

            Animation glowEffect = AnimationUtils.loadAnimation(this, R.anim.glow_alpha);
            gdvCauTraLoi.startAnimation(glowEffect);
            for (int i = 0; i < gdvCauTraLoi.getChildCount(); i++) {
                View view = gdvCauTraLoi.getChildAt(i);
                view.setBackgroundResource(R.drawable.glow_effect);
            }
            new Handler().postDelayed(this::openDialog, 2000);
        }
    }

    private void openDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_asking);

        Button btnContinue = dialog.findViewById(R.id.btn_continue);
        Button btnGoBack = dialog.findViewById(R.id.btn_main_activity);

        btnContinue.setOnClickListener(v -> {
            dialog.dismiss();
            hienCauDo();
        });

        btnGoBack.setOnClickListener(v -> {
            dialog.dismiss();
            startActivity(new Intent(this, MainActivity.class));
        });
        dialog.show();
    }

    public void moGoiY(View view) {
        models.layThongTin();
        SoundManager.playSoundEffect(ChoiGameActivity.this, R.raw.click_sound);
        if (models.getNguoiDung().tien < 5) {
            Toast.makeText(this, "Bạn đã hết tiền", Toast.LENGTH_SHORT).show();
            return;
        }
        int id = -1;
        for (int i = 0; i < arrCauTraLoi.size(); i++) {
            if (arrCauTraLoi.get(i).length() == 0) {
                id = i;
                break;
            }
        }
        if (id == -1) {
            for (int i = 0; i < arrCauTraLoi.size(); i++) {
                String s = String.valueOf(dapAn.toUpperCase().charAt(i));
                if (!arrCauTraLoi.get(i).toUpperCase().equals(s)) {
                    id = i;
                    break;
                }
            }
        }
        String goiY = String.valueOf(dapAn.charAt(id));
        goiY = goiY.toUpperCase();

        for (int i = 0; i < arrCauTraLoi.size(); i++) {
            if (arrCauTraLoi.get(i).toUpperCase().equals(goiY)) {
                arrCauTraLoi.set(i, "");
                break;
            }
        }
        for (int i = 0; i < arrDapAn.size(); i++) {
            if (goiY.equals(arrDapAn.get(i))) {
                arrDapAn.set(i, "");
                break;
            }
        }
        arrCauTraLoi.set(id, goiY);
        hienThiCauTraLoi();
        hienThiDapAn();
        truTien(5);

        Toast.makeText(this, "Gợi ý đã được mở!", Toast.LENGTH_SHORT).show();
        checkWin();
    }

    public void doiCauHoi(View view) {
        SoundManager.playSoundEffect(ChoiGameActivity.this, R.raw.click_sound);
        models.layThongTin();
        if (models.getNguoiDung().tien < 50) {
            Toast.makeText(this, "Bạn đã hết tiền", Toast.LENGTH_SHORT).show();
            return;
        }
        models.getNguoiDung().currentId++;
        models.luuThongTin();
        truTien(50);
        hienCauDo();
    }

    private void updateMoney(int newAmount) {
        int currentMoney = Integer.parseInt(txvTienNguoiDung.getText().toString().replace("$", ""));

        ValueAnimator animator = ValueAnimator.ofInt(currentMoney, newAmount);
        animator.setDuration(1000);
        animator.addUpdateListener(animation -> {
            int animatedValue = (int) animation.getAnimatedValue();
            txvTienNguoiDung.setText(animatedValue + "$");
        });

        animator.start();
    }

    private void congTien(int soTienCongThem) {
        models.layThongTin();
        int newAmount = models.getNguoiDung().tien + soTienCongThem;
        updateMoney(newAmount);
        models.getNguoiDung().tien = newAmount;
        models.luuThongTin();
    }

    private void truTien(int soTienBiTru) {
        models.layThongTin();
        int newAmount = models.getNguoiDung().tien - soTienBiTru;
        updateMoney(newAmount);
        models.getNguoiDung().tien = newAmount;
        models.luuThongTin();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SoundManager.resumeBackgroundMusic();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SoundManager.pauseBackgroundMusic();
    }

}