package com.salazarv.girlsapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText txtcorreo, txtpass;
    Button btn_Registrar, btn_Is;

    // Componente de firebase
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciamos el componente de firebase Autentification
        mAuth = FirebaseAuth.getInstance();

        txtcorreo = findViewById(R.id.txtcorreo);
        txtpass = findViewById(R.id.txtpass);
        btn_Is = findViewById(R.id.btnIs);
        btn_Registrar = findViewById(R.id.btnRegistrar);

        //Evento onClic al boton btn_ingresar
        btn_Is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSesion();
            }
        });


        observador();

        btn_Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,registrar.class));

            }
        });
    }

    private void iniciarSesion() {

        String email = txtcorreo.getText().toString().trim();
        String clave = txtpass.getText().toString().trim();

//        Validamos que el campo email no esté vacio
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Ingrese su correo electrónico", Toast.LENGTH_SHORT).show();
            return;
        }

//        Validamos que el campo password no esté vacio
        if (TextUtils.isEmpty(clave)) {
            Toast.makeText(this, "Ingrese su contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

//          Mostramos un progressDialog para esperar la confirmación de Firebase
//        ProgressDialog dialog = new ProgressDialog(this);
//        dialog.setTitle("Autentificando");
//        dialog.setMessage("Espere por Favor...");
//        dialog.setCancelable(false);
//        dialog.show();

//          Autenticación al usuario si se encuentra registrado en Firebase en firebase (Autentication)
        mAuth.signInWithEmailAndPassword(email, clave).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    finish();
                    startActivity(new Intent(MainActivity.this, MainActivity2.class));
//                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, "Si se ha logeado correctamente", Toast.LENGTH_SHORT).show();
                } else {
//                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, "Usuario y/o contrasñea incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    private void observador() {
        mAuthStateListener = firebaseAuth -> {
            FirebaseUser usuario = firebaseAuth.getCurrentUser();
            if (usuario == null){
                Toast.makeText(this,"No hay sesion activa", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"las ession esta activa", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
                finish();
            }
        };
    }

    @Override
    protected void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onStop(){
        super.onStop();
        if (mAuthStateListener != null){
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

}