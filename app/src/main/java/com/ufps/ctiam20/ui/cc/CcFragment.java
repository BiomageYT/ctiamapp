package com.ufps.ctiam20.ui.cc;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ufps.ctiam20.R;
import com.ufps.ctiam20.TiendaAdapter;
import com.ufps.ctiam20.modelo.Tienda;

import java.net.MalformedURLException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CcFragment extends Fragment {
    RecyclerView contenedorTienda;

    private CcViewModel ccViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ccViewModel =
                new ViewModelProvider(this).get(CcViewModel.class);
        //AQUI VA EL FRAGMENTO QUE INFLÓ , DEJO TIENDAS DE MOMENTO PERO VA fragment_cc
        View view = inflater.inflate(R.layout.fragment_tiendas, container, false);
        contenedorTienda=view.findViewById(R.id.contenedortiendas);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getContext());
        linearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        contenedorTienda.setLayoutManager(linearLayout);
        TiendaAdapter tiendaAdapter = new TiendaAdapter(getActivity(),cargarDatos(),R.id.card);
        contenedorTienda.setAdapter(tiendaAdapter);

        ;
        return view;
    }

    public ArrayList<Tienda> cargarDatos() {
        String sql = "http://100.26.160.202/api/tiendas";
        ArrayList<Tienda> tiendas = new ArrayList<>();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = null;
        HttpURLConnection conn;

        try {
            url = new URL(sql);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;

            StringBuffer response = new StringBuffer();
            String json = "";

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            json = response.toString();
            JSONArray jsonArr = null;
            jsonArr = new JSONArray(json);

            for (int i = 0; i < jsonArr.length(); i++) {
                JSONObject jsonObject = jsonArr.getJSONObject(i);
                String id = jsonObject.optString("id");
                String nombreTienda = jsonObject.optString("nombre");
                String descripcionTienda = jsonObject.optString("descripcion");
                String telefonoTienda = jsonObject.optString("telefono");
                String emailTienda = jsonObject.optString("email");
                String paginawebTienda = jsonObject.optString("pagina_web");
                String fotoTienda = jsonObject.optString("imagen");
                String horarioTienda = jsonObject.optString("horario");
                String ubicacionTienda = jsonObject.optString("ubicacion");
                if(ubicacionTienda.equals("cc")) {
                    tiendas.add(new Tienda(id, nombreTienda, descripcionTienda, telefonoTienda, emailTienda, paginawebTienda, fotoTienda, horarioTienda, ubicacionTienda));
                }else{
                    continue;
                }
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tiendas;
    }




}