package com.github.oscarcpozas.marvel.client.modules.home.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.oscarcpozas.marvel.client.MVPContract;
import com.github.oscarcpozas.marvel.client.R;
import com.github.oscarcpozas.marvel.client.data.Hero;
import com.github.oscarcpozas.marvel.client.di.scopes.ActivityScoped;
import com.github.oscarcpozas.marvel.client.di.scopes.FragmentScoped;
import com.github.oscarcpozas.marvel.client.modules.home.HomeContract;
import com.github.oscarcpozas.marvel.client.modules.home.ui.adapter.HomeDataAdapter;
import com.github.oscarcpozas.marvel.client.modules.home.ui.presenter.HomePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

@ActivityScoped
public class HomeFragment extends Fragment implements HomeContract.View {
    private static final String TAG = HomeFragment.class.getCanonicalName();

    @Inject HomeContract.Presenter presenter;

    private HomeDataAdapter recyclerAdapter;

    @BindView(R.id.home_recycler_view) RecyclerView recyclerView;
    @BindView(R.id.home_loading_view) LinearLayout loadingView;

    @Inject public HomeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);
        configureRecyclerView();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    private void configureRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerAdapter = new HomeDataAdapter(presenter);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void setLoadingIndicator(boolean visible) {
        loadingView.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showHeroes(List<Hero> heroes) {
        recyclerAdapter.addAll(heroes);
        recyclerAdapter.notifyDataSetChanged();
    }
}
