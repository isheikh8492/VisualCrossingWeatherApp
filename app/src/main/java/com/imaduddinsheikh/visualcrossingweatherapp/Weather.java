package com.imaduddinsheikh.visualcrossingweatherapp;

public class Weather {

    private final String dateTime;

    public Weather(String dateTime) {
        this.dateTime = dateTime;
    }

    String getDateTime() {
        return this.dateTime;
    }
}
