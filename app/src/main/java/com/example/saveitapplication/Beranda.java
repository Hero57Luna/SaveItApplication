package com.example.saveitapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Beranda extends AppCompatActivity {

    ImageButton button_pemasukan, button_pengeluaran, button_detail, button_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        button_pemasukan = findViewById(R.id.button_pemasukan);
        button_detail = findViewById(R.id.button_detail);

        button_pemasukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Beranda.this, TambahPemasukan.class);
                startActivity(intent);
            }
        });

        button_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Beranda.this, DetailCashFlow.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Beranda.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}