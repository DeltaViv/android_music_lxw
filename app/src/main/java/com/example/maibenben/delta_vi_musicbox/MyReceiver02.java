package com.example.maibenben.delta_vi_musicbox;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

public class MyReceiver02 extends BroadcastReceiver {
    AssetManager am;
    String[] musics = new String[] { "wish.mp3", "promise.mp3",
            "beautiful.mp3" };
    MediaPlayer mPlayer;
    public MyReceiver02() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        am = context.getAssets();
        mPlayer = new MediaPlayer();
        Toast.makeText(context, intent.getAction() +
                        "\n消息:" + intent.getStringExtra("msg"),
                Toast.LENGTH_LONG).show();
        Log.d("dd", "123456");
        prepareAndPlay("wish.mp3");
    }
    private void prepareAndPlay(String music)
    {
        try
        {
            // 打开指定音乐文件
            AssetFileDescriptor afd = am.openFd(music);
            mPlayer.reset();
            // 使用MediaPlayer加载指定的声音文件。
            mPlayer.setDataSource(afd.getFileDescriptor(),
                    afd.getStartOffset(), afd.getLength());
            // 准备声音
            mPlayer.prepare();
            // 播放
            mPlayer.start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
