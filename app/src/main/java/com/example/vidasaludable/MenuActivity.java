package com.example.vidasaludable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vidasaludable.control.ControlActivity;

public class MenuActivity extends AppCompatActivity {

    private Button btnControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnControl = (Button) findViewById(R.id.btnControl);

        btnControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MenuActivity.this, ControlActivity.class);
                startActivity(myIntent);
            }
        });

    }
}