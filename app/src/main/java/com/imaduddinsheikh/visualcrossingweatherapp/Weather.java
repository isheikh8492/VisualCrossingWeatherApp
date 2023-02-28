package com.imaduddinsheikh.visualcrossingweatherapp;

public class Weather {

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




    public Weather(String currentDateTime, String currentTemp, String currentFeelsLike, String currentHumidity, String currentUvIndex, String currentConditions, String currentCloudCover, String currentWindDir, String currentWindSpeed, String currentWindGust, String currentVisibility, Long currentSunrise, Long currentSunset) {
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
    }

    String getCurrentDateTime() {
        return this.currentDateTime;
    }

    String getCurrentHumidity() { return this.currentHumidity;}


    public String getCurrentTemp() {
        return currentTemp;
    }

    public String getCurrentFeelsLike() {
        return currentFeelsLike;
    }

    public String getCurrentUvIndex() {
        return currentUvIndex;
    }

    public String getCurrentConditions() {
        return currentConditions;
    }

    public String getCurrentCloudCover() {
        return currentCloudCover;
    }

    public String getCurrentWindDir() {
        return currentWindDir;
    }

    public String getCurrentWindSpeed() {
        return currentWindSpeed;
    }

    public String getCurrentWindGust() {
        return currentWindGust;
    }

    public String getCurrentVisibility() {
        return currentVisibility;
    }

    public Long getCurrentSunrise() {
        return currentSunrise;
    }

    public Long getCurrentSunset() {
        return currentSunset;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "currentDateTime='" + currentDateTime + '\'' +
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
                '}';
    }
}
