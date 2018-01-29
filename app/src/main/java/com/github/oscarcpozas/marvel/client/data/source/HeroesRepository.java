package com.github.oscarcpozas.marvel.client.data.source;

import com.github.oscarcpozas.marvel.client.data.Hero;
import com.github.oscarcpozas.marvel.client.data.source.remote.HeroesRemoteDataSource;
import com.github.oscarcpozas.marvel.client.di.scopes.Repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class HeroesRepository implements HeroesDataSource {

    private final HeroesRemoteDataSource remoteDataSource;

    @Inject HeroesRepository(@Repository HeroesRemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getHeroes(final GetHeroesCallback callback) {
        remoteDataSource.getHeroes(new GetHeroesCallback() {
            @Override
            public void onHeroesLoaded(List<Hero> heroes) {
                callback.onHeroesLoaded(heroes);
            }

            @Override
            public void onHeroesNotLoaded() {
                callback.onHeroesNotLoaded();
            }
        });
    }
}
