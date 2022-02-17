package com.caluneo.navigator;

import android.os.Bundle;
import android.view.Gravity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

/**
 * Represents an activity that can be navigated to through a navigation drawer.
 * @author Brendan Caluneo
 */
public class NavigatorActivity extends AppCompatActivity {

    private final int titleID, layoutID, menuID;

    public NavigatorActivity(int titleID, int layoutID, int menuID) {
        this.titleID = titleID;
        this.layoutID = layoutID;
        this.menuID = menuID;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(layoutID);

        MaterialToolbar toolbar = (MaterialToolbar) findViewById(R.id.action_bar);
        DrawerLayout drawer = ((DrawerLayout) findViewById(R.id.drawer_layout));
        NavigationView nav = (NavigationView) findViewById(R.id.nav_view);

        toolbar.setTitle(titleID);
        setSupportActionBar(toolbar);
        nav.setCheckedItem(menuID);

        toolbar.setNavigationOnClickListener(v -> {
            drawer.openDrawer(Gravity.LEFT);
            drawer.bringToFront();
            nav.bringToFront();
        });

        nav.setNavigationItemSelectedListener(new NavigatorMenuListener(layoutID));
    }
}
