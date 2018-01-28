package com.github.oscarcpozas.marvel.client.modules.home.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.oscarcpozas.marvel.client.R;
import com.github.oscarcpozas.marvel.client.data.Hero;
import com.github.oscarcpozas.marvel.client.modules.home.HomeContract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HomeDataAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private final HomeContract.Presenter presenter;
    private List<Hero> heroes;

    public HomeDataAdapter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
        heroes = new ArrayList<>();
    }

    public void addAll(Collection<Hero> heroes) {
        this.heroes.addAll(heroes);
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.row_hero, parent, false);
        return new HomeViewHolder(view, presenter);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        Hero hero = heroes.get(position);
        holder.render(hero);
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }
}
