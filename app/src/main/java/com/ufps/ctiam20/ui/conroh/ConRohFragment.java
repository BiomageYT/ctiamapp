package com.ufps.ctiam20.ui.conroh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ufps.ctiam20.DesTiendaActivity;
import com.ufps.ctiam20.MainActivity;
import com.ufps.ctiam20.MenuActivity;
import com.ufps.ctiam20.OlvidoClaveActivity;
import com.ufps.ctiam20.ProductoAdapter;
import com.ufps.ctiam20.R;
import com.ufps.ctiam20.modelo.Producto;
import com.ufps.ctiam20.modelo.Tienda;

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

public class ConRohFragment extends Fragment {

    RecyclerView contenedorproductos;
    FloatingActionButton botonIrProducto;

    private ConRohViewModel conrohViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        conrohViewModel =
                new ViewModelProvider(this).get(ConRohViewModel.class);
        //AQUI VA EL FRAGMENTO QUE INFLÓ , DEJO PRODUCTOS DE MOMENTO PERO VA fragment_con_roh
        View view = inflater.inflate(R.layout.fragment_productos, container, false);
        contenedorproductos=view.findViewById(R.id.contenedorproductos);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getContext());
        linearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        contenedorproductos.setLayoutManager(linearLayout);
        ProductoAdapter productoAdapter = new ProductoAdapter(getActivity(),cargarProductos(),R.id.cardproducto);
        contenedorproductos.setAdapter(productoAdapter);
        return view;
    }

    public ArrayList<Producto> cargarProductos() {
        String sql = "http://100.26.160.202/api/productos";
        ArrayList<Producto> productos = new ArrayList<>();
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
                String idTienda = jsonObject.optString("id_tienda");
                String idCategoria = jsonObject.optString("id_categoria");
                String idMarca = jsonObject.optString("id_marca");
                String idEstado = jsonObject.optString("id_estado");
                String tituloProducto = jsonObject.optString("titulo");
                String descripcionProducto = jsonObject.optString("descripcion");
                String detalleProducto = jsonObject.optString("detalle");
                String precioProducto = jsonObject.optString("precio");
                String fechaProducto = jsonObject.optString("fecha");
                String stockProducto = jsonObject.optString("stock");
                String imagenProducto = jsonObject.optString("imagen");
                if(idCategoria.equals("3")){
                    productos.add(new Producto(id, idTienda, idCategoria,idMarca,idEstado,tituloProducto,descripcionProducto,detalleProducto,precioProducto,fechaProducto,stockProducto,imagenProducto));
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
        return productos;
    }

}