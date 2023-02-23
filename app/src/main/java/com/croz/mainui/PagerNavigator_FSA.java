package com.croz.mainui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.croz.mainui.home.HomeFragment;
import com.croz.test.TestFragment;

import java.util.ArrayList;
import java.util.List;

public class PagerNavigator_FSA extends FragmentStateAdapter {
    private List<Fragment> _fragmentList = new ArrayList<>();

    public PagerNavigator_FSA(@NonNull Fragment fragment) {
        super(fragment);

        _fragmentList.add(new HomeFragment());
        _fragmentList.add(new TestFragment());
        _fragmentList.add(new TestFragment());
        _fragmentList.add(new TestFragment());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       return _fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return _fragmentList.size();
    }
}
