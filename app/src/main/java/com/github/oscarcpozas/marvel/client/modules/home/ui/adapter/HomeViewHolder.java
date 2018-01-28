package com.github.oscarcpozas.marvel.client.modules.home.ui.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.oscarcpozas.marvel.client.R;
import com.github.oscarcpozas.marvel.client.data.Hero;
import com.github.oscarcpozas.marvel.client.modules.home.HomeContract;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeViewHolder extends RecyclerView.ViewHolder {

    private final HomeContract.Presenter presenter;

    @BindView(R.id.iv_hero_photo) ImageView heroPhoto;
    @BindView(R.id.tv_hero_name) TextView heroName;
    @BindView(R.id.tv_hero_real_name) TextView heroRealName;

    public HomeViewHolder(View itemView, HomeContract.Presenter presenter) {
        super(itemView);
        this.presenter = presenter;
        ButterKnife.bind(this, itemView);
    }

    public void render(Hero hero) {
        configureListener(hero);
        renderHeroPhoto(hero.getPhoto());
        heroName.setText(hero.getName());
        heroRealName.setText(hero.getRealName());
    }

    private void configureListener(final Hero hero) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onHeroClicked(hero);
            }
        });
    }

    private void renderHeroPhoto(String photo) {
        Picasso.with(itemView.getContext()).load(photo).into(heroPhoto);
    }
}
