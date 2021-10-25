package com.example.vidasaludable.exercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vidasaludable.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.firebase.database.FirebaseDatabase;

public class ExerciseActivity extends AppCompatActivity {
    RecyclerView recview;
    MaterialToolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        toolbar = findViewById(R.id.topAppBarExercise);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recview = (RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<FileModelExercise> options =
                new FirebaseRecyclerOptions.Builder<FileModelExercise>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("myvideos"), FileModelExercise.class)
                        .build();
        FirebaseRecyclerAdapter<FileModelExercise,myviewholder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<FileModelExercise, myviewholder>(options){
            @Override
            protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull FileModelExercise model) {
                holder.prepareexoplayer(getApplication(), model.getTitle(), model.getVurl(), model.getDuration(), model.getDescription());
            }
            @NonNull
            @Override
            public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singelrow,parent,false);
                return new myviewholder(view);
            }
        };
        firebaseRecyclerAdapter.startListening();
        recview.setAdapter(firebaseRecyclerAdapter);
    }
}