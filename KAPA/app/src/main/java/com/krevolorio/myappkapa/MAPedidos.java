package com.krevolorio.myappkapa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.krevolorio.myappkapa.basededatossw.PedidoDAO;
import com.krevolorio.myappkapa.basededatossw.PedidoVO;
import com.krevolorio.myappkapa.complementos.ConstanteCliente;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Clase dedicada a la lógica para la visualización de pedidos realizados
 * por el cliente logueado
 */
public class MAPedidos extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    private PedidoVO pevo = new PedidoVO();
    private PedidoDAO pedao = new PedidoDAO();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapedidos);
        recyclerView = findViewById(R.id.rvPedidos);
        pedao.listarPedidos(pevo, getApplicationContext(), this, this);
    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<PedidoVO> listaPedidos = new ArrayList<>();
        if (pedao.respuestaListarPedidos(response) != null) {
            if(!pedao.respuestaListarPedidos(response).get(0).getIdFactura().equals(0)) {
                for (PedidoVO pedidoVO : pedao.respuestaListarPedidos(response)) {
                    if(pedidoVO.getIdClienteFK() == ConstanteCliente.CODIGO_CLIENTE){
                        listaPedidos.add(pedidoVO);
                    }
                }
            }
            else {
                Toast.makeText(this, "No existen datos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Error, no existen datos", Toast.LENGTH_SHORT).show();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AdapterRecyclerPedidos adapterRecyclerPedidos = new AdapterRecyclerPedidos(listaPedidos);
        recyclerView.setAdapter(adapterRecyclerPedidos);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println("[Error]: " + error);
    }
}