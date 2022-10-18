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
import com.krevolorio.myappkapa.complementos.ConsultasFacturaDAO;

import org.json.JSONObject;

public class DetalleDAO implements ConsultasFacturaDAO,  Response.Listener<JSONObject>, Response.ErrorListener {
    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }

    @Override
    public boolean facturaSW(FacturaVO cvo, Context context) {
        boolean resultado = false;
        try {
            String url = Constantes.IPSERVER +"KapaApiSwRest/insertarfactura.php?numero="+cvo.getNumeroFactura()
                    +"&serie="+cvo.getSerieFactura()+"&fecha="+cvo.getFechaFactura()+"&total="+cvo.getTotalFactura()
                    +"&tipoPago="+cvo.getTipoPagoFactura()+"&estado="+cvo.getEstadoFactura()+"&idCliente="+cvo.getIdClienteFactura();

            //Proceso de interaccion con la api
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
            requestQueue.add(jsonObjectRequest);
            resultado = true;


        }
        catch (Exception e){
            Toast.makeText(context, "Error en la conexion "+e.getMessage(), Toast.LENGTH_SHORT).show();


        }
        return resultado;
    }

    @Override
    public boolean detalleFacturaSW(DetalleVO cvo, Context context) {
        boolean resultado = false;
        try {
            String url = Constantes.IPSERVER +"KapaApiSwRest/insertardetalle.php?cantidad="+cvo.getCantidad()
                    +"&subtotal="+cvo.getSubtotal()+"&idProducto="+cvo.getIdProducto();

            //Proceso de interaccion con la api
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
            requestQueue.add(jsonObjectRequest);
            resultado = true;


        }
        catch (Exception e){
            Toast.makeText(context, "Error en la conexion "+e.getMessage(), Toast.LENGTH_SHORT).show();


        }

        return resultado;
    }
}
