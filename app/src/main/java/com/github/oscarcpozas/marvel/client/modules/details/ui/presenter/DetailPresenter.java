package com.github.oscarcpozas.marvel.client.modules.details.ui.presenter;

import com.github.oscarcpozas.marvel.client.di.scopes.ActivityScoped;
import com.github.oscarcpozas.marvel.client.modules.details.DetailContract;

@ActivityScoped
public class DetailPresenter implements DetailContract.Presenter {

    private DetailContract.View detailView;

    @Override
    public void setView(DetailContract.View view) {

    }

    @Override
    public void start() {

    }
}
