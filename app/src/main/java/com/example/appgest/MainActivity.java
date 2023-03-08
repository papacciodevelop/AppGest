package com.example.appgest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout opcionListado, opcionAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataWorker dataWorker = new dataWorker(this);
        ArrayList<Worker> workers = dataWorker.getAllWorkers();

// Configurar el RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new WorkersAdapter(this, workers));







        // Obtener referencias a los elementos del menú de navegación
        opcionListado = findViewById(R.id.opcion_listado);
        opcionAgregar = findViewById(R.id.opcion_agregar);

        // Configurar el evento de clic en la opción de Listado


        // Configurar el evento de clic en la opción de Agregar
        opcionAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la pantalla de agregar trabajador
               Intent intent = new Intent(MainActivity.this, addWorker.class);
              startActivity(intent);
            }
        });
    }
}


