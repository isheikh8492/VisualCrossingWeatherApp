package com.imaduddinsheikh.visualcrossingweatherapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class WeatherDownloader {

    private static final String TAG = "WeatherDownloadRunnable";

    private static MainActivity mainActivity;
    private static RequestQueue queue;
    private static Weather weatherObj;

    private static final String weatherURL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/chicago";
    private static final String APIKey = "QBW2N54RVWJW3F2J4JJK2CKUH";
    //
    //////////////////////////////////////////////////////////////////////////////////

    public static void downloadWeather(MainActivity mainActivityIn, boolean fahrenheit) {

        mainActivity = mainActivityIn;

        queue = Volley.newRequestQueue(mainActivity);

//        Uri.Builder buildURL = Uri.parse(weatherURL).buildUpon();
//        buildURL.appendQueryParameter("unitGroup", "metric");
//        buildURL.appendQueryParameter("key", APIKey);
//        buildURL.appendQueryParameter("contentType", "json");
//        String urlToUse = buildURL.build().toString();

        String urlToUse = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/chicago?unitGroup=metric&key=QBW2N54RVWJW3F2J4JJK2CKUH&contentType=json";

        Response.Listener<JSONObject> listener =
                response -> parseJSON(response.toString());

        Response.ErrorListener error =
                error1 -> mainActivity.updateData(null);

        // Request a string response from the provided URL.
        JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.GET, urlToUse,
                        null, listener, error);

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);
    }

    private static void parseJSON(String s) {
        Log.d(TAG, "parseJSON:\n" + s);
        try {
            JSONObject jObjMain = new JSONObject(s);

            // "currentLocation" section
            String location = jObjMain.getString("resolvedAddress");
            String jCurrentLocation = location.substring(0, location.lastIndexOf(","));

            // "currentDateTime" section
            long dt = jObjMain.getJSONObject("currentConditions").getLong("datetimeEpoch");
            Date dateTime = new Date(dt * 1000); // Java time values need milliseconds
            SimpleDateFormat fullDate =
                    new SimpleDateFormat("EEE MMM dd h:mm a, yyyy", Locale.getDefault());
            String jCurrentDateTime = fullDate.format(dateTime);


            // "currentTemp" section
            String temp = jObjMain.getJSONObject("currentConditions").getString("temp");
            String jCurrentTemp = Math.round(Double.parseDouble(temp)) + "\u00B0C";

            // "currentFeelsLike" section
            String feelsLike = jObjMain.getJSONObject("currentConditions").getString("feelslike");
            String jCurrentFeelsLike = "Feels Like " + Math.round(Double.parseDouble(feelsLike)) + "\u00B0C";

            // "currentHumidity" section
            String humidity = jObjMain.getJSONObject("currentConditions").getString("humidity");
            String jCurrentHumidity = "Humidity: " + humidity + "%";

            // "currentUvIndex" section
            String uvIndex = jObjMain.getJSONObject("currentConditions").getString("uvindex");
            String jCurrentUvIndex = "UV Index: " + uvIndex;

            // "currentConditions" section
            String jCurrentConditions = jObjMain.getJSONObject("currentConditions").getString("conditions");

            // "currentCloudCover" section
            String cloudCover = jObjMain.getJSONObject("currentConditions").getString("cloudcover");
            String jCurrentCloudCover = " (" + cloudCover + "% clouds) ";

            // "currentWindDir" section
            String windDir = jObjMain.getJSONObject("currentConditions").getString("winddir");
            String jCurrentWindDir = "Winds: " + getDirection(Double.parseDouble(windDir)) + " at ";

            // "currentWindSpeed" section
            String winddir = jObjMain.getJSONObject("currentConditions").getString("windspeed");
            String jCurrentWindSpeed = Math.round(Double.parseDouble(winddir)) + " mph ";

            // "currentWindGust" section
            String windgust = jObjMain.getJSONObject("currentConditions").getString("windgust");
            String jCurrentWindGust = "";
            if (!windgust.equals("null")) {
                jCurrentWindGust = "gusting to " + Math.round(Double.parseDouble(windgust)) + " mph";
            }

            // "currentVisibility" section
            String visibility = jObjMain.getJSONObject("currentConditions").getString("visibility");
            String jCurrentVisibility = "Visibility: " + visibility + " km";

            // "currentSunrise" section
            long dtSunrise = jObjMain.getJSONObject("currentConditions").getLong("sunriseEpoch");
            Date dateTimeSunrise = new Date(dtSunrise * 1000); // Java time values need milliseconds
            SimpleDateFormat timeOnly =
                    new SimpleDateFormat("h:mm a", Locale.getDefault());
            String jCurrentSunrise = "Sunrise: " + timeOnly.format(dateTimeSunrise);

            // "currentSunset" section
            long dtSunset = jObjMain.getJSONObject("currentConditions").getLong("sunsetEpoch");
            Date dateTimeSunset = new Date(dtSunset * 1000); // Java time values need milliseconds
            String jCurrentSunset = "Sunset: " + timeOnly.format(dateTimeSunset);

            // "currentIcon" section
            String icon = jObjMain.getJSONObject("currentConditions").getString("icon");

            // "morningDayTemp" section
            String morningDayTemp = jObjMain.getJSONArray("days").getJSONObject(0).getJSONArray("hours")
                    .getJSONObject(8).getString("temp");
            String jMorningDayTemp = Math.round(Double.parseDouble(morningDayTemp)) + "\u00B0C";

            // "afternoonDayTemp" section
            String afternoonDayTemp = jObjMain.getJSONArray("days").getJSONObject(0).getJSONArray("hours")
                    .getJSONObject(13).getString("temp");
            String jAfternoonDayTemp = Math.round(Double.parseDouble(afternoonDayTemp)) + "\u00B0C";

            // "eveningDayTemp" section
            String eveningDayTemp = jObjMain.getJSONArray("days").getJSONObject(0).getJSONArray("hours")
                    .getJSONObject(17).getString("temp");
            String jEveningDayTemp = Math.round(Double.parseDouble(eveningDayTemp)) + "\u00B0C";

            // "nightDayTemp" section
            String nightDayTemp = jObjMain.getJSONArray("days").getJSONObject(0).getJSONArray("hours")
                    .getJSONObject(23).getString("temp");
            String jNightDayTemp = Math.round(Double.parseDouble(nightDayTemp)) + "\u00B0C";

            // "48 Hour RecyclerView" section
            List<WeatherDay> jWeatherDayList = new ArrayList<>();
            JSONArray jsonArray = jObjMain.getJSONArray("days");
            SimpleDateFormat logTime = new SimpleDateFormat("EEEE h:mm a", Locale.getDefault());
            Log.d(TAG, "parseJSON: " + logTime.format(jsonArray.getJSONObject(13).getJSONArray("hours").getJSONObject(20).getLong("datetimeEpoch")));
            Log.d(TAG, "parseJSON: LENGTH OF JSONArray " + logTime.format(dt));
            int count = 0;
            for (int i = 0; i < jsonArray.length(); i++) {
                for (int j = 0;j < jsonArray.getJSONObject(i).getJSONArray("hours").length();j++) {
                    long dtToCompare = jsonArray.getJSONObject(i).getJSONArray("hours").getJSONObject(j).getLong("datetimeEpoch");
                    Date dateTimeToCompare = new Date(dtToCompare * 1000);
                    if (dtToCompare >= dt && count < 48) {
                        Log.d(TAG, "parseJSON: " + logTime.format(dateTimeToCompare));

                        String weatherDayName = "Today";
                        SimpleDateFormat dayOnly = new SimpleDateFormat("EEEE", Locale.getDefault());
                        if (!dayOnly.format(dateTimeToCompare).equals(dayOnly.format(dateTime))) {
                            weatherDayName = dayOnly.format(dateTimeToCompare);
                        }
                        String weatherDayTime = timeOnly.format(dateTimeToCompare);
                        String iconOnly = jsonArray.getJSONObject(i).getJSONArray("hours").getJSONObject(j).getString("icon");
                        Bitmap weatherDayIcon = getweatherDayIcon(iconOnly);
                        String tempOnly = jsonArray.getJSONObject(i).getJSONArray("hours").getJSONObject(j).getString("temp");
                        String weatherDayTemp = String.valueOf(Math.round(Double.parseDouble(tempOnly)));
                        String weatherDayConditions = jsonArray.getJSONObject(i).getJSONArray("hours").getJSONObject(j).getString("conditions");
                        WeatherDay weatherDay = new WeatherDay(weatherDayName, weatherDayTime, weatherDayIcon, weatherDayTemp, weatherDayConditions);
                        jWeatherDayList.add(weatherDay);
                        count++;
                    }
                }
            }


            weatherObj = new Weather(jCurrentLocation, jCurrentDateTime, jCurrentTemp, jCurrentFeelsLike, jCurrentHumidity, jCurrentUvIndex, jCurrentConditions, jCurrentCloudCover, jCurrentWindDir, jCurrentWindSpeed, jCurrentWindGust, jCurrentVisibility, jCurrentSunrise, jCurrentSunset, jMorningDayTemp, jAfternoonDayTemp, jEveningDayTemp, jNightDayTemp, jWeatherDayList);
            getIcon(icon);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getDirection(double degrees) {
        if (degrees >= 337.5 || degrees < 22.5)
            return "N";
        if (degrees >= 22.5 && degrees < 67.5)
            return "NE";
        if (degrees >= 67.5 && degrees < 112.5)
            return "E";
        if (degrees >= 112.5 && degrees < 157.5)
            return "SE";
        if (degrees >= 157.5 && degrees < 202.5)
            return "S";
        if (degrees >= 202.5 && degrees < 247.5)
            return "SW";
        if (degrees >= 247.5 && degrees < 292.5)
            return "W";
        if (degrees >= 292.5)
            return "NW";
        return "X";
    }

    private static void getIcon(String icon) {
        icon = icon.replace("-", "_");
        int resourceId = mainActivity.getResources().getIdentifier(icon, "drawable", mainActivity.getPackageName());
        Bitmap currentIcon = BitmapFactory.decodeResource(mainActivity.getResources(), resourceId);
        weatherObj.setCurrentIcon(currentIcon);
        mainActivity.updateData(weatherObj);
    }

    private static Bitmap getweatherDayIcon(String icon) {
        icon = icon.replace("-", "_");
        int resourceId = mainActivity.getResources().getIdentifier(icon, "drawable", mainActivity.getPackageName());
        return BitmapFactory.decodeResource(mainActivity.getResources(), resourceId);
    }
}
