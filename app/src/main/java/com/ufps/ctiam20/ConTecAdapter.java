package com.ufps.ctiam20;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;
import com.ufps.ctiam20.modelo.Producto;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ConTecAdapter extends RecyclerView.Adapter<ConTecAdapter.ProductoViewHolder> implements View.OnClickListener {

    private Context context;
    private ArrayList<Producto> productos;
    private int cursor;

    public ConTecAdapter(Context context, ArrayList<Producto> productos, int cursor) {
        this.context = context;
        this.productos = productos;
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardproducto,parent,false);

        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Picasso.get().load(productos.get(position).getImagen()).into(holder.fotoproducto);
        holder.nombreproducto.setText(productos.get(position).getTitulo());
        holder.descripcionproducto.setText(productos.get(position).getDescripcion());
        holder.precioproducto.setText(productos.get(position).getPrecio());

        holder.botonIrProducto.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, DesProductoActivity.class);
        context.startActivity(intent);
    }

    class ProductoViewHolder extends RecyclerView.ViewHolder{

        ImageView fotoproducto;
        TextView nombreproducto,descripcionproducto,precioproducto;
        FloatingActionButton botonIrProducto;




        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoproducto=itemView.findViewById(R.id.fotoproducto);
            nombreproducto=itemView.findViewById(R.id.nombreproducto);
            descripcionproducto=itemView.findViewById(R.id.descripcionproducto);
            precioproducto=itemView.findViewById(R.id.precioproducto);
            botonIrProducto=itemView.findViewById(R.id.botonIrProducto);
        }
    }

}

