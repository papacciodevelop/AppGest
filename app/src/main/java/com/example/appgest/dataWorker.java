package com.example.appgest;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class dataWorker extends SQLiteOpenHelper {
    private static final int VERSION_BASE_DATOS = 1;
    private static final String NOMBRE_BASE_DATOS = "mi_base_datos.db";
    private static final String TABLA_WORKER = "worker";
    private static final String COLUMNA_ID = "id";
    private static final String COLUMNA_NOMBRE = "nombre";
    private static final String COLUMNA_HORARIO = "horario";
    private static final String COLUMNA_PUESTO = "puesto";

    public dataWorker(Context context) {
        super(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla "worker" con los tres campos de texto
        String sql = "CREATE TABLE " + TABLA_WORKER + " ("
                + COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMNA_NOMBRE + " TEXT, "
                + COLUMNA_HORARIO + " TEXT, "
                + COLUMNA_PUESTO + " TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void addWorker(Worker worker) {
        // Insertar un nuevo trabajador
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMNA_NOMBRE, worker.getNombre());
        values.put(COLUMNA_HORARIO, worker.getHorario());
        values.put(COLUMNA_PUESTO, worker.getPuesto());
        db.insert(TABLA_WORKER, null, values);
        db.close();
    }

    public ArrayList<Worker> getAllWorkers() {
        ArrayList<Worker> workers = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLA_WORKER, null);
        while (cursor.moveToNext()) {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMNA_ID));
            @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(COLUMNA_NOMBRE));
            @SuppressLint("Range") String horario = cursor.getString(cursor.getColumnIndex(COLUMNA_HORARIO));
            @SuppressLint("Range") String puesto = cursor.getString(cursor.getColumnIndex(COLUMNA_PUESTO));
            workers.add(new Worker(id,nombre, horario, puesto));
        }
        cursor.close();
        db.close();
        return workers;
    }

    public void deleteWorker(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLA_WORKER, COLUMNA_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

}

