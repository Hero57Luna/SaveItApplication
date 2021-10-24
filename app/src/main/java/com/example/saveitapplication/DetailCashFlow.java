package com.example.saveitapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailCashFlow extends AppCompatActivity {

    RecyclerView recyclerView;

    DatabaseHelper databaseHelper;
    ArrayList<String> tanggal, nominal, tipe, keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cash_flow);

        recyclerView = findViewById(R.id.cashflow_recycler);

        databaseHelper = new DatabaseHelper(DetailCashFlow.this);
        tanggal = new ArrayList<>();
        nominal = new ArrayList<>();
        tipe = new ArrayList<>();
        keterangan = new ArrayList<>();

        storeDataInArrays();
    }

    void storeDataInArrays() {
        Cursor cursor = databaseHelper.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Tida ada data", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()) {
                tanggal.add(cursor.getString(0));
                nominal.add(cursor.getString(1));
                tipe.add(cursor.getString(2));
                keterangan.add(cursor.getString(3));
            }
        }
    }
}