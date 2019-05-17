package com.terset.myapplication;


import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class modul5 extends AppCompatActivity {

    EditText isiuser,isipass;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul5);

        isiuser = findViewById(R.id.isiuser);
        isipass = findViewById(R.id.isipass);
        btn_login = findViewById(R.id.btn_login);
    }

    public void login (View view){
        String usernameKey = isiuser.getText().toString();
        String passwordKey = isipass.getText().toString();

        if (usernameKey.equals("gloriafebby") && passwordKey.equals("160411100059")){
            Intent intent = new Intent(this,menu.class);
            startActivity(intent);
            finish();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Username atau Password Anda Salah").setNegativeButton("Retry",null).create().show();
        }
    }
}


