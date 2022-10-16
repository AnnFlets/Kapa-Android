package com.krevolorio.myappkapa.complementos;

import android.content.Context;
import com.android.volley.Response;
import com.krevolorio.myappkapa.basededatossw.ProductoVO;
import org.json.JSONObject;

import java.util.ArrayList;

public interface ConsultasProductoDAO {

    public boolean insertarProducto(ProductoVO pdvo, Context context);
    public boolean actualizarProducto(ProductoVO pdvo, Context context);
    public boolean eliminarProducto(ProductoVO pdvo, Context context);
    public boolean listarProductos(ProductoVO pdvo, Context context,Response.Listener listener, Response.ErrorListener errorListener);
    public boolean buscarProducto(ProductoVO pdvo, Context context, Response.Listener listener, Response.ErrorListener errorListener);
    public boolean respuestaBusqueddaID(ProductoVO pdvo, JSONObject respuesta);
    public ArrayList<ProductoVO> respuestaListarMostrar(JSONObject respuesta);
}
