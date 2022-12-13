package com.salazarv.girlsapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.salazarv.girlsapp.MainActivity;


public class ConfiguracionFragment extends Fragment {

    FirebaseAuth mAuth;

    Button btnCs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();


        btnCs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth.signOut();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
    }




}