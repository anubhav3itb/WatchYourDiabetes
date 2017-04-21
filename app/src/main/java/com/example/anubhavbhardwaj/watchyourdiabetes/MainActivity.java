package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private Button continue_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseHandler db = new DatabaseHandler(this);

        if(db.getUserCount() > 0){
            Intent myIntent = new Intent( MainActivity.this, Reminder.class);
            this.startActivity(myIntent);
            return;
        }

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
}
