package com.caluneo.navigator;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;

/**
 * Represents a click listener for Navigation menu items.
 * @author Brendan Caluneo
 */
public class NavigatorMenuListener implements NavigationView.OnNavigationItemSelectedListener {

    /* CONFIGURE ME */
    private final Context context = AppContext.getContext();

    private final int layoutID;

    public NavigatorMenuListener(int layoutID) {
        this.layoutID = layoutID;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        NavigatorMap.NavPair navPair = NavigatorMap.get(id);
        assert(navPair != null);
        if (navPair.layoutID == layoutID) return false;

        Intent intent = new Intent(context, navPair.navClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

        return true;
    }
}
