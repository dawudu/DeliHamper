package com.example.manthole.delihamper;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by manthole on 13 Nov 2017.
 */
public class NotificationReceiver extends BroadcastReceiver {

    private Context ctx;


    @Override
    public void onReceive(Context context, Intent intent) {


        int notificationId = intent.getIntExtra("notificationId", 0);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(notificationId);
    }

}
