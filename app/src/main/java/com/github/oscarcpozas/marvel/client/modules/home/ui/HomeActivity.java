package com.github.oscarcpozas.marvel.client.modules.home.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.github.oscarcpozas.marvel.client.R;
import com.github.oscarcpozas.marvel.client.modules.home.ui.presenter.HomePresenter;
import com.github.oscarcpozas.marvel.client.utils.ActivityUtils;

import butterknife.BindView;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.frame_container) FrameLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        HomeFragment fragment =
                (HomeFragment) getSupportFragmentManager().findFragmentById(container.getId());
        if (fragment == null) {
            fragment = HomeFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    fragment, container.getId());
        }

        new HomePresenter(fragment);
    }
}
