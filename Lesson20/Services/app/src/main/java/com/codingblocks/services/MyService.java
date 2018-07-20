package com.codingblocks.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by harshitdwivedi on 20/07/18.
 */

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "onCreate: ");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG", "onStartCommand: ");
        //stopSelf()  kills the service so that next time a
        //new instance of the service will be created

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (long i = 0; i < 10000000000L; i++) {
                    //Run the loop
                }
                stopSelf();
            }
        }).start();

        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
