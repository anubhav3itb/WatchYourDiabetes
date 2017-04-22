package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditableInformation2 extends AppCompatActivity {

    Button continue_button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editable_information2);

        final DatabaseHandler db = new DatabaseHandler(this);

        MutableUserData data = db.getMutableUserData();

        continue_button = (Button) findViewById(R.id.submit);
        continue_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                EditText vmedicine1 = (EditText) findViewById(R.id.medicine1);
                EditText vmedicine2 = (EditText) findViewById(R.id.medicine2);
                EditText vmedicine3 = (EditText) findViewById(R.id.medicine3);

                EditText vdosage1 = (EditText) findViewById(R.id.dosage1);
                EditText vdosage2 = (EditText) findViewById(R.id.dosage2);
                EditText vdosage3 = (EditText) findViewById(R.id.dosage3);



                Intent myIntent = new Intent( EditableInformation2.this, SetupAppointment.class);
                EditableInformation2.this.startActivity(myIntent);
            }
        });
    }
}
