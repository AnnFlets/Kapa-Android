package com.krevolorio.myappkapa.basededatossw;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.krevolorio.myappkapa.complementos.Constantes;
import com.krevolorio.myappkapa.complementos.ConsultasDAO;

import org.json.JSONObject;

public class ClienteDAO implements ConsultasDAO, Response.Listener<JSONObject>, Response.ErrorListener {


    @Override
    public boolean registroSW(ClienteVO cvo, Context context) {
        boolean resultado = false;
        try {
            String url = Constantes.IPSERVER +"site/wwwroot/KapaApiSwRest/registro.php?usuarioCliente="+cvo.getUsuarioCliente()+
                    "&contraseniaCliente="+cvo.getContraCliente()+"&nombreCliente"+cvo.getNombreCliente()+
                    "&apellidoCliente"+cvo.getApellidoCliente()+"&nitCliente"+cvo.getNitCliente()+
                    "&direccionCliente"+cvo.getDireccionCliente()+"&telefonoCliente"+cvo.getTelCliente()+
                    "correoCliente"+cvo.getCorreCliente();

            //Proceso de interacicon con la api
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            //JsonObjectRequest jsonObjectRequest = new JsonObjectRequest();



        }
        catch (Exception e){



        }
        return resultado;
    }


    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
