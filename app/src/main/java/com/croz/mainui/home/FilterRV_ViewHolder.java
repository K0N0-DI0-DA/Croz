package com.croz.mainui.home;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.croz.GlobalVariable;
import com.example.croz.R;

public class FilterRV_ViewHolder extends RecyclerView.ViewHolder {
    private static FilterRV_ViewHolder _currentSelected = null;
    private ImageView _image;
    private TextView _title;

    public FilterRV_ViewHolder(@NonNull View itemView) {
        super(itemView);
        _image = itemView.findViewById(R.id.filterrv_image);
        _title = itemView.findViewById(R.id.filterrv_title);
        itemView.setOnClickListener(view -> {
            if (_currentSelected != null)
                _currentSelected.onExit();

            _currentSelected = this;
            _currentSelected.onEnter();
        });
    }

    public void set(FilterRV_ViewModel viewModel) {
        _image.setImageResource(viewModel.getImageRID());
        _title.setText(viewModel.getTitleRID());
    }

    private void onEnter() {
        _image.setBackgroundResource(R.drawable.rounded_corner_16x16x16x16_dark_pink);
        int color = ContextCompat.getColor(GlobalVariable.currentContext, R.color.color_white_pink);
        ImageViewCompat.setImageTintList(_image, ColorStateList.valueOf(color));
    }

    private void onExit() {
        _image.setBackgroundResource(R.drawable.rounded_corner_16x16x16x16_white_pink);
        int color = ContextCompat.getColor(GlobalVariable.currentContext, R.color.color_dark_pink);
        ImageViewCompat.setImageTintList(_image, ColorStateList.valueOf(color));
    }
}