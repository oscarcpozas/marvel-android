package com.github.oscarcpozas.marvel.client.modules.home;


import com.github.oscarcpozas.marvel.client.MVPContract;

public interface HomeContract {

    interface Presenter extends MVPContract.BasePresenter {

    }

    interface View extends MVPContract.BaseView<Presenter> {

    }
}
