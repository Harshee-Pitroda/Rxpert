package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new HealthFragment();

            case 1:
                return new ScienceFragment(); //Diet Fragment

            case 2:
                return new TechFragment(); //Exercise Fragment

            case 3:
                return new EntertainmentFragment(); //Covid Fragment

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
