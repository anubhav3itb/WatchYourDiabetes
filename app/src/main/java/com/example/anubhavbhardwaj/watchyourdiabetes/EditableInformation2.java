package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditableInformation2 extends AppCompatActivity {

    Button continue_button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editable_information2);

        continue_button = (Button) findViewById(R.id.submit);
        continue_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( EditableInformation2.this, SetupAppointment.class);
                EditableInformation2.this.startActivity(myIntent);
            }
        });
    }
}