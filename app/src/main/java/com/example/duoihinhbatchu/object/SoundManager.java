package com.example.duoihinhbatchu.object;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundManager {
    private static MediaPlayer backgroundMusic;
    private static MediaPlayer soundEffect;
    private static boolean isBackgroundMusicMuted = false;
    private static boolean isSoundEffectMuted = false;
    public static void playBackgroundMusic(Context context, int musicResId) {
        if (backgroundMusic == null) {
            backgroundMusic = MediaPlayer.create(context, musicResId);
            backgroundMusic.setLooping(true);
        }
        if (!isBackgroundMusicMuted) {
            backgroundMusic.start();
        }
    }
    public static void pauseBackgroundMusic() {
        if (backgroundMusic != null && backgroundMusic.isPlaying()) {
            backgroundMusic.pause();
        }
    }
    public static void resumeBackgroundMusic() {
        if (backgroundMusic != null && !backgroundMusic.isPlaying() && !isBackgroundMusicMuted) {
            backgroundMusic.start();
        }
    }
    public static void playSoundEffect(Context context, int soundEffectResId) {
        if (!isSoundEffectMuted) {
            soundEffect = MediaPlayer.create(context, soundEffectResId);
            soundEffect.start();
        }
    }
    public static void muteBackgroundMusic() {
        isBackgroundMusicMuted = true;
        pauseBackgroundMusic();
    }
    public static void unMuteBackgroundMusic() {
        isBackgroundMusicMuted = false;
        resumeBackgroundMusic();
    }
    public static void muteSoundEffect() {
        isSoundEffectMuted = true;
    }
    public static void unMuteSoundEffect() {
        isSoundEffectMuted = false;
    }
    public static void release() {
        if (backgroundMusic != null) {
            backgroundMusic.release();
            backgroundMusic = null;
        }
        if (soundEffect != null) {
            soundEffect.release();
            soundEffect = null;
        }
    }
    public static boolean isBackgroundMusicMuted() {
        return isBackgroundMusicMuted;
    }
    public static boolean isSoundEffectMuted() {
        return isSoundEffectMuted;
    }
}