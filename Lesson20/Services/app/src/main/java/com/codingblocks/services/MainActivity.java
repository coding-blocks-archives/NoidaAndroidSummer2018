package com.codingblocks.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnStartService;
    public static final String CHANNEL_ID = "420YOLO";
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartService = findViewById(R.id.btnStartService);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel(CHANNEL_ID,
                            "Default Channel",
                            NotificationManager.IMPORTANCE_DEFAULT);

            notificationManager.createNotificationChannel(notificationChannel);

            btnStartService.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent myService = new Intent(getBaseContext(), MyService.class);

                    Intent myIntentService = new Intent(getBaseContext(), MyIntentService.class);

                    Intent myForegroundService = new Intent(getBaseContext(), MyForegroundService.class);

//                startService(myService);

                    ContextCompat.startForegroundService(getBaseContext(), myForegroundService);

                    //Start the service here
                }
            });

        }
    }
}
