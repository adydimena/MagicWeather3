package com.example.ady.magicweather.DI.Main;

import com.example.ady.magicweather.Data.Remote.WeatherDataSource;
import com.example.ady.magicweather.View.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ady on 5/12/2018.
 */

@Module
public class MainModule {
    @Provides
    MainPresenter providesMainPresenter (WeatherDataSource weatherDataSource){
        return new MainPresenter(weatherDataSource);
    }
}
