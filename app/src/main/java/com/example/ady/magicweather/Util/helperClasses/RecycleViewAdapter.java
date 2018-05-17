package com.example.ady.magicweather.Util.helperClasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.ady.magicweather.MagicWeather;
import com.example.ady.magicweather.R;
import com.example.ady.magicweather.Util.pojo.WeatherPojo;


import java.util.ArrayList;
import java.util.List;


public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{
    WeatherPojo weatherPojo;
    Context context;
    int size =1;

    String TAG = RecycleViewAdapter.class.getSimpleName();

    public RecycleViewAdapter(WeatherPojo weatherPojo, Context contex) {
        this.weatherPojo = weatherPojo;
        this.context = contex;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclelayout,null);

        return new ViewHolder(view);//this is not used
        //TODO delete this file when done!! not used
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.forecast.setText(weatherPojo.getWeather().get(0).getMain());
        holder.forecastDes.setText(weatherPojo.getWeather().get(0).getDescription());
        holder.setTemp.setText(weatherPojo.getMain().getTemp().toString() + "°");
        Glide.with(context).load(weatherPojo.getWeather().get(0).getIcon()).into(holder.icon);
        holder.windspeed.setText(weatherPojo.getWind().getSpeed().toString() +" m/s");
       holder.cloud.setText(weatherPojo.getClouds().getAll().toString());
        holder.pressure.setText(weatherPojo.getMain().getPressure()+ " hpa");
        holder.huminity.setText(weatherPojo.getMain().getHumidity()+ "%");
        holder.sunrise.setText(weatherPojo.getSys().getSunrise().toString());
    }
    @Override
    public int getItemCount() {

            return size;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView forecast, forecastDes, setTemp, windspeed, cloud, pressure,huminity, sunrise;
        ImageView icon;
        public ViewHolder(View itemView) {
            super(itemView);
            forecast = itemView.findViewById(R.id.forecast);
            forecastDes = itemView.findViewById(R.id.forecastDescription);
            setTemp = itemView.findViewById(R.id.setTemp);
            windspeed = itemView.findViewById(R.id.windSpeedValue);
            cloud = itemView.findViewById(R.id.cloudValue);
            pressure = itemView.findViewById(R.id.presurreValue);
            huminity = itemView.findViewById(R.id.huminityValue);
            sunrise = itemView.findViewById(R.id.sunRiseValue);
            icon = itemView.findViewById(R.id.iconImage);

        }
    }
}