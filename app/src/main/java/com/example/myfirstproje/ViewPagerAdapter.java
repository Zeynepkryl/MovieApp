package com.example.myfirstproje;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myfirstproje.fragments.FavoritesMoviesFragment;
import com.example.myfirstproje.fragments.LastestMoviesFragment;
import com.example.myfirstproje.fragments.TopRatedMoviesFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    int tabCount = 3;


    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new LastestMoviesFragment();
            case 1:
                return new TopRatedMoviesFragment();
            case 2:
                return new FavoritesMoviesFragment();


        }
        return null;
    }

    @Override
    public int getItemCount() {
        return tabCount;
    }
}
