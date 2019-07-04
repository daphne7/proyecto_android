package daphne.example.prueba;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import daphne.example.prueba.adaptadores.adaptersAnuncios;
import daphne.example.prueba.datainfos.dataAnuncios;


public class anuncios extends Fragment {

    private RecyclerView recyclerV ;
    private adaptersAnuncios adapter;


    private OnFragmentInteractionListener mListener;
    RecyclerView recicler ;
    ArrayList<dataAnuncios> listarecycler;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

  //  private OnFragmentInteractionListener mListener;

    public anuncios() {

  //      loadComponents();
    }

    public static anuncios newInstance(String param1, String param2) {
        anuncios fragment = new anuncios();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

 /*   private void loadComponents() {

        ListView list = findViewById(R.id.listaanun);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listdata = new ArrayList<>();
        Integer[] images = new Integer[]{R.drawable.fondo2, R.drawable.fondo3, R.drawable.logo2, R.drawable.logo2, R.drawable.logo2};
        String[] titles = new String[]{"AUTO", "CELULAR", "BICICLETA", "VENTILADOR", "DESPERTADOR"};
        String[] descrip = new String[]{"vendo auto costo 25.000$ cantida 5,disponible", "vendo celular samsung costo 150bs", "vendo bicicleta costo 300bs cantidad 4, disponible", "vendo ventilador, costo 200bs, cantidad 5, disponible", "vendo despertador, costo 100bs,cantidad 10 , disponible"};
        //ArrayList<DataInfo> listdata =new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            dataAnuncios info = new dataAnuncios();
            info.setImg(images[i]);
            info.setTitle(titles[i]);
            info.setDescripcion(descrip[i]);
            listdata.add(info);

        }
        adaptersAnuncios adapter = new adaptersAnuncios(this, listdata);

        list.setAdapter(adapter);
    }*/

    public List<dataAnuncios> obtencion() {
        List<dataAnuncios> datos = new ArrayList<>();

       // listarecycler.add(new dataAnuncios
       //         ("bicicleta","costo a listarecycler.add(new dataAnuncios("title", "est", R.drawable.fondo3)"));

      //  listarecycler.add(new dataAnuncios
             //   ("patines","costo a listarecycler.add(new dataAnuncios("title", "est", R.drawable.logo2)"));

        listarecycler.add(new dataAnuncios("est","aqui nuestro logo lindo",R.drawable.logouno));
        listarecycler.add(new dataAnuncios("est","esaz",R.drawable.logo2));
        listarecycler.add(new dataAnuncios("est","esaz",R.drawable.logo2));
        listarecycler.add(new dataAnuncios("est","esaz",R.drawable.logo2));
      return listarecycler;
    }




   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
       // Inflate the layout for this fragment
       View vista=inflater.inflate(R.layout.fragment_anuncios, container, false);

       listarecycler= new ArrayList<>();
       recicler=(RecyclerView)vista.findViewById(R.id.recicler);
       recicler.setLayoutManager(new LinearLayoutManager(getContext()));
       obtencion();
       adaptersAnuncios adapter = new adaptersAnuncios(listarecycler);
       recicler.setAdapter(adapter);
       return vista;
   }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
