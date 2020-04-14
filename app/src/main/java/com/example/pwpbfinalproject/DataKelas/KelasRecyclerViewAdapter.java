package com.example.pwpbfinalproject.DataKelas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pwpbfinalproject.R;

import java.util.List;

public class KelasRecyclerViewAdapter extends RecyclerView.Adapter<KelasRecyclerViewAdapter.ViewHolder> {
    List<Kelas> listKelas;
    Context context;

    public KelasRecyclerViewAdapter(List<Kelas> listKelas, Context context) {
        this.listKelas = listKelas;
        this.context = context;
    }
    @NonNull
    @Override
    public KelasRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kelas, parent, false);
        KelasRecyclerViewAdapter.ViewHolder vh = new KelasRecyclerViewAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull KelasRecyclerViewAdapter.ViewHolder holder, int position) {
        Kelas kelas = listKelas.get(position);
        holder.no.setText((String.valueOf(kelas.getId())));
        holder.kelas.setText((String.valueOf(kelas.getNama())));
    }

    @Override
    public int getItemCount() {
        return listKelas.size();
    }

    public KelasRecyclerViewAdapter(List<Kelas> listKelas) {
        this.listKelas = listKelas;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView no, kelas;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            no = itemView.findViewById(R.id.tvNo);
            kelas = itemView.findViewById(R.id.tvKelas);
        }
    }
}
