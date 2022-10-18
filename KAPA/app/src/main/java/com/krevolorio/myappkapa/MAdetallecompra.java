package com.krevolorio.myappkapa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.krevolorio.myappkapa.basededatossw.ClienteVO;
import com.krevolorio.myappkapa.basededatossw.DetalleDAO;
import com.krevolorio.myappkapa.basededatossw.DetalleVO;
import com.krevolorio.myappkapa.basededatossw.FacturaVO;
import com.krevolorio.myappkapa.basededatossw.UsuarioDAO;
import com.krevolorio.myappkapa.complementos.ConstanteCliente;
import com.krevolorio.myappkapa.complementos.Constantes;

import org.json.JSONObject;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class MAdetallecompra extends AppCompatActivity implements  Response.Listener<JSONObject>, Response.ErrorListener {


    FloatingActionButton btnPagar, btnQuitar;
    private int contar;
    SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");


    long millis = System.currentTimeMillis();
    java.sql.Date date = new Date(millis);

    private EditText editTextNombre, editTextNit, editTextTotal;
    RecyclerView recycler;


    FacturaVO fvo = new FacturaVO();

    DetalleDAO ddao = new DetalleDAO();
    ClienteVO cvo = new ClienteVO();
    UsuarioDAO dao = new UsuarioDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madetallecompra);
        recycler = findViewById(R.id.recyclerDatos);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        //recycler.setLayoutManager(new GridLayoutManager(this,4));
        AdapterRecyclerDetalle adapter = new AdapterRecyclerDetalle(Constantes.listaDetalle);
        recycler.setAdapter(adapter);
        editTextNombre = findViewById(R.id.txtNom);
        editTextNit = findViewById(R.id.txtNIT);
        editTextTotal = findViewById(R.id.txtTotal);
        btnPagar = findViewById(R.id.pagar);
        btnQuitar = findViewById(R.id.cancelar);
        cargarCliente();
        this.clickPagar();
        this.clickQuitar();

    }

    private void clickQuitar() {
        btnQuitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constantes.listaDetalle.clear();

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);


            }
        });
    }

    private void clickPagar() {
        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearFactura();
            }
        });
    }

    private double calcularTotal(){
        double total = 0;


        for (DetalleVO detalle: Constantes.listaDetalle) {
            total += detalle.getSubtotal();
        }
        return total;
    }


    private void cargarCliente(){

        cvo.setIdCliente(ConstanteCliente.CODIGO_CLIENTE);

        if (ConstanteCliente.CODIGO_CLIENTE != 0) {
            if (!dao.buscarUsuario(cvo, getApplicationContext(), this, this)) {

                editTextNombre.setText("-");
                editTextNit.setText("-");
                editTextTotal.setText("-");

                Toast.makeText(this, "Error r", Toast.LENGTH_SHORT).show();
            }

        }
    }



    private void crearFactura(){

        if (Constantes.listaDetalle.isEmpty() == false){
            if (ConstanteCliente.CODIGO_CLIENTE != 0){
                fvo.setNumeroFactura((int)(Math.random() * (1000-1)) + 1);
                fvo.setSerieFactura("A");
                fvo.setFechaFactura(java.sql.Date.valueOf(fecha.format(date)));
                fvo.setTotalFactura(calcularTotal());
                fvo.setTipoPagoFactura("Efectivo");
                fvo.setEstadoFactura("Pendiente");
                fvo.setIdClienteFactura(ConstanteCliente.CODIGO_CLIENTE);

                if (ddao.facturaSW(fvo, getApplicationContext())){
                    for (DetalleVO detalle :Constantes.listaDetalle) {
                        DetalleVO dvo = new DetalleVO();
                        dvo.setCantidad(detalle.getCantidad());
                        dvo.setSubtotal(detalle.getSubtotal());
                        dvo.setIdProducto(detalle.getIdProducto());
                        if(ddao.detalleFacturaSW(dvo, getApplicationContext())){
                            if (ddao.productoUpdateSW(dvo, getApplicationContext()))
                            contar++;
                        }

                    }
                    Toast.makeText(this, contar +" Facturas creadas", Toast.LENGTH_SHORT).show();
                    contar = 0;



                }else{
                    Toast.makeText(this, "No se pudo crear las facturas", Toast.LENGTH_SHORT).show();
                }

            }

        }




        }


    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println(error);

    }

    @Override
    public void onResponse(JSONObject response) {

        if (dao.respuestaBusquedaUsuario(cvo, response)){
            editTextNombre.setText("Nombre: "+ cvo.getNombreCliente());
            editTextNit.setText("Nit: " + cvo.getNitCliente());

            editTextTotal.setText("Total Q. " + String.valueOf(calcularTotal()));

        }else{

            Toast.makeText(this, "No ha iniciado sesión error", Toast.LENGTH_SHORT).show();
        }
    }
}
