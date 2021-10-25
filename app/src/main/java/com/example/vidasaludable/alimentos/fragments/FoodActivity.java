package com.example.vidasaludable.alimentos.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;

import com.example.vidasaludable.R;
import com.example.vidasaludable.adapters.FragmentsAdapter;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class FoodActivity extends AppCompatActivity {
    FragmentsAdapter fragmentsAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MaterialToolbar toolbar;

    private String[] titles = new String[]{"Comida Tipicas", "Alimentos"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        toolbar = findViewById(R.id.topAppBarFood);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager2 = findViewById(R.id.viewpager);
        tabLayout =  findViewById(R.id.tablayout);
        fragmentsAdapter = new FragmentsAdapter(this);
        viewPager2.setAdapter(fragmentsAdapter);
        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();
    }
}