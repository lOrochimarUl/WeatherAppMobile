package com.example.forecastweatherapp;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class GetApiActivity extends Activity {

    private Button save_APIkey;
    private String APIkey_OPW;
    private TextView userAPIkey;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_api_key);
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        save_APIkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String query = "INSERT OR IGNORE INTO info VALUES " + userAPIkey.toString();
                    db.execSQL(query);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        });



    }
}
