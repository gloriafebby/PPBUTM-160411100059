package com.terset.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class modul1nomor2 extends AppCompatActivity {

    TextView result;
    EditText Berat,Tinggi;
    Button hitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul1nomor2);
        Berat = findViewById(R.id.inputBerat);
        Tinggi = findViewById(R.id.inputTinggi);
        result = findViewById(R.id.result);
        hitung = findViewById(R.id.hitung);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitungBMI();
            }
        });
    }
    private void hitungBMI(){

        String beratStr = Berat.getText().toString();
        String tinggiStr = Tinggi.getText().toString();

        if (beratStr!=null &&!"".equals(beratStr)
                && tinggiStr!=null &&!"".equals(tinggiStr)){
            float beratbdn= Float.parseFloat(beratStr);
            float tinggibdn = Float.parseFloat(tinggiStr)/100;

            float bmi = beratbdn / (tinggibdn * tinggibdn);

            displayBMI(bmi);
        }
    }

    private void displayBMI(float bmi){
        String ket = "" ;

        if (Float.compare(bmi, 18.5f)<=0){
            ket = "Under Weight";
        } else if (Float.compare(bmi, 18.5f)>0 && Float.compare(bmi, 24.9f)<=0){
            ket = "Normal Weight";
        } else if (Float.compare(bmi, 25f)>0 && Float.compare(bmi, 29.9f)<=0){
            ket = "Over Weight";
        } else if (Float.compare(bmi, 30f)>0 && Float.compare(bmi, 34.9f)<=0){
            ket = "Obesity 1";
        } else if (Float.compare(bmi, 35f)>0 && Float.compare(bmi, 39.9f)<=0){
            ket = "Obesity 2";
        } else {
            ket = "Obesity 3";
        }
        ket = bmi + "\n" + ket;
        result.setText(ket);
    }
}