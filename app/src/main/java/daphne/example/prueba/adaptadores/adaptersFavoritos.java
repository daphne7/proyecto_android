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
import daphne.example.prueba.datainfos.dataFavoritos;

public class adaptersFavoritos  extends RecyclerView.Adapter<adaptersFavoritos.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgfavoritos;
        TextView descripcion;
        TextView tit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tit = itemView.findViewById(R.id.title);
            descripcion = itemView.findViewById(R.id.descripcion);
            imgfavoritos = itemView.findViewById(R.id.imgfavoritos);
        }
    }

    public List<dataFavoritos> listaa;
    public adaptersFavoritos(List<dataFavoritos> listaa) {
        this.listaa = listaa;
    }

    @Override
    public adaptersFavoritos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemfavoritos, parent, false);
        adaptersFavoritos.ViewHolder viewHolder = new adaptersFavoritos.ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(adaptersFavoritos.ViewHolder holder, int position) {
        holder.tit.setText(listaa.get(position).getTitle());
        holder.imgfavoritos.setImageResource(listaa.get(position).getImg());
        holder.descripcion.setText(listaa.get(position).getDescripcion());
    }


    @Override
    public int getItemCount() {
        return listaa.size();
    }


}