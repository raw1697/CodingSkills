package com.example.riderlog;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsAcessAdapter extends FragmentPagerAdapter {


    public TabsAcessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i)
        {
            case 0:

                myOrdersFragment myOrdersFragment = new myOrdersFragment();
                return myOrdersFragment;

            case 1:

                ordersToTakeFragment ordersToTakeFragment = new ordersToTakeFragment();
                return ordersToTakeFragment;

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:

                return "my orders";

            case 1:

                return "unassigned orders";
            default:
                return null;

        }
    }
}
