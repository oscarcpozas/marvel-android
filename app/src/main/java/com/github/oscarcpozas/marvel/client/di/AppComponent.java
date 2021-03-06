package com.github.oscarcpozas.marvel.client.di;

import android.app.Application;

import com.github.oscarcpozas.marvel.client.MarvelApplication;
import com.github.oscarcpozas.marvel.client.data.source.HeroesRepositoryModule;
import com.github.oscarcpozas.marvel.client.net.NetModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        HeroesRepositoryModule.class,
        NetModule.class,
        AppModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<MarvelApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
