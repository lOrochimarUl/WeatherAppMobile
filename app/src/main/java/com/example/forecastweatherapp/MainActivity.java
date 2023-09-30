package com.example.forecastweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;

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

import java.sql.*;

public class MainActivity extends AppCompatActivity {

    private Button save_APIkey;
    private TextView userAPIkey;
    private String APIkey_OPW = new String();
    private File file;
    private String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS info (api_key TEXT)");

        Intent intent = new Intent(this, GetApiActivity.class);
            startActivity(intent);



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

/*
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        GsonParser parser = new GsonParser();
        Root root = parser.parse_current_weather(response);
*/

/*
        save_APIkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    APIkey_OPW = userAPIkey.toString();
                }catch (NullPointerException e){
                    e.printStackTrace();
                }

            }
        });
*/
        Thread thread = new Thread(runnable);

        //Start thread;
        thread.start();


    }
}