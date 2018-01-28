package com.github.oscarcpozas.marvel.client.modules.home.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.oscarcpozas.marvel.client.R;
import com.github.oscarcpozas.marvel.client.utils.ActivityUtils;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class HomeActivity extends DaggerAppCompatActivity {

    @Inject Lazy<HomeFragment> fragmentProvider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        HomeFragment fragment =
                (HomeFragment) getSupportFragmentManager().findFragmentById(R.id.frame_container);
        if (fragment == null) {
            fragment = fragmentProvider.get();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    fragment, R.id.frame_container);
        }
    }
}
