package com.github.oscarcpozas.marvel.client.data.source.remote;

import android.support.annotation.NonNull;

import com.github.oscarcpozas.marvel.client.data.Hero;
import com.github.oscarcpozas.marvel.client.data.source.HeroesDataSource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@Singleton
public class HeroesRemoteDataSource implements HeroesDataSource {

    Retrofit retrofit;

    @Inject public HeroesRemoteDataSource(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public void getHeroes(final GetHeroesCallback callback) {
        Call<List<Hero>> call = retrofit.create(Hero.HeroesService.class).heroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(@NonNull Call<List<Hero>> call,
                                   @NonNull Response<List<Hero>> response) {
                callback.onHeroesLoaded(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Hero>> call,
                                  @NonNull Throwable t) {
                callback.onHeroesNotLoaded();
            }
        });
    }
}
