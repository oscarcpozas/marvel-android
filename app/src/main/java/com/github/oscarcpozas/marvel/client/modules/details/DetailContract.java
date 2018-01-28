package com.github.oscarcpozas.marvel.client.modules.details;


import com.github.oscarcpozas.marvel.client.MVPContract;

public interface DetailContract {

    interface View extends MVPContract.BaseView<Presenter> {

    }

    interface Presenter extends MVPContract.BasePresenter<View> {

    }
}
