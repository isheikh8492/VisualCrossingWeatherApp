package com.imaduddinsheikh.visualcrossingweatherapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private boolean fahrenheit = true;

    private TextView currentDateTimeTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Weather Application");
        setContentView(R.layout.activity_main);
        currentDateTimeTxtView = findViewById(R.id.currentDateTimeTxtView);

        doDownload();
    }

    public void updateData(Weather weather) {
        if (weather == null) {
            String noInternet = "No Internet Connection";
            currentDateTimeTxtView.setText(noInternet);
            return;
        }
        Log.d(TAG, "updateData: " + weather.getCurrentDateTime());
        currentDateTimeTxtView.setText(weather.getCurrentDateTime());

    }

    private void doDownload() {
        WeatherDownloader.downloadWeather(this, fahrenheit);
    }
}