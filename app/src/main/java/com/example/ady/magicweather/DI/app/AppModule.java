package com.example.ady.magicweather.DI.app;

import com.example.ady.magicweather.Data.Remote.WeatherDataSource;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ady on 5/12/2018.
 */

@Module
public class AppModule {
    String weatherBaseURL;

    public AppModule(String weatherbaseurl){

        this.weatherBaseURL = weatherbaseurl;
    }
    @Provides
    WeatherDataSource providesWeatherDataSource(){
        return new WeatherDataSource(weatherBaseURL);
    }
}
