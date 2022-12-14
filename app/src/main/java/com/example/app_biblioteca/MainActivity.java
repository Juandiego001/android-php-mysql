package com.example.app_biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    String charset = "UTF-8";
    String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ip = getResources().getString(R.string.the_ip);
        setContentView(R.layout.activity_main);
    }

    /*
    public void registrarse () {

    }
    */

    public void iniciarSesion (View v) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    String usuario = ((EditText) findViewById(R.id.usuarioMain)).getText().toString();
                    String contrasena = ((EditText) findViewById(R.id.contrasenaMain)).getText().toString();

                    String query = String.format("?usuario=%s&contrasena=%s",
                            URLEncoder.encode(usuario, charset),
                            URLEncoder.encode(contrasena, charset));

                    URL url = new URL(String.format("http://%s/servidor_biblioteca/iniciarSesion.php/%s", ip, query));
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setRequestProperty("Accept-Charset", charset);
                    urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
                    BufferedReader rd = new BufferedReader(new InputStreamReader(
                            urlConnection.getInputStream()));

                    String line;
                    while ((line = rd.readLine()) != null) {
                        Log.i("Data", line);
                        JSONObject jsonValue = new JSONObject(line);
                        String nombre = jsonValue.getString("nombre");

                        if (line.equalsIgnoreCase("false")) {
                            MainActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    Toast toast = Toast.makeText(MainActivity.this, "Error al intentar iniciar sesi??n", Toast.LENGTH_LONG);
                                    toast.show();
                                }
                            });
                        } else {
                            MainActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    Toast toast = Toast.makeText(MainActivity.this, "??Inicio de sesi??n exitoso!", Toast.LENGTH_LONG);
                                    toast.show();
                                    Intent intent = new Intent(MainActivity.this, MenuSlideActivity.class);
                                    intent.putExtra("usuario", usuario);
                                    intent.putExtra("nombre", nombre);
                                    startActivity(intent);
                                }
                            });
                        }
                    }
                } catch (Exception e) {
                    Log.d("Error on sign up", "Ocurri?? un error al intentar iniciar sesi??n.");
                    Log.d("Error on sign up", e.toString());
                }
            }
        });

        if (thread.isAlive()) {
            thread.interrupt();
        } else {
            thread.start();
        }
    }
}