package com.example.duoihinhbatchu;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.duoihinhbatchu.object.CauDo;
import com.example.duoihinhbatchu.object.SoundManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Switch switchBackgroundMusic;
    private Switch switchSoundEffect;

    private ArrayList<CauDo> list;


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

        layCauDo();
//        if (list != null){
//            for (CauDo c : list){
//                Log.d("Cau Do", c.getDapAn());
//            }
//        }else
//            Log.d("Cau Do", "K lay duoc cau do");

        playButton.setOnClickListener(v -> {
            SoundManager.playSoundEffect(MainActivity.this, R.raw.click_sound);
            Intent intent = new Intent(MainActivity.this, ChoiGameActivity.class);
            intent.putExtra("cauDoList", list);
            startActivity(intent);
        });
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

    private void layCauDo() {
        list = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("caudo");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    CauDo cauDo = snapshot.getValue(CauDo.class);
                    list.add(cauDo);
//                    Log.d("FirebaseDatabase", "Cau Do : " + cauDo);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("FirebaseDatabase", "Failed to read value.", error.toException());
            }
        });
    }



}