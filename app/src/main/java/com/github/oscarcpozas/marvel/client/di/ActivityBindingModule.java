package com.github.oscarcpozas.marvel.client.di;

import com.github.oscarcpozas.marvel.client.di.scopes.ActivityScoped;
import com.github.oscarcpozas.marvel.client.modules.details.DetailContract;
import com.github.oscarcpozas.marvel.client.modules.details.DetailModule;
import com.github.oscarcpozas.marvel.client.modules.details.ui.DetailActivity;
import com.github.oscarcpozas.marvel.client.modules.home.HomeModule;
import com.github.oscarcpozas.marvel.client.modules.home.ui.HomeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity homeActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = DetailModule.class)
    abstract DetailActivity detailActivity();
}
