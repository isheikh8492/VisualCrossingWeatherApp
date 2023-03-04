package com.imaduddinsheikh.visualcrossingweatherapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WeatherDaysViewHolder extends RecyclerView.ViewHolder {
    TextView dayName;
    TextView dayTime;
    ImageView dayIcon;
    TextView dayTemp;
    TextView dayCloudCondition;


    public WeatherDaysViewHolder(@NonNull View view) {
        super(view);
        this.dayName = view.findViewById(R.id.dayNameTxtView);
        this.dayTime = view.findViewById(R.id.dayTimeTxtView);
        this.dayIcon = view.findViewById(R.id.dayIconImgView);
        this.dayTemp = view.findViewById(R.id.dayTempTxtView);
        this.dayCloudCondition = view.findViewById(R.id.dayCloudTxtView);
    }
}
