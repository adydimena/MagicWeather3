package com.example.ady.magicweather.Util.view;

/**
 * Created by Ady on 5/13/2018.
 */

public interface BasePresenter <V extends BaseView> {
    void attachView (V view);
    void detachView();
}
