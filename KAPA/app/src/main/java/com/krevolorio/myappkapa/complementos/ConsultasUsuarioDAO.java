package com.krevolorio.myappkapa.complementos;

import android.content.Context;

import com.android.volley.Response;
import com.krevolorio.myappkapa.basededatossw.ClienteVO;

import org.json.JSONObject;

/**
 * Interfaz que contiene la declaración de los métodos para realizar
 * las consultas del cliente para el apartado de configuraciones
 */
public interface ConsultasUsuarioDAO {
    public boolean buscarUsuario(ClienteVO cvo, Context context, Response.Listener listener, Response.ErrorListener errorListener);
    public boolean respuestaBusquedaUsuario(ClienteVO cvo, JSONObject respuesta);
    public boolean actualizarUsuario(ClienteVO cvo, Context context);
}
