package com.krevolorio.myappkapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MAregistro extends AppCompatActivity {
    private Button buttonRe;

    public MAregistro(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maregistro);
        buttonRe = findViewById(R.id.btnRegistrar);
        this.clickRe();
    }

    private void clickRe() {
        buttonRe.setOnClickListener(view -> aperturaRegistrar());
    }
    private void aperturaRegistrar(){
        Intent intent = new Intent(this, MAregistro.class);
        startActivity(intent);
    }
}