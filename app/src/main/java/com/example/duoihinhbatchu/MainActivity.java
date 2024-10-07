package com.example.duoihinhbatchu;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duoihinhbatchu.object.SoundManager;

public class MainActivity extends AppCompatActivity {
    private Switch switchBackgroundMusic;
    private Switch switchSoundEffect;
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
}
