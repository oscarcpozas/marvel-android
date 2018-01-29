package com.github.oscarcpozas.marvel.client.modules.home.ui.presenter;

import android.support.annotation.NonNull;

import com.github.oscarcpozas.marvel.client.data.Hero;
import com.github.oscarcpozas.marvel.client.data.source.HeroesDataSource;
import com.github.oscarcpozas.marvel.client.data.source.HeroesRepository;
import com.github.oscarcpozas.marvel.client.di.scopes.ActivityScoped;
import com.github.oscarcpozas.marvel.client.modules.home.HomeContract;

import java.util.List;

import javax.inject.Inject;

@ActivityScoped
public class HomePresenter implements HomeContract.Presenter {

    private final HeroesRepository heroesRepository;
    private HomeContract.View homeView;

    @Inject HomePresenter(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

    @Override
    public void setView(@NonNull HomeContract.View view) {
        homeView = view;
    }

    @Override
    public void start() {
        loadHeroes();
    }

    @Override
    public void loadHeroesData() {
        loadHeroes();
    }

    @Override
    public void onHeroClicked(Hero hero) {
        homeView.openDetailScreen(hero);
    }

    private void loadHeroes() {
        heroesRepository.getHeroes(new HeroesDataSource.GetHeroesCallback() {
            @Override
            public void onHeroesLoaded(List<Hero> heroes) {
                homeView.setLoadingIndicator(false);
                if (heroes.isEmpty()) {
                    homeView.showErrorLoadingHeroes();
                } else {
                    homeView.showHeroes(heroes);
                }
            }

            @Override
            public void onHeroesNotLoaded() {
                homeView.setLoadingIndicator(false);
                homeView.showErrorLoadingHeroes();
            }
        });
    }
}
