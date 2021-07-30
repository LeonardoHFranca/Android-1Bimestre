package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //permite conexão com a internet na linha principal
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
     private void carregarLocalizacao(String ip) throws JSONException {
         Localizacao localizacao = ClienteGeoIP.localizar(ip);
         TextView pais = (TextView)findViewById(R.id.pais);
         pais.setText(localizacao.getCountryName());

    }
    public void btnLocalizarOnClick(View v) throws JSONException {
        EditText txtIP = (EditText) findViewById(R.id.txtIP);
        String ip = txtIP.getText().toString();
        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, 1);
            }
            else { //server para conceder acesso a internet para interação do APP
                carregarLocalizacao(ip);
            }
        } catch (JSONException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show(); 
        }

    }
            public void onRequestPermissionResult(int requestCode, String permissions[], int[]grantResults) {
            switch (requestCode) {
                case 1: {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        EditText txtIP = (EditText) findViewById(R.id.txtIP);
                        String ip = txtIP.getText().toString();
                     try{   carregarLocalizacao(ip);
                    }catch (JSONException e){
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    }else{
                        Toast.makeText(this, "Não vai funcionar!!!", Toast.LENGTH_LONG).show();
                    }
                    return;
                    }
                }
            }
        }
