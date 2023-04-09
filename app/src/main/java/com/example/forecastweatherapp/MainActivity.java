package com.example.forecastweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import com.loopj.android.http.*;

public class MainActivity extends AppCompatActivity {

    private Button get_owm_forecast;
    private TextView view_forecast;
    private String APIkey_OPW = new String();
    private File file;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        get_owm_forecast = findViewById(R.id.get_owm_forecast);
        view_forecast = findViewById(R.id.view_forecast);

        get_owm_forecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }
}