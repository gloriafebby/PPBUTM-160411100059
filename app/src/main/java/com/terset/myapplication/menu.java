package com.terset.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends AppCompatActivity{
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;
    RecyclerView menu;
    ArrayAdapter<CharSequence> adapter;
    String[] jumlahPesanan;
    String[] ksp={"menu1","menu2","menu3","menu4","menu5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menu= findViewById(R.id.Menu);
        sp = getSharedPreferences("jumPesanan", Context.MODE_PRIVATE);
        spEditor = sp.edit();
        //menampilkan reyclerview yang ada pada file layout dengan id reycler view

        RecyclerAdapter adapter=new RecyclerAdapter(this);
        //membuat adapter baru untuk reyclerview
        menu.setAdapter(adapter);
        //menset nilai dari adapter
        menu.setHasFixedSize(true);
        //menset setukuran
        menu.setLayoutManager(new LinearLayoutManager(this));

        if (sp.getString("back", "").equals("true")){
            spEditor.putString("back", "false");
            spEditor.commit();
            Intent intent=new Intent(getApplication(),login.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_about) {
            Intent intent=new Intent(getApplication(),about.class);
            startActivity(intent);
        }
        if (id == R.id.menu_logout) {
            spEditor.putBoolean("login",false);
            spEditor.commit();
            Intent intent=new Intent(getApplication(),login.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void order(View view) {
        String m1=sp.getString(ksp[0], "");
        String m2=sp.getString(ksp[1], "");
        String m3=sp.getString(ksp[2], "");
        if (m1.equals("0") && m2.equals("0") && m3.equals("0")){
            Toast.makeText(getApplication(), "Pesanan kosong", Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent=new Intent(getApplication(),nota.class);
            startActivity(intent);
        }
    }
}
