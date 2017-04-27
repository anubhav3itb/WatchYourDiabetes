package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// made in reference with http://www.journaldev.com/9976/android-date-time-picker-dialog
public class SetupAppointment extends AppCompatActivity implements View.OnClickListener {

    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_appointment);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        try {
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#88001b")));
        }
        catch (Exception e){
            Log.d("Ooops",e.toString());
        }

        final DatabaseHandler db = new DatabaseHandler(this);

        int doctor_type_tmp = 1;
        Bundle extras = getIntent().getExtras();
        try {
            doctor_type_tmp = extras.getInt("doctortype");

        }
        catch(Exception e){
            assert(1 < 0);
        }

        final int doctor_type = doctor_type_tmp;

        assert(doctor_type > 0);

        btnDatePicker=(Button)findViewById(R.id.btn_date);
        btnTimePicker=(Button)findViewById(R.id.btn_time);
        txtDate=(EditText)findViewById(R.id.in_date);
        txtTime=(EditText)findViewById(R.id.in_time);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);

        Button continue_button = (Button) findViewById(R.id.submitDate);
        continue_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String date = txtDate.getText().toString();
                String time = txtTime.getText().toString();

                db.updateAppointment(new Appointment(doctor_type, date + " " + time));

                Log.d("TIME", date + " " + time);

                Intent myIntent = new Intent( SetupAppointment.this, Reminders.class);
                SetupAppointment.this.startActivity(myIntent);

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                try {
                    cal.setTime(sdf.parse(date + " " + time));
                    createAlarm(doctor_type, cal);
                }
                catch (Exception e){
                    Log.d("WHY :(", e.toString());
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }

    private void createAlarm(int id, Calendar cal) {
        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.putExtra("requestCode", (int) id);
        PendingIntent sender = PendingIntent.getBroadcast(this, id, intent, 0);

        // Get the AlarmManager service
        AlarmManager am = (AlarmManager) this.getSystemService(this.ALARM_SERVICE);
        am.cancel(sender);

        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), sender);
        Toast.makeText(this, "New alarm has been set", Toast.LENGTH_SHORT).show();
    }
}