package com.wisys.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isPlay = false;
    boolean isPause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // TODO Method to start the service
    public void startPlayer(View view) {
        if(isPlay == false)
        {
            isPlay = true;
            Intent intent = new Intent(this, MusicService.class);
            intent.putExtra("key", "play");
            startService(intent);
        }
        else
        {
            isPlay = false;
            Intent intent = new Intent(this, MusicService.class);
            intent.putExtra("key", "stop");
            startService(intent);
        }

    }

    // TODO Method to pause the service
    public void pausePlayer(View view) {
        if(isPlay == true && isPause == false)
        {
            isPause = true;
            Intent intent = new Intent(this, MusicService.class);
            intent.putExtra("key", "pause");
            startService(intent);
        }
        else if(isPlay == true && isPause == true)
        {
            isPause = false;
            Intent intent = new Intent(this, MusicService.class);
            intent.putExtra("key", "resume");
            startService(intent);
        }

    }

}
