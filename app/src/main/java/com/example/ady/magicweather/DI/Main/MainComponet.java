package com.example.ady.magicweather.DI.Main;

import com.example.ady.magicweather.View.main.MainActivity;

import dagger.Subcomponent;

/**
 * Created by Ady on 5/12/2018.
 */

@Subcomponent (modules = MainModule.class)
public interface MainComponet {
    void inject(MainActivity mainActivity);
}
