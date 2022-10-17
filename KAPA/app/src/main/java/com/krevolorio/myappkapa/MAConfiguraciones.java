package com.krevolorio.myappkapa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.krevolorio.myappkapa.basededatossw.ClienteVO;
import com.krevolorio.myappkapa.basededatossw.UsuarioDAO;
import com.krevolorio.myappkapa.complementos.ConstanteCliente;

import org.json.JSONObject;

/**
 * Clase destinada a la visualización de la información del cliente logueado.
 * Asimismo, permite la actualización de determinados datos.
 */
public class MAConfiguraciones extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    private EditText editTextNombreU, editTextApellidoU, editTextNitU, editTextDireccionU,
    editTextTelefonoU, editTextCorreoU;
    private Button buttonAceptar;
    private ClienteVO cvo = new ClienteVO();
    private UsuarioDAO udao = new UsuarioDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maconfiguraciones);
        editTextNombreU = findViewById(R.id.edtNombreUsuario);
        editTextApellidoU = findViewById(R.id.edtApellidoUsuario);
        editTextNitU = findViewById(R.id.edtNitUsuario);
        editTextDireccionU = findViewById(R.id.edtDireccionUsuario);
        editTextTelefonoU = findViewById(R.id.edtTelefonoUsuario);
        editTextCorreoU = findViewById(R.id.edtCorreoUsuario);
        buttonAceptar = findViewById(R.id.btnAceptarUsuario);
        buscarClientePorCodigo();
        this.click();
    }

    /**
     * Método que administra la pulsación realizada en el botón 'Aceptar',
     * ejecutando la actualización de datos del cliente
     */
    private void click() {
        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarCliente();
            }
        });
    }

    private void actualizarCliente() {
        if (!editTextNombreU.getText().toString().isEmpty() && !editTextApellidoU.getText().toString().isEmpty() &&
                !editTextNitU.getText().toString().isEmpty() && !editTextDireccionU.getText().toString().isEmpty() &&
                !editTextTelefonoU.getText().toString().isEmpty() && !editTextCorreoU.getText().toString().isEmpty()) {
            cvo.setDireccionCliente(editTextDireccionU.getText().toString());
            cvo.setTelCliente(editTextTelefonoU.getText().toString());
            cvo.setCorreCliente(editTextCorreoU.getText().toString());
            if (udao.actualizarUsuario(cvo, getApplicationContext())) {
                Toast.makeText(this, "Cliente actualizado correctamente", Toast.LENGTH_SHORT).show();
                this.recreate();
            } else {
                Toast.makeText(this, "Error en la actualización", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Debe de llenar todos los campos para poder actualizar", Toast.LENGTH_SHORT).show();
        }
    }

    private void buscarClientePorCodigo() {
        cvo.setIdCliente(ConstanteCliente.CODIGO_CLIENTE);
        if (!udao.buscarUsuario(cvo, getApplicationContext(), this, this)) {
            editTextNombreU.setText("-");
            editTextApellidoU.setText("-");
            editTextNitU.setText("-");
            editTextDireccionU.setText("-");
            editTextTelefonoU.setText("-");
            editTextCorreoU.setText("-");
            buttonAceptar.setEnabled(false);
            Toast.makeText(this, "Error en la comunicación con el servidor de la información", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        if(udao.respuestaBusquedaUsuario(cvo,response)) {
            editTextNombreU.setText(cvo.getNombreCliente());
            editTextApellidoU.setText(cvo.getApellidoCliente());
            editTextNitU.setText(cvo.getNitCliente());
            editTextDireccionU.setText(cvo.getDireccionCliente());
            editTextTelefonoU.setText(cvo.getTelCliente());
            editTextCorreoU.setText(cvo.getCorreCliente());
        }
        else {
            editTextNombreU.setText("-");
            editTextApellidoU.setText("-");
            editTextNitU.setText("-");
            editTextDireccionU.setText("-");
            editTextTelefonoU.setText("-");
            editTextCorreoU.setText("-");
            buttonAceptar.setEnabled(false);
            Toast.makeText(this, "Datos No Encontrados", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println(error);
    }
}