package com.croz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.croz.databinding.RootBinding;

public class MainActivity extends AppCompatActivity {
    private RootBinding _binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalVariable.currentContext = this;

        getSupportActionBar().hide();
        _binding = RootBinding.inflate(getLayoutInflater());
        setContentView(_binding.getRoot());
    }
}