package com.imaduddinsheikh.visualcrossingweatherapp;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
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


            // "dt" section
            long dt = jObjMain.getJSONObject("currentConditions").getLong("datetimeEpoch");
            Date dateTime = new Date(dt * 1000); // Java time values need milliseconds
            SimpleDateFormat fullDate =
                    new SimpleDateFormat("EEE MMM dd h:mm a, yyyy", Locale.getDefault());
            String date = fullDate.format(dateTime);


            String humidity ="0";
            String currentTemp = "0";
            weatherObj = new Weather(date, currentTemp, humidity);
            mainActivity.updateData(weatherObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
