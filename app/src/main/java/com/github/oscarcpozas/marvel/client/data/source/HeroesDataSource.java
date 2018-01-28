package com.github.oscarcpozas.marvel.client.data.source;


import com.github.oscarcpozas.marvel.client.data.Hero;

import java.util.List;

public interface HeroesDataSource {

    interface GetHeroesCallback {

        void onHeroesLoaded(List<Hero> heroes);

        void onHeroesNotLoaded();
    }

    void getHeroes(GetHeroesCallback callback);
}
