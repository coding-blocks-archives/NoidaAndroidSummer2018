package com.codingblocks.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String CHANNEL_ID = "420";
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel(CHANNEL_ID,
                            "Default Channel",
                            NotificationManager.IMPORTANCE_DEFAULT);

            notificationManager.createNotificationChannel(notificationChannel);
        }


    }

    public void inboxStyle(View view) {
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Hello There!")
                .setContentText("I've been expecting you!")
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("Line 1")
                        .addLine("Line 2")
                        .addLine("Line 3")
                        .addLine("Line 4")
                        .addLine("Line 5")
                        .addLine("Line 6"))
                .build();

        notificationManager.notify(1111114, notification);

    }

    public void expandedText(View view) {
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Hello There!")
                .setContentText("I've been expecting you!")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("What do we have here? Perhaps the archives are incomplete!"))
                .build();

        notificationManager.notify(1111112, notification);
    }

    public void simpleNotification(View view) {

        Intent intent = new Intent(this, MainActivity.class);

        PendingIntent pi = PendingIntent.getActivity(this,
                333,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Hello There!")
                .setContentText("I've been expecting you!")
                .setContentIntent(pi)
                .setAutoCancel(true)
                .addAction(R.drawable.ic_android_black,"Reply",pi)
                .build();

        notificationManager.notify(1111111, notification);

    }


    public void expandedImage(View view) {


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Hello There!")
                .setContentText("I've been expecting you!")
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap))
                .build();

        notificationManager.notify(1111113, notification);

    }
}
