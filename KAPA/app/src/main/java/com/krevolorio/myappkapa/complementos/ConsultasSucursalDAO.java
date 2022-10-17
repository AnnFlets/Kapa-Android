package com.krevolorio.myappkapa.complementos;

import android.content.Context;

import com.android.volley.Response;
import com.krevolorio.myappkapa.basededatossw.SucursalVO;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Interfaz que contiene la declaración de los métodos para realizar
 * las consultas de las sucursales
 */
public interface ConsultasSucursalDAO {
    public boolean listarSucursales(SucursalVO svo, Context context, Response.Listener listener, Response.ErrorListener errorListener);
    public ArrayList<SucursalVO> respuestaListarSucursales(JSONObject respuesta);
}
