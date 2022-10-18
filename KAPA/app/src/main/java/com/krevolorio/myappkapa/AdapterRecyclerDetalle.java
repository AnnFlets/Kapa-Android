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

    private ArrayList<DetalleVO> listaDatos = new ArrayList<>();

    public AdapterRecyclerDetalle(ArrayList<DetalleVO> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false );
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
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

        private TextView textViewCantidad, textViewPrecio, textViewSubtotal, textViewDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCantidad = itemView.findViewById(R.id.idCantidad);
            textViewPrecio = itemView.findViewById(R.id.idPrecio);
            textViewSubtotal = itemView.findViewById(R.id.idSubtotal);
            textViewDescripcion = itemView.findViewById(R.id.idDescripcion);
        }

        public void asignarDatos(DetalleVO datos) {
            textViewPrecio.setText("Q. "+String.valueOf(datos.getPrecio()));
            textViewCantidad.setText(String.valueOf(datos.getCantidad()));
            textViewDescripcion.setText(datos.getDescripcion());
            textViewSubtotal.setText("Q. "+String.valueOf(datos.getSubtotal()));
        }
    }
}
