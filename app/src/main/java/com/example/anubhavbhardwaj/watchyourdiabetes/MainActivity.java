package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button continue_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testAlarm();

        setOneMonthDefaults();
        setOneYearDefaults();

        final DatabaseHandler db = new DatabaseHandler(this);

//        if(db.getUserCount() > 0){
//            Intent myIntent = new Intent( MainActivity.this, Reminder.class);
//            this.startActivity(myIntent);
//            return;
//        }

        continue_button = (Button) findViewById(R.id.continuebutton2);
        continue_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                EditText vname = (EditText)  findViewById(R.id.name);
                EditText vage = (EditText)  findViewById(R.id.age);
                RadioGroup group = (RadioGroup) findViewById(R.id.sex);

                String name = vname.getText().toString();
                int age  = Integer.parseInt(vage.getText().toString());
                int selectedId = group.getCheckedRadioButtonId();

                RadioButton rbutton = (RadioButton) findViewById(selectedId);
                String sex = rbutton.getText().toString();

                db.addUser(new User(1, name, age, sex));

                Intent myIntent = new Intent( MainActivity.this, EditableInformation.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }

    private void testAlarm() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 10);

        AlarmManager a = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(this, AlarmReceiver.class);
        PendingIntent  pi = PendingIntent.getBroadcast(this, 0, i, 0);
        a.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);
    }

    public void setOneMonthDefaults(){
        final DatabaseHandler db = new DatabaseHandler(this);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);

        SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat time_format = new SimpleDateFormat("HH:mm");
        Date date = cal.getTime();
        String day = date_format.format(date);
        String time = time_format.format(date);

        db.addAppointment(new Appointment(1, day + " " + time));
        db.addAppointment(new Appointment(2, day + " " + time));
    }

    public void setOneYearDefaults(){
        final DatabaseHandler db = new DatabaseHandler(this);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);

        SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat time_format = new SimpleDateFormat("HH:mm");
        Date date = cal.getTime();
        String day = date_format.format(date);
        String time = time_format.format(date);

        db.addAppointment(new Appointment(3, day + " " + time));
        db.addAppointment(new Appointment(4, day + " " + time));
        db.addAppointment(new Appointment(5, day + " " + time));
        db.addAppointment(new Appointment(6, day + " " + time));
    }
}
