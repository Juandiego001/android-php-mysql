package com.example.app_biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    String charset = "UTF-8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registrarse () {

    }

    public void iniciarSesion (View v) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    String nombreUsuario = ((EditText) findViewById(R.id.nombreUsuarioMain)).getText().toString();
                    String contrasena = ((EditText) findViewById(R.id.contrasenaMain)).getText().toString();

                    String query = String.format("?nombreUsuario=%s&contrasena=%s",
                            URLEncoder.encode(nombreUsuario, charset),
                            URLEncoder.encode(contrasena, charset));

                    URL url = new URL(String.format("http://172.16.52.25/servidor_biblioteca/iniciarSesion.php/%s", query));
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setRequestProperty("Accept-Charset", charset);
                    urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
                    BufferedReader rd = new BufferedReader(new InputStreamReader(
                            urlConnection.getInputStream()));

                    String line;
                    while ((line = rd.readLine()) != null) {
                        Log.i("data", line);
                    }
                } catch (Exception e) {
                    Log.d("Error on sign up", "Ocurrió un error al intentar iniciar sesión.");
                    Log.d("Error on sign up", e.toString());
                }
            }
        });

        thread.start();
    }
}