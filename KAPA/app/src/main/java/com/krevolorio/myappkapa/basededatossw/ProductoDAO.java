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

    private Integer banderaDeUsoProducto = 0;


 //METODOS IMPLEMENTADOS
    @Override
    public boolean insertarProducto(ProductoVO pdvo, Context context) {

        boolean resultado = false;
        banderaDeUsoProducto = Constantes.INSERTARPRODUCTO;

        return false;
    }

    @Override
    public boolean actualizarProducto(ProductoVO pdvo, Context context) {
        return false;
    }

    @Override
    public boolean eliminarProducto(ProductoVO pdvo, Context context) {
        return false;
    }


   //BLOQUE PARA LISTAR PRODUCTOS
    @Override
    public boolean listarProductos(ProductoVO pdvo, Context context, Response.Listener listener,
                                   Response.ErrorListener errorListener) {
       boolean resultado = false;

       try{
            String url = Constantes.IPSERVER+"KapaApiSwRest/listarproducto.php";
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,
                   listener, errorListener);
            requestQueue.add(jsonObjectRequest);
            resultado = true;


       } catch(Exception e){
           Toast.makeText(context, "Error en la Conexión", Toast.LENGTH_SHORT).show();
       }
        return resultado;
    }

    @Override
    public ArrayList<ProductoVO> respuestaListarMostrar(JSONObject respuesta) {

        ArrayList<ProductoVO> arrayListProductoVO = new ArrayList<>();
        JSONArray jsonArray = respuesta.optJSONArray("producto");

        try{
            for (int i = 0; i< jsonArray.length(); i++){
                ProductoVO pdvo = new ProductoVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                pdvo.setIdProducto(jsonObject.optInt("id_producto"));
                pdvo.setDescripcionProducto(jsonObject.optString("descripcion_producto"));
                pdvo.setMarcaProducto(jsonObject.optString("marca_producto"));
                pdvo.setPresentacionProducto(jsonObject.optString("presentacion_producto"));
                pdvo.setCategoriaProducto(jsonObject.optString("categoria_producto"));
                pdvo.setPrecioCompraProducto(jsonObject.optDouble("precio_compra_producto"));
                pdvo.setPrecioVentaProducto(jsonObject.optDouble("precio_venta_producto"));
                pdvo.setExistenciaProducto(jsonObject.optInt("existencia_producto"));
                pdvo.setImgProducto(jsonObject.optString("img_producto"));
                pdvo.setIdProveedor_fk(jsonObject.optInt("id_proveedor_fk"));

                 arrayListProductoVO.add(pdvo);
            }

        }

        catch(JSONException e){ //EL ERROR EN JSONException se quita la definir en try JSONObject
            System.err.println("ERROR RESPUESTA LISTAR MOSTRAR PRODUCTO: "+e.getMessage());
            e.printStackTrace();
        }


        return arrayListProductoVO;
    }
   // FIN DEL BLOQUE LISTAR MOSTRAR PRODUCTOS

    @Override
    public boolean buscarProducto(ProductoVO pdvo, Context context, Response.Listener listener, Response.ErrorListener errorListener) {
        //aqui no sive bandera de uso

        return false;
    }

    @Override
    public boolean respuestaBusqueddaID(ProductoVO pdvo, JSONObject respuesta) {
        return false;
    }




    @Override
    public void onResponse(JSONObject response) {
        switch (banderaDeUsoProducto){

            case 1: //EN CASO SEA INSERTAR
                    System.out.println("---------------SE INSERTO CORRECTAMENTE");
                break;
        }

    }
    @Override
    public void onErrorResponse(VolleyError error) {

        switch (banderaDeUsoProducto){

            case 1: //EN CASO SEA INSERTAR
                System.out.println("---------------ERROR AL INSERTAR "+error);
                break;
        }
    }
}
