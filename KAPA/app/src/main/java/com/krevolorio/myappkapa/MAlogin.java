package com.krevolorio.myappkapa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MAlogin extends AppCompatActivity {
    private Button buttonIr;
    EditText edtUsuario, edtPassword;
    Button btnLogin;

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

                //String subsResponse = response.substring(0,2);

                //begin
                //try {
                //  JSONObject json = new JSONObject(response);
                //   String nombrecliente = json.getString("cliente");
                //  System.out.println(nombrecliente);
                //} catch (JSONException e) {
                //   e.printStackTrace();
                //}

                //end

                if (!response.isEmpty()){
                //  if (subsResponse.toString() == "ok"){

                    Intent intent=new Intent(getApplicationContext(),MAcomprar.class);
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
}