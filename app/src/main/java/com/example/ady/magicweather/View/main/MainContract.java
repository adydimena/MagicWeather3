package com.example.ady.magicweather.View.main;

import com.example.ady.magicweather.Util.pojo.WeatherPojo;
import com.example.ady.magicweather.Util.view.BasePresenter;
import com.example.ady.magicweather.Util.view.BaseView;

/**
 * Created by Ady on 5/12/2018.
 */

public interface MainContract {
    interface View extends BaseView{
        void setWeatherdata(WeatherPojo weatherPojo);
        void setError(String message);

    }
    interface Presenter extends BasePresenter<View> {
        void getWeatherData(String location);
    }
}
