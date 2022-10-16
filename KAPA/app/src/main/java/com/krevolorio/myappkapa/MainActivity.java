package com.krevolorio.myappkapa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.krevolorio.myappkapa.basededatossw.ProductoDAO;
import com.krevolorio.myappkapa.basededatossw.ProductoVO;
import com.krevolorio.myappkapa.complementos.AdaptadorRecylerProducto;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>,
        Response.ErrorListener {

    private ProductoVO pdvo = new ProductoVO();
    private ProductoDAO pddao = new ProductoDAO();
    RecyclerView recyclerView;
    TextView txtpruebarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ///MOSTRAR PRODUCTOS

        recyclerView = findViewById(R.id.lvListarProductos);
        recyclerView.setLayoutManager( new LinearLayoutManager(getApplicationContext()));
        txtpruebarray = findViewById(R.id.txt_pruebaarray);
        //txtpruebarray.setText("Aqui si funciona");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.onResponse(new JSONObject());


        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setCustomView(R.layout.actionbar);

        final EditText buscar = (EditText) actionBar.getCustomView().findViewById(R.id.buscar);
        ImageButton imgBuscar = (ImageButton) actionBar.getCustomView().findViewById(R.id.imgBuscar);

        imgBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Buscar desde boton" + buscar.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        buscar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                Toast.makeText(MainActivity.this, "Buscar desde Enter" + buscar.getText().toString(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);

    }



    private void aperturaLogin(){
    Intent intent = new Intent(this, MAlogin.class);
    startActivity(intent);
    }

    private void aperturaComprar(){
        Intent intent = new Intent(this, MAcomprar.class);
        startActivity(intent);
    }

    private void aperturaDetallecompra(){
        Intent intent = new Intent(this, MAdetallecompra.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.login:
                Toast.makeText(this, "Ir a Login", Toast.LENGTH_SHORT).show();
                aperturaLogin();
                break;
            case R.id.comprar:
                Toast.makeText(this, "Necesita hacer login", Toast.LENGTH_SHORT).show();
                aperturaComprar();
                break;
            case R.id.detalleCompra:
                Toast.makeText(this, "Ver detalle de compra", Toast.LENGTH_SHORT).show();
                aperturaDetallecompra();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    ///LISTAR MOSTRAR PRODUCTOS
    @Override
    public void onResponse(JSONObject response) {

        ArrayList<ProductoVO> listapd = new ArrayList<>();


        if (pddao.respuestaListarMostrar(response) != null) {

            if(!pddao.respuestaListarMostrar(response).get(0).getIdProducto().equals(0)) {

                for (ProductoVO productoVO : pddao.respuestaListarMostrar(response)) {
                    listapd.add(productoVO);
                }
            }
        }
        else {
            Toast.makeText(this,"Error, no existen datos ",Toast.LENGTH_SHORT).show();
        }
        AdaptadorRecylerProducto adaptadorRecylerProducto = new AdaptadorRecylerProducto(listapd);

        recyclerView.setAdapter(adaptadorRecylerProducto);
        txtpruebarray.setText(listapd.toString());
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println("ERROR RESPUESTA MAIN LLENAR LISTA: "+error);
    }


}
