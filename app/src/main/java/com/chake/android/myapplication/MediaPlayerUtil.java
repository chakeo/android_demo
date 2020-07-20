package com.chake.android.myapplication;

import android.media.MediaExtractor;
import android.media.MediaPlayer;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;

public class MediaPlayerUtil {

    private MediaPlayer mediaPlayer;

    private void initMediaPlayer(String filePath) {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(filePath);//指定音频文件路径
            mediaPlayer.setLooping(true);//设置为循环播放
            mediaPlayer.prepare();//初始化播放器MediaPlayer

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startPlay(String filePath) {
        if (!FileUtil.isFileExist(filePath)) {
            return;
        }

        if (mediaPlayer == null) {
            initMediaPlayer(filePath);
        }
        mediaPlayer.start();
    }

    public void pause() {
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.pause();
    }

    public void stop() {
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        mediaPlayer = null;
    }

}
