package com.example.message;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtMessage, edtNumber;
    public String message, number;
    Button sendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMessage = findViewById(R.id.editTextTextPersonName);
        edtNumber = findViewById(R.id.editTextNumber);

        sendMessage = findViewById(R.id.button);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = edtMessage.getText().toString();
                number = edtNumber.getText().toString();
                sendSmsUsingIntent();
            }
        });
    }

    public void sendSmsUsingApi(){
        try {
            SmsManager smgr = SmsManager.getDefault();
            smgr.sendTextMessage(number,null, message, null, null);

            Toast.makeText(this, "Passed", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void sendSmsUsingIntent(){
        try {
            Intent i = new Intent(android.content.Intent.ACTION_VIEW);
            i.setType("vnd.android-dir/mms-sms");
            i.putExtra("address", number);
            i.putExtra("sms_body", message);
            startActivity(i);
        }
        catch (Exception e) {
            Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }
}