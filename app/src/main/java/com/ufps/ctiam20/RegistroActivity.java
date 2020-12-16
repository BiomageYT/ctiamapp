package com.ufps.ctiam20;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class RegistroActivity extends AppCompatActivity {
    private static final String TAG = "MainActivityy";
    private FirebaseAuth mAuth;
    TextInputEditText nuevoemail,nuevapassword;
    Button registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mAuth = FirebaseAuth.getInstance();
        nuevoemail = findViewById(R.id.nuevoemail);
        nuevapassword = findViewById(R.id.nuevaclave);
        registro = findViewById(R.id.registro);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nuevapassword.getText().toString().equals("")){
                    Toast.makeText(RegistroActivity.this, "Ingrese una contraseña valida.",
                            Toast.LENGTH_SHORT).show();
                }
                else if (nuevoemail.getText().toString().equals("")){
                    Toast.makeText(RegistroActivity.this, "Ingrese un email valido.",
                            Toast.LENGTH_SHORT).show();
                }else {

                crearUsuario(nuevoemail.getText().toString(),nuevapassword.getText().toString());
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
    private void crearUsuario(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(RegistroActivity.this, "Usuario creado correctamente.",
                                    Toast.LENGTH_SHORT).show();
                                registroExitoso();
                            FirebaseUser user = mAuth.getCurrentUser();
                            // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegistroActivity.this, "No se pudo crear el usuario",
                                    Toast.LENGTH_SHORT).show();
                            // updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void inicioSesion(View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);


    }

    public void registroExitoso(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}