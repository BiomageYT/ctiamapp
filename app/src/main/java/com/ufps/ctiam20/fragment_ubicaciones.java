package com.ufps.ctiam20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ufps.ctiam20.ui.cc.CcFragment;
import com.ufps.ctiam20.ui.lp.LpFragment;
import com.ufps.ctiam20.ui.vr.VrFragment;


public class fragment_ubicaciones extends Fragment {

    FragmentTransaction hola;
    Fragment hola2;

    ImageView imagenVR;
    ImageView imagenCucuta;
    ImageView imagenPatios;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public fragment_ubicaciones() {
    }

    public static fragment_ubicaciones newInstance(String param1, String param2) {
        fragment_ubicaciones fragment = new fragment_ubicaciones();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_ubicaciones, container, false);

        imagenVR = view.findViewById(R.id.imagenVR);
        imagenCucuta = view.findViewById(R.id.imagenCucuta);
        imagenPatios = view.findViewById(R.id.imagenPatios);

        imagenVR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment nuevoFragment = new VrFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.drawer_layout, nuevoFragment).addToBackStack(null).commit();

            }
        });
        imagenPatios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment nuevoFragment = new LpFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.drawer_layout, nuevoFragment).addToBackStack(null).commit();

            }
        });
        imagenCucuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragment = new CcFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.drawer_layout, nuevoFragment).addToBackStack(null).commit();

            }
        });

        return view;
    }

}