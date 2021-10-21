package com.example.vidasaludable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vidasaludable.alimentos.fragments.FoodActivity;
import com.example.vidasaludable.control.ControlActivity;
import com.example.vidasaludable.exercise.ExerciseActivity;

public class MenuActivity extends AppCompatActivity {

    private Button btnControl;
    private Button btnCrearActividad;
    private Button btnVerAlimentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnControl = (Button) findViewById(R.id.btnControl);
        btnCrearActividad = (Button) findViewById(R.id.btnCrearActividad);
        btnVerAlimentos = (Button) findViewById(R.id.btnVerAlimentos);


        btnControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MenuActivity.this, ControlActivity.class);
                startActivity(myIntent);
            }
        });

        btnCrearActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MenuActivity.this, ExerciseActivity.class);
                startActivity(myIntent);
            }
        });

        btnVerAlimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MenuActivity.this, FoodActivity.class);
                startActivity(myIntent);
            }
        });

    }
}