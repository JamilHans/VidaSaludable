package com.example.vidasaludable.control;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.vidasaludable.R;
import com.example.vidasaludable.adapters.FragmentsAdapter;
import com.example.vidasaludable.adapters.imcAdapter.IMCFragmentAdapter;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;

public class ControlActivity extends AppCompatActivity {

    IMCFragmentAdapter imcFragmentAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MaterialToolbar toolbar;
    private String[] titles = new String[]{"IMC", "Record"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        toolbar = findViewById(R.id.topAppBarImc);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager2 = findViewById(R.id.viewpagerimc);
        tabLayout =  findViewById(R.id.tablayoutimc);
        imcFragmentAdapter = new IMCFragmentAdapter(this);
        viewPager2.setAdapter(imcFragmentAdapter);
        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();

    }

    public Float operation(Float talla, Float peso){
        float tallam2 = cmstotalla(talla);
        float result = peso/tallam2;
        DecimalFormat df = new DecimalFormat("###.##");
        return Float.parseFloat(df.format(result));
    }

    public Float cmstotalla(Float talla){
        Float convtalla = 0.0f;
        convtalla = talla/100;
        convtalla = convtalla * convtalla;
        return convtalla;
    }
}