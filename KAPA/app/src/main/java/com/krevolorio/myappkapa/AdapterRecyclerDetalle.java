package com.krevolorio.myappkapa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krevolorio.myappkapa.basededatossw.DetalleVO;

import java.util.ArrayList;

public class AdapterRecyclerDetalle extends RecyclerView.Adapter<AdapterRecyclerDetalle.ViewHolder> {

    ArrayList<DetalleVO> listaDatos;

    public AdapterRecyclerDetalle(ArrayList<DetalleVO> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false );
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.asignarDatos(listaDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dato= (TextView) itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(DetalleVO datos) {
            dato.setText((CharSequence) datos);
        }
    }
}
