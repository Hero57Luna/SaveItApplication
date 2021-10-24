package com.example.saveitapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CashFlowAdapter extends RecyclerView.Adapter<CashFlowAdapter.MyViewHolder> {

    private Context context;
    private ArrayList nominal, keterangan, tanggal;

    CashFlowAdapter(Context context, ArrayList nominal, ArrayList keterangan, ArrayList tanggal) {
        this.context = context;
        this.nominal = nominal;
        this.keterangan = keterangan;
        this.tanggal = tanggal;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cash_flow_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt_nominal.setText(String.valueOf(nominal.get(position)));
        holder.txt_keterangan.setText(String.valueOf(keterangan.get(position)));
        holder.txt_tanggal.setText(String.valueOf(tanggal.get(position)));
    }

    @Override
    public int getItemCount() {
        return nominal.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_nominal, txt_keterangan, txt_tanggal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_nominal = itemView.findViewById(R.id.text_nominal);
            txt_keterangan = itemView.findViewById(R.id.text_keterangan);
            txt_tanggal = itemView.findViewById(R.id.text_tanggal);
        }
    }
}
