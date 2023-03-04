package com.imaduddinsheikh.visualcrossingweatherapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeatherDaysAdapter extends RecyclerView.Adapter<WeatherDaysViewHolder> {

    private static final String TAG = "DaysWeatherAdapter";

    private final List<WeatherDay> weatherDayList;

    private final MainActivity mainActivity;

    public WeatherDaysAdapter(List<WeatherDay> weatherDayList, MainActivity mainActivity) {
        this.weatherDayList = weatherDayList;
        this.mainActivity = mainActivity;
    }


    @NonNull
    @Override
    public WeatherDaysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: MAKING NEW WeatherDaysViewHolder");

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weatherday_list_column, parent, false);

        itemView.setOnClickListener(mainActivity);
        itemView.setOnClickListener(mainActivity);

        return new WeatherDaysViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherDaysViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: FILLING VIEW HOLDER WeatherDay " + position);

        WeatherDay weatherDay = weatherDayList.get(position);

        holder.dayName.setText(weatherDay.getDayName());
        holder.dayTime.setText(weatherDay.getDayHour());
        holder.dayIcon.setImageBitmap(weatherDay.getDayIcon());
        holder.dayTemp.setText(weatherDay.getDayTemp() + "\u00B0C");
        holder.dayCloudCondition.setText(weatherDay.getDayCloudCondition());

    }

    @Override
    public int getItemCount() {
        return weatherDayList.size();
    }
}
