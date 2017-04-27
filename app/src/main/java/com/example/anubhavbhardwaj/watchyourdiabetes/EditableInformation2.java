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

        Log.d("SOMETHING", Integer.toString(doctor_type));

        final DatabaseHandler db = new DatabaseHandler(this);

        EditText vmedicine1 = (EditText) findViewById(R.id.medicine1);
        EditText vmedicine2 = (EditText) findViewById(R.id.medicine2);
        EditText vmedicine3 = (EditText) findViewById(R.id.medicine3);

        EditText vdosage1 = (EditText) findViewById(R.id.dosage1);
        EditText vdosage2 = (EditText) findViewById(R.id.dosage2);
        EditText vdosage3 = (EditText) findViewById(R.id.dosage3);

        Prescription pres = db.getPrescription(doctor_type);

        Log.d("TESTIT", pres.getMedicine1());

        vmedicine1.setText(pres.getMedicine1());
        vmedicine2.setText(pres.getMedicine2());
        vmedicine3.setText(pres.getMedicine3());

        vdosage1.setText(Integer.toString(pres.getDosage1()));
        vdosage2.setText(Integer.toString(pres.getDosage2()));
        vdosage3.setText(Integer.toString(pres.getDosage3()));

        continue_button = (Button) findViewById(R.id.submit);
        continue_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                EditText vmedicine1 = (EditText) findViewById(R.id.medicine1);
                EditText vmedicine2 = (EditText) findViewById(R.id.medicine2);
                EditText vmedicine3 = (EditText) findViewById(R.id.medicine3);

                EditText vdosage1 = (EditText) findViewById(R.id.dosage1);
                EditText vdosage2 = (EditText) findViewById(R.id.dosage2);
                EditText vdosage3 = (EditText) findViewById(R.id.dosage3);


                String medicine1 = vmedicine1.getText().toString();
                String medicine2 = vmedicine2.getText().toString();
                String medicine3 = vmedicine3.getText().toString();

                int dosage1 = Integer.parseInt(vdosage1.getText().toString());
                int dosage2 = Integer.parseInt(vdosage2.getText().toString());
                int dosage3 = Integer.parseInt(vdosage3.getText().toString());

                db.updatePrescription(new Prescription(doctor_type, medicine1, dosage1, medicine2, dosage2, medicine3, dosage3));

                Intent myIntent = new Intent( EditableInformation2.this, SetupAppointment.class);
                myIntent.putExtra("doctortype", (int)doctor_type);
                startActivity(myIntent);
            }
        });
    }
}
