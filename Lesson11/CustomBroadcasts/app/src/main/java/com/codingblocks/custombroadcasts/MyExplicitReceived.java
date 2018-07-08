package com.codingblocks.custombroadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyExplicitReceived extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Explicit Broadcast called", Toast.LENGTH_SHORT).show();
    }
}
