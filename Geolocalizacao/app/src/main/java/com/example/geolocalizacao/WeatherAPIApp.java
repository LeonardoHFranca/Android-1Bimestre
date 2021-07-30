package com.example.geolocalizacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class WeatherAPIApp extends AppCompatActivity {

    Button btn_cityID, btn_getWeadtherByID, btn_getWeadtherByName;
    EditText et_dataInput;
    ListView lv_weatherReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_a_p_i_app);
        IniciarComponentes();

        btn_getWeadtherByID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WeatherAPIApp.this, "You clicked me 1", Toast.LENGTH_SHORT);
            }
        });

        btn_getWeadtherByID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(WeatherAPIApp.this, "You clicked me 2", Toast.LENGTH_SHORT);
            }
        });

        btn_getWeadtherByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WeatherAPIApp.this, "You typed" + et_dataInput.getText().toString(), Toast.LENGTH_SHORT);
            }
        });
    }

    private void IniciarComponentes(){
        btn_cityID = findViewById(R.id.btn_getCityID);
        btn_getWeadtherByID = findViewById(R.id.btn_getWeatherByCityID);
        btn_getWeadtherByName = findViewById(R.id.btn_getWeatherByCityName);
    }
}