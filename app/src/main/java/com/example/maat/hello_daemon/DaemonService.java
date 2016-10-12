package com.example.maat.hello_daemon;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by xinghongfei on 16/10/8.
 */

public class DaemonService extends Service {
    private boolean isFirst = true;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("hehe", "DaemoService is onStartCommend");
//        if (isFirst) {
            Notification.Builder builder = new Notification.Builder(this);
            builder.setSmallIcon(R.mipmap.ic_launcher);
            startForeground(111, builder.build());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SystemClock.sleep(1000);
                    stopForeground(true);
                    NotificationManager manager =
                            (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    manager.cancel(111);

                }
            }).start();
//            isFirst = false;
//        }
//        sendBroadcast(new Intent(this,RemoteBroadcastRecieve.class));
//        startService(new Intent(this,RemoteService.class));

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i("hehe", "DaemonService is Destroy");
        super.onDestroy();
    }
}
