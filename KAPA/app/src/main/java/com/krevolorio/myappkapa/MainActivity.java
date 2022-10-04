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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
}
