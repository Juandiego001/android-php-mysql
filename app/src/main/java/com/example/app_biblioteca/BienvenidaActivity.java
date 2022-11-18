package com.example.app_biblioteca;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BienvenidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        // Se coloca el nombre del usuario
        String nombreUsuario = getIntent().getExtras().getString("nombre");
        ((TextView) findViewById(R.id.textBienvenida2)).setText(String.format("Bienvenid@ %s a Biblioteca Escobar", nombreUsuario));
    }
}
