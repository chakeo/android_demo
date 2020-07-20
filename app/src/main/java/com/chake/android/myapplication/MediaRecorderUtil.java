package com.chake.android.myapplication;

import android.media.MediaRecorder;
import android.text.format.DateFormat;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

public class MediaRecorderUtil {

    private MediaRecorder mMediaRecorder;
    private final String TAG = "MediaRecorderUtil";
    private String filePath;
    private String fileName;

    public void startRecord() {
        // 开始录音
        /* ①Initial：实例化MediaRecorder对象 */
        if (mMediaRecorder == null)
            mMediaRecorder = new MediaRecorder();
        try {
            /* ②setAudioSource/setVedioSource */
            mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);// 设置麦克风
            /*
             * ②设置输出文件的格式：THREE_GPP/MPEG-4/RAW_AMR/Default THREE_GPP(3gp格式
             * ，H263视频/ARM音频编码)、MPEG-4、RAW_AMR(只支持音频且音频编码要求为AMR_NB)
             */
            mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            /* ②设置音频文件的编码：AAC/AMR_NB/AMR_MB/Default 声音的（波形）的采样 */
            mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            fileName = DateFormat.format("yyyyMMdd_HHmmss", Calendar.getInstance(Locale.CHINA)) + ".m4a";
            filePath = FileUtil.getDirPath(fileName);
            Log.i("ouTest","filePath:"+filePath);
            /* ③准备 */
            mMediaRecorder.setOutputFile(filePath);
            mMediaRecorder.prepare();
            /* ④开始 */
            mMediaRecorder.start();
        } catch (IllegalStateException e) {
            Log.i(TAG,"call startAmr(File mRecAudioFile) failed!" + e.getMessage());
        } catch (IOException e) {
            Log.i(TAG,"call startAmr(File mRecAudioFile) failed!" + e.getMessage());
        }
    }

    public String getFinalPath(){
        return filePath;
    }

    public void stopRecord() {
        try {
            mMediaRecorder.stop();
            mMediaRecorder.release();
            mMediaRecorder = null;
        } catch (RuntimeException e) {
            Log.e(TAG,e.toString());
            mMediaRecorder.reset();
            mMediaRecorder.release();
            mMediaRecorder = null;

            File file = new File(filePath);
            if (file.exists())
                file.delete();

            filePath = "";
        }
    }
}
