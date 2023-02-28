package com.imaduddinsheikh.visualcrossingweatherapp;

public class Weather {

    private final String currentDateTime;


    private final String currentTemp;
    private final String currentHumidity;




    public Weather(String currentDateTime, String currentTemp, String currentHumidity) {
        this.currentDateTime = currentDateTime;
        this.currentTemp = currentTemp;
        this.currentHumidity = currentHumidity;
    }

    String getCurrentDateTime() {
        return this.currentDateTime;
    }

    String getCurrentHumidity() { return this.currentHumidity;}


}
