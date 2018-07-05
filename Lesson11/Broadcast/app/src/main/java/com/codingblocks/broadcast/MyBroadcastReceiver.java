package com.codingblocks.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Hello from the Broadcast", Toast.LENGTH_SHORT).show();

    }

}
