package daphne.example.prueba.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import daphne.example.prueba.R;
import daphne.example.prueba.datainfos.dataAnuncios;
import daphne.example.prueba.descripcion_articulo;
import daphne.example.prueba.fragmentos.anuncios;
import daphne.example.prueba.miauapp;

public class adaptersAnuncios  extends RecyclerView.Adapter<adaptersAnuncios.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imganuncios;
        TextView descripcion;
        TextView tit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

                    tit = itemView.findViewById(R.id.title);
            descripcion = itemView.findViewById(R.id.descripcion);
            imganuncios = itemView.findViewById(R.id.imganuncio);
        }
    }

    public List<dataAnuncios> listaa;
    public adaptersAnuncios(List<dataAnuncios> listaa) {
        this.listaa = listaa;
    }

    @Override
    public adaptersAnuncios.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemanuncio, parent, false);
        adaptersAnuncios.ViewHolder viewHolder = new adaptersAnuncios.ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(adaptersAnuncios.ViewHolder holder, int position) {
        holder.tit.setText(listaa.get(position).getTitle());
        holder.imganuncios.setImageResource(listaa.get(position).getImg());
        holder.descripcion.setText(listaa.get(position).getDescripcion());
    }


    @Override
    public int getItemCount() {
        return listaa.size();
    }


}