package com.example.appgest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class addWorker extends AppCompatActivity {

    String nombre, turno, puesto;
    private LinearLayout opcionListado;
    Spinner spinnerTurno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_worker);

        dataWorker dataWorker = new dataWorker(this); // <--- aquí creas la instancia de dataWorker

        Context context = getApplicationContext();
        spinnerTurno = findViewById(R.id.spinner_turno);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.turnos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerTurno.setAdapter(adapter);
        spinnerTurno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                turno = parent.getItemAtPosition(position).toString();
                System.out.println(turno+"Texto Spinner ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Si no se selecciona nada
            }
        });

        //BUTTON ENVIAR
        Button btnEnviar = findViewById(R.id.boton_enviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores actuales de los EditText
                EditText editTextNombre = findViewById(R.id.edit_text_nombre);
                nombre = editTextNombre.getText().toString();
                EditText editTextPuesto = findViewById(R.id.edit_text_puesto);
                puesto = editTextPuesto.getText().toString();

                // Código para manejar el clic del botón
                SQLiteDatabase db = dataWorker.getWritableDatabase();
                // Insertar un nuevo trabajador
                Worker worker = new Worker(nombre, turno, puesto);
                ContentValues values = worker.toContentValues();
                if (!nombre.isEmpty() && !turno.isEmpty() && !puesto.isEmpty()) {
                    db.insert("worker", null, values);
                    // Cerrar la base de datos
                    db.close();

                    //ENVIADO
                    CharSequence mensaje = context.getString(R.string.text_02Toast); ;
                    int duracion = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, mensaje, duracion);
                    toast.show();
                }else{
                    System.out.println(nombre+turno+puesto+"NOMBRE + TURNO + PUESTO");
                    CharSequence mensaje = context.getString(R.string.text_01Toast); ;
                    int duracion = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, mensaje, duracion);
                    toast.show();
                }
            }
        });

        opcionListado = findViewById(R.id.opcion_listado);
        opcionListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir el listado de trabajadores
                Intent intent = new Intent(addWorker.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
