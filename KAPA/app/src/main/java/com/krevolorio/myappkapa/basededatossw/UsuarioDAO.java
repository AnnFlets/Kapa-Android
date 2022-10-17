package com.krevolorio.myappkapa.basededatossw;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.krevolorio.myappkapa.complementos.ConstanteCliente;
import com.krevolorio.myappkapa.complementos.Constantes;
import com.krevolorio.myappkapa.complementos.ConsultasUsuarioDAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Clase que contiene los métodos para realizar distintas consultas a la base de datos,
 * referente a los usuarios (se utilizará en el apartado de Configuraciones)
 */
public class UsuarioDAO implements ConsultasUsuarioDAO, Response.Listener<JSONObject>,Response.ErrorListener {

    @Override
    public boolean buscarUsuario(ClienteVO cvo, Context context, Response.Listener listener, Response.ErrorListener errorListener) {
        boolean resultado = false;
        try {
            String url = Constantes.IPSERVER+"KapaApiSwRest/buscarcliente.php?idCliente=" + ConstanteCliente.CODIGO_CLIENTE;
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,
                    listener,errorListener);
            requestQueue.add(jsonObjectRequest);
            resultado = true;
        }
        catch (Exception e){
            Toast.makeText(context, "Error en la conexion "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return resultado;
    }

    @Override
    public boolean respuestaBusquedaUsuario(ClienteVO cvo, JSONObject respuesta) {
        boolean resultado = false;
        JSONArray jsonArray = respuesta.optJSONArray("cliente");
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            cvo.setIdCliente(jsonObject.optInt("id_cliente"));
            cvo.setUsuarioCliente(jsonObject.optString("usuario_cliente"));
            cvo.setContraCliente(jsonObject.optString("contrasenia_cliente"));
            cvo.setNombreCliente(jsonObject.optString("nombre_cliente"));
            cvo.setApellidoCliente(jsonObject.optString("apellido_cliente"));
            cvo.setNitCliente(jsonObject.optString("nit_cliente"));
            cvo.setDireccionCliente(jsonObject.optString("direccion_cliente"));
            cvo.setTelCliente(jsonObject.optString("telefono_cliente"));
            cvo.setCorreCliente(jsonObject.optString("correo_cliente"));
            String identificadorDeError = jsonObject.optString("error");
            if(identificadorDeError.isEmpty())
                resultado = true;
            else
                resultado = false;
        }
        catch (JSONException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean listarUsuarios(ClienteVO cvo, Context context, Response.Listener listener, Response.ErrorListener errorListener) {
        boolean resultado = false;
        try {
            String url = Constantes.IPSERVER+"KapaApiSwRest/listarusuarios.php";
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,
                    listener, errorListener);
            requestQueue.add(jsonObjectRequest);
            resultado = true;
        }
        catch (Exception e){
            Toast.makeText(context, "Error en la conexión " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return resultado;
    }

    @Override
    public ArrayList<ClienteVO> respuestaListarUsuarios(JSONObject respuesta) {
        ArrayList<ClienteVO> clientes = new ArrayList<>();
        JSONArray jsonArray = respuesta.optJSONArray("cliente");
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                ClienteVO cvo = new ClienteVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                cvo.setIdCliente(jsonObject.optInt("id_cliente"));
                cvo.setUsuarioCliente(jsonObject.optString("usuario_cliente"));
                cvo.setContraCliente(jsonObject.optString("contrasenia_cliente"));
                clientes.add(cvo);
            }
        }
        catch (JSONException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public boolean actualizarUsuario(ClienteVO cvo, Context context) {
        boolean resultado = false;
        try {
            String url = Constantes.IPSERVER+"KapaApiSwRest/actualizarusuario.php?idCliente=" + ConstanteCliente.CODIGO_CLIENTE
                    +"&direccionCliente="+cvo.getDireccionCliente()+"&telefonoCliente="+cvo.getTelCliente()
                    +"&correoCliente="+cvo.getCorreCliente();
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,
                    null,this);
            requestQueue.add(jsonObjectRequest);
            resultado = true;
        }
        catch (Exception e){
            Toast.makeText(context, "Error en la conexion "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return resultado;
    }

    @Override
    public void onResponse(JSONObject response) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
