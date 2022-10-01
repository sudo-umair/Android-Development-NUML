package com.example.umairconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.sax.SAXResult;


public class MainActivity extends AppCompatActivity {

    EditText value;
    TextView conversion, result;

    String numberType = "decimal";
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conversion = findViewById(R.id.tConversion);
        value = findViewById(R.id.edtNumber);
        result = findViewById(R.id.tResult);
    }

    public void convert(View view) {
        if (value.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(), "Please enter a number first", Toast.LENGTH_SHORT).show();
        }
        else{
            number = Integer.parseInt(value.getText().toString());
            if (numberType.equals("decimal")){
                String fromDectoBin = convertToBinary(number);
                result.setText(("Binary is: " + fromDectoBin));
            }
            else if(numberType.equals("binary")){
                String fromBintoDec = convertToDecimal(number);
                result.setText(("Decimal is: " + fromBintoDec));
            }
        }
    }

    public void onSwitch(View view){
        if (numberType.equals("decimal")){
            numberType = "binary";
            conversion.setText(("Enter Binary Value"));
        }
        else {
            numberType = "decimal";
            conversion.setText(("Enter Decimal Value"));
        }
        onClear(view);
    }

    public void onClear(View view){
        value.setText("");
        result.setText("");
        Toast.makeText(getApplicationContext(), "Cleared!", Toast.LENGTH_SHORT).show();
    }
    public String convertToBinary(int decimal){
        int[] binary = new int[40];
        int index = 0;
        while(decimal > 0){
            binary[index++] = decimal%2;
            decimal = decimal/2;
        }
        StringBuilder s = new StringBuilder();
        for(int i = index-1;i >= 0;i--){
            s.append(binary[i]);
        }
        return s.toString();
    }

    public String convertToDecimal(int binary){
        int decimal = 0;
        int n = 0;
        while(true){
            if(binary == 0){
                break;
            }
            else {
                int temp = binary%10;
                decimal += temp*Math.pow(2, n);
                binary = binary/10;
                n++;
            }
        }
        return Integer.toString(decimal);
    }
}



