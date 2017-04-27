package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Reminders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

        final DatabaseHandler db = new DatabaseHandler(this);

        TextView endo_days   = (TextView) findViewById(R.id.endo_days);
        TextView nutri_days  = (TextView) findViewById(R.id.nutri_days);
        TextView optha_days  = (TextView) findViewById(R.id.optha_days);
        TextView nephro_days = (TextView) findViewById(R.id.nephro_days);
        TextView poda_days   = (TextView) findViewById(R.id.poda_days);
        TextView lipid_days  = (TextView) findViewById(R.id.lipid_days);

        endo_days.setText(  daysLeft(db.getAppointment(1).getDate()));
        nutri_days.setText( daysLeft(db.getAppointment(2).getDate()));
        optha_days.setText( daysLeft(db.getAppointment(3).getDate()));
        nephro_days.setText(daysLeft(db.getAppointment(4).getDate()));
        poda_days.setText(  daysLeft(db.getAppointment(5).getDate()));
        lipid_days.setText( daysLeft(db.getAppointment(6).getDate()));

        endo_days.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( Reminders.this, SetupAppointment.class);
                myIntent.putExtra("doctortype", (int)1);
                Reminders.this.startActivity(myIntent);
            }
        });

        nutri_days.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( Reminders.this, SetupAppointment.class);
                myIntent.putExtra("doctortype", (int)2);
                Reminders.this.startActivity(myIntent);
            }
        });

        optha_days.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( Reminders.this, SetupAppointment.class);
                myIntent.putExtra("doctortype", (int)3);
                Reminders.this.startActivity(myIntent);
            }
        });

        nephro_days.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( Reminders.this, SetupAppointment.class);
                myIntent.putExtra("doctortype", (int)4);
                Reminders.this.startActivity(myIntent);
            }
        });

        poda_days.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( Reminders.this, SetupAppointment.class);
                myIntent.putExtra("doctortype", (int)5);
                Reminders.this.startActivity(myIntent);
            }
        });

        lipid_days.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( Reminders.this, SetupAppointment.class);
                myIntent.putExtra("doctortype", (int)6);
                Reminders.this.startActivity(myIntent);
            }
        });


        TextView endo   = (TextView) findViewById(R.id.endo);
        TextView nutri  = (TextView) findViewById(R.id.nutri);
        TextView optha  = (TextView) findViewById(R.id.optha);
        TextView nephro = (TextView) findViewById(R.id.nephro);
        TextView poda   = (TextView) findViewById(R.id.poda);
        TextView lipid  = (TextView) findViewById(R.id.lipid);

        endo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( Reminders.this, EditableInformation2.class);
                myIntent.putExtra("doctortype", (int)1);
                Reminders.this.startActivity(myIntent);
            }
        });

        nutri.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( Reminders.this, EditableInformation2.class);
                myIntent.putExtra("doctortype", (int)2);
                Reminders.this.startActivity(myIntent);
            }
        });

        optha.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( Reminders.this, EditableInformation2.class);
                myIntent.putExtra("doctortype", (int)3);
                Reminders.this.startActivity(myIntent);
            }
        });

        nephro.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( Reminders.this, EditableInformation2.class);
                myIntent.putExtra("doctortype", (int)4);
                Reminders.this.startActivity(myIntent);
            }
        });

        poda.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( Reminders.this, EditableInformation2.class);
                myIntent.putExtra("doctortype", (int)5);
                Reminders.this.startActivity(myIntent);
            }
        });

        lipid.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( Reminders.this, EditableInformation2.class);
                myIntent.putExtra("doctortype", (int)6);
                Reminders.this.startActivity(myIntent);
            }
        });

    }

    public String daysLeft(String endtime){
        Calendar today = Calendar.getInstance();
        Calendar later = Calendar.getInstance();

        try {
            later.setTime(new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(endtime));
        }
        catch (Exception e){
            Log.wtf("WTF", e.toString());
        }

        int ans = 0;
        while(later.after(today)){
            today.add(Calendar.DAY_OF_MONTH, 1);
            ans++;
        }

        return Integer.toString(ans);
    }
}
