package com.terset.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class modul1nomor1 extends AppCompatActivity {

    EditText Edit;
    TextView View;
    TextView Lihat;
    Button Press;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul1nomor1);

        //connecting to xml
        Edit = findViewById(R.id.inputNama);
        View = findViewById(R.id.hasil);
        Press = findViewById(R.id.simpan);
        Lihat = findViewById(R.id.nama);

    }
    public void Simpan (android.view.View view) {
        String namasa = Edit.getText().toString();
        View.setText(namasa);
    }
}
