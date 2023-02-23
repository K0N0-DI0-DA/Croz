package com.croz.login;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.croz.AnimatorProperty;
import com.croz.test.TestFragment;
import com.example.croz.R;
import com.example.croz.databinding.LoginBinding;

public class LoginFragment extends Fragment {
    private LoginBinding _binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        _binding = LoginBinding.inflate(inflater, container, false);

        setupClickableSwitch();
        setupButton();

        return _binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _binding = null;
    }

    private void setupClickableSwitch() {
        _binding.clickableSwitchLogin.setOnClickListener(view -> {
            int offset = _binding.clickableSwitchLogin.getMeasuredWidth() / 2;
            ObjectAnimator.ofFloat(_binding.loginSwitchLine, AnimatorProperty.translationX, -offset).start();

            _binding.buttonLogin.setText(R.string.clickable_login);

            ObjectAnimator.ofFloat(_binding.clickableForgotPassword, AnimatorProperty.scaleX, 1.0f).start();
            ObjectAnimator.ofFloat(_binding.clickableForgotPassword, AnimatorProperty.scaleY, 1.0f).start();
            ObjectAnimator.ofFloat(_binding.fieldRepeatPassword, AnimatorProperty.scaleX, 0.0f).start();
            ObjectAnimator.ofFloat(_binding.fieldRepeatPassword, AnimatorProperty.scaleY, 0.0f).start();
            ObjectAnimator.ofFloat(_binding.bottomContainer, AnimatorProperty.translationY, 0.0f).start();
        });

        _binding.clickableSwitchRegister.setOnClickListener(view -> {
            int offset = _binding.clickableSwitchLogin.getMeasuredWidth() / 2;
            ObjectAnimator.ofFloat(_binding.loginSwitchLine, AnimatorProperty.translationX, +offset).start();

            _binding.buttonLogin.setText(R.string.clickable_register);

            ObjectAnimator.ofFloat(_binding.clickableForgotPassword, AnimatorProperty.scaleX, 0.0f).start();
            ObjectAnimator.ofFloat(_binding.clickableForgotPassword, AnimatorProperty.scaleY, 0.0f).start();
            ObjectAnimator.ofFloat(_binding.fieldRepeatPassword, AnimatorProperty.scaleX, 1.0f).start();
            ObjectAnimator.ofFloat(_binding.fieldRepeatPassword, AnimatorProperty.scaleY, 1.0f).start();
            ObjectAnimator.ofFloat(_binding.bottomContainer, AnimatorProperty.translationY, _binding.bottomContainer.getMeasuredHeight()).start();
        });
    }

    private void setupButton()  {
        View.OnClickListener callback = view -> { Toast.makeText(getContext(), "Chưa cài đặt", Toast.LENGTH_SHORT).show(); };
        _binding.clickableForgotPassword.setOnClickListener(callback);
        _binding.buttonFacebookLogin.setOnClickListener(callback);
        _binding.buttonGoogleLogin.setOnClickListener(callback);
        _binding.buttonLogin.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_mainUIFragment);
        });
    }
}