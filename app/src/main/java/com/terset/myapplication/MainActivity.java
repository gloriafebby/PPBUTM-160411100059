package com.terset.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button modulsatu;
    Button modulsatunomordua;
    Button moduldua;
    Button modultiga;
    Button modulempat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modulsatu =  findViewById(R.id.btn1);
        modulsatunomordua = findViewById(R.id.btn2);
        moduldua = findViewById(R.id.btn3);
        modultiga = findViewById(R.id.btn4);
        modulempat = (Button) findViewById(R.id.btn5);
    }

    public void Modulsatusatu(View v) {
        Intent i = new Intent(MainActivity.this, modul1nomor1.class);
        startActivity(i);
    }

    public void Modulsatudua(View w) {
        Intent x = new Intent(MainActivity.this, modul1nomor2.class);
        startActivity(x);
    }

    public void Moduldua(View a) {
        Intent b = new Intent(MainActivity.this, modul2.class);
        startActivity(b);
    }

    public void Modultiga(View d){
        Intent c = new Intent(MainActivity.this,login.class);
        startActivity(c);
    }

    public void Modulempat(View e){
        Intent f = new Intent(MainActivity.this,login.class);
        startActivity(f);
    }

    public void ModulLima(View e){
        Intent f = new Intent(MainActivity.this,mainmodul5.class);
        startActivity(f);
    }
}
