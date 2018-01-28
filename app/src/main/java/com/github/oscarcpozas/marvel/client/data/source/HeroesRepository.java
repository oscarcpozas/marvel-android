package com.github.oscarcpozas.marvel.client.data.source;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class HeroesRepository implements HeroesDataSource {

    @Inject
    HeroesRepository() {

    }

    @Override
    public void getHeroes(GetHeroesCallback callback) {

    }
}
