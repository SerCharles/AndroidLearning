
package com.example.android.tabexperiment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Fragment to return the clicked tab.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        //To do
        //return the corresponded fragment according to position
        //remember that the position can not be out of [0, 2]
        if(position == 0)
        {
            return new TabFragment1();
        }
        else if(position == 1)
        {
            return new TabFragment2();

        }
        else if(position == 2)
        {
            return new TabFragment3();

        }
        else
        {
            return new TabFragment1();
        }
        //return null;
        //To do closed
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
