package com.github.oscarcpozas.marvel.client;

public interface MVPContract {

    interface BaseView<T extends BasePresenter> {
        void setPresenter(T presenter);
    }

    interface BasePresenter {
        void start();
    }
}
