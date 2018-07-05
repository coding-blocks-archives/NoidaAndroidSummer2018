package com.codingblocks.custombroadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyImplicitReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Implicit Broadcast called", Toast.LENGTH_SHORT).show();
    }
}
