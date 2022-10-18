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
import android.widget.Button;
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
import com.krevolorio.myappkapa.complementos.ConstanteCliente;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Clase de la actividad principal, donde se visualiza el catálogo de productos y
 * se permite la búsqueda de los mismos. También posee un menú con opciones a las
 * cuales el cliente puede acceder dependiendo de si inició sesión o no
 */
public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>,
        Response.ErrorListener {
    private ProductoVO pvo = new ProductoVO();
    private ProductoDAO pdao = new ProductoDAO();
    private RecyclerView recyclerView;
    private Button buttonMostrarTodoProducto;
    private ArrayList<ProductoVO> listaProductos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonMostrarTodoProducto = findViewById(R.id.btnMostrarTodoProducto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setCustomView(R.layout.actionbar);
        EditText edtBuscar = (EditText) actionBar.getCustomView().findViewById(R.id.buscar);
        ImageButton imgBuscar = (ImageButton) actionBar.getCustomView().findViewById(R.id.imgBuscar);
        imgBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarProducto(edtBuscar);
            }
        });
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);
        recyclerView = findViewById(R.id.rvCatalogo);
        pdao.listarProductos(pvo, getApplicationContext(), this, this);
        this.click();
    }

    private void click() {
        buttonMostrarTodoProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarProductos();
            }
        });
    }

    private void buscarProducto(EditText edtBuscar){
        String productoB = String.valueOf(edtBuscar.getText());
        ArrayList<ProductoVO> productoFiltrado = new ArrayList<>();
        for(ProductoVO proVO : listaProductos){
            if(proVO.getMarcaProducto().toUpperCase().contains(productoB.toUpperCase())
            || proVO.getDescripcionProducto().toUpperCase().contains(productoB.toUpperCase())){
                productoFiltrado.add(proVO);
            }
        }
        if(productoFiltrado.size() > 0){
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            AdapterRecyclerProductos adapterRecyclerProductos = new AdapterRecyclerProductos(productoFiltrado);
            clickRecycler(adapterRecyclerProductos, productoFiltrado);
            recyclerView.setAdapter(adapterRecyclerProductos);
            Toast.makeText(this, "Se buscó: " + edtBuscar.getText(), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No hay productos con esa descripción o marca", Toast.LENGTH_SHORT).show();
        }
    }

    private void mostrarProductos(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AdapterRecyclerProductos adapterRecyclerProductos = new AdapterRecyclerProductos(listaProductos);
        clickRecycler(adapterRecyclerProductos, listaProductos);
        recyclerView.setAdapter(adapterRecyclerProductos);
    }


    /**
     * Métodos para aperturar o abrir las demás actividades
     */
    private void aperturaLogin(){
        Intent intent = new Intent(this, MAlogin.class);
        startActivity(intent);
    }

    private void aperturaDetallecompra(){
        Intent intent = new Intent(this, MAdetallecompra.class);
        startActivity(intent);
    }

    private void aperturaPedidos(){
        Intent intent = new Intent(this, MAPedidos.class);
        startActivity(intent);
    }

    private void aperturaSucursales(){
        Intent intent = new Intent(this, MASucursales.class);
        startActivity(intent);
    }

    private void aperturaConfiguraciones(){
        Intent intent = new Intent(this, MAConfiguraciones.class);
        startActivity(intent);
    }

    private void aperturaInformacion(){
        Intent intent = new Intent(this, MAInformacion.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    /**
     * Administra la selección de opciones disponibles en el menú
     * @param item -> Representa las opciones existentes
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.login:
                if(ConstanteCliente.CODIGO_CLIENTE == 0){
                    Toast.makeText(this, "Ir a Login", Toast.LENGTH_SHORT).show();
                    aperturaLogin();
                }else{
                    Toast.makeText(this, "Ya hay una sesión activa", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.detalleCompra:
                if(ConstanteCliente.CODIGO_CLIENTE == 0){
                    Toast.makeText(this, "Debe iniciar sesión", Toast.LENGTH_SHORT).show();
                    aperturaDetallecompra();
                }else{
                    Toast.makeText(this, "Ver detalle de compra", Toast.LENGTH_SHORT).show();
                    aperturaDetallecompra();
                }
                break;
            case R.id.pedidos:
                if(ConstanteCliente.CODIGO_CLIENTE == 0){
                    Toast.makeText(this, "Debe iniciar sesión", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Ver mis pedidos", Toast.LENGTH_SHORT).show();
                    aperturaPedidos();
                }
                break;
            case R.id.sucursales:
                Toast.makeText(this, "Ver nuestras sucursales", Toast.LENGTH_SHORT).show();
                aperturaSucursales();
                break;
            case R.id.configuraciones:
                if(ConstanteCliente.CODIGO_CLIENTE == 0){
                    Toast.makeText(this, "Debe iniciar sesión", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Ver configuraciones", Toast.LENGTH_SHORT).show();
                    aperturaConfiguraciones();
                }
                break;
            case R.id.informacion:
                Toast.makeText(this, "Ver información de la APP", Toast.LENGTH_SHORT).show();
                aperturaInformacion();
                break;
            case R.id.cerrar:
                if(ConstanteCliente.CODIGO_CLIENTE == 0){
                    Toast.makeText(this, "No se ha logueado", Toast.LENGTH_SHORT).show();
                }else{
                    ConstanteCliente.CODIGO_CLIENTE = 0;
                    Toast.makeText(this, "Salió de la sesión", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResponse(JSONObject response) {
        if (pdao.respuestaListarProductos(response) != null) {
            if(!pdao.respuestaListarProductos(response).get(0).getIdProducto().equals(0)) {
                for (ProductoVO productoVO : pdao.respuestaListarProductos(response)) {
                    listaProductos.add(productoVO);
                }
            }
            else {
                Toast.makeText(this, "No existen datos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Error, no existen datos", Toast.LENGTH_SHORT).show();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AdapterRecyclerProductos adapterRecyclerProductos = new AdapterRecyclerProductos(listaProductos);
        clickRecycler(adapterRecyclerProductos, listaProductos);
        recyclerView.setAdapter(adapterRecyclerProductos);
    }

    /**
     * Método que administra las pulsaciones en los item del recyclerview
     * @param adapterRecyclerProductos -> Adaptador del recyclerview
     * @param listaProductos -> Arreglo con los productos existentes en la base de datos
     */
    private void clickRecycler(AdapterRecyclerProductos adapterRecyclerProductos, ArrayList<ProductoVO> listaProductos) {
        adapterRecyclerProductos.setItemClickListener(new ClickListener() {
            @Override
            public void itemClick(Integer position, View view) {
                trasladarInformacion(position, listaProductos);
            }
        });
    }

    /**
     * Método para enviar la información del producto seleccionado a la actividad
     * de información del producto
     * @param position -> Representa la posición o elemento seleccionado
     * @param productoVO -> Es el arreglo con los productos existentes en la base de datos
     */
    private void trasladarInformacion(int position, ArrayList<ProductoVO> productoVO){
        Intent intent = new Intent(getApplicationContext(), MAInfoProducto.class);
        intent.putExtra("id", productoVO.get(position).getIdProducto());
        intent.putExtra("descripcion", productoVO.get(position).getDescripcionProducto());
        intent.putExtra("marca", productoVO.get(position).getMarcaProducto());
        intent.putExtra("presentacion", productoVO.get(position).getPresentacionProducto());
        intent.putExtra("categoria", productoVO.get(position).getCategoriaProducto());
        intent.putExtra("pventa", productoVO.get(position).getPrecioVentaProducto());
        intent.putExtra("existencia", productoVO.get(position).getExistenciaProducto());
        intent.putExtra("img", productoVO.get(position).getImgProducto());
        startActivity(intent);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println("[Error]: " + error);
    }
}
