package com.github.oscarcpozas.marvel.client.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class HeroResponse {

    public interface HeroesService {
        @GET("bins/bvyob")
        Call<HeroResponse> heroes();
    }

    @SerializedName("superheroes")
    @Expose
    private List<Hero> superheroes;

    public List<Hero> getSuperheroes() {
        return superheroes;
    }
}
