package com.ufps.ctiam20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ufps.ctiam20.ui.productos.ProductosFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    TextInputEditText email,password;
    Button inicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.clave);
        inicio = findViewById(R.id.botonInicio);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Ingrese una contraseña valida.",
                            Toast.LENGTH_SHORT).show();
                }
                else if (email.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Ingrese un email valido.",
                            Toast.LENGTH_SHORT).show();
                }else {
                iniciar(email.getText().toString(),password.getText().toString());
            }
            }
        });
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }
    private void iniciar(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            Toast.makeText(MainActivity.this, "Inicio de sesion exitoso.",
                                    Toast.LENGTH_SHORT).show();
                         inicioExitoso();
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Email o contraseña incorrecta.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void crearUsuario(View view){
        Intent intent = new Intent (this,RegistroActivity.class);
        startActivity(intent);


    }
    public void olvidoClave(View view){
        Intent intent = new Intent (this,DesTiendaActivity.class);
        startActivity(intent);


    }

    public void inicioExitoso(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}