package com.krevolorio.myappkapa.complementos;

import android.content.Context;
import com.android.volley.Response;
import com.krevolorio.myappkapa.basededatossw.ProductoVO;
import org.json.JSONObject;

import java.util.ArrayList;

public interface ConsultasProductoDAO {

    public boolean listarProductos(ProductoVO pdvo, Context context,Response.Listener listener, Response.ErrorListener errorListener);
    public ArrayList<ProductoVO> respuestaListarProductos(JSONObject respuesta);
}
