package com.krevolorio.myappkapa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.krevolorio.myappkapa.basededatossw.SucursalDAO;
import com.krevolorio.myappkapa.basededatossw.SucursalVO;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Clase dedicada a la lógica para la visualización de sucursales
 */
public class MASucursales extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    private SucursalVO svo = new SucursalVO();
    private SucursalDAO sdao = new SucursalDAO();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masucursales);
        recyclerView = findViewById(R.id.rvSucursales);
        sdao.listarSucursales(svo, getApplicationContext(), this, this);
    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<SucursalVO> listaSucursales = new ArrayList<>();
        if (sdao.respuestaListarSucursales(response) != null) {
            if(!sdao.respuestaListarSucursales(response).get(0).getIdSucursal().equals(0)) {
                for (SucursalVO sucursalVO : sdao.respuestaListarSucursales(response)) {
                    listaSucursales.add(sucursalVO);
                }
            }
            else {
                Toast.makeText(this, "No existen datos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Error, no existen datos", Toast.LENGTH_SHORT).show();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AdapterRecyclerSucursal adapterRecycler = new AdapterRecyclerSucursal(listaSucursales);
        recyclerView.setAdapter(adapterRecycler);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println("[Error]: " + error);
    }
}