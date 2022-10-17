package com.krevolorio.myappkapa.basededatossw;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.krevolorio.myappkapa.complementos.Constantes;
import com.krevolorio.myappkapa.complementos.ConsultasPedidoDAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Clase que contiene los métodos para realizar distintas consultas a la base de datos,
 * referente a los pedidos
 */
public class PedidoDAO implements ConsultasPedidoDAO, Response.Listener<JSONObject>, Response.ErrorListener{

    @Override
    public boolean listarPedidos(PedidoVO pevo, Context context, Response.Listener listener, Response.ErrorListener errorListener) {
        boolean resultado = false;
        try {
            String url = Constantes.IPSERVER+"KapaApiSwRest/listarpedidos.php";
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
    public ArrayList<PedidoVO> respuestaListarPedidos(JSONObject respuesta) {
        ArrayList<PedidoVO> pedidos = new ArrayList<>();
        JSONArray jsonArray = respuesta.optJSONArray("factura");
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                PedidoVO pevo = new PedidoVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                pevo.setIdFactura(jsonObject.optInt("id_factura"));
                pevo.setNumeroFactura(jsonObject.optInt("numero_factura"));
                pevo.setSerieFactura(jsonObject.optString("serie_factura"));
                pevo.setFechaFactura(jsonObject.optString("fecha_factura"));
                pevo.setTotalFactura(jsonObject.optDouble("total_factura"));
                pevo.setTipoPagoFactura(jsonObject.optString("tipo_pago_factura"));
                pevo.setEstadoFactura(jsonObject.optString("estado_factura"));
                pevo.setIdClienteFK(jsonObject.optInt("id_cliente_fk"));
                pedidos.add(pevo);
            }
        }
        catch (JSONException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return pedidos;
    }

    @Override
    public void onResponse(JSONObject response) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
