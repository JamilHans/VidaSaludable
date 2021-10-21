package com.example.vidasaludable.control.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "recordImc.db";
    private static final String TABLE_RECORD = "record";
    private static final String KEY_ID = "id";
    private static final String KEY_PESO = "peso";
    private static final String KEY_ESTATURA = "estatura";
    private static final String KEY_RESULTIMC = "resultImc";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_RECORD_TABLE = "CREATE TABLE " + TABLE_RECORD + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_PESO + " REAL,"
                + KEY_ESTATURA + " REAL,"
                + KEY_RESULTIMC + " REAL" + ")";
        db.execSQL(CREATE_RECORD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECORD);
        onCreate(db);
    }

    public void addDateIMC(Imc imc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PESO, imc.getPeso());
        values.put(KEY_ESTATURA, imc.getEstatura());
        values.put(KEY_RESULTIMC, imc.getResultImc());

        db.insert(TABLE_RECORD,null,values);
    }
}
