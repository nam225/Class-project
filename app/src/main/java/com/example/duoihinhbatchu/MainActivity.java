package com.example.duoihinhbatchu;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duoihinhbatchu.object.SoundManager;

public class MainActivity extends AppCompatActivity {
    private Switch switchBackgroundMusic;
    private Switch switchSoundEffect;
    private CauDoRepository cauDoRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SoundManager.playBackgroundMusic(this, R.raw.background_music);

        ImageView settingsIcon = findViewById(R.id.settings_icon);
        Button playButton = findViewById(R.id.play_button);

        settingsIcon.setOnClickListener(v -> {
            SoundManager.playSoundEffect(MainActivity.this, R.raw.click_sound);
            openSettingsDialog();
        });

        playButton.setOnClickListener(v -> {
            SoundManager.playSoundEffect(MainActivity.this, R.raw.click_sound);
            Intent intent = new Intent(MainActivity.this, ChoiGameActivity.class);
            startActivity(intent);
        });

        addCauDo();
    }

    private void openSettingsDialog() {
        final Dialog settingsDialog = new Dialog(this);
        settingsDialog.setContentView(R.layout.dialog_settings);

        switchBackgroundMusic = settingsDialog.findViewById(R.id.switchBackgroundMusic);
        switchSoundEffect = settingsDialog.findViewById(R.id.switchSoundEffect);

        switchBackgroundMusic.setChecked(!SoundManager.isBackgroundMusicMuted());
        switchSoundEffect.setChecked(!SoundManager.isSoundEffectMuted());

        switchBackgroundMusic.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                SoundManager.unMuteBackgroundMusic();
            } else {
                SoundManager.muteBackgroundMusic();
            }
        });

        switchSoundEffect.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                SoundManager.unMuteSoundEffect();
            } else {
                SoundManager.muteSoundEffect();
            }
        });

        settingsDialog.show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        SoundManager.pauseBackgroundMusic();
    }
    @Override
    protected void onResume() {
        super.onResume();
        SoundManager.resumeBackgroundMusic();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SoundManager.release();
    }

    private void addCauDo(){
        cauDoRepository = new CauDoRepository(this);

        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
        cauDoRepository.addCauDo("tienganh", "https://i.ytimg.com/vi/3UQdkHEKJnw/maxresdefault.jpg");
        cauDoRepository.addCauDo("baocao", "https://3.bp.blogspot.com/-pzQILmYu4Jw/U8ePEjoEW2I/AAAAAAAACq8/QN8KosNpR70/s1600/2014-07-17+00.43.58-1.png");
        cauDoRepository.addCauDo("yeuot", "https://i.pinimg.com/originals/bc/78/f2/bc78f2d35cba826e5a24ac8b7d0cb2dd.png");
        cauDoRepository.addCauDo("cavoi", "https://i.ytimg.com/vi/DDU_gtuLhy4/maxresdefault.jpg");
        cauDoRepository.addCauDo("danhrang", "https://i.ytimg.com/vi/x_VLDsQnY-U/maxresdefault.jpg");
        cauDoRepository.addCauDo("hoahoc", "https://i.ytimg.com/vi/_JaIoN9sKLo/maxresdefault.jpg");
        cauDoRepository.addCauDo("bahoa", "https://4.bp.blogspot.com/-T_-FcxYAQQQ/U8ePkOP1LXI/AAAAAAAACrA/oE1jx5ahNe0/s1600/2014-07-17+00.44.19-1.png");
        cauDoRepository.addCauDo("capsach", "https://i.ytimg.com/vi/J6zl-zaxARk/maxresdefault.jpg");
        cauDoRepository.addCauDo("mangcut", " https://i.ytimg.com/vi/ffetwXwmngc/maxresdefault.jpg");
        cauDoRepository.addCauDo("keolac", "https://i.ytimg.com/vi/CeYlDTI4GTc/maxresdefault.jpg");
        cauDoRepository.addCauDo("caheo", "https://i.ytimg.com/vi/b7D1n0gxnRQ/hqdefault.jpg");
        cauDoRepository.addCauDo("xakep", "http://2.bp.blogspot.com/-kemUSGyZPVo/U8elNGaxE_I/AAAAAAAACuI/5A7sHcKFAjY/s1600/2014-07-17+01.07.46-1.png");
        cauDoRepository.addCauDo("dongnai", "https://i.ytimg.com/vi/dpaz38AFJto/maxresdefault.jpg");
        cauDoRepository.addCauDo("cobap", "https://th.bing.com/th/id/OIP.xVk2Wa3J5XiZsCtorE154gHaFE?pid=ImgDet&w=474&h=324&rs=1");
        cauDoRepository.addCauDo("hailong", "https://th.bing.com/th/id/OIP.5bNF5k4nX_Kzw0-RVPU5dwHaE8?pid=ImgDet&w=474&h=316&rs=1");
        cauDoRepository.addCauDo("nguao", "https://1.bp.blogspot.com/-ayLUfO-hgLY/U8kgPvxARaI/AAAAAAAAC20/Y5tbLj26hAU/s1600/2014-07-18+18.31.39-1.png");
        cauDoRepository.addCauDo("butky", "http://4.bp.blogspot.com/-KdsanHEW95I/U8kh9r9mNtI/AAAAAAAAC3c/q9wcB0hr7mw/s1600/2014-07-18+20.08.13-1.png");
        cauDoRepository.addCauDo("taihoa", "https://th.bing.com/th/id/R.62306141d2b6f5bd83e0bdf72a815a6d?rik=l1kh6P1RtNICVA&riu=http%3a%2f%2f3.bp.blogspot.com%2f-qKr1Y2zvHuw%2fU5FtR4eoMVI%2fAAAAAAAAS5A%2fHIBONUUcnJ8%2fs1600%2f10437494_755471944505057_2615786629208984288_n.jpg&ehk=Y7Ttas0tAZyU%2b7ok3vVOlPYwNxao2lvmDUg%2fkxZY2P4%3d&risl=&pid=ImgRaw&r=0");
        cauDoRepository.addCauDo("coloa", "https://i.vdoc.vn/data/image/2016/01/09/duoi-hinh-bat-chu-co-loa.jpg");
        cauDoRepository.addCauDo("aimo", "http://1.bp.blogspot.com/-bCxr3-vS2EI/U8kpBeHwegI/AAAAAAAAC44/gEGLUtOH874/s1600/2014-07-18+20.16.58-1.png");
        cauDoRepository.addCauDo("luclac", "http://1.bp.blogspot.com/-jgX3otSucNE/U8kgZ1GM-VI/AAAAAAAAC28/jqOTfkPsyvA/s1600/2014-07-18+18.31.54-1.png");
        cauDoRepository.addCauDo("cadao", "http://1.bp.blogspot.com/-Gpcp2PFRTz4/U8eW_0A_hYI/AAAAAAAACrw/sirdOt66sPE/s1600/2014-07-17+00.45.08-1.png");
        cauDoRepository.addCauDo("hoahau", "http://4.bp.blogspot.com/-aBg2hAUafUA/U8ebHKLLWNI/AAAAAAAACso/Bp9Imtk83q4/s1600/2014-07-17+00.47.33-1.png");
        cauDoRepository.addCauDo("cangua", "http://4.bp.blogspot.com/-oB67omLrGPw/U8eqWsVfkvI/AAAAAAAACvw/0OxRiqGIqQQ/s1600/2014-07-17+01.19.53-1.png");
        cauDoRepository.addCauDo("mytam", "http://3.bp.blogspot.com/-6uCu0sfxwOY/U8evZyB0JUI/AAAAAAAACxU/ofJqOJj_RzI/s1600/2014-07-17+01.30.44-1.png");
        cauDoRepository.addCauDo("matma", "http://1.bp.blogspot.com/-DvJsoAqJD84/U8eY0yhenFI/AAAAAAAACsE/vw4EM1Sk0GM/s1600/2014-07-17+00.45.56-1.png");
        cauDoRepository.addCauDo("chidiem", "http://4.bp.blogspot.com/-JLK24fYR1iw/U8elmp9zjRI/AAAAAAAACuQ/TBp__5sop2M/s1600/2014-07-17+01.08.19-1.png");
        cauDoRepository.addCauDo("daugau", "http://1.bp.blogspot.com/-ZLUHLdwbk2I/U8eu3CPj-SI/AAAAAAAACxE/VZ6MX7h2d9Y/s1600/2014-07-17+01.29.21-1.png");
        cauDoRepository.addCauDo("baibac", "http://4.bp.blogspot.com/-Qk8ufawo4IQ/U8evo2GVgLI/AAAAAAAACxc/EqxnD2EhfjE/s1600/2014-07-17+01.33.51-1.png");
        cauDoRepository.addCauDo("caumay", "http://3.bp.blogspot.com/-GAtRAp7jGXo/U8ex60oQsPI/AAAAAAAACyA/zSDO9mnv6Xo/s1600/2014-07-17+01.34.30-1.png");
        cauDoRepository.addCauDo("xetang", "http://2.bp.blogspot.com/-p1s5_BhdMh8/U8erH5hKCcI/AAAAAAAACwA/b1dY91RB0Vw/s1600/2014-07-17+01.21.37-1.png");
        cauDoRepository.addCauDo("canbang", "http://2.bp.blogspot.com/-XXZ24VYRB6U/U8eXLUGiNQI/AAAAAAAACr4/kr7UxNjJ6Cw/s1600/2014-07-17+00.45.40-1.png");
        cauDoRepository.addCauDo("noithat", "http://3.bp.blogspot.com/-uUYKOia79bI/U8jiGl0zLRI/AAAAAAAACz4/LhMw9Gno8HM/s1600/2014-07-18+08.38.10-1.png");
        cauDoRepository.addCauDo("nhahat", "http://3.bp.blogspot.com/-2uCAs8hsWsk/U8kg2AKBTKI/AAAAAAAAC3M/GoWLyO1YuC8/s1600/2014-07-18+18.33.06-1.png");
        cauDoRepository.addCauDo("omai", "https://cdn.lazi.vn/storage/uploads/dhbc/1466613268_o-mai.jpg");
        cauDoRepository.addCauDo("hanhlang", "https://cdn.lazi.vn/storage/uploads/dhbc/1466613154_hanh-lang.jpg");
        cauDoRepository.addCauDo("kinhdo", "https://cdn.lazi.vn/storage/uploads/dhbc/1466601711_kinh-do.jpg");
        cauDoRepository.addCauDo("noigian", "https://cdn.lazi.vn/storage/uploads/dhbc/1466601788_noi-gian.jpg");
        cauDoRepository.addCauDo("congtrai", "https://cdn.lazi.vn/storage/uploads/dhbc/1466601939_cong-trai.jpg");
        cauDoRepository.addCauDo("thankhoc", "https://cdn.lazi.vn/storage/uploads/dhbc/1466602204_than-khoc.jpg");
        cauDoRepository.addCauDo("thongtan", "https://cdn.lazi.vn/storage/uploads/dhbc/1466602458_thong-tan.jpg");
        cauDoRepository.addCauDo("caugio", "https://cdn.lazi.vn/storage/uploads/dhbc/1466602934_cau-gio.jpg");
        cauDoRepository.addCauDo("tambenh", "https://cdn.lazi.vn/storage/uploads/dhbc/1466603962_tam-benh.jpg");
        cauDoRepository.addCauDo("cungcau", "https://cdn.lazi.vn/storage/uploads/dhbc/1466613006_cung-cau.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");
//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");

    }
}