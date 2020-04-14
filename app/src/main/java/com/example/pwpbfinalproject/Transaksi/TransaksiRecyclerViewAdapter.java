package com.example.pwpbfinalproject.Transaksi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pwpbfinalproject.R;

import java.util.List;

public class TransaksiRecyclerViewAdapter extends RecyclerView.Adapter<TransaksiRecyclerViewAdapter.ViewHolder> {
    List<Transaksi> listTransaksi;
    Context context;

    TransaksiRecyclerViewAdapter(List<Transaksi> listTransaksi, Context context) {
        this.listTransaksi = listTransaksi;
        this.context = context;
    }
    @NonNull
    @Override
    public TransaksiRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaksi, parent, false);
        TransaksiRecyclerViewAdapter.ViewHolder vh = new TransaksiRecyclerViewAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TransaksiRecyclerViewAdapter.ViewHolder holder, int position) {
        Transaksi transaksi = listTransaksi.get(position);
        holder.tanggal.setText((String.valueOf(transaksi.getTanggal())));
        holder.jumlah.setText((String.valueOf(transaksi.getBayar())));
        holder.nama.setText((String.valueOf(transaksi.getSiswa())));
    }

    @Override
    public int getItemCount() {
        return listTransaksi.size();
    }

    public TransaksiRecyclerViewAdapter(List<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tanggal, nama, jumlah;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tanggal = itemView.findViewById(R.id.tvTanggal);
            nama = itemView.findViewById(R.id.tvNama);
            jumlah = itemView.findViewById(R.id.tvKeterangan);
        }
    }
}
