package com.example.vidasaludable.control;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.vidasaludable.R;
import com.example.vidasaludable.control.bd.DatabaseHandler;
import com.example.vidasaludable.control.bd.Imc;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;


public class ImcFragment extends Fragment {
    View vista;
    DatabaseHandler db;
    private TextInputLayout textFieldPeso, textFieldEstatura;
    private TextInputEditText textEtPeso, textEtTalla;
    private MaterialButton textButton;
    private String toTalla, toPeso;
    private Float talla, peso, imc;
    private AppCompatTextView textViewPeso, textViewEstatura, textViewResultado;
    private MaterialButton button;
    private LinearLayoutCompat setBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_imc, container, false);
        db = new DatabaseHandler(getContext());
        textEtPeso = (TextInputEditText) vista.findViewById(R.id.textEtPeso);
        textEtTalla = (TextInputEditText) vista.findViewById(R.id.textEtTalla);

        textViewPeso = (AppCompatTextView) vista.findViewById(R.id.textViewPeso);
        textViewEstatura = (AppCompatTextView) vista.findViewById(R.id.textViewEstatura);
        textViewResultado = (AppCompatTextView) vista.findViewById(R.id.textViewResultado);

        button = (MaterialButton) vista.findViewById(R.id.textButton);

        setBack = (LinearLayoutCompat) vista.findViewById(R.id.llcImc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTalla = textEtTalla.getText().toString();
                toPeso = textEtPeso.getText().toString();

                talla = Float.parseFloat(toTalla);
                peso = Float.parseFloat(toPeso);
                imc = operation(talla,peso);

                db.addDateIMC(new Imc(peso,talla,imc));

                textViewEstatura.setText("Estatura: "+toTalla + "cms");
                textViewPeso.setText("Peso: " + toPeso+ "kgs");
                if (imc<18.5){
                    textViewResultado.setText("Su IMC es "+ imc+", lo que indica que su \npeso esta en la categoria de delgadez");
                    setBack.setBackgroundColor(Color.WHITE);
                }
                else if (18.5 <= imc  && imc <= 24.99){
                    textViewResultado.setText("Su IMC es "+ imc+", lo que indica que su \npeso esta en la categoria normal");
                    setBack.setBackgroundColor(Color.YELLOW);
                }
                else if (25.0 <= imc  && imc <= 30.0){
                    textViewResultado.setText("Su IMC es "+ imc+", lo que indica que su \npeso esta en la categoria sobrepeso");
                    setBack.setBackgroundColor(Color.MAGENTA);
                }
                else if (imc > 30){
                    textViewResultado.setText("Su IMC es "+ imc+", lo que indica que su \npeso esta en la categoria obesidad");
                    setBack.setBackgroundColor(Color.RED);
                }



            }
        });
        return vista;
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