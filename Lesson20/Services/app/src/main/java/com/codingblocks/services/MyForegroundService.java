package com.codingblocks.services;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

/**
 * Created by harshitdwivedi on 20/07/18.
 */

public class MyForegroundService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Intent stopForeground = new Intent(this, MyForegroundService.class);
        stopForeground.putExtra("KEY", true);

        PendingIntent pi = PendingIntent.getService(this,
                333,
                stopForeground,
                PendingIntent.FLAG_UPDATE_CURRENT);

        //When the onStartCommand was called the second time,
        //i.e. when the user tapped on the stop button
        if (intent.hasExtra("KEY")) {
            stopSelf();
        }

        Notification notification = new NotificationCompat.Builder(this, MainActivity.CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Hello There!")
                .setContentText("I've been expecting you!")
                .setAutoCancel(true)
                .addAction(R.mipmap.ic_launcher, "Stop", pi)
                .build();

        startForeground(420, notification);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
