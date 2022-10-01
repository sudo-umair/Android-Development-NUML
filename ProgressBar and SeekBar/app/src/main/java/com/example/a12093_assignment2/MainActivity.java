package com.example.a12093_assignment2;


import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar pgbarHor;
    SeekBar seekBar;
    TextView progressbarProgress, seekbarProgress;
    String progressPerc;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pgbarHor = findViewById(R.id.progressBar2);
        progressbarProgress = findViewById(R.id.progressbarProgress);

        seekBar = findViewById(R.id.seekBar);
        seekbarProgress = findViewById(R.id.seekbarProgress);

        String temp1 = "ProgressBar: " + progressPerc + " %";
        progressbarProgress.setText(temp1);

        String temp2 = "Seekbar: " + seekBar.getProgress() + " %";
        seekbarProgress.setText(temp2);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String temp = Integer.toString(progress);
                String str1 = "Seekbar: " + temp + " %";
                seekbarProgress.setText(str1);

                if (seekBar.getProgress() == 100) {
                    Toast.makeText(getApplicationContext(), "SeekBar is at MAX", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void Add(View view) {
        counter += 10;
        pgbarHor.setProgress(counter);

        int temp = pgbarHor.getProgress();
        progressPerc = Integer.toString(temp);

        String str2 = "ProgressBar: " + progressPerc + " %";
        progressbarProgress.setText(str2);

        if (pgbarHor.getProgress() == 100) {
            Toast.makeText(getApplicationContext(), "ProgressBar is at MAX", Toast.LENGTH_SHORT).show();
        }

    }
}