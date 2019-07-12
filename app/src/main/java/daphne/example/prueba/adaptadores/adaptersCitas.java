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
import daphne.example.prueba.datainfos.dataCita;

public class adaptersCitas extends RecyclerView.Adapter<adaptersCitas.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgcitas;
        TextView descripcion;
        TextView tit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tit = itemView.findViewById(R.id.title);
            descripcion = itemView.findViewById(R.id.descripcion);
            imgcitas = itemView.findViewById(R.id.imgcita);
        }
    }

    public List<dataCita> listaa;
    public adaptersCitas(List<dataCita> listaa) {
        this.listaa = listaa;
    }

    @Override
    public adaptersCitas.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcita, parent, false);
        adaptersCitas.ViewHolder viewHolder = new adaptersCitas.ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(adaptersCitas.ViewHolder holder, int position) {
        holder.tit.setText(listaa.get(position).getTitle());
        holder.imgcitas.setImageResource(listaa.get(position).getImg());
        holder.descripcion.setText(listaa.get(position).getDescripcion());
    }


    @Override
    public int getItemCount() {
        return listaa.size();
    }

}