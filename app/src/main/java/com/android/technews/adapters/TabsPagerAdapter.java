package com.android.technews.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by smutneja03 on 07/08/15.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LatestNews();
            case 1:
                return new AllNews();

        }

        return null;

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
