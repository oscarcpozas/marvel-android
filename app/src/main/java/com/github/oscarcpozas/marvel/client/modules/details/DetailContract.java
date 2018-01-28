package com.github.oscarcpozas.marvel.client.modules.details;


import com.github.oscarcpozas.marvel.client.MVPContract;
import com.github.oscarcpozas.marvel.client.data.Hero;

public interface DetailContract {

    interface View extends MVPContract.BaseView<Presenter> {
        void getSelectedHero();
        void renderHero(Hero hero);
    }

    interface Presenter extends MVPContract.BasePresenter<View> {
        void onHeroSelectedObtain(Hero hero);
    }
}
