package com.ufps.ctiam20.ui.perfil;

import android.os.Bundle;
import android.os.StrictMode;
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
import com.ufps.ctiam20.modelo.Producto;
import com.ufps.ctiam20.modelo.Perfil;

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

        Perfil usuario = getUserPerfil();
        String nombreCompleto = usuario.getNombres() + " " + usuario.getApellidos();
        nombreperfil.setText(nombreCompleto);
        cedulaperfil.setText(usuario.getDni());
        sexo.setText(usuario.getGenero());
        correoperfil.setText(usuario.getEmail());
        telefonoperfil.setText(usuario.getTelefono());


        return root;
    }
    public Perfil getUserPerfil() {
        String sql = "http://100.26.160.202/api/usuarios";
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
                String nombres = jsonObject.optString("nombres");
                String apellidos = jsonObject.optString("apellidos");
                String avatar = jsonObject.optString("avatar");
                String dni = jsonObject.optString("dni");
                String email = jsonObject.optString("email");
                String telefono = jsonObject.optString("telefono");
                String telefono_alternativo = jsonObject.optString("telefono_alternativo");
                String password = jsonObject.optString("password");
                String is_seller = jsonObject.optString("is_seller");
                String genero = jsonObject.optString("genero");
                System.out.println("dni amazon = " + dni);
                if(dni.equals("1090529363")){
                    System.out.println("Entró");
                    Perfil usuario = new Perfil(nombres, apellidos, dni, genero, email, telefono);
                    return usuario;
                }
                System.out.println("No Entró");
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new Perfil();
    }
}