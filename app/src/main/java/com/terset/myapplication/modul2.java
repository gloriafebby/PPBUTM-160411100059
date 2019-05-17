package com.terset.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class modul2 extends AppCompatActivity {

    int bayar2, total3, kembalian3, jumlahsatu, jumlahdua, jumlahtiga, arab, amer, robu, total4, total5, total6;
    EditText bayari;
    TextView total2;
    EditText nama2, jumlah1, jumlah2, jumlah3;
    CheckBox Ar, Am, Ro;
    RadioButton panas1, panas2, panas3, dingin1, dingin2, dingin3;
    Button ordering, pembayaran;
    TextView viewname, bahasa,sajian, menu, jumlah, bayar, kembalian, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul2);
        //Edit Text
        nama2 = findViewById(R.id.editNamaPemesan);
        bayari = findViewById(R.id.bayar2);
        jumlah1 = findViewById(R.id.jumlah1);
        jumlah2 = findViewById(R.id.jumlah2);
        jumlah3 = findViewById(R.id.jumlah3);

        //Text View
        total2 = findViewById(R.id.total2);
        menu = findViewById(R.id.menuCoffe);
        sajian = findViewById(R.id.sajian);
        jumlah = findViewById(R.id.jumlah);
        bayar = findViewById(R.id.bayar);
        kembalian = findViewById(R.id.kembalian);
        total = findViewById(R.id.total);
        bahasa = findViewById(R.id.bahasa);
        viewname = findViewById(R.id.nama);

        //CheckBox
        Ar = findViewById(R.id.kopi1);
        Am = findViewById(R.id.kopi2);
        Ro = findViewById(R.id.kopi3);

        //RadioButton
        panas1 = findViewById(R.id.panas1);
        dingin1 = findViewById(R.id.dingin1);
        panas2 = findViewById(R.id.panas2);
        dingin2 = findViewById(R.id.dingin2);
        panas3 = findViewById(R.id.panas3);
        dingin3 = findViewById(R.id.dingin3);

        //Button
        ordering = findViewById(R.id.order);
        pembayaran = findViewById(R.id.bayar3);
    }

    public void setInd(View a){
        bahasa.setText("Bahasa :");
        menu.setText("Menu Kopi : ");
        sajian.setText("Sajian : ");
        jumlah.setText("Jumlah : ");

        nama2.setHint("Nama Pemesan : ");

        kembalian.setText("Kembalian");
        total.setText("Total : ");

        ordering.setText("PESAN");
        bayar.setText("BAYAR : ");

        panas1.setText("Panas");
        dingin1.setText("Dingin");
        panas2.setText("Panas");
        dingin2.setText("Dingin");
        panas3.setText("Panas");
        dingin3.setText("Dingin");

    }

    public void setEng(View a){
        bahasa.setText("Languange : ");
        menu.setText("Menu Coffee : ");
        sajian.setText("Dish : ");
        jumlah.setText("Count : ");

        nama2.setHint("Enter Your Name ");

        total.setText("Bill : ");
        kembalian.setText("Change : ");

        ordering.setText("ORDER");
        bayar.setText("PAYMENT");

        panas1.setText("Hot");
        dingin1.setText("Cold");
        panas2.setText("Hot");
        dingin2.setText("Cold");
        panas3.setText("Hot");
        dingin3.setText("Cold");

    }

    public void order(View x) {
        viewname.setText("Nama Pemesan : " + nama2.getText().toString());

        jumlahsatu = 0; arab = 6000;
        jumlahdua = 0; amer = 7000;
        jumlahtiga = 0; robu = 8000;
        total3 = 0; total4 = 0;
        kembalian3 = 0;

        if (Ar.isChecked() && (panas1.isChecked() || dingin1.isChecked())) {
            jumlahsatu = Integer.parseInt(jumlah1.getText().toString());
            total3 = arab * jumlahsatu;
        }
        if (Am.isChecked() && (panas2.isChecked() || dingin2.isChecked())) {
            jumlahdua = Integer.parseInt(jumlah2.getText().toString());
            total4 = amer * jumlahdua;
//            total2.setText(Integer.toString(total4));
        }
        if (Ro.isChecked() && (panas3.isChecked() || dingin3.isChecked())) {
            jumlahtiga = Integer.parseInt(jumlah3.getText().toString());
            total5 = robu * jumlahtiga;
//            total2.setText(Integer.toString(total5));
        }

        total6 = total3 + total4 + total5;
        total2.setText(Integer.toString(total6));
    }
    public void bayar(View v){
        bayar2 = Integer.parseInt(bayari.getText().toString());
        kembalian3 = bayar2 - total6;
        kembalian.setText("Kembalian : Rp. "+Integer.toString(kembalian3));
    }
}
