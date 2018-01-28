package com.github.oscarcpozas.marvel.client.modules.home;

import com.github.oscarcpozas.marvel.client.di.scopes.ActivityScoped;
import com.github.oscarcpozas.marvel.client.di.scopes.FragmentScoped;
import com.github.oscarcpozas.marvel.client.modules.home.ui.HomeFragment;
import com.github.oscarcpozas.marvel.client.modules.home.ui.presenter.HomePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeModule {

    @FragmentScoped
    @ContributesAndroidInjector abstract HomeFragment homeFragment();

    @ActivityScoped
    @Binds abstract HomeContract.Presenter homePresenter(HomePresenter presenter);
}
