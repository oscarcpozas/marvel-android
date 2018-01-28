package com.github.oscarcpozas.marvel.client.modules.home.ui.presenter;

import com.github.oscarcpozas.marvel.client.data.Hero;
import com.github.oscarcpozas.marvel.client.data.source.HeroesDataSource;
import com.github.oscarcpozas.marvel.client.data.source.HeroesRepository;
import com.github.oscarcpozas.marvel.client.di.scopes.ActivityScoped;
import com.github.oscarcpozas.marvel.client.modules.home.HomeContract;

import java.util.List;

import javax.inject.Inject;

@ActivityScoped
public class HomePresenter implements HomeContract.Presenter {
    private static final String TAG = HomePresenter.class.getCanonicalName();

    private final HeroesRepository heroesRepository;
    private HomeContract.View homeView;

    @Inject HomePresenter(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

    @Override
    public void start() {
        loadHeroes();
    }

    @Override
    public void loadHeroesData() {
        loadHeroes();
    }

    private void loadHeroes() {
        heroesRepository.getHeroes(new HeroesDataSource.GetHeroesCallback() {
            @Override
            public void onHeroesLoaded(List<Hero> heroes) {
                homeView.setLoadingIndicator(false);
                if (heroes.isEmpty()) {
                    // TODO: Implement empty case
                } else {
                    homeView.showHeroes(heroes);
                }
            }

            @Override
            public void onHeroesNotLoaded() {
                // TODO: Implement error loading heroes
            }
        });
    }
}
