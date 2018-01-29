package com.github.oscarcpozas.marvel.client;

public interface MVPContract {

    interface BaseView<T extends BasePresenter> {

    }

    interface BasePresenter<P extends BaseView> {
        void setView(P view);
        void start();
    }
}
