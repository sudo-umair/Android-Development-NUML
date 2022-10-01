package com.example.userpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name, fname;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.edtname);
        fname = findViewById(R.id.edtfname);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sp = getSharedPreferences("store", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("name", name.getText().toString());
        editor.putString("fname", fname.getText().toString());
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        sp = getSharedPreferences("store", MODE_PRIVATE);
        name.setText(sp.getString("name", ""));
        fname.setText(sp.getString("fname", ""));

    }
}