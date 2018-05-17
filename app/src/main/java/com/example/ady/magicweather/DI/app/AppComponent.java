package com.example.ady.magicweather.DI.app;

import com.example.ady.magicweather.DI.Main.MainComponet;
import com.example.ady.magicweather.DI.Main.MainModule;

import dagger.Component;

/**
 * Created by Ady on 5/12/2018.
 */

@Component(modules = AppModule.class)
public interface AppComponent {
    MainComponet add(MainModule mainModule);
}
