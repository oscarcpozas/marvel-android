package com.github.oscarcpozas.marvel.client.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class ActivityUtils {

    public static void addFragmentToActivity(FragmentManager fragmentManager, Fragment fragment,
                                             int container) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(container, fragment);
        transaction.commit();
    }
}
