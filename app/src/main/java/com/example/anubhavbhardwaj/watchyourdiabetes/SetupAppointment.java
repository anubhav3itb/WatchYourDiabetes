package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetupAppointment extends AppCompatActivity {

    Button endo;
    Button nutri;
    Button optha;
    Button nephro;
    Button podia;
    Button lipid;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_appointment);

        endo = (Button) findViewById(R.id.Endocrinologist);
        endo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( SetupAppointment.this, GetFirst.class);
                SetupAppointment.this.startActivity(myIntent);
            }
        });

        nutri = (Button) findViewById(R.id.Nutritionist);
        nutri.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( SetupAppointment.this, GetFirst.class);
                SetupAppointment.this.startActivity(myIntent);
            }
        });

        optha = (Button) findViewById(R.id.Opthalmologist);
        optha.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( SetupAppointment.this, GetFirst.class);
                SetupAppointment.this.startActivity(myIntent);
            }
        });

        nephro = (Button) findViewById(R.id.Nephrologist);
        nephro.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( SetupAppointment.this, GetFirst.class);
                SetupAppointment.this.startActivity(myIntent);
            }
        });

        podia = (Button) findViewById(R.id.Podiatrist);
        podia.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( SetupAppointment.this, GetFirst.class);
                SetupAppointment.this.startActivity(myIntent);
            }
        });

        lipid = (Button) findViewById(R.id.Lipid);
        lipid.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( SetupAppointment.this, GetFirst.class);
                SetupAppointment.this.startActivity(myIntent);
            }
        });

        home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( SetupAppointment.this, Reminder.class);
                SetupAppointment.this.startActivity(myIntent);
            }
        });

    }
}
