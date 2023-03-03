package com.imaduddinsheikh.visualcrossingweatherapp;

import android.graphics.Bitmap;

public class Weather {

    private final String currentLocation;
    private final String currentDateTime;
    private final String currentTemp;
    private final String currentFeelsLike;
    private final String currentHumidity;

    private final String currentUvIndex;

    private final String currentConditions;

    private final String currentCloudCover;

    private final String currentWindDir;

    private final String currentWindSpeed;

    private final String currentWindGust;

    private final String currentVisibility;

    private final Long currentSunrise;

    private final Long currentSunset;

    private final String morningDayTemp;

    private final String afternoonDayTemp;

    private final String eveningDayTemp;

    private final String nightDayTemp;

    private Bitmap currentIcon;




    public Weather(String currentLocation, String currentDateTime, String currentTemp, String currentFeelsLike, String currentHumidity, String currentUvIndex, String currentConditions, String currentCloudCover, String currentWindDir, String currentWindSpeed, String currentWindGust, String currentVisibility, Long currentSunrise, Long currentSunset, String morningDayTemp, String afternoonDayTemp, String eveningDayTemp, String nightDayTemp) {
        this.currentLocation = currentLocation;
        this.currentDateTime = currentDateTime;
        this.currentTemp = currentTemp;
        this.currentFeelsLike = currentFeelsLike;
        this.currentHumidity = currentHumidity;
        this.currentUvIndex = currentUvIndex;
        this.currentConditions = currentConditions;
        this.currentCloudCover = currentCloudCover;
        this.currentWindDir = currentWindDir;
        this.currentWindSpeed = currentWindSpeed;
        this.currentWindGust = currentWindGust;
        this.currentVisibility = currentVisibility;
        this.currentSunrise = currentSunrise;
        this.currentSunset = currentSunset;
        this.morningDayTemp = morningDayTemp;
        this.afternoonDayTemp = afternoonDayTemp;
        this.eveningDayTemp = eveningDayTemp;
        this.nightDayTemp = nightDayTemp;
    }

    String getCurrentLocation() { return this.currentLocation;}
    String getCurrentDateTime() {
        return this.currentDateTime;
    }

    String getCurrentHumidity() { return this.currentHumidity;}


    public String getCurrentTemp() {
        return this.currentTemp;
    }

    public String getCurrentFeelsLike() {
        return this.currentFeelsLike;
    }

    public String getCurrentUvIndex() {
        return this.currentUvIndex;
    }

    public String getCurrentConditions() {
        return this.currentConditions;
    }

    public String getCurrentCloudCover() {
        return this.currentCloudCover;
    }

    public String getCurrentWindDir() {
        return this.currentWindDir;
    }

    public String getCurrentWindSpeed() {
        return this.currentWindSpeed;
    }

    public String getCurrentWindGust() {
        return this.currentWindGust;
    }

    public String getCurrentVisibility() {
        return this.currentVisibility;
    }

    public Long getCurrentSunrise() {
        return this.currentSunrise;
    }

    public Long getCurrentSunset() {
        return this.currentSunset;
    }

    public String getMorningDayTemp() {
        return this.morningDayTemp;
    }

    public String getAfternoonDayTemp() {
        return this.afternoonDayTemp;
    }

    public String getEveningDayTemp() {
        return this.eveningDayTemp;
    }

    public String getNightDayTemp() {
        return this.nightDayTemp;
    }

    Bitmap getCurrentIcon() { return this.currentIcon; }

    public void setCurrentIcon(Bitmap currentIcon) {
        this.currentIcon = currentIcon;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "currentLocation='" + currentLocation + '\'' +
                ", currentDateTime='" + currentDateTime + '\'' +
                ", currentTemp='" + currentTemp + '\'' +
                ", currentFeelsLike='" + currentFeelsLike + '\'' +
                ", currentHumidity='" + currentHumidity + '\'' +
                ", currentUvIndex='" + currentUvIndex + '\'' +
                ", currentConditions='" + currentConditions + '\'' +
                ", currentCloudCover='" + currentCloudCover + '\'' +
                ", currentWindDir='" + currentWindDir + '\'' +
                ", currentWindSpeed='" + currentWindSpeed + '\'' +
                ", currentWindGust='" + currentWindGust + '\'' +
                ", currentVisibility='" + currentVisibility + '\'' +
                ", currentSunrise=" + currentSunrise +
                ", currentSunset=" + currentSunset +
                ", morningDayTemp='" + morningDayTemp + '\'' +
                ", afternoonDayTemp='" + afternoonDayTemp + '\'' +
                ", eveningDayTemp='" + eveningDayTemp + '\'' +
                ", nightDayTemp='" + nightDayTemp + '\'' +
                ", currentIcon=" + currentIcon +
                '}';
    }
}
