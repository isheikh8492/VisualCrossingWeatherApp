package com.imaduddinsheikh.visualcrossingweatherapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private WeatherDaysAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private boolean fahrenheit = true;
    private TextView currentDateTimeTxtView;
    private TextView currentTempTxtView;
    private TextView currentFeelsLikeTxtView;
    private TextView currentCloudConditionsTxtView;
    private TextView currentWindConditionsTxtView;
    private TextView currentHumidityTxtView;
    private TextView currentUvIndexTxtView;
    private TextView currentVisibilityTxtView;
    private ImageView currentIconImgView;

    private TextView morningDayTempTxtView;

    private TextView afternoonDayTempTxtView;

    private TextView eveningDayTempTxtView;

    private TextView nightDayTempTxtView;

    private TextView sunriseTxtView;

    private TextView sunsetTxtView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Weather Application");
        setContentView(R.layout.activity_main);
        currentDateTimeTxtView = findViewById(R.id.currentDateTimeTxtView);
        currentTempTxtView = findViewById(R.id.tempTxtView);
        currentFeelsLikeTxtView = findViewById(R.id.feelsLikeTxtView);
        currentCloudConditionsTxtView = findViewById(R.id.cloudDescTextView);
        currentWindConditionsTxtView= findViewById(R.id.windSpeedDirectionTextView);
        currentHumidityTxtView = findViewById(R.id.humidityTxtView);
        currentUvIndexTxtView = findViewById(R.id.UVTxtView);
        currentVisibilityTxtView = findViewById(R.id.visibilityTxtView);
        currentIconImgView = findViewById(R.id.iconImgView);
        morningDayTempTxtView = findViewById(R.id.morningTempTxtView);
        afternoonDayTempTxtView = findViewById(R.id.afternoonTempTxtView);
        eveningDayTempTxtView = findViewById(R.id.eveningTempTxtView);
        nightDayTempTxtView = findViewById(R.id.nightTempTxtView);
        sunriseTxtView = findViewById(R.id.sunriseTxtView);
        sunsetTxtView = findViewById(R.id.sunsetTxtView);
        recyclerView = findViewById(R.id.WeatherDayRecyclerView);

        doDownload();
    }

    public void updateData(Weather weather) {
        if (weather == null) {
            String noInternet = "No Internet Connection";
            currentDateTimeTxtView.setText(noInternet);
            return;
        }
        Log.d(TAG, "updateData: " + weather);
        setTitle(weather.getCurrentLocation());
        currentDateTimeTxtView.setText(weather.getCurrentDateTime());
        currentTempTxtView.setText(weather.getCurrentTemp());
        currentFeelsLikeTxtView.setText(weather.getCurrentFeelsLike());
        String currentCloudConditions = weather.getCurrentConditions() + weather.getCurrentCloudCover();
        currentCloudConditionsTxtView.setText(currentCloudConditions);
        String currentWindConditions = weather.getCurrentWindDir() + weather.getCurrentWindSpeed() + weather.getCurrentWindGust();
        currentWindConditionsTxtView.setText(currentWindConditions);
        currentHumidityTxtView.setText(weather.getCurrentHumidity());
        currentUvIndexTxtView.setText(weather.getCurrentUvIndex());
        currentVisibilityTxtView.setText(weather.getCurrentVisibility());
        currentIconImgView.setImageBitmap(weather.getCurrentIcon());
        morningDayTempTxtView.setText(weather.getMorningDayTemp());
        afternoonDayTempTxtView.setText(weather.getAfternoonDayTemp());
        eveningDayTempTxtView.setText(weather.getEveningDayTemp());
        nightDayTempTxtView.setText(weather.getNightDayTemp());
        sunriseTxtView.setText(weather.getCurrentSunrise());
        sunsetTxtView.setText(weather.getCurrentSunset());

        adapter = new WeatherDaysAdapter(weather.getWeatherDayList(), this);
        recyclerView.setAdapter(adapter);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private void doDownload() {
        WeatherDownloader.downloadWeather(this, fahrenheit);
    }

    @Override
    public void onClick(View v) {

    }
}