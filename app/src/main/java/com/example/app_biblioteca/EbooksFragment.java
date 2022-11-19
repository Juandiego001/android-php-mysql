package com.example.app_biblioteca;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class EbooksFragment extends Fragment {

    public String charset = "UTF-8";
    public LinearLayout theLayout;
    public String ip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ebooks, container, false);
        // Inflate the layout for this fragment
        theLayout = view.findViewById(R.id.linearFEBooks);
        ip = getResources().getString(R.string.the_ip);
        getLibros();
        return view;
    }

    public void getLibros() {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    String tipo = "ebook";

                    String query = String.format("?tipo=%s",
                            URLEncoder.encode(tipo, charset));

                    URL url = new URL(String.format("http://%s/servidor_biblioteca/obtenerLibros.php/%s", ip, query));
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setRequestProperty("Accept-Charset", charset);
                    urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
                    BufferedReader rd = new BufferedReader(new InputStreamReader(
                            urlConnection.getInputStream()));

                    String line;
                    JSONArray arrayValues = new JSONArray();
                    while ((line = rd.readLine()) != null) {
                        Log.i("Data", line);
                        arrayValues = new JSONObject(line).getJSONArray("data");
                    }

                    final JSONArray finalArray = arrayValues;

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                for (int i = 0; i < finalArray.length(); i++) {
                                    JSONObject libro = finalArray.getJSONObject(i);

                                    TextView txv1 = new TextView(getActivity());
                                    txv1.setText("Nombre: " + libro.getString("nombre"));
                                    txv1.setTextSize(16);

                                    TextView txv2 = new TextView(getActivity());
                                    txv2.setText("Autor: " + libro.getString("autor"));
                                    txv2.setTextSize(16);

                                    TextView txv3 = new TextView(getActivity());
                                    txv3.setText("Resumen: " + libro.getString("resumen"));
                                    txv3.setTextSize(12);

                                    TextView txvBlank1 = new TextView(getActivity());
                                    TextView txvBlank2 = new TextView(getActivity());

                                    theLayout.addView(txvBlank1);
                                    theLayout.addView(txv1);
                                    theLayout.addView(txv2);
                                    theLayout.addView(txv3);
                                    theLayout.addView(txvBlank2);
                                }
                            } catch (Exception e) {
                                Log.i("Error MainThread", e.toString());
                            }
                        }
                    });
                }
                catch (Exception e) {
                    Log.d("EbooksFragment", "Ocurrió un error al intentar obtener los libros infantiles.");
                    Log.d("EbooksFragment", e.toString());
                }
            }
        });

        if (thread.isAlive()) {
            thread.interrupt();
            thread.start();
        } else {
            thread.start();
        }
    }
}