package com.caluneo.navigator;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the mapping of a class's layout, class, and navigation menu item.
 * @author Brendan Caluneo
 */
public class NavigatorMap {
    public static class NavPair {
        int layoutID;
        Class<? extends NavigatorActivity> navClass;

        public NavPair(int layoutID, Class<? extends NavigatorActivity> navClass) {
            this.layoutID = layoutID;
            this.navClass = navClass;
        }
    }

    private static final Map<Integer, NavPair> navMap = new HashMap<>();

    public static NavPair get(int layoutID) {
        return navMap.get(layoutID);
    }

    public static void insert(int menuID, int layoutID, Class<? extends NavigatorActivity> clazz) {
        navMap.put(menuID, new NavPair(layoutID, clazz));
    }
}