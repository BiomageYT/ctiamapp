package com.ufps.ctiam20.ui.categorias;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ufps.ctiam20.DesTiendaActivity;
import com.ufps.ctiam20.R;
import com.ufps.ctiam20.ui.conbel.ConBelFragment;
import com.ufps.ctiam20.ui.concom.ConComFragment;
import com.ufps.ctiam20.ui.conhog.ConHogFragment;
import com.ufps.ctiam20.ui.conroh.ConRohFragment;
import com.ufps.ctiam20.ui.conrom.ConRomFragment;
import com.ufps.ctiam20.ui.contec.ConTecFragment;
import com.ufps.ctiam20.ui.vr.VrFragment;

public class CategoriasFragment extends Fragment {

    ImageView imagenTecno;
    ImageView imagenHogar;
    ImageView imagenComida;
    ImageView imagenRopaMujer;
    ImageView imagenRopaHombre;
    ImageView imagenBelleza;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_categorias, container, false);

        imagenTecno = view.findViewById(R.id.imagenTecno);
        imagenHogar = view.findViewById(R.id.imagenHogar);
        imagenComida = view.findViewById(R.id.imagenComida);
        imagenRopaMujer = view.findViewById(R.id.imagenRopaMujer);
        imagenRopaHombre = view.findViewById(R.id.imagenRopaHombre);
        imagenBelleza = view.findViewById(R.id.imagenBelleza);

        imagenTecno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment nuevoFragment = new ConTecFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.drawer_layout, nuevoFragment).addToBackStack(null).commit();

            }
        });
        imagenHogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment nuevoFragment = new ConHogFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.drawer_layout, nuevoFragment).addToBackStack(null).commit();

            }
        });
        imagenComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment nuevoFragment = new ConComFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.drawer_layout, nuevoFragment).addToBackStack(null).commit();

            }
        });
        imagenRopaMujer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment nuevoFragment = new ConRomFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.drawer_layout, nuevoFragment).addToBackStack(null).commit();

            }
        });
        imagenRopaHombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment nuevoFragment = new ConRohFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.drawer_layout, nuevoFragment).addToBackStack(null).commit();

            }
        });

        imagenBelleza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment nuevoFragment = new ConBelFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.drawer_layout, nuevoFragment).addToBackStack(null).commit();

            }
        });

        return view;
    }

}