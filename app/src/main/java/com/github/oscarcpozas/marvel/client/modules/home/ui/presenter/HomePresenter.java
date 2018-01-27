package com.github.oscarcpozas.marvel.client.modules.home.ui.presenter;

import com.github.oscarcpozas.marvel.client.modules.home.HomeContract;

public class HomePresenter implements HomeContract.Presenter {
    private static final String TAG = HomePresenter.class.getCanonicalName();

    private HomeContract.View homeView;

    public HomePresenter(HomeContract.View homeView) {
        this.homeView = homeView;
        homeView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
