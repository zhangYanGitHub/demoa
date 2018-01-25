package com.zhang.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoControlView controlView = (VideoControlView) findViewById(R.id.control_view);

        controlView.setOnRecordListener(new VideoControlView.OnRecordListener() {
            @Override
            public void onShortClick() {
                Toast.makeText(MainActivity.this, "点击事件", Toast.LENGTH_SHORT).show();
                Log.i(TAG,"点击事件");

            }

            @Override
            public void OnRecordStartClick() {
                Toast.makeText(MainActivity.this, "开始录制", Toast.LENGTH_SHORT).show();
                Log.i(TAG,"开始录制");
            }

            @Override
            public void OnFinish(int resultCode) {
                switch (resultCode) {
                    case 0:
                        Toast.makeText(MainActivity.this, "录制时间过短", Toast.LENGTH_SHORT).show();
                        Log.i(TAG,"录制时间过短");
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "录制结束", Toast.LENGTH_SHORT).show();
                        Log.i(TAG,"录制结束");
                        break;
                }

            }
        });
    }
}
