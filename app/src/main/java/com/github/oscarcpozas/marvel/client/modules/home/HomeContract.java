package com.github.oscarcpozas.marvel.client.modules.home;


import com.github.oscarcpozas.marvel.client.MVPContract;
import com.github.oscarcpozas.marvel.client.data.Hero;

import java.util.List;

public interface HomeContract {

    interface Presenter extends MVPContract.BasePresenter<View> {
        void loadHeroesData();
        void onHeroClicked(Hero hero);
    }

    interface View extends MVPContract.BaseView<Presenter> {
        void setLoadingIndicator(boolean visible);
        void showHeroes(List<Hero> heroes);
        void showErrorLoadingHeroes();
        void openDetailScreen(Hero hero);
    }
}
