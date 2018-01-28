package com.github.oscarcpozas.marvel.client;

import com.github.oscarcpozas.marvel.client.data.source.HeroesRepositoryModule;
import com.github.oscarcpozas.marvel.client.di.DaggerAppComponent;
import com.github.oscarcpozas.marvel.client.net.NetModule;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MarvelApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
//        return DaggerAppComponent.builder().application(this).build();
        return DaggerAppComponent.builder()
                .heroesRepositoryModule(new HeroesRepositoryModule())
                .netModule(new NetModule("https://api.myjson.com/"))
                .build();
    }
}
