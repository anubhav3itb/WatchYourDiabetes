package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by aditya on 27/4/17.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm Raised", Toast.LENGTH_SHORT).show();
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        PendingIntent pendingIntent= PendingIntent.getActivity(context,0,intent1,0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.gradient);
        builder.setContentTitle("Tracker");

        builder.setContentText("Turn on Gps");
        builder.setPriority(Notification.PRIORITY_MAX);
        builder.setDefaults(Notification.DEFAULT_SOUND);
        builder.setLights(0x0000FF,3000,2000);
        builder.setContentIntent(pendingIntent);
        notificationManager.notify(56, builder.build());
    }
}
