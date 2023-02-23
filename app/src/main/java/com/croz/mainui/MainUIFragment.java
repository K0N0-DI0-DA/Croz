package com.croz.mainui;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager2.widget.ViewPager2;

import com.croz.AnimatorProperty;
import com.example.croz.R;
import com.example.croz.databinding.MainuiBinding;
import com.google.android.material.navigation.NavigationView;

public class MainUIFragment extends Fragment {
    public static MainUIFragment _currentInstance;

    private MainuiBinding _binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        _binding = MainuiBinding.inflate(inflater, container, false);

        setupCenterLayout();
        setupSideNavigatorBlocker();
        setupSideNavigator();
        setupBottomNavigator();

        _currentInstance = this;
        return _binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _binding = null;
        _currentInstance = null;
    }

    private void setupCenterLayout() {

        _binding.pagerNavigator.setUserInputEnabled(false);
        _binding.pagerNavigator.setAdapter(new PagerNavigator_FSA(this));
        _binding.pagerNavigator.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            private final int[] BOTTOM_NAVIGATOR_MENU_RID = new int[] {
                    R.id.bottom_navigator_home,
                    R.id.bottom_navigator_cart,
                    R.id.bottom_navigator_bill,
                    R.id.bottom_navigator_setting
            };

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                _binding.bottomNavigator.getMenu().findItem(BOTTOM_NAVIGATOR_MENU_RID[position]).setChecked(true);
            }
        });
    }

    private void setupSideNavigator() {
        _binding.sideNavigator.setClickable(true);
    }

    private void setupSideNavigatorBlocker() {
         _binding.sideNavigatorBlocker.setOnClickListener(view -> {
             _binding.sideNavigatorBlocker.setClickable(false);
             ObjectAnimator.ofFloat(_binding.sideNavigatorBlocker, AnimatorProperty.alpha, 0.0f).start();

             int sidebarWidth = _binding.sideNavigator.getMeasuredWidth();
             ObjectAnimator.ofFloat(_binding.sideNavigator, AnimatorProperty.translationX, -sidebarWidth).start();
             ObjectAnimator.ofFloat(_binding.centerLayout , AnimatorProperty.translationX, 0.0f).start();
             ObjectAnimator.ofFloat(_binding.centerLayout , AnimatorProperty.translationY, 0.0f).start();
             ObjectAnimator.ofFloat(_binding.centerLayout , AnimatorProperty.scaleX, 1.0f).start();
             ObjectAnimator.ofFloat(_binding.centerLayout , AnimatorProperty.scaleY, 1.0f).start();
         });
    }

    private void setupBottomNavigator() {
        _binding.bottomNavigator.setOnItemSelectedListener(item -> {
            _binding.pagerNavigator.setCurrentItem(item.getOrder());
            return true;
        });
    }

    public View.OnClickListener onOpenSideNavigatorListener() {
        return view -> {
            _binding.sideNavigatorBlocker.setClickable(true);
            ObjectAnimator.ofFloat(_binding.sideNavigatorBlocker, AnimatorProperty.alpha, 1.0f).start();

            int sidebarWidth = _binding.sideNavigator.getMeasuredWidth();
            ObjectAnimator.ofFloat(_binding.sideNavigator, AnimatorProperty.translationX, 0.0f).start();
            ObjectAnimator.ofFloat(_binding.centerLayout , AnimatorProperty.translationX, sidebarWidth+32.0f).start();
            ObjectAnimator.ofFloat(_binding.centerLayout , AnimatorProperty.translationY, (1.0f-0.65f)*0.5f*_binding.centerLayout.getMeasuredHeight()).start();
            ObjectAnimator.ofFloat(_binding.centerLayout , AnimatorProperty.scaleX, 0.65f).start();
            ObjectAnimator.ofFloat(_binding.centerLayout , AnimatorProperty.scaleY, 0.65f).start();
        };
    }
}