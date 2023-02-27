package com.imaduddinsheikh.visualcrossingweatherapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private boolean fahrenheit = true;

    private TextView dateTimeTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Weather Application");
        setContentView(R.layout.activity_main);
        dateTimeTxtView = findViewById(R.id.dateTimeTxtView);

        doDownload();
    }

    public void updateData(Weather weather) {
        if (weather == null) {
            String noInternet = "No Internet Connection";
            dateTimeTxtView.setText(noInternet);
            return;
        }
        Log.d(TAG, "updateData: " + weather.getDateTime());
        dateTimeTxtView.setText(weather.getDateTime());

    }

    private void doDownload() {
        WeatherDownloader.downloadWeather(this, fahrenheit);
    }
}