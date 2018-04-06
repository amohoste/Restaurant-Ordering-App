package com.example.aggoetey.myapplication.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aggoetey on 3/20/18.
 *
 * Dit is een model voor een Menu.
 */

public class Menu implements Serializable {
    private ArrayList<MenuItem> menuItemList = new ArrayList<>();

    /**
     * Voeg een MenuItem toe aan het menu
     */
    public void addMenuItem(MenuItem menuItem){
        menuItemList.add(menuItem);
    }

    public ArrayList<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public ArrayList<MenuItem> getMenuItemList(String category) {
        ArrayList<MenuItem> result = new ArrayList<>();
        for (MenuItem menuItem: menuItemList) {
            if (menuItem.category.equals(category)) {
                result.add(menuItem);
            }
        }
        return result;
    }
}
