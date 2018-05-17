package com.example.ady.magicweather.View.main;

import android.util.Log;

import com.example.ady.magicweather.Data.Remote.WeatherDataSource;
import com.example.ady.magicweather.Util.pojo.WeatherPojo;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ady on 5/12/2018.
 */

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;
    WeatherDataSource weatherDataSource;
    WeatherPojo dummyPojo;
    public static final String TAG = MainPresenter.class.getSimpleName();

    @Inject
    public MainPresenter(WeatherDataSource weatherDataSource){
        this.weatherDataSource = weatherDataSource;

    }
    public MainPresenter(){
        // empty
    }
    @Override
    public void attachView(MainContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }

    @Override
    public void getWeatherData(String location) {
        Log.d(TAG, "getWeatherData: ");
        WeatherDataSource.getWeatherdata(location)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<WeatherPojo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeatherPojo weatherPojo) {
                        dummyPojo = weatherPojo;
                        Log.d(TAG, "onNext: ");

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+ e.getMessage());
                        view.setError(e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        view.setWeatherdata(dummyPojo);

                    }
                });
    }
}
