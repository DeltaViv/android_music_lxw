package com.example.maibenben.delta_vi_musicbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity_02 extends Activity {
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = (Button)findViewById(R.id.button1);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.maibenben.delta_vi_musicbox.borad");
                intent.putExtra("msg", "简单的消息");
                Log.d("dd", "jjj");
                sendBroadcast(intent);
            }
        });
    }
}
