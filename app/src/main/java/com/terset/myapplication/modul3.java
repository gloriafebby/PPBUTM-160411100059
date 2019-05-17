package com.terset.myapplication;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class modul3 extends AppCompatActivity {

    EditText editNamaPemesan;
    String nama;
    String nilaic1,nilaic2, nilaic3;
    String txtmenu1,txtmenu2,txtmenu3;
    String jmlhmenu1,jmlhmenu2,jmlhmenu3;
    String c1,c2,c3;
    TextView viewname, bahasa,sajian, menu, jumlah, bayar, kembalian, total;
    RadioButton panas1,dingin1,panas2,dingin2,panas3,dingin3;
    EditText jumlah1,jumlah2,jumlah3;
    CheckBox arab, amer, robu;
    Button order;
    Button dialphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul3);
        //Edit Text
        editNamaPemesan = findViewById(R.id.editNamaPemesan);

        jumlah1 = findViewById(R.id.jumlah1);
        jumlah2 = findViewById(R.id.jumlah2);
        jumlah3 = findViewById(R.id.jumlah3);

        //Text View
        menu = findViewById(R.id.menuCoffe);
        sajian = findViewById(R.id.sajian);
        jumlah = findViewById(R.id.jumlah);
        bayar = findViewById(R.id.bayar);
        kembalian = findViewById(R.id.kembalian);
        total = findViewById(R.id.total);
        bahasa = findViewById(R.id.bahasa);
        viewname = findViewById(R.id.namaPemesan);

        //CheckBox
        arab = findViewById(R.id.kopi1);
        amer = findViewById(R.id.kopi2);
        robu = findViewById(R.id.kopi3);

        //RadioButton
        panas1 = findViewById(R.id.panas1);
        panas2 = findViewById(R.id.panas2);
        panas3 = findViewById(R.id.panas3);
        dingin1 = findViewById(R.id.dingin1);
        dingin2 = findViewById(R.id.dingin2);
        dingin3 = findViewById(R.id.dingin3);

        //Button
        order = findViewById(R.id.order);
        dialphone = findViewById(R.id.dialphone);
    }

    public void setInd(View a){
        bahasa.setText("Bahasa : ");
        menu.setText("Menu Kopi : ");
        sajian.setText("Sajian : ");
        jumlah.setText("Jumlah : ");

        editNamaPemesan.setHint("Masukkan Nama Anda");
        viewname.setText("Nama Pemesan :");

        order.setText("PESAN");

        panas1.setText("Panas");
        dingin1.setText("Dingin");
        panas2.setText("Panas");
        dingin2.setText("Dingin");
        panas3.setText("Panas");
        dingin3.setText("Dingin");

    }

    public void setEng(View b){
        bahasa.setText("Languange : ");
        menu.setText("Menu Coffee : ");
        sajian.setText("Dish : ");
        jumlah.setText("Count : ");

        editNamaPemesan.setHint("Enter Your Name ");
        viewname.setText("Customer's Name : ");

        order.setText("ORDER");

        panas1.setText("Hot");
        dingin1.setText("Cold");
        panas2.setText("Hot");
        dingin2.setText("Cold");
        panas3.setText("Hot");
        dingin3.setText("Cold");

    }
    public void order(View v){
        Intent intent = new Intent(modul3.this, pembayaran.class);

        nama = editNamaPemesan.getText().toString();
        intent.putExtra("nama",nama);

        nilaic1 = getString(R.string.f);
        nilaic2 = getString(R.string.f);
        nilaic3 = getString(R.string.f);
        if (arab.isChecked()){
            nilaic1 = getString(R.string.t);
            int totalmenu1 = 0;
            txtmenu1 = getString(R.string.arabika);
            if (panas1.isChecked()){
                totalmenu1 = 5000;
            } else {
                totalmenu1 = 5500;
            }
            intent.putExtra(getString(R.string.txt_menu1),txtmenu1);
            intent.putExtra(getString(R.string.hrg_menu1),Integer.toString(totalmenu1));

            jmlhmenu1 = jumlah1.getText().toString();
            intent.putExtra("jmlh1", jmlhmenu1);
            totalmenu1*=Integer.parseInt(jmlhmenu1);
            intent.putExtra(getString(R.string.total_menu1), Integer.toString(totalmenu1));
        }
        if (amer.isChecked()){
            nilaic2 = getString(R.string.t);
            int totalmenu2 = 0;
            txtmenu2 = getString(R.string.american);
            if (panas2.isChecked()){
                totalmenu2 = 6000;
            } else {
                totalmenu2 = 6500;
            }
            intent.putExtra(getString(R.string.txt_menu2),txtmenu2);
            intent.putExtra(getString(R.string.hrg_menu2),Integer.toString(totalmenu2));

            jmlhmenu2 = jumlah2.getText().toString();
            intent.putExtra("jmlh2", jmlhmenu2);
            totalmenu2*=Integer.parseInt(jmlhmenu2);
            intent.putExtra(getString(R.string.total_menu2), Integer.toString(totalmenu2));
        }
        if (robu.isChecked()){
            nilaic3 = getString(R.string.t);
            int totalmenu3 = 0;
            txtmenu3 = getString(R.string.robusta);
            if (panas2.isChecked()){
                totalmenu3 = 8000;
            } else {
                totalmenu3 = 8500;
            }
            intent.putExtra(getString(R.string.txt_menu3),txtmenu3);
            intent.putExtra(getString(R.string.hrg_menu3),Integer.toString(totalmenu3));

            jmlhmenu3 = jumlah3.getText().toString();
            intent.putExtra("jmlh3", jmlhmenu3);
            totalmenu3*=Integer.parseInt(jmlhmenu3);
            intent.putExtra(getString(R.string.total_menu3), Integer.toString(totalmenu3));
        }

        intent.putExtra(getString(R.string.c1), nilaic1);
        intent.putExtra(getString(R.string.c2), nilaic2);
        intent.putExtra(getString(R.string.c3), nilaic3);
        startActivity(intent);
    }
    public void telfon(View view){
        Intent dialphoneintent = new Intent(Intent.ACTION_DIAL);
        dialphoneintent.setData(Uri.parse("tel:087857022080"));
        startActivity(dialphoneintent);
    }
}