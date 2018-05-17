package com.example.ady.magicweather.Data.Remote;

import com.example.ady.magicweather.Util.pojo.WeatherPojo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ady on 5/12/2018.
 */

public interface WeatherService {
    @GET("/data/2.5/weather?&APPID=646ca407655026b348b710aad5378f2b&units=imperial")
    Observable<WeatherPojo> getWeatherData(@Query("q") String location);



}
