package com.example.vidasaludable.control;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vidasaludable.R;
import com.example.vidasaludable.control.adapterExercise.ControlAdapter;
import com.example.vidasaludable.control.bd.DatabaseHandler;
import com.example.vidasaludable.control.bd.Imc;

import java.util.ArrayList;


public class RecortdFragment extends Fragment {

    ArrayList<Imc>imcArrayList;
    RecyclerView recyclerViewImc;
    DatabaseHandler conn;
    View vista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_recortd, container, false);
        conn = new DatabaseHandler(getContext());
        imcArrayList = new ArrayList<>();
        recyclerViewImc = (RecyclerView) vista.findViewById(R.id.recyclerviewRecord);
        recyclerViewImc.setLayoutManager(new LinearLayoutManager(getContext()));
        consultarListaRecord();
        ControlAdapter adapter= new ControlAdapter(imcArrayList);
        recyclerViewImc.setAdapter(adapter);
        return vista;
    }

    private void consultarListaRecord() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Imc imc = null;
        Cursor cursor = db.rawQuery("SELECT * FROM  record", null);

        while (cursor.moveToNext()){
            imc = new Imc();
            imc.setPeso(cursor.getFloat(1));
            imc.setEstatura(cursor.getFloat(2));
            imc.setResultImc(cursor.getFloat(3));
            imcArrayList.add(imc);
        }
    }
}