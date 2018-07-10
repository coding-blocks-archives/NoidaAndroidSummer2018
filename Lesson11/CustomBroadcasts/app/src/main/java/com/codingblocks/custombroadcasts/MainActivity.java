package com.codingblocks.custombroadcasts;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnExplicit = findViewById(R.id.btnExplicit), btnImplicit = findViewById(R.id.btnImplicit);

        btnExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MyExplicitReceived.class);
                sendBroadcast(intent);
            }
        });

        MyImplicitReceiver myImplicitReceiver = new MyImplicitReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.codingblocks.custombroadcasts");

        registerReceiver(myImplicitReceiver,intentFilter);

        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent();
                i.setAction("com.codingblocks.custombroadcasts");

                sendBroadcast(i);

            }
        });


    }
}
