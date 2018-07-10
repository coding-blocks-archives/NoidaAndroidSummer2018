package com.codingblocks.localbroadcasts;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //A custom action that will be used to register MyReceiver
    public static final String CUSTOM_ACTION = "com.codingblocks.localbroadcasts";

    MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myReceiver = new MyReceiver();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CUSTOM_ACTION);

        //Registers the broadcast receiver locally so that other apps can't execute it
        LocalBroadcastManager
                .getInstance(this)
                .registerReceiver(myReceiver, intentFilter);

        Button button = findViewById(R.id.btnLocal);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CUSTOM_ACTION);
//                intent.setAction(CUSTOM_ACTION);
                //Sends the broadcast locally so that other apps won't receive it
                LocalBroadcastManager
                        .getInstance(getBaseContext())
                        .sendBroadcast(intent);

            }
        });

    }

    @Override
    protected void onStop() {
        LocalBroadcastManager
                .getInstance(this)
                .unregisterReceiver(myReceiver);
        super.onStop();
    }
}
