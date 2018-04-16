package com.example.aggoetey.myapplication.menu.adapters;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.aggoetey.myapplication.menu.model.MenuInfo;
import com.example.aggoetey.myapplication.menu.fragments.MenuPageFragment;

/**
 * Created by Dries on 6/04/2018.
 */

public class MenuFragmentPagerAdapter extends FragmentPagerAdapter implements MenuPageFragment.MenuViewStateListener {

    private String tabTitles[];
    private MenuInfo menuInfo;
    private boolean isGridView;

    public MenuFragmentPagerAdapter(FragmentManager fm, MenuInfo menuInfo) {
        super(fm);
        tabTitles = menuInfo.getRestaurant().getMenu().getCategories().toArray(
                new String[menuInfo.getRestaurant().getMenu().getCategories().size()]);
        this.menuInfo = menuInfo;
        this.isGridView = false;
    }

    @Override
    public Fragment getItem(int position) {
        Log.i("PagerAdapter", "getItem : "  + position);
        return MenuPageFragment.newInstance(position + 1, getPageTitle(position).toString(), menuInfo, this);
    }

    /**
     * This method is called when notifydatasetchanged() is called.
     * Default value is POSITION_UNCHANGED which won't call getItem(int position) method to update the views.
     * Overriding it with POSITION_NONE will refresh all fragments of the viewpager.
     */
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }


    public void changeViewType (boolean isGridView){
        this.isGridView =  isGridView;
        notifyDataSetChanged();
    }


    @Override
    public boolean currentViewIsGrid() {
        return this.isGridView;
    }
}
