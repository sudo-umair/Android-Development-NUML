package com.example.umair;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.umair.R.layout.abc_activity_chooser_view_list_item;
import static com.example.umair.R.layout.support_simple_spinner_dropdown_item;

public class MainActivity extends AppCompatActivity {

    String[] pres = {"Asif Ali Zardari", "Ayub Khan", "Mamnoon Husain", "Arif Alvi"};
    String[] pm = {"Imran Khan", "Nawaz Sharif", "Shahid Khaqan", "Yousaf Raza"};
    ListView liView;
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liView = findViewById(R.id.listview1);
        spin = findViewById(R.id.spinner);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, pm);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        ArrayAdapter<String> ab = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pres);
        liView.setAdapter(ab);


        liView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You have selected: " + pres[position], Toast.LENGTH_SHORT).show();
            }
        });

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You have selected " + pm[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}