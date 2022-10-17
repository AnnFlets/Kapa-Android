package com.krevolorio.myappkapa.complementos;

import android.content.Context;

import com.android.volley.Response;
import com.krevolorio.myappkapa.basededatossw.PedidoVO;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Interfaz que contiene la declaración de los métodos para realizar
 * las consultas de los pedidos
 */
public interface ConsultasPedidoDAO {
    public boolean listarPedidos(PedidoVO pevo, Context context, Response.Listener listener, Response.ErrorListener errorListener);
    public ArrayList<PedidoVO> respuestaListarPedidos(JSONObject respuesta);
}
