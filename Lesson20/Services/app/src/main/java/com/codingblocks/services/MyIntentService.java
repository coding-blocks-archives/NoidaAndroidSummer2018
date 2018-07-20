package com.codingblocks.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by harshitdwivedi on 20/07/18.
 */

public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public MyIntentService() {
        super("MyIntentServiceThread");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //Runs in a separate thread by default
        //You can call blocking operations here directly

        //The service is killed by the OS as soon as the work here is done
    }
}
