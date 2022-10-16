package com.krevolorio.myappkapa.complementos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krevolorio.myappkapa.R;
import com.krevolorio.myappkapa.basededatossw.ProductoVO;

import java.util.ArrayList;

public class AdaptadorRecylerProducto extends RecyclerView.Adapter<AdaptadorRecylerProducto.ViewHolder> {

    private ArrayList<ProductoVO> pdvo = new ArrayList<>();

    public AdaptadorRecylerProducto(ArrayList<ProductoVO> pdvo){

      this.pdvo = pdvo;


    }

    @NonNull
    @Override
    public AdaptadorRecylerProducto.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //INFLAR
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_producto,
                parent,false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecylerProducto.ViewHolder holder, int position) {
      holder.setDataProductos(R.drawable.lengua,
              pdvo.get(position).getDescripcionProducto(),
              pdvo.get(position).getPresentacionProducto(),
              pdvo.get(position).getPrecioVentaProducto());


    }

    @Override
    public int getItemCount() {

        return this.pdvo.size();
    }

    public class   ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewProducto;
        private TextView txtView_descripcionProducto, txtViewPresentacionProducto, txtViewPrecioProducto;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imageViewProducto = itemView.findViewById(R.id.imgProductoCategoria);
            txtView_descripcionProducto = itemView.findViewById(R.id.txt_descripcionProducto);
            txtViewPresentacionProducto = itemView.findViewById(R.id.txt_presentacionProducto);
            txtViewPrecioProducto = itemView.findViewById(R.id.txt_precioProducto);

        }
        private void setDataProductos(Integer img, String descripcion, String presentacion, Double precio){

        imageViewProducto.setImageResource(img);
        txtView_descripcionProducto.setText(descripcion);
        txtViewPresentacionProducto.setText(presentacion);
        txtViewPrecioProducto.setText(Double.toString(precio));


        }
    }
}
