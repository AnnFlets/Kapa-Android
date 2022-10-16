package com.krevolorio.myappkapa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MAInfoProducto extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewDescripcion, textViewMarca, textViewPresentacion, textViewCategoria,
            textViewExistencia, textViewPrecio, textViewCantidad, textViewTotal, textViewId;
    private Button buttonMenos, buttonMas, buttonAniadirCarrito;
    private double total = 0;
    private double precioProducto = 0;
    private int cantidadMaximaProducto = 0;
    private int cantidadProducto = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfo_producto);
        imageView = findViewById(R.id.imgProductoU);
        textViewDescripcion = findViewById(R.id.txtDescripcionProductoU);
        textViewMarca = findViewById(R.id.txtMarcaProductoU);
        textViewPresentacion = findViewById(R.id.txtPresentacionProductoU);
        textViewCategoria = findViewById(R.id.txtCategoriaProductoU);
        textViewExistencia = findViewById(R.id.txtExistenciaProductoU);
        textViewPrecio = findViewById(R.id.txtPrecioProductoU);
        textViewCantidad = findViewById(R.id.txtCantidadProductoU);
        textViewTotal = findViewById(R.id.txtTotalPagar);
        textViewId = findViewById(R.id.txtIdProductoU);
        buttonMenos = findViewById(R.id.btnMenosProducto);
        buttonMas = findViewById(R.id.btnMasProducto);
        buttonAniadirCarrito = findViewById(R.id.btnAniadirCarrito);
        this.obtenerInformacionProducto();
        this.click();
    }

    private void obtenerInformacionProducto() {
        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        String descripcion = bundle.getString("descripcion");
        String marca = bundle.getString("marca");
        String presentacion = bundle.getString("presentacion");
        String categoria = bundle.getString("categoria");
        double precio = bundle.getDouble("pventa");
        int existencia = bundle.getInt("existencia");
        String imagen = bundle.getString("img");
        cantidadMaximaProducto = existencia;
        precioProducto = precio;
        imageView.setImageResource(imgProducto(imagen));
        textViewId.setText(String.valueOf(id));
        textViewDescripcion.setText(descripcion);
        textViewMarca.setText(marca);
        textViewPresentacion.setText(presentacion);
        textViewCategoria.setText(categoria);
        textViewPrecio.setText(String.valueOf(precio));
        textViewExistencia.setText(String.valueOf(existencia));
        textViewCantidad.setText("0");
        textViewTotal.setText("0");
    }

    private int imgProducto(String img){
        int imagenProducto;
        if(img.equals("img001.png")){
            imagenProducto = R.drawable.img001;
        }else if (img.equals("img002.png")){
            imagenProducto = R.drawable.img002;
        }else if (img.equals("img003.png")){
            imagenProducto = R.drawable.img003;
        }else if (img.equals("img004.png")){
            imagenProducto = R.drawable.img004;
        }else if (img.equals("img005.png")){
            imagenProducto = R.drawable.img005;
        }else if (img.equals("img006.png")){
            imagenProducto = R.drawable.img006;
        }else if (img.equals("img007.png")){
            imagenProducto = R.drawable.img007;
        }else if (img.equals("img008.png")){
            imagenProducto = R.drawable.img008;
        }else{
            imagenProducto = R.drawable.caja;
        }
        return imagenProducto;
    }

    private void click() {
        buttonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disminuirCantidadProducto();
            }
        });
        buttonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aumentarCantidadProducto();
            }
        });
        buttonAniadirCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void disminuirCantidadProducto(){
        if(!(cantidadProducto == 0)){
            cantidadProducto--;
            textViewCantidad.setText(String.valueOf(cantidadProducto));
            total = Math.round((precioProducto * cantidadProducto)*100.0)/100.0;
            textViewTotal.setText(String.valueOf(total));
        }
    }

    private void aumentarCantidadProducto(){
        if(cantidadProducto < cantidadMaximaProducto){
            cantidadProducto++;
            textViewCantidad.setText(String.valueOf(cantidadProducto));
            total = Math.round((precioProducto * cantidadProducto)*100.0)/100.0;
            textViewTotal.setText(String.valueOf(total));
        }
    }
}