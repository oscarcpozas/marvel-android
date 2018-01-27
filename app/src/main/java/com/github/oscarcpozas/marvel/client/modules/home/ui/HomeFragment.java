package com.github.oscarcpozas.marvel.client.modules.home.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.oscarcpozas.marvel.client.MVPContract;
import com.github.oscarcpozas.marvel.client.R;
import com.github.oscarcpozas.marvel.client.modules.home.HomeContract;
import com.github.oscarcpozas.marvel.client.modules.home.ui.presenter.HomePresenter;

public class HomeFragment extends Fragment implements HomeContract.View {
    private static final String TAG = HomeFragment.class.getCanonicalName();

    private HomeContract.Presenter presenter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_home, container, false);


        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }
}
