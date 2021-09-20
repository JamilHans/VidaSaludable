package com.example.vidasaludable.control;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.vidasaludable.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ControlActivity extends AppCompatActivity {

    private TextInputLayout textFieldPeso;
    private MaterialButton textButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        textFieldPeso = findViewById(R.id.textFieldPeso);




    }
}