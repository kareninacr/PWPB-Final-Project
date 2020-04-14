package com.example.pwpbfinalproject.DataSPP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pwpbfinalproject.R;

import java.util.List;

public class SPPRecyclerViewAdapter extends RecyclerView.Adapter<SPPRecyclerViewAdapter.ViewHolder> {
    List<SPP> listSPP;
    Context context;

    public SPPRecyclerViewAdapter(List<SPP> listSPP, Context context) {
        this.listSPP = listSPP;
        this.context = context;
    }
    @NonNull
    @Override
    public SPPRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spp, parent, false);
        SPPRecyclerViewAdapter.ViewHolder vh = new SPPRecyclerViewAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SPPRecyclerViewAdapter.ViewHolder holder, int position) {
        SPP spp = listSPP.get(position);
        holder.id.setText((String.valueOf(spp.getId())));
        holder.nominal.setText((String.valueOf(spp.getNominal())));
        holder.tahun.setText((String.valueOf(spp.getTahun())));
    }

    @Override
    public int getItemCount() {
        return listSPP.size();
    }

    public SPPRecyclerViewAdapter(List<SPP> listSPP) {
        this.listSPP = listSPP;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, nominal, tahun;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nominal = itemView.findViewById(R.id.tvLevel);
            tahun = itemView.findViewById(R.id.tvTahun);
        }
    }
}