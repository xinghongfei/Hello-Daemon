package com.example.maat.hello_daemon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by xinghongfei on 16/10/8.
 */

public class DaemonBroadcastRecieve extends BroadcastReceiver {
    private boolean isFirst = true;

    @Override
    public void onReceive(final Context context, Intent intent) {
        while (isFirst) {
            isFirst = false;
            while (true){
                try {
                    Thread.sleep(2000);
                    Log.i("hehe", "DaemonBroadRecieve is onReceive");
                    context.startService(new Intent(context, RemoteService.class));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
