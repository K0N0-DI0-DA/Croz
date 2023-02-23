package com.croz.mainui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.croz.mainui.MainUIFragment;
import com.example.croz.R;
import com.example.croz.databinding.MainuiHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private MainuiHomeBinding _binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        _binding = MainuiHomeBinding.inflate(inflater, container, false);

        setupSideNavigatorOpenButton();
        setupFilterRecylerView();

        return _binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _binding = null;
    }

    private void setupSideNavigatorOpenButton() {
        _binding.buttonOpenSidebar.setOnClickListener(MainUIFragment._currentInstance.onOpenSideNavigatorListener());
    }

    private void setupFilterRecylerView() {
        List<FilterRV_ViewModel> testViewModelList = new ArrayList<>();
        testViewModelList.add(new FilterRV_ViewModel(R.drawable.icon_cake, R.string.filterrv_title_1));
        testViewModelList.add(new FilterRV_ViewModel(R.drawable.icon_coffee, R.string.filterrv_title_2));
        testViewModelList.add(new FilterRV_ViewModel(R.drawable.icon_hamburger, R.string.filterrv_title_3));
        testViewModelList.add(new FilterRV_ViewModel(R.drawable.icon_nutriton, R.string.filterrv_title_4));
        testViewModelList.add(new FilterRV_ViewModel(R.drawable.icon_dot, R.string.filterrv_title_5));
        testViewModelList.add(new FilterRV_ViewModel(R.drawable.icon_cake, R.string.test_string));
        testViewModelList.add(new FilterRV_ViewModel(R.drawable.icon_coffee, R.string.test_string));
        testViewModelList.add(new FilterRV_ViewModel(R.drawable.icon_hamburger, R.string.test_string));
        FilterRV_Adapter adapter = new FilterRV_Adapter(getContext(), testViewModelList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        _binding.filterRecyclerView.setLayoutManager(layoutManager);
        _binding.filterRecyclerView.setAdapter(adapter);
    }

}