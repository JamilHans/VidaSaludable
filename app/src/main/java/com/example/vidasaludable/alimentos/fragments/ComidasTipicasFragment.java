package com.example.vidasaludable.alimentos.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vidasaludable.adapters.comidatipicaAdapter;
import com.example.vidasaludable.databinding.FragmentComidasTipicasBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ComidasTipicasFragment extends Fragment {


    public ComidasTipicasFragment() {
        // Required empty public constructor
    }

    FragmentComidasTipicasBinding binding;
    ArrayList<comidatipica> list = new ArrayList<>();
    FirebaseDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // Inflate the layout for this fragment
        binding = FragmentComidasTipicasBinding.inflate(inflater, container, false);
        database = FirebaseDatabase.getInstance();
       comidatipicaAdapter adapter = new comidatipicaAdapter(list,getContext());
        binding.charRecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.charRecyclerView.setLayoutManager(layoutManager);


        database.getReference().child("PlatosTipicos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    comidatipica comidatipica = dataSnapshot.getValue(comidatipica.class);
                    list.add(comidatipica);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        binding.getRoot().setBackgroundColor(Color.WHITE);
       return binding.getRoot();


    }
}