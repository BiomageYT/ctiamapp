package com.ufps.ctiam20.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ufps.ctiam20.R;

public class PerfilFragment extends Fragment {


    TextView nombreperfil;
    TextView cedulaperfil;
    TextView sexo;
    TextView correoperfil;
    TextView telefonoperfil;



   //private PerfilViewModel perfilViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       // perfilViewModel =
         //     new ViewModelProvider(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

        nombreperfil= root.findViewById(R.id.nombreperfil);
        cedulaperfil= root.findViewById(R.id.cedulaperfil);
        sexo= root.findViewById(R.id.sexo);
        correoperfil=root.findViewById(R.id.correoperfil);
        telefonoperfil=root.findViewById(R.id.telefonoperfil);

        nombreperfil.setText("Juan sebastian Castellanos Sanchez");
        cedulaperfil.setText("1090529363");
        sexo.setText("Masculino");
        correoperfil.setText("scastellanos356@gmail.com");
        telefonoperfil.setText("3165282884");

    //    final TextView textView =  root.findViewById(R.id.text_slideshow);
      //  perfilViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
        //    @Override
       //     public void onChanged(@Nullable String s) {
       //         textView.setText(s);
       //     }
      //  });
        return root;
    }
}