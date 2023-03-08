package com.example.appgest;

import android.content.ContentValues;

import java.util.UUID;

public class Worker {
    private int id;
    private String nombre;
    private String horario;
    private String puesto;

    public Worker(int id,String nombre, String horario, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.horario = horario;
        this.puesto = puesto;
    }
    public Worker(String nombre, String horario, String puesto) {

        this.nombre = nombre;
        this.horario = horario;
        this.puesto = puesto;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("horario", horario);
        values.put("puesto", puesto);
        return values;
    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
