package daphne.example.prueba.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import daphne.example.prueba.R;
import daphne.example.prueba.datainfos.dataAmigos;
import daphne.example.prueba.datainfos.dataAnuncios;

public class adaptersamigos extends RecyclerView.Adapter<adaptersamigos.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgamigos;
        TextView descripcion;
        TextView tit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tit = itemView.findViewById(R.id.title);
            descripcion = itemView.findViewById(R.id.descripcion);
            imgamigos = itemView.findViewById(R.id.imgamigo);
        }
    }
    public List<dataAmigos> listaa;
    public adaptersamigos(List<dataAmigos> listaa) {
        this.listaa = listaa;
    }

    /* @Override
    public adaptersAnuncios.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemanuncio, parent, false);
        adaptersAnuncios.ViewHolder viewHolder = new adaptersAnuncios.ViewHolder(view);
        return viewHolder;
    }*/
    @Override
    public adaptersamigos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemamigos, parent, false);
        adaptersamigos.ViewHolder viewHolder = new adaptersamigos.ViewHolder(view);
        return viewHolder;

    }

    /*public void onBindViewHolder(adaptersAnuncios.ViewHolder holder, int position)*/

    @Override
    public void onBindViewHolder(adaptersamigos.ViewHolder holder, int position) {
        holder.tit.setText(listaa.get(position).getTitle());
        holder.imgamigos.setImageResource(listaa.get(position).getImg());
        holder.descripcion.setText(listaa.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return listaa.size();
    }


}
