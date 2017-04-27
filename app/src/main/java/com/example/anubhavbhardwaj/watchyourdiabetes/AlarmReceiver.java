package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by aditya on 27/4/17.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"You have a pending appointment! Check your reminders!", Toast.LENGTH_SHORT).show();

        int code = intent.getIntExtra("requestCode", 2);

        Log.d("WTFFFFFF", Integer.toString(code));

        Calendar cal = Calendar.getInstance();
        if(code <= 2){
            cal.add(Calendar.MONTH, 1);
        }
        else{
            cal.add(Calendar.YEAR, 1);
        }


        SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat time_format = new SimpleDateFormat("HH:mm");
        Date date = cal.getTime();
        String day = date_format.format(date);
        String time = time_format.format(date);

        final DatabaseHandler db = new DatabaseHandler(context);
        db.updateAppointment(new Appointment(code, day + " " + time));

        Intent intent2 = new Intent(context, AlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, code, intent2, 0);

        // Get the AlarmManager service
        AlarmManager am = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), sender);


        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
    }
}
