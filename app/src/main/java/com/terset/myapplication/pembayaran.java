package com.terset.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class pembayaran extends AppCompatActivity {

    TextView nama,bayar,kembalian,bayar2;
    TextView txtmenu1,txtmenu2,txtmenu3;
    TextView hrgmenu1,hrgmenu2,hrgmenu3;
    TextView jmlhmenu1,jmlhmenu2,jmlhmenu3;
    TextView to_Menu1,to_Menu2,to_Menu3;
    TextView total_view, kembalian_view;
    EditText bayar_view;
    int total_harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        nama = findViewById(R.id.LihatNama);
        bayar = findViewById(R.id.bayar);
        bayar_view = findViewById(R.id.bayar_view);
        kembalian = findViewById(R.id.kembalian);
        kembalian_view = findViewById(R.id.kembalian_view);
        to_Menu1 = findViewById(R.id.total_kopi1);
        to_Menu2 = findViewById(R.id.total_kopi2);
        to_Menu3 = findViewById(R.id.total_kopi3);

        total_harga = 0;

        nama.setText(getIntent().getStringExtra("nama"));
        bayar.setText(R.string.bayar);
        kembalian.setText(R.string.kembalian);
        if (getIntent().getStringExtra(getString(R.string.c1)).equals(getString(R.string.t))) {
            txtmenu1 = findViewById(R.id.txt_kopi1);
            txtmenu1.setText(getIntent().getStringExtra(getString(R.string.txt_menu1)));
            hrgmenu1 = findViewById(R.id.harga_kopi1);
            hrgmenu1.setText(getIntent().getStringExtra(getString(R.string.hrg_menu1)));
            jmlhmenu1 = findViewById(R.id.jmlh_kopi1);
            jmlhmenu1.setText(getIntent().getStringExtra(getString(R.string.jmlh_menu1)));
            to_Menu1.setText(getIntent().getStringExtra(getString(R.string.total_menu1)));
            total_harga += Integer.parseInt(getIntent().getStringExtra(getString(R.string.total_menu1)));
        } else {
            RelativeLayout RL3 = findViewById(R.id.RL3);
            RL3.setVisibility(View.GONE);
        }
        if (getIntent().getStringExtra(getString(R.string.c2)).equals(getString(R.string.t))) {
            txtmenu2 = findViewById(R.id.txt_kopi2);
            txtmenu2.setText(getIntent().getStringExtra(getString(R.string.txt_menu2)));
            hrgmenu2 = findViewById(R.id.harga_kopi2);
            hrgmenu2.setText(getIntent().getStringExtra(getString(R.string.hrg_menu2)));
            jmlhmenu2 = findViewById(R.id.jmlh_kopi2);
            jmlhmenu2.setText(getIntent().getStringExtra(getString(R.string.jmlh_menu2)));
            to_Menu2.setText(getIntent().getStringExtra(getString(R.string.total_menu2)));
            total_harga += Integer.parseInt(getIntent().getStringExtra(getString(R.string.total_menu2)));
        } else {
            RelativeLayout RL4 = findViewById(R.id.RL4);
            RL4.setVisibility(View.GONE);
        }
        if (getIntent().getStringExtra(getString(R.string.c3)).equals(getString(R.string.t))) {
            txtmenu3 = findViewById(R.id.txt_kopi3);
            txtmenu3.setText(getIntent().getStringExtra(getString(R.string.txt_menu3)));
            hrgmenu3 = findViewById(R.id.harga_kopi3);
            hrgmenu3.setText(getIntent().getStringExtra(getString(R.string.hrg_menu3)));
            jmlhmenu3 = findViewById(R.id.jmlh_kopi3);
            jmlhmenu3.setText(getIntent().getStringExtra(getString(R.string.jmlh_menu3)));
            to_Menu3.setText(getIntent().getStringExtra(getString(R.string.total_menu3)));
            total_harga += Integer.parseInt(getIntent().getStringExtra(getString(R.string.total_menu3)));
        } else {
            RelativeLayout RL5 = findViewById(R.id.RL5);
            RL5.setVisibility(View.GONE);
        }

        total_view = findViewById(R.id.total_view);
        total_view.setText(Integer.toString(total_harga));
    }
    public void bayar (View view){
        String hasil;
        if (bayar_view.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Masukkan Nominal Uang yang Harus Di Bayarkan",Toast.LENGTH_SHORT).show();
        } else {
            int bayar_semua = Integer.parseInt(bayar_view.getText().toString());
            if (bayar_semua>=total_harga){
                hasil = Integer.toString(bayar_semua-total_harga);
                kembalian_view.setText(hasil);
                Toast.makeText(getApplicationContext(),"Transaksi Berhasil !", Toast.LENGTH_SHORT).show();
            }
        }
    }
}