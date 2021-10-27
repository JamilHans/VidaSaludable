package com.example.vidasaludable.control.adapterExercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vidasaludable.R;
import com.example.vidasaludable.control.bd.Imc;

import java.util.ArrayList;

public class ControlAdapter extends RecyclerView.Adapter<ControlAdapter.RecordViewHolder> {
    ArrayList<Imc> listaImc;

    public ControlAdapter(ArrayList<Imc> listaImc){
        this.listaImc = listaImc;
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_record,null,false);
        return new RecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
        holder.tvPeso.setText(String.valueOf(listaImc.get(position).getPeso()));
        holder.tvTalla.setText(String.valueOf(listaImc.get(position).getEstatura()));
        holder.tvIMC.setText(String.valueOf(listaImc.get(position).getResultImc()));

    }

    @Override
    public int getItemCount() {
        return listaImc.size();
    }

    public class RecordViewHolder extends RecyclerView.ViewHolder {

        TextView tvPeso, tvTalla, tvIMC;

        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPeso = (TextView) itemView.findViewById(R.id.tvPeso);
            tvTalla = (TextView) itemView.findViewById(R.id.tvTalla);
            tvIMC = (TextView) itemView.findViewById(R.id.tvIMC);
        }
    }
}
