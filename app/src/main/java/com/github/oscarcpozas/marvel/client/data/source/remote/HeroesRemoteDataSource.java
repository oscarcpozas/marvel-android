package com.github.oscarcpozas.marvel.client.data.source.remote;

import android.support.annotation.NonNull;

import com.github.oscarcpozas.marvel.client.data.Hero;
import com.github.oscarcpozas.marvel.client.data.HeroResponse;
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
        Call<HeroResponse> call = retrofit.create(HeroResponse.HeroesService.class).heroes();
        call.enqueue(new Callback<HeroResponse>() {
            @Override
            public void onResponse(@NonNull Call<HeroResponse> call,
                                   @NonNull Response<HeroResponse> response) {
                if (response.isSuccessful()) {
                    callback.onHeroesLoaded(response.body().getSuperheroes());
                } else {
                    callback.onHeroesNotLoaded();
                }
            }

            @Override
            public void onFailure(@NonNull Call<HeroResponse> call,
                                  @NonNull Throwable t) {
                callback.onHeroesNotLoaded();
            }
        });
    }
}
