package com.example.pwpbfinalproject.DataPetugas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pwpbfinalproject.DataSPP.SPPRecyclerViewAdapter;
import com.example.pwpbfinalproject.R;

import java.util.List;

class PetugasRecyclerView extends RecyclerView.Adapter<PetugasRecyclerView.ViewHolder> {

    Context mContext;
    List<Petugas> petugasList;

    public PetugasRecyclerView(Context mContext, List<Petugas> petugasList) {
        this.mContext = mContext;
        this.petugasList = petugasList;
    }


    public PetugasRecyclerView(List<Petugas>petugases) {
        this.petugasList = petugases;
    }

    @NonNull
    @Override
    public PetugasRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_petugas, parent, false);
        return new PetugasRecyclerView.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PetugasRecyclerView.ViewHolder holder, int position) {
        Petugas petugas = petugasList.get(position);
        holder.name.setText(petugas.getNama());
        holder.level.setText(petugas.getLevel());
    }

    @Override
    public int getItemCount() {
        return petugasList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView username,level,name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvNama);
            level = itemView.findViewById(R.id.tvLevel);
        }
    }
}
