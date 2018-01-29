package com.github.oscarcpozas.marvel.client.data.source;


import com.github.oscarcpozas.marvel.client.data.source.remote.HeroesRemoteDataSource;
import com.github.oscarcpozas.marvel.client.di.scopes.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class HeroesRepositoryModule {

    @Repository
    @Singleton
    @Provides HeroesRemoteDataSource provideHeroesRemoteDataSource(Retrofit retrofit) {
        return new HeroesRemoteDataSource(retrofit);
    }
}
