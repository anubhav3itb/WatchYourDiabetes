package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class EditableInformation extends AppCompatActivity {

    Button continue_button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editable_information);

        continue_button = (Button) findViewById(R.id.continue1);
        continue_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( EditableInformation.this, EditableInformation2.class);
                EditableInformation.this.startActivity(myIntent);
            }
        });
    }
}
