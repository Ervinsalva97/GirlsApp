package com.salazarv.girlsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class registrar extends AppCompatActivity {


    EditText fec_nac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        fec_nac = findViewById(R.id.txtFecNac);
        fec_nac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarView.generateViewId();
            }
        });

    }
}