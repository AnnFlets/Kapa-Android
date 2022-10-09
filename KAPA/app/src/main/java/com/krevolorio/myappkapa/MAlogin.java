package com.krevolorio.myappkapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MAlogin extends AppCompatActivity {
    private Button buttonIr;

    public MAlogin() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malogin);
        buttonIr = findViewById(R.id.btnIrregistro);
        this.clickIr();

    }

    private void clickIr() {
        buttonIr.setOnClickListener(view -> aperturaIrregistro());
    }
    private void aperturaIrregistro(){
        Intent intent = new Intent(this, MAregistro.class);
                startActivity(intent);

    }
}