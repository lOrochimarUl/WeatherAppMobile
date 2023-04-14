package com.example.forecastweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import jsonparsing.GsonParser;
import current_weather.Root;
import current_weather.Sys;

public class MainActivity extends AppCompatActivity {

    private Button get_owm_forecast;
    private TextView view_forecast;
    private String APIkey_OPW = new String();
    private File file;
    private String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get APIkey
        file = new File(getFilesDir(), "APIkey.txt");
        try (FileReader reader = new FileReader(file))
        {
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            APIkey_OPW = new String(chars);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //Thread description where I send a request and get JSON-response
        Runnable runnable = new Runnable() {
            @Override
            public void run() {


                OkHttpClient client = new OkHttpClient();
                Request request = new Request
                        .Builder()
                        .url("https://api.openweathermap.org/data/2.5/weather?q=Budënnovsk&lang=ru&units=metric&appid=" + APIkey_OPW)
                        .build();
                try {
                    response = client.newCall(request).execute().body().string();
                    System.out.println(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);

        //Start thread;
        thread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        GsonParser parser = new GsonParser();
        Root root = parser.parse_current_weather(response);


        get_owm_forecast = findViewById(R.id.get_owm_forecast);
        view_forecast = findViewById(R.id.view_forecast);

        get_owm_forecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view_forecast.setText(response);
            }
        });

    }
}