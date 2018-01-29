package com.github.oscarcpozas.marvel.client.modules.details.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.oscarcpozas.marvel.client.R;
import com.github.oscarcpozas.marvel.client.data.Hero;
import com.github.oscarcpozas.marvel.client.di.scopes.ActivityScoped;
import com.github.oscarcpozas.marvel.client.modules.details.DetailContract;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.github.oscarcpozas.marvel.client.modules.details.ui.DetailActivity.HERO_KEY;

@ActivityScoped
public class DetailFragment extends Fragment implements DetailContract.View {

    @Inject DetailContract.Presenter presenter;

    @BindView(R.id.detail_iv_hero_photo) ImageView heroPhoto;
    @BindView(R.id.detail_tv_hero_name) TextView heroName;
    @BindView(R.id.detail_tv_hero_real_name) TextView heroRealName;
    @BindView(R.id.detail_tv_description) TextView heroDescription;

    @Inject public DetailFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void getSelectedHero() {
        Hero hero = getActivity().getIntent().getExtras().getParcelable(HERO_KEY);
        presenter.onHeroSelectedObtain(hero);
    }

    @Override
    public void renderHero(Hero hero) {
        renderHeroPhoto(hero.getPhoto());
        heroName.setText(hero.getName());
        heroRealName.setText(hero.getRealName());
        heroDescription.setText(hero.getAbilities());
    }

    private void renderHeroPhoto(String photo) {
        Picasso.with(getContext()).load(photo).into(heroPhoto);
    }
}
