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
import com.ufps.ctiam20.modelo.Tienda;
import java.util.ArrayList;

public class CcAdapter extends RecyclerView.Adapter<CcAdapter.TiendaViewHolder> {
    private Context context;
    private ArrayList<Tienda> tiendas;
    private int cursor;

    public CcAdapter(Context context, ArrayList<Tienda> tiendas, int cursor) {
        this.context = context;
        this.tiendas = tiendas;
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public TiendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);

        return new TiendaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TiendaViewHolder holder, int position) {
        Picasso.get().load(tiendas.get(position).getImagen()).into(holder.fototienda);
        holder.nombretienda.setText(tiendas.get(position).getNombre());
        holder.descripciontienda.setText(tiendas.get(position).getDescripcion());
        holder.horariotienda.setText(tiendas.get(position).getHorario());
        //holder.botonTienda.setOnClickListener(this);
        switch (position){
            case 0:
                holder.botonTienda.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ir();
                    }
                });
                break;
            case 2:
                holder.botonTienda.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ir2();
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return tiendas.size();
    }

    public void ir() {
        Intent sebas = new Intent(context, DesTiendaActivity.class);
        context.startActivity(sebas);
    }
    public void ir2() {
        Intent sebas = new Intent(context, MenuActivity.class);
        context.startActivity(sebas);
    }


    //  @Override
    //public void onClick(View v) {
    //        Intent sebas = new Intent(context, DesTiendaActivity.class);
    //      context.startActivity(sebas);
    //  }
    //}

    class TiendaViewHolder extends RecyclerView.ViewHolder {
        ImageView fototienda, localizaciontienda, whatsapptienda;
        TextView nombretienda, descripciontienda ,horariotienda;
        FloatingActionButton botonTienda;


        public TiendaViewHolder(@NonNull View itemView) {
            super(itemView);
            fototienda=itemView.findViewById(R.id.fototienda);
            nombretienda=itemView.findViewById(R.id.nombretienda);
            descripciontienda=itemView.findViewById(R.id.descripciontienda);
            horariotienda=itemView.findViewById(R.id.horariotienda);
            botonTienda= itemView.findViewById(R.id.floating_action_button);

        }
    }
}

