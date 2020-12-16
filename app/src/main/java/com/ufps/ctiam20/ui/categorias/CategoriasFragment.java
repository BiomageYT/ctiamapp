package com.ufps.ctiam20.ui.categorias;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ufps.ctiam20.DesTiendaActivity;
import com.ufps.ctiam20.R;

public class CategoriasFragment extends Fragment {

    Button categoriatecnologia;
    Button categoriahogar;
    Button categoriacomidas;
    Button categoriadeporte;
    Button categoriabelleza;
    Button categoriajuguetes;
    Button categoriamodahombre;
    Button categoriamodamujer;
    Button categoriasupermercado;
    Button categoriainstrumentos;



 //   private CategoriasViewModel categoriasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
  //      categoriasViewModel =
   //             new ViewModelProvider(this).get(CategoriasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_categorias, container, false);

    //   categoriatecnologia = root.findViewById(R.id.categoriatecnologia);
    //  categoriahogar = root.findViewById(R.id.categoriahogar);
   //    categoriacomidas = root.findViewById(R.id.categoriacomidas);
   //     categoriadeporte = root.findViewById(R.id.categoriadeporte);
   //     categoriabelleza = root.findViewById(R.id.categoriabelleza);
  //      categoriajuguetes = root.findViewById(R.id.categoriajuguetes);
  //      categoriamodahombre = root.findViewById(R.id.categoriamodahombre);
 //       categoriamodamujer = root.findViewById(R.id.categoriamodamujer);
  //      categoriasupermercado = root.findViewById(R.id.categoriasupermercado);
 //       categoriainstrumentos = root.findViewById(R.id.categoriainstrumentos);

  //    categoriatecnologia.setText("TECNOLOGIA");
    //    categoriahogar.setText("HOGAR");
    //   categoriacomidas.setText("COMIDAS");
   //     categoriadeporte.setText("DEPORTES");
   //     categoriabelleza.setText("BELLEZA");
   //     categoriajuguetes.setText("JUGUETES");
   //     categoriamodahombre.setText("ROPA HOMBRE");
   //     categoriamodamujer.setText("ROPA MUJER");
  //      categoriasupermercado.setText("VIVERES");
   //     categoriainstrumentos.setText("MUSICA");


  //      final TextView textView = root.findViewById(R.id.text_gallery);
  //      categoriasViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
   //         @Override
   //         public void onChanged(@Nullable String s) {
   //            textView.setText(s);
  //          }
   //     });
        return root;
    }

}