package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button continue_button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continue_button = (Button) findViewById(R.id.continue1);
        continue_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent( MainActivity.this, EditableInformation.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}
