package com.saifkhan.fingerresponsetimerrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String age,gender;
    EditText Eage;
    Button Bstart;
    public static final String AGE = "ageKey";
    public static final String GENDER = "genderKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bstart = (Button) findViewById(R.id.Button_Start_Main);
        Eage = (EditText)findViewById(R.id.Edittext_Age_Main);

/*
        Intent intent = new Intent(MainActivity.this, RespondRecordWindow.class);
        intent.putExtra("age","25");
        intent.putExtra("gender","F");
        startActivity(intent);
 */
        Bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age = Eage.getText().toString();
                Intent intent = new Intent(MainActivity.this, RespondRecordWindow.class);
                intent.putExtra("age",age);
                intent.putExtra("gender",gender);
                startActivity(intent);
            }
        });
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_male_main:
                if (checked)
                    gender = "M";
                break;
            case R.id.radio_female_main:
                if (checked)
                    gender = "F";
                break;
        }
    }
}