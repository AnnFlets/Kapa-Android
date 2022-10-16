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
import com.krevolorio.myappkapa.complementos.ConsultasProductoDAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductoDAO implements ConsultasProductoDAO, Response.Listener<JSONObject>,Response.ErrorListener {

    @Override
    public boolean listarProductos(ProductoVO pdvo, Context context, Response.Listener listener, Response.ErrorListener errorListener) {
        boolean resultado = false;
        try {
            String url = Constantes.IPSERVER+"KapaApiSwRest/listarproducto.php";
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
    public ArrayList<ProductoVO> respuestaListarProductos(JSONObject respuesta) {
        ArrayList<ProductoVO> productos = new ArrayList<>();
        JSONArray jsonArray = respuesta.optJSONArray("producto");
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                ProductoVO pvo = new ProductoVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                pvo.setIdProducto(jsonObject.optInt("id_producto"));
                pvo.setDescripcionProducto(jsonObject.optString("descripcion_producto"));
                pvo.setMarcaProducto(jsonObject.optString("marca_producto"));
                pvo.setPresentacionProducto(jsonObject.optString("presentacion_producto"));
                pvo.setCategoriaProducto(jsonObject.optString("categoria_producto"));
                pvo.setPrecioCompraProducto(jsonObject.optDouble("precio_compra_producto"));
                pvo.setPrecioVentaProducto(jsonObject.optDouble("precio_venta_producto"));
                pvo.setExistenciaProducto(jsonObject.optInt("existencia_producto"));
                pvo.setImgProducto(jsonObject.optString("img_producto"));
                pvo.setIdProveedorFK(jsonObject.optInt("id_proveedor_fk"));
                productos.add(pvo);
            }
        }
        catch (JSONException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public void onResponse(JSONObject response) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
