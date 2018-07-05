package com.codingblocks.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Toast.makeText(context, "Hello from the Airplane Broadcast", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "Hello from the Power Connected Broadcast", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "Hello from the Power Disconnected Broadcast", Toast.LENGTH_SHORT).show();
                break;
        }


//        Intent intent1 = new Intent(context,MainActivity.class);
//        context.startActivity(intent1);

    }

}
