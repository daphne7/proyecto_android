package daphne.example.prueba.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.List;

import daphne.example.prueba.R;
import daphne.example.prueba.chatUsuario;
import daphne.example.prueba.datainfos.dataAmigos;


public class adaptersamigos extends RecyclerView.Adapter<adaptersamigos.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linear;
        ImageView imgamigos;
        TextView descripcion;
        TextView tit;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linear = itemView.findViewById(R.id.listaenlace1);
            tit = itemView.findViewById(R.id.title);
            descripcion = itemView.findViewById(R.id.descripcion);
            imgamigos = itemView.findViewById(R.id.imgamigo);
           
        }

    }
    public List<dataAmigos> listaa;
    public adaptersamigos(List<dataAmigos> listaa) { this.listaa = listaa; }

    @Override
    public adaptersamigos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemamigos, parent, false);
        adaptersamigos.ViewHolder viewHolder = new adaptersamigos.ViewHolder(view);
        return viewHolder;

    }

    /*public void onBindViewHolder(adaptersAnuncios.ViewHolder holder, int position)*/

    @Override
    public void onBindViewHolder(adaptersamigos.ViewHolder holder, final int position) {
        holder.tit.setText(listaa.get(position).getTitle());
        holder.imgamigos.setImageResource(listaa.get(position).getImg());
        holder.descripcion.setText(listaa.get(position).getDescripcion());

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), chatUsuario.class);
                Intent img = intent.putExtra("img", listaa.get(position).getImg());
                intent.putExtra("descripcion", listaa.get(position).getDescripcion());
                intent.putExtra("title", listaa.get(position).getTitle());
                (v.getContext()).startActivity(intent);
            }
        });
    //    return convertView;
    }
    

    @Override
    public int getItemCount() {
        return listaa.size();
    }


}
