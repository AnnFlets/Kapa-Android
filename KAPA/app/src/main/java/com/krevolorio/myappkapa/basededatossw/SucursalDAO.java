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
import com.krevolorio.myappkapa.complementos.ConsultasSucursalDAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SucursalDAO implements ConsultasSucursalDAO, Response.Listener<JSONObject>, Response.ErrorListener{

    @Override
    public boolean listarSucursales(SucursalVO svo, Context context, Response.Listener listener, Response.ErrorListener errorListener) {
        boolean resultado = false;
        try {
            String url = Constantes.IPSERVER+"KapaApiSwRest/listarsucursales.php";
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
    public ArrayList<SucursalVO> respuestaListarSucursales(JSONObject respuesta) {
        ArrayList<SucursalVO> sucursales = new ArrayList<>();
        JSONArray jsonArray = respuesta.optJSONArray("sucursal");
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                SucursalVO svo = new SucursalVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                svo.setIdSucursal(jsonObject.optInt("id_sucursal"));
                svo.setNombreSucursal(jsonObject.optString("nombre_sucursal"));
                svo.setTelefonoSucursal(jsonObject.optString("telefono_sucursal"));
                svo.setDireccionSucursal(jsonObject.optString("direccion_sucursal"));
                sucursales.add(svo);
            }
        }
        catch (JSONException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return sucursales;
    }

    @Override
    public void onResponse(JSONObject response) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
