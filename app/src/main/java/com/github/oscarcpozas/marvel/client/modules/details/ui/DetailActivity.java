package com.github.oscarcpozas.marvel.client.modules.details.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class DetailActivity extends DaggerAppCompatActivity {

    @Inject DetailFragment injectedFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
