package daphne.example.prueba.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import daphne.example.prueba.HolderMensaje;
import daphne.example.prueba.R;
import daphne.example.prueba.mensaje;
import daphne.example.prueba.mensajeRecibir;
//import de.hdodenhof.circleimageview.CircleImageView;

public class adaptersMensajes extends RecyclerView.Adapter<HolderMensaje> {
    @NonNull
    @Override
    public HolderMensaje onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderMensaje holderMensaje, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
/*
     private List<mensajeRecibir> listMensaje = new ArrayList<>();
     private Context c;

     //aqui se llenara un contexto
    public adaptersMensajes( Context c) {
        this.listMensaje = listMensaje;
        this.c = c;
    }
    //creando metodo para agregar mensaje
    public void addmensaje(mensajeRecibir m){
        listMensaje.add(m);
        //permite enviar el mensaje
        notifyItemInserted(listMensaje.size());
    }

    @Override
    public HolderMensaje onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_mensajes,parent,false);
        return new HolderMensaje(v);

    }

    @Override
    public void onBindViewHolder(HolderMensaje holder, int position) {
     holder.getNombre().setText(listMensaje.get(position).getNombre());
     holder.getMensaje().setText(listMensaje.get(position).getMenssaje());
     //holder.getHora().setText(listMensaje.get(position).getHora());
       if (listMensaje.get(position).getType_mensaje().equals("2")){
          holder.getFotomensajeenviado().setVisibility(View.VISIBLE);
          holder.getMensaje().setVisibility(View.VISIBLE);
           Glide.with(c).load(listMensaje.get(position).getUrlfoto()).into(holder.getFotomensajeenviado());

          }else if (listMensaje.get(position).getType_mensaje().equals("1")) {
           holder.getFotomensajeenviado().setVisibility(View.GONE);
           holder.getMensaje().setVisibility(View.VISIBLE);
           }
           if (listMensaje.get(position).getFotoPerfil().isEmpty()){
               holder.getFotoMensaje().setImageResource(R.mipmap.ic_launcher);
           }else {
               Glide.with(c).load(listMensaje.get(position).getFotoPerfil()).into(holder.getFotoMensaje());
           }

        Long codigoHora = listMensaje.get(position).getHora();
        Date d =new Date(codigoHora);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");//para poner la hora
        holder.getHora().setText(sdf.format(d));

    }

    @Override
    public int getItemCount() {
        //tamano de lista
        return listMensaje.size();

    }*/
}
