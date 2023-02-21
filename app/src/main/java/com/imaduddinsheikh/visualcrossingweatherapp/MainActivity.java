package com.imaduddinsheikh.visualcrossingweatherapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Weather Application");
        setContentView(R.layout.activity_main);
    }
}