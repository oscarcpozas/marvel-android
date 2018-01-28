package com.github.oscarcpozas.marvel.client;

public interface MVPContract {

    interface BaseView<T extends BasePresenter> {

    }

    interface BasePresenter {
        void start();
    }
}
