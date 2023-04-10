package com.example.forecastweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class MainActivity extends AppCompatActivity {

    private Button get_owm_forecast;
    private TextView view_forecast;
    private String APIkey_OPW = new String();
    private File file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        file = new File("C:\\Users\\User\\AndroidStudioProjects\\ForecastWeatherApp\\app\\src\\main\\res\\APIkey.txt");
        BufferedReader r = null;
        try {
            r = new BufferedReader(new FileReader(file.getAbsolutePath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String scores = r.readLine();
            APIkey_OPW = r.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //file = new File("C:\\Users\\User\\AndroidStudioProjects\\ForecastWeatherApp\\app\\src\\main\\res\\APIkey.txt");


        try (FileReader reader = new FileReader(new File(getFilesDir(), "com/example/forecastweatherapp/APIkey.txt")))
        {
            char[] chars = new char[(int) file.length()];
            reader.read(chars);

            APIkey_OPW = new String(chars);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
      */

        try(FileReader reader = new FileReader("APIkey.txt"))
        {
            int c;
            while((c=reader.read())!=-1)
            {
                System.out.print((char)c);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(APIkey_OPW);



        OkHttpClient client = new OkHttpClient();
        Request request = new Request
                .Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?q=Budënnovsk&lang=ru&units=metric&appid=" + APIkey_OPW)
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }


        get_owm_forecast = findViewById(R.id.get_owm_forecast);
        view_forecast = findViewById(R.id.view_forecast);

        get_owm_forecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }
}