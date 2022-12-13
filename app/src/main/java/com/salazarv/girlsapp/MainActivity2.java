package com.salazarv.girlsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.salazarv.girlsapp.databinding.ActivityMain2Binding;
import com.salazarv.girlsapp.fragment.ConfiguracionFragment;
import com.salazarv.girlsapp.fragment.InicioFragment;
import com.salazarv.girlsapp.fragment.PerfilFragment;

public class MainActivity2 extends AppCompatActivity {
    
    
    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        reemplazarFragment(new InicioFragment());
        
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.menu_inicio:
                    reemplazarFragment(new InicioFragment());
                    break;
                case R.id.menu_perfil:
                    reemplazarFragment(new PerfilFragment());
                    break;
                case R.id.menu_configuracion:
                    reemplazarFragment(new ConfiguracionFragment());
                    break;
            }

            return true;
        });
        
    }

    private void reemplazarFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenerdor_fragment, fragment);
        fragmentTransaction.commit();

    }
}