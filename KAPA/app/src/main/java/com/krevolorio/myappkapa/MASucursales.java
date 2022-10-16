package com.krevolorio.myappkapa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.krevolorio.myappkapa.basededatossw.SucursalDAO;
import com.krevolorio.myappkapa.basededatossw.SucursalVO;

public class MASucursales extends AppCompatActivity {
    private SucursalVO svo = new SucursalVO();
    private SucursalDAO sdao = new SucursalDAO();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masucursales);
        recyclerView = findViewById(R.id.rvSucursales);
    }
}