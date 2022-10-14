package com.krevolorio.myappkapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.krevolorio.myappkapa.basededatossw.ClienteDAO;
import com.krevolorio.myappkapa.basededatossw.ClienteVO;

public class MAregistro extends AppCompatActivity {
    private Button buttonRe;
    private EditText editTextNombre, editTextApellido, editTextNit, editTextDireccion, editTextTel, editTextUsuario,
            editTextPassword, editTextRepassowrd, editTextCorreo;

    ClienteVO cvo = new ClienteVO();
    ClienteDAO cdao = new ClienteDAO();


    public MAregistro(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maregistro);
        editTextNombre = findViewById(R.id.edtNombre);
        editTextApellido = findViewById(R.id.edtApellido);
        editTextNit = findViewById(R.id.edtNIT);
        editTextDireccion = findViewById(R.id.edtDireccion);
        editTextTel = findViewById(R.id.edtTelefono);
        editTextUsuario = findViewById(R.id.edtUsuario);
        editTextPassword = findViewById(R.id.edtPassword);
        editTextRepassowrd = findViewById(R.id.edtRepassword);
        editTextCorreo = findViewById(R.id.edtCorreo);

        buttonRe = findViewById(R.id.btnRegistrar);
        this.clickRegistro();
    }

    private void clickRegistro() {
        buttonRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarCliente();
            }
        });
    }

    private void registrarCliente(){

        if (!editTextNombre.getText().toString().isEmpty() && !editTextApellido.getText().toString().isEmpty() && !editTextNit.getText().toString().isEmpty()
            && !editTextDireccion.getText().toString().isEmpty() && !editTextTel.getText().toString().isEmpty() && !editTextUsuario.getText().toString().isEmpty()
            && !editTextPassword.getText().toString().isEmpty() && !editTextRepassowrd.getText().toString().isEmpty() && !editTextCorreo.getText().toString().isEmpty()){


            if (editTextPassword.getText().toString().equals(editTextRepassowrd.getText().toString())){
                cvo.setNombreCliente(editTextNombre.getText().toString());
                cvo.setApellidoCliente(editTextApellido.getText().toString());
                cvo.setNitCliente(editTextNit.getText().toString());
                cvo.setDireccionCliente(editTextDireccion.getText().toString());
                cvo.setTelCliente(editTextTel.getText().toString());
                cvo.setUsuarioCliente(editTextUsuario.getText().toString());
                cvo.setContraCliente(editTextPassword.getText().toString());
                cvo.setCorreCliente(editTextCorreo.getText().toString());

                if (cdao.registroSW(cvo, getApplicationContext())){
                    editTextNombre.setText("");
                    editTextApellido.setText("");
                    editTextNit.setText("");
                    editTextDireccion.setText("");
                    editTextTel.setText("");
                    editTextUsuario.setText("");
                    editTextPassword.setText("");
                    editTextRepassowrd.setText("");
                    editTextCorreo.setText("");
                    Toast.makeText(this, "Cliente registrado correctamente", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Error al registrar al cliente", Toast.LENGTH_SHORT).show();

                }


            }else{

                Toast.makeText(this, "Ingrese las mismas contraseñas", Toast.LENGTH_SHORT).show();
            }

        }else{

            Toast.makeText(this, "Debe de llenar todos los campos!", Toast.LENGTH_SHORT).show();
        }

    }

}