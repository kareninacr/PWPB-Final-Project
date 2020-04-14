package com.example.pwpbfinalproject.DataSiswa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.example.pwpbfinalproject.R;

public class SiswaRecyclerViewAdapter extends RecyclerView.Adapter<SiswaRecyclerViewAdapter.ViewHolder> {
    List<Siswa> listSiswa;
    Context context;

    public SiswaRecyclerViewAdapter(List<Siswa> listSiswa, Context context) {
        this.listSiswa = listSiswa;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_siswa, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Siswa siswa = listSiswa.get(position);
        holder.nis.setText((String.valueOf(siswa.getNis())));
        holder.nama.setText((String.valueOf(siswa.getNama())));
    }

    @Override
    public int getItemCount() {
        return listSiswa.size();
    }

    public SiswaRecyclerViewAdapter(List<Siswa> listSiswa) {
        this.listSiswa = listSiswa;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nis, nama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nis = itemView.findViewById(R.id.tvNis);
            nama = itemView.findViewById(R.id.tvNama);
        }
    }
}
