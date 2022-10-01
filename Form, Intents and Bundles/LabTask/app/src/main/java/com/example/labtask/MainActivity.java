package com.example.labtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ename, eage;
    CheckBox cmatric, cintr, cbs, cms;
    RadioButton rmale, rfemale;
    Button bsubmit, bcancel;

    String name, age, qual = "", gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ename = findViewById(R.id.edtName);
        eage = findViewById(R.id.edtAge);

        cmatric = findViewById(R.id.chkmatric);
        cintr = findViewById(R.id.chkintr);
        cbs = findViewById(R.id.chkbs);
        cms = findViewById(R.id.chkms);

        rmale = findViewById(R.id.rdmale);
        rfemale = findViewById(R.id.rdfemale);

        bsubmit = findViewById(R.id.btnSubmit);
        bcancel = findViewById(R.id.btnCancel);
    }

    public void submit(View view) {

        if (cmatric.isChecked()) {
            qual = cmatric.getText().toString();
        }
        if (cintr.isChecked()) {
            qual = qual+", "+cintr.getText().toString();
        }
        if (cbs.isChecked()) {
            qual = qual+", "+cbs.getText().toString();
        }
        if (cms.isChecked()) {
            qual = qual+", "+cms.getText().toString();
        }
        int o = checkDetails();
        int i = checkGender();
        if (i != 1 && o!=0) {
            Toast.makeText(getApplicationContext(), "Data Submitted", Toast.LENGTH_LONG).show();
            passDetails();
        }



    }

    public int checkGender() {
        int i = 0;
        if (rmale.isChecked()) {
            gender = rmale.getText().toString();
        }
        else if (rfemale.isChecked()) {
            gender = rfemale.getText().toString();
        }
        else {
            Toast.makeText(getApplicationContext(), "Select Gender", Toast.LENGTH_LONG).show();
            i = 1;
        }
        return i;
    }

    public int checkDetails() {
        int i = 0;
        if (ename.getText().toString().matches("") || eage.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(), "Enter Details", Toast.LENGTH_LONG).show();
        }
        else{
            name = ename.getText().toString();
            age = eage.getText().toString();
            i = 1;
        }
        return i;
    }

    public void cancel(View view) {
        ename.setText("");
        eage.setText("");
        cmatric.setChecked(false);
        cintr.setChecked(false);
        cbs.setChecked(false);
        cms.setChecked(false);
        rmale.setChecked(false);
        rfemale.setChecked(false);

    }

    public void passDetails(){
        Intent in = new Intent(this, Display.class);
        Bundle b = new Bundle();

        b.putString("name", name);
        b.putString("age", age);
        b.putString("qual", qual);
        b.putString("gender", gender);

        in.putExtras(b);
        startActivity(in);
    }


}