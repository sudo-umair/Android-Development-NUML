package com.example.labtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    TextView name, age, qual, gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        name = findViewById(R.id.tname);
        age = findViewById(R.id.tage);
        qual = findViewById(R.id.tqual);
        gender = findViewById(R.id.tgender);

        Bundle b = getIntent().getExtras();

        String sname = b.getString("name");
        String sage = b.getString("age");
        String squal = b.getString("qual");
        String sgender = b.getString("gender");


        name.setText(sname);
        age.setText(sage);
        qual.setText(squal);
        gender.setText(sgender);






    }
}