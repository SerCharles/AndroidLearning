package com.wisys.systembroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private wifiReceiver wifiReceiver;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);


        // TODO registerReceiver
        wifiReceiver = new wifiReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        this.registerReceiver(wifiReceiver, filter);

    }

    public class wifiReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            TextView textView= MainActivity.this.findViewById(R.id.broadcast);
            //TODO create a broadcastReceiver to receive the broadcast sending by system
            //TODO change the textView(Wifi On/Wifi Off) according to the wifi status
            String action = intent.getAction();
            Bundle extras = intent.getExtras();

            if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(action)) {//这个监听wifi的打开与关闭，与wifi的连接无关
                int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, -1);
                System.out.println(wifiState);
                switch (wifiState) {
                    case WifiManager.WIFI_STATE_DISABLED:
                        System.out.println("Wifi Off");
                        textView.setText("Wifi Off");
                        break;
                    case WifiManager.WIFI_STATE_ENABLED:
                        System.out.println("Wifi On");

                        textView.setText("Wifi On");
                        break;


                }
            }

        }
    }

}
