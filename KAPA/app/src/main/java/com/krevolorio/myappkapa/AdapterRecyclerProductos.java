package com.krevolorio.myappkapa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krevolorio.myappkapa.basededatossw.ProductoVO;

import java.util.ArrayList;

public class AdapterRecyclerProductos extends RecyclerView.Adapter<AdapterRecyclerProductos.ViewHolder>{
    private static ClickListener clickListener;
    private ArrayList<ProductoVO> productos = new ArrayList<>();

    public AdapterRecyclerProductos(ArrayList<ProductoVO> productos) {
        this.productos = productos;
    }

    @Override
    public AdapterRecyclerProductos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_producto, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.establecerProductos(productos.get(position).getImgProducto(),
                productos.get(position).getDescripcionProducto(),
                productos.get(position).getMarcaProducto(),
                productos.get(position).getPresentacionProducto(),
                productos.get(position).getPrecioVentaProducto());
    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textViewDescripcion, textViewMarca, textViewPresentacion, textViewPrecio;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgProducto);
            textViewDescripcion = itemView.findViewById(R.id.txtDescripcionProducto);
            textViewMarca = itemView.findViewById(R.id.txtMarcaProducto);
            textViewPresentacion = itemView.findViewById(R.id.txtPresentacionProducto);
            textViewPrecio = itemView.findViewById(R.id.txtPrecioProducto);
            itemView.setOnClickListener(this);
        }
        private void establecerProductos(String img, String descripcion, String marca, String presentacion, double precio) {
            imageView.setImageResource(imgProducto(img));
            textViewDescripcion.setText(descripcion);
            textViewMarca.setText(marca);
            textViewPresentacion.setText(presentacion);
            textViewPrecio.setText(String.valueOf(precio));
        }
        @Override
        public void onClick(View v) {
            clickListener.itemClick(getAdapterPosition(), v);
        }
    }

    private int imgProducto(String img){
        int imagenProducto;
        if(img.equals("img001.png")){
            imagenProducto = R.drawable.img001;
        }else if (img.equals("img002.png")){
            imagenProducto = R.drawable.img002;
        }else if (img.equals("img003.png")){
            imagenProducto = R.drawable.img003;
        }else if (img.equals("img004.png")){
            imagenProducto = R.drawable.img004;
        }else if (img.equals("img005.png")){
            imagenProducto = R.drawable.img005;
        }else if (img.equals("img006.png")){
            imagenProducto = R.drawable.img006;
        }else if (img.equals("img007.png")){
            imagenProducto = R.drawable.img007;
        }else if (img.equals("img008.png")){
            imagenProducto = R.drawable.img008;
        }else{
            imagenProducto = R.drawable.caja;
        }
        return imagenProducto;
    }

    public void setItemClickListener(ClickListener clickListener){
        AdapterRecyclerProductos.clickListener = clickListener;
    }
}
