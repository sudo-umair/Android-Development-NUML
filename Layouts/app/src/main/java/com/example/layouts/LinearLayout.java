package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LinearLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
    }

    public void onclick1(View view){
        Toast.makeText(getApplicationContext(), "This is Button 1", Toast.LENGTH_SHORT).show();
    }
    public void onclick2(View view){
        Toast.makeText(getApplicationContext(), "This is Button 2", Toast.LENGTH_SHORT).show();
    }
    public void onclick3(View view){
        Toast.makeText(getApplicationContext(), "This is Button 3", Toast.LENGTH_SHORT).show();
    }
    public void onclick4(View view){
        Toast.makeText(getApplicationContext(), "This is Button 4", Toast.LENGTH_SHORT).show();
    }
}