package daphne.example.prueba.fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import daphne.example.prueba.R;
import daphne.example.prueba.adaptadores.adaptersamigos;
import daphne.example.prueba.datainfos.dataAmigos;

public class amigos extends Fragment {

    private RecyclerView recyclerV ;
    private adaptersamigos adapter;

    private OnFragmentInteractionListener mListener;
    RecyclerView recicler ;
    ArrayList<dataAmigos> listarecycler;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public amigos() {

    }


    // TODO: Rename and change types and number of parameters
    public static amigos newInstance(String param1, String param2) {
        amigos fragment = new amigos();
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



    public List<dataAmigos> obtencion() {
        List<dataAmigos> datos = new ArrayList<>();

        listarecycler.add(new dataAmigos("esta es el titulo","aqui nuestro logo lindo", R.drawable.logouno));
        listarecycler.add(new dataAmigos("est","esaz",R.drawable.logouno));
        listarecycler.add(new dataAmigos("est","esaz",R.drawable.logo2));
        listarecycler.add(new dataAmigos("est","esaz",R.drawable.logouno));
        listarecycler.add(new dataAmigos("est","esaz",R.drawable.logo2));



        return listarecycler;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_amigos, container, false);

        listarecycler= new ArrayList<>();
        recicler=(RecyclerView)vista.findViewById(R.id.recicler);
        recicler.setLayoutManager(new LinearLayoutManager(getContext()));
        obtencion();
        adaptersamigos adapter = new adaptersamigos(listarecycler);
        recicler.setAdapter(adapter);
        return vista;

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


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
