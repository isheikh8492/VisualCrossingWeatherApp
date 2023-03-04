package com.imaduddinsheikh.visualcrossingweatherapp;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

public class WeatherDay {
    private final String dayName;
    private final String dayHour;
    private final Bitmap dayIcon;
    private final String dayTemp;
    private final String dayCloudCondition;

    WeatherDay(String dayName, String dayHour, Bitmap dayIcon, String dayTemp, String dayCloudCondition) {
        this.dayName = dayName;
        this.dayHour = dayHour;
        this.dayIcon = dayIcon;
        this.dayTemp = dayTemp;
        this.dayCloudCondition = dayCloudCondition;
    }

    public String getDayName() {
        return dayName;
    }

    public String getDayHour() {
        return dayHour;
    }

    public Bitmap getDayIcon() {
        return dayIcon;
    }

    public String getDayTemp() {
        return dayTemp;
    }

    public String getDayCloudCondition() {
        return dayCloudCondition;
    }

    @NonNull
    @Override
    public String toString() {
        return "WeatherDay{" +
                "dayName='" + dayName + '\'' +
                ", dayHour=" + dayHour +
                ", dayIcon=" + dayIcon +
                ", dayTemp='" + dayTemp + '\'' +
                ", dayCloudCondition='" + dayCloudCondition + '\'' +
                '}';
    }
}
