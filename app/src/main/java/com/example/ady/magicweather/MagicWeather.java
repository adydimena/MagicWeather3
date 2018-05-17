package com.example.ady.magicweather;

import android.app.Application;
import android.content.Context;

import com.example.ady.magicweather.DI.Main.MainComponet;
import com.example.ady.magicweather.DI.Main.MainModule;
import com.example.ady.magicweather.DI.app.AppComponent;
import com.example.ady.magicweather.DI.app.AppModule;
import com.example.ady.magicweather.DI.app.DaggerAppComponent;

/**
 * Created by Ady on 5/12/2018.
 */

public class MagicWeather extends Application {
private static final String weatherBaseUrl= "https://api.openweathermap.org";
private AppComponent appComponent;
private MainComponet mainComponet;

    @Override
    public void onCreate() {
        super.onCreate();
        AppModule appModule = new AppModule(weatherBaseUrl);
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();
    }
    public static MagicWeather get(Context context){
        return (MagicWeather) context.getApplicationContext();
    }
    public MainComponet getMainComponet(){
        mainComponet = appComponent.add(new MainModule());
        return mainComponet;
    }
    public void ClearmainComponent(){
        mainComponet =  null;
    }

}
