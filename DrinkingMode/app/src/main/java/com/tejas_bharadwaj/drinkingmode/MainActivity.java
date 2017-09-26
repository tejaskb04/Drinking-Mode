package com.tejas_bharadwaj.drinkingmode;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button drinkingModeBtn;
    private boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drinkingModeBtn = (Button) findViewById(R.id.drinking_mode_button);
        drinkingModeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clicked) {
                    drinkingModeBtn.setText("DISABLED");
                    clicked = false;
                } else {
                    WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(false);
                    drinkingModeBtn.setText("ENABLED");
                    clicked = true;
                }
            }
        });
    }
}
