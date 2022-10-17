package com.krevolorio.myappkapa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krevolorio.myappkapa.basededatossw.SucursalVO;

import java.util.ArrayList;

/**
 * Clase que contiene los métodos para el adaptador del recyclerview de sucursales
 */
public class AdapterRecyclerSucursal extends RecyclerView.Adapter<AdapterRecyclerSucursal.ViewHolder>{
    private ArrayList<SucursalVO> sucursales = new ArrayList<>();

    public AdapterRecyclerSucursal(ArrayList<SucursalVO> sucursales) {
        this.sucursales = sucursales;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_sucursal, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.establecerSucursales(sucursales.get(position).getNombreSucursal(),
                sucursales.get(position).getDireccionSucursal(),
                sucursales.get(position).getTelefonoSucursal());
    }

    @Override
    public int getItemCount() {
        return this.sucursales.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewNombre, textViewDireccion, textViewTelefono;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.txtNombreSucursal);
            textViewDireccion = itemView.findViewById(R.id.txtDireccionSucursal);
            textViewTelefono = itemView.findViewById(R.id.txtTelefonoSucursal);
        }
        private void establecerSucursales(String nombre, String direccion, String telefono) {
            textViewNombre.setText(nombre);
            textViewDireccion.setText(direccion);
            textViewTelefono.setText(telefono);
        }
    }
}
