package com.example.vidasaludable.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vidasaludable.R;
import com.example.vidasaludable.alimentos.fragments.comidatipica;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class comidatipicaAdapter extends  RecyclerView.Adapter<comidatipicaAdapter.ViewHolder>{
    ArrayList<comidatipica> list;
    Context context;

    public comidatipicaAdapter(ArrayList<comidatipica> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_comidas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        comidatipica comidatipica = list.get(position);
        Picasso.get().load(comidatipica.getImage()).into(holder.image);
        //Picasso .get().load(comidatipica.getImage()).placeholder(R.drawable.balanza).into(holder.image);
        holder.titulo.setText(comidatipica.getTitleFood());
        holder.calorias.setText(comidatipica.getTitlekcal());
        holder.grasa.setText(comidatipica.getTitleg());
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView titulo, calorias, grasa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.post_image);
            titulo = itemView.findViewById(R.id.textView);
            calorias = itemView.findViewById(R.id.textView2);
            grasa = itemView.findViewById(R.id.textView3);
        }
    }
}
