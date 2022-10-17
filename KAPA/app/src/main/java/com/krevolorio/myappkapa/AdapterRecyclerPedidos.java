package com.krevolorio.myappkapa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krevolorio.myappkapa.basededatossw.PedidoVO;

import java.util.ArrayList;

/**
 * Clase que contiene los métodos para el adaptador del recyclerview de pedidos
 */
public class AdapterRecyclerPedidos extends RecyclerView.Adapter<AdapterRecyclerPedidos.ViewHolder>{
    private ArrayList<PedidoVO> pedidos = new ArrayList<>();

    public AdapterRecyclerPedidos(ArrayList<PedidoVO> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_pedidos, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.establecerPedidos(pedidos.get(position).getNumeroFactura(),
                pedidos.get(position).getFechaFactura(),
                pedidos.get(position).getTotalFactura(),
                pedidos.get(position).getEstadoFactura());
    }

    @Override
    public int getItemCount() {
        return this.pedidos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNumeroPedido, textViewFechaPedido, textViewTotalPedido, textViewEstadoPedido;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumeroPedido = itemView.findViewById(R.id.txtNumeroPedido);
            textViewFechaPedido = itemView.findViewById(R.id.txtFechaPedido);
            textViewTotalPedido = itemView.findViewById(R.id.txtTotalPedido);
            textViewEstadoPedido = itemView.findViewById(R.id.txtEstadoPedido);
        }
        private void establecerPedidos(int numero, String fecha, double total, String estado) {
            textViewNumeroPedido.setText(String.valueOf(numero));
            textViewFechaPedido.setText(fecha);
            textViewTotalPedido.setText(String.valueOf(total));
            textViewEstadoPedido.setText(estado);
        }
    }
}
