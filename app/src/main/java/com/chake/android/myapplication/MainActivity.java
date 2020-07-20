package com.chake.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testAudio();
        checkPermission();
    }

    private MediaRecorderUtil mediaRecorderUtil = new MediaRecorderUtil();

    private void testAudio(){
        View start = findViewById(R.id.start);
        start.setOnClickListener(this);
        View end = findViewById(R.id.end);
        end.setOnClickListener(this);
        View play = findViewById(R.id.start_play);
        play.setOnClickListener(this);
        View pause = findViewById(R.id.pause);
        pause.setOnClickListener(this);
        View stop = findViewById(R.id.stop);
        stop.setOnClickListener(this);
    }

    private MediaPlayerUtil mediaPlayerUtil = new MediaPlayerUtil();

    private void checkPermission(){
        //Manifest.permission.WRITE_EXTERNAL_STORAGE
        boolean b = PermissionUtil.checkPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (!b) {
            PermissionUtil.requestPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        b = PermissionUtil.checkPermission(this,Manifest.permission.RECORD_AUDIO);
        if (!b) {
            PermissionUtil.requestPermission(this, Manifest.permission.RECORD_AUDIO);
        }
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.start:
                mediaRecorderUtil.startRecord();
                break;
            case R.id.end:
                mediaRecorderUtil.stopRecord();
                break;
            case R.id.start_play:
                mediaPlayerUtil.startPlay(mediaRecorderUtil.getFinalPath());
                break;
            case R.id.pause:
                mediaPlayerUtil.pause();
                break;
            case R.id.stop:
                mediaPlayerUtil.stop();
                break;
            default:
                break;
        }
    }

}
