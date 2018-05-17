package com.example.ady.magicweather.Data.Remote;

import com.example.ady.magicweather.Util.pojo.WeatherPojo;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ady on 5/12/2018.
 */

public class WeatherDataSource {
    private static String weatherBaseUrl;

    public WeatherDataSource(String weatherBaseUrl) {
        this.weatherBaseUrl = weatherBaseUrl;
    }
    public static Retrofit create()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(weatherBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
    public static Observable<WeatherPojo> getWeatherdata(String location){
        Retrofit retrofit = create();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        return weatherService.getWeatherData(location);
    }
}
