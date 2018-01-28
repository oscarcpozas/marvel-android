package com.github.oscarcpozas.marvel.client.modules.details.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.oscarcpozas.marvel.client.R;
import com.github.oscarcpozas.marvel.client.utils.ActivityUtils;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class DetailActivity extends DaggerAppCompatActivity {
    public static final String HERO_KEY = "HERO_KEY";

    @Inject Lazy<DetailFragment> injectedFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        DetailFragment fragment =
                (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_container);
        if (fragment == null) {
            fragment = injectedFragment.get();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    fragment, R.id.frame_container);
        }
    }
}
