package com.krevolorio.myappkapa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.krevolorio.myappkapa.complementos.Constantes;

public class MAdetallecompra extends AppCompatActivity {



    RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madetallecompra);
        recycler = findViewById(R.id.recyclerDatos);
        //recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        recycler.setLayoutManager(new GridLayoutManager(this,4));
        AdapterRecyclerDetalle adapter = new AdapterRecyclerDetalle(Constantes.listaDetalle);
        recycler.setAdapter(adapter);
    }
}