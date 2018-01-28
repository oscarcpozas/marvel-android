package com.github.oscarcpozas.marvel.client.modules.home;


import com.github.oscarcpozas.marvel.client.MVPContract;
import com.github.oscarcpozas.marvel.client.data.Hero;

import java.util.List;

public interface HomeContract {

    interface Presenter extends MVPContract.BasePresenter {
        void loadHeroesData();
    }

    interface View extends MVPContract.BaseView<Presenter> {
        void setLoadingIndicator(boolean visible);
        void showHeroes(List<Hero> heroes);
    }
}
