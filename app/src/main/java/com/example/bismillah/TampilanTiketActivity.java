package com.example.bismillah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TampilanTiketActivity extends AppCompatActivity {

    TextView txNama,txNIK, txPenumpang, txKelamin, txAsal, txTujuan, txMaskapai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_tiket);

        txNama = findViewById(R.id.tvNama);
        txNIK = findViewById(R.id.tvNIK);
        txPenumpang = findViewById(R.id.tvPenumpang);
        txKelamin = findViewById(R.id.tvKelamin);
        txAsal = findViewById(R.id.tvAsal);
        txTujuan = findViewById(R.id.tvTujuan);
        txMaskapai = findViewById(R.id.tvMaskapai);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");
        String nik = bundle.getString("b");
        String penumpang = bundle.getString("c");
        String kelamin = bundle.getString("d");
        String asal = bundle.getString("e");
        String tujuan = bundle.getString("f");
        String maskapai = bundle.getString("g");

        txNama.setText(nama);
        txNIK.setText(nik);;
        txPenumpang.setText(penumpang);
        txKelamin.setText(kelamin);
        txAsal.setText(asal);
        txTujuan.setText(tujuan);
        txMaskapai.setText(maskapai);
    }
}