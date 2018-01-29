package com.github.oscarcpozas.marvel.client.modules.details;

import com.github.oscarcpozas.marvel.client.di.scopes.ActivityScoped;
import com.github.oscarcpozas.marvel.client.di.scopes.FragmentScoped;
import com.github.oscarcpozas.marvel.client.modules.details.ui.DetailFragment;
import com.github.oscarcpozas.marvel.client.modules.details.ui.presenter.DetailPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DetailModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract DetailFragment detailFragment();

    @ActivityScoped
    @Binds
    abstract DetailContract.Presenter detailPresenter(DetailPresenter presenter);
}
