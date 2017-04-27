package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditableInformation extends AppCompatActivity {

    Button continue_button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editable_information);

        final DatabaseHandler db = new DatabaseHandler(this);

        continue_button = (Button) findViewById(R.id.continuebutton2);
        continue_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                EditText vweight = (EditText) findViewById(R.id.weight);
                EditText vheight = (EditText) findViewById(R.id.height);
                EditText vfastingBloodSugar = (EditText) findViewById(R.id.fastbloodsugar);
                EditText vpostLunchBloodSugar = (EditText) findViewById(R.id.postlunchbloodsugar);
                EditText vhba1c = (EditText) findViewById(R.id.hba);

                int weight = Integer.parseInt(vweight.getText().toString());
                int height = Integer.parseInt(vheight.getText().toString());
                int fastingBloodSugar = Integer.parseInt(vfastingBloodSugar.getText().toString());
                int postLunchBloodSugar = Integer.parseInt(vpostLunchBloodSugar.getText().toString());
                int hba1c = Integer.parseInt(vhba1c.getText().toString());

                db.addmutableUserData(new MutableUserData(1, weight, height, fastingBloodSugar, postLunchBloodSugar, hba1c));

                Intent myIntent = new Intent( EditableInformation.this, EditableInformation2.class);
                myIntent.putExtra("doctortype", (int)1);
                EditableInformation.this.startActivity(myIntent);
            }
        });
    }
}