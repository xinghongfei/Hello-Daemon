package com.example.maat.hello_daemon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by xinghongfei on 16/10/8.
 */

public class RemoteBroadcastRecieve extends BroadcastReceiver {

    boolean isFirst = true;

    @Override
    public void onReceive(final Context context, Intent intent) {


        if (isFirst) {
            isFirst=false;
           while (true){
               try {
                   Thread.sleep(2000);
                   context.startService(new Intent(context, DaemonService.class));
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }

        }


    }
}
