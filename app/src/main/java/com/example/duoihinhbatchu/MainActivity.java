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

    private void addCauDo() {
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
        cauDoRepository.addCauDo("hoahau", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612864_hoa-hau.jpg");
        cauDoRepository.addCauDo("nhatbao", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612832_nhat-bao.jpg");
        cauDoRepository.addCauDo("xakep", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612799_xa-kep.jpg");
        cauDoRepository.addCauDo("hocduong", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612755_hoc-duong.jpg");
        cauDoRepository.addCauDo("hungthu", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612687_hung-thu.jpg");
        cauDoRepository.addCauDo("cangua", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612649_ca-ngua.jpg");
        cauDoRepository.addCauDo("bactinh", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612624_bac-tinh.jpg");
        cauDoRepository.addCauDo("chanthanh", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612600_chan-thanh.jpg");
        cauDoRepository.addCauDo("gaungua", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612575_gau-ngua.jpg");
        cauDoRepository.addCauDo("dauthu", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612541_dau-thu.jpg");
        cauDoRepository.addCauDo("ngaycong", "https://cdn.lazi.vn/storage/uploads/dhbc/1466609177_ngay-cong.jpg");
        cauDoRepository.addCauDo("baibac", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612497_bai-bac.jpg");
        cauDoRepository.addCauDo("tinhtruong", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612446_tinh-truong.jpg");
        cauDoRepository.addCauDo("caumay", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612401_cau-may.jpg");
        cauDoRepository.addCauDo("gachhoa", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612348_gach-hoa.jpg");
        cauDoRepository.addCauDo("neodon", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612320_neo-don.jpg");
        cauDoRepository.addCauDo("giaybac", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612287_giay-bac.jpg");
        cauDoRepository.addCauDo("thamthiet", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612256_tham-thiet.jpg");
        cauDoRepository.addCauDo("obama", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612227_obama.jpg");
        cauDoRepository.addCauDo("bongbay", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612201_bong-bay.jpg");
        cauDoRepository.addCauDo("tranhthu", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612174_tranh-thu.jpg");
        cauDoRepository.addCauDo("dauca", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612101_dau-ca.jpg");
        cauDoRepository.addCauDo("coloa", "https://cdn.lazi.vn/storage/uploads/dhbc/1466612069_co-loa.jpg");
        cauDoRepository.addCauDo("taytrang", "https://cdn.lazi.vn/storage/uploads/dhbc/1466611835_tay-trang.jpg");
        cauDoRepository.addCauDo("mytam", "https://cdn.lazi.vn/storage/uploads/dhbc/1466611736_my-tam.jpg");
        cauDoRepository.addCauDo("bioi", "https://cdn.lazi.vn/storage/uploads/dhbc/1466660915_bi-oi.jpg");
        cauDoRepository.addCauDo("chidiem", "https://cdn.lazi.vn/storage/uploads/dhbc/1466660954_chi-diem.jpg");
        cauDoRepository.addCauDo("hoicung", "https://cdn.lazi.vn/storage/uploads/dhbc/1466661239_hoi-cung.jpg");
        cauDoRepository.addCauDo("chantuong", "https://cdn.lazi.vn/storage/uploads/dhbc/1466661230_chan-tuong.jpg");


        cauDoRepository.addCauDo("xetang", "https://cdn.lazi.vn/storage/uploads/dhbc/1466661328_xe-tang.jpg");


        cauDoRepository.addCauDo("aimo", "https://cdn.lazi.vn/storage/uploads/dhbc/1466666997_ai-mo.jpg");


        cauDoRepository.addCauDo("anhhao", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667014_anh-hao.jpg");


        cauDoRepository.addCauDo("aomua", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667031_ao-mua.jpg");


        cauDoRepository.addCauDo("badong", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667073_ba-dong.jpg");


        cauDoRepository.addCauDo("baothuc", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667191_bao-thuc.jpg");


        cauDoRepository.addCauDo("bamoi", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667132_ba-moi.jpg");


        cauDoRepository.addCauDo("batron", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667274_ba-tron.jpg");


        cauDoRepository.addCauDo("bongda", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667314_bong-da.jpg");


        cauDoRepository.addCauDo("butky", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667336_but-ky.jpg");


        cauDoRepository.addCauDo("cangian", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667356_can-gian.jpg");


        cauDoRepository.addCauDo("cobap", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667375_co-bap.jpg");


        cauDoRepository.addCauDo("congbo", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667393_cong-bo.jpg");


        cauDoRepository.addCauDo("conggiao", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667414_cong-giao.jpg");


        cauDoRepository.addCauDo("daituong", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667435_dai-tuong.jpg");


        cauDoRepository.addCauDo("xemtuong", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667453_xem-tuong.jpg");


        cauDoRepository.addCauDo("detien", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667472_de-tien.jpg");


        cauDoRepository.addCauDo("hailong", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667504_hai-long.jpg");


        cauDoRepository.addCauDo("hanhha", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667522_hanh-ha.jpg");


        cauDoRepository.addCauDo("hongtam", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667545_hong-tam.jpg");


        cauDoRepository.addCauDo("kichthich", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667564_kich-thich.jpg");


        cauDoRepository.addCauDo("kinhluoc", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667614_kinh-luoc.jpg");


        cauDoRepository.addCauDo("khotam", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667640_kho-tam.jpg");


        cauDoRepository.addCauDo("luclac", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667657_luc-lac.jpg");


        cauDoRepository.addCauDo("muinhon", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667697_mui-nhon.jpg");


        cauDoRepository.addCauDo("ngangu", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667716_nga-ngu.jpg");


        cauDoRepository.addCauDo("nguao", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667821_ngua-o.jpg");


        cauDoRepository.addCauDo("nhahat", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667838_nha-hat.jpg");

        cauDoRepository.addCauDo("nhanduc", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667858_nhan-duc.jpg");


        cauDoRepository.addCauDo("ruatien", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667877_rua-tien.jpg");


        cauDoRepository.addCauDo("xehoa", "https://cdn.lazi.vn/storage/uploads/dhbc/1466698966_xe-hoa.jpg");


        cauDoRepository.addCauDo("taihoa", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667898_tai-hoa.jpg");


        cauDoRepository.addCauDo("xichlo", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667962_xich-lo.jpg");


        cauDoRepository.addCauDo("traicay", "https://cdn.lazi.vn/storage/uploads/dhbc/1466667983_trai-cay.jpg");


        cauDoRepository.addCauDo("auyem", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676260_au-yem.jpg");


        cauDoRepository.addCauDo("balo", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676304_ba-lo.jpg");


        cauDoRepository.addCauDo("baomong", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676338_bao-mong.jpg");

        cauDoRepository.addCauDo("baphai", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676358_ba-phai.jpg");

        cauDoRepository.addCauDo("bienhieu", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676395_bien-hieu.jpg");

        cauDoRepository.addCauDo("bihai", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676415_bi-hai.jpg");

        cauDoRepository.addCauDo("bikich", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676438_bi-kich.jpg");

        cauDoRepository.addCauDo("biquan", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676455_bi-quan.jpg");

        cauDoRepository.addCauDo("caokien", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676496_cao-kien.jpg");

        cauDoRepository.addCauDo("cohoi", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676513_co-hoi.jpg");

        cauDoRepository.addCauDo("daosau", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676594_dao-sau.jpg");

        cauDoRepository.addCauDo("hamhau", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676622_ham-hau.jpg");

        cauDoRepository.addCauDo("yeusach", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676708_yeu-sach.jpg");

        cauDoRepository.addCauDo("thichthu", "https://cdn.lazi.vn/storage/uploads/dhbc/1466677525_thich-thu.jpg");

        cauDoRepository.addCauDo("mahoa", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676863_ma-hoa.jpg");

        cauDoRepository.addCauDo("taomeo", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676892_tao-meo.jpg");

        cauDoRepository.addCauDo("matkhau", "https://cdn.lazi.vn/storage/uploads/dhbc/1466676981_mat-khau.jpg");

        cauDoRepository.addCauDo("nanglong", "https://cdn.lazi.vn/storage/uploads/dhbc/1466677077_nang-long.jpg");

        cauDoRepository.addCauDo("nhanhieu", "https://cdn.lazi.vn/storage/uploads/dhbc/1466677125_nhan-hieu.jpg");

        cauDoRepository.addCauDo("xalan", "https://cdn.lazi.vn/storage/uploads/dhbc/1466677628_xa-lan.jpg");

        cauDoRepository.addCauDo("nhantam", "https://cdn.lazi.vn/storage/uploads/dhbc/1466677191_nhan-tam.jpg");

        cauDoRepository.addCauDo("nhantu", "https://cdn.lazi.vn/storage/uploads/dhbc/1466677274_nhan-tu.jpg");

        cauDoRepository.addCauDo("quycu", "https://cdn.lazi.vn/storage/uploads/dhbc/1466677310_quy-cu.jpg");

        cauDoRepository.addCauDo("tancong", "https://cdn.lazi.vn/storage/uploads/dhbc/1466677334_tan-cong.jpg");

        cauDoRepository.addCauDo("tiendao", "https://cdn.lazi.vn/storage/uploads/dhbc/1466677418_tien-dao.jpg");

        cauDoRepository.addCauDo("tungtang", "https://cdn.lazi.vn/storage/uploads/dhbc/1466677445_tung-tang.jpg");

        cauDoRepository.addCauDo("thamhoa", "https://cdn.lazi.vn/storage/uploads/dhbc/1466677482_tham-hoa.jpg");

        cauDoRepository.addCauDo("xauho", "https://cdn.lazi.vn/storage/uploads/dhbc/1466677681_xau-ho.jpg");
        cauDoRepository.addCauDo("yenbinh", "https://cdn.lazi.vn/storage/uploads/dhbc/1466677699_yen-binh.jpg");

        cauDoRepository.addCauDo("anmay", "https://cdn.lazi.vn/storage/uploads/dhbc/1466693900_an-may.jpg");

        cauDoRepository.addCauDo("banhtrai", "https://cdn.lazi.vn/storage/uploads/dhbc/1466694057_banh-trai.jpg");

        cauDoRepository.addCauDo("batbi", "https://cdn.lazi.vn/storage/uploads/dhbc/1466694084_bat-bi.jpg");

        cauDoRepository.addCauDo("camky", "https://cdn.lazi.vn/storage/uploads/dhbc/1466694123_cam-ky.jpg");

        cauDoRepository.addCauDo("cocua", "https://cdn.lazi.vn/storage/uploads/dhbc/1466694142_co-cua.jpg");

        cauDoRepository.addCauDo("chiso", "https://cdn.lazi.vn/storage/uploads/dhbc/1466694167_chi-so.jpg");

        cauDoRepository.addCauDo("daphop", "https://cdn.lazi.vn/storage/uploads/dhbc/1466694247_dap-hop.jpg");

        cauDoRepository.addCauDo("dondoc", "https://cdn.lazi.vn/storage/uploads/dhbc/1466694296_don-doc.jpg");

        cauDoRepository.addCauDo("dongcam", "https://cdn.lazi.vn/storage/uploads/dhbc/1466694319_dong-cam.jpg");

        cauDoRepository.addCauDo("hoami", "https://cdn.lazi.vn/storage/uploads/dhbc/1466694389_hoa-mi.jpg");

        cauDoRepository.addCauDo("lienthu", "https://cdn.lazi.vn/storage/uploads/dhbc/1466694509_lien-thu.jpg");


//        cauDoRepository.addCauDo("obama", "https://lazi.vn/uploads/dhbc/1466612227_obama.jpg");

    }
}