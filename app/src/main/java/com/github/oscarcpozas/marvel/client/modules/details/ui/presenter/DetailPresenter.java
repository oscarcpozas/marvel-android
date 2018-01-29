package com.github.oscarcpozas.marvel.client.modules.details.ui.presenter;

import com.github.oscarcpozas.marvel.client.data.Hero;
import com.github.oscarcpozas.marvel.client.di.scopes.ActivityScoped;
import com.github.oscarcpozas.marvel.client.modules.details.DetailContract;

import javax.inject.Inject;

@ActivityScoped
public class DetailPresenter implements DetailContract.Presenter {

    private DetailContract.View detailView;

    @Inject public DetailPresenter() {

    }

    @Override
    public void setView(DetailContract.View view) {
        detailView = view;
    }

    @Override
    public void start() {
        detailView.getSelectedHero();
    }

    @Override
    public void onHeroSelectedObtain(Hero hero) {
        detailView.renderHero(hero);
    }
}
