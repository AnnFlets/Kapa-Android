package com.krevolorio.myappkapa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.krevolorio.myappkapa.basededatossw.ClienteDAO;
import com.krevolorio.myappkapa.basededatossw.ClienteVO;
import com.krevolorio.myappkapa.basededatossw.UsuarioDAO;
import com.krevolorio.myappkapa.complementos.ConstanteCliente;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que se encarga de la lógica para iniciar sesión en la aplicación
 */
public class MAlogin extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    private ClienteVO cvo = new ClienteVO();
    private UsuarioDAO udao = new UsuarioDAO();
    private Button buttonIr;
    EditText edtUsuario, edtPassword;
    Button btnLogin;
    private ArrayList<ClienteVO> listaClientes = new ArrayList<>();

    public MAlogin() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malogin);
        buttonIr = findViewById(R.id.btnIrregistro);
        edtUsuario= findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnLogin);
        udao.listarUsuarios(cvo, getApplicationContext(), this, this);
        this.clickIr();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarUsuario("https://kapa2022.azurewebsites.net/KapaApiSwRest/validar_client.php");
            }
        });
    }

    private void validarUsuario (String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){
                    for(ClienteVO cliente : listaClientes){
                        if(cliente.getUsuarioCliente().equals(edtUsuario.getText().toString())
                        && cliente.getContraCliente().equals(edtPassword.getText().toString())){
                            ConstanteCliente.CODIGO_CLIENTE = cliente.getIdCliente();
                            break;
                        }
                    }
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MAlogin.this, "Usuario o contraseña incorrecta, si no estas registrado, registrate", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MAlogin.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        }){
            //@Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map <String, String> parametros=new HashMap<String,String>();
                parametros.put("usuario",edtUsuario.getText().toString());
                parametros.put("password", edtPassword.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void clickIr() {
        buttonIr.setOnClickListener(view -> aperturaIrregistro());
    }
    private void aperturaIrregistro(){
        Intent intent = new Intent(this, MAregistro.class);
        startActivity(intent);
    }

    @Override
    public void onResponse(JSONObject response) {
        if (udao.respuestaListarUsuarios(response) != null) {
            if(!udao.respuestaListarUsuarios(response).get(0).getIdCliente().equals(0)) {
                for (ClienteVO usuarioVO : udao.respuestaListarUsuarios(response)) {
                    listaClientes.add(usuarioVO);
                }
            }
            else {
                Toast.makeText(this, "No existen datos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Error, no existen datos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println("[Error]: " + error);
    }
}