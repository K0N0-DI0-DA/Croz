package com.croz.mainui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.croz.R;

import java.util.List;

public class FilterRV_Adapter extends RecyclerView.Adapter<FilterRV_ViewHolder> {
    private Context _context;
    private  List<FilterRV_ViewModel> _modelList;

    public FilterRV_Adapter(Context context, List<FilterRV_ViewModel> modelList) {
        _context = context;
        _modelList = modelList;
    }

    @NonNull
    @Override
    public FilterRV_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(_context);
        View filterItem = inflater.inflate(R.layout.mainui_filterrv_item, parent, false);
        FilterRV_ViewHolder holder = new FilterRV_ViewHolder(filterItem);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilterRV_ViewHolder holder, int position) {
        FilterRV_ViewModel viewModel = _modelList.get(position);
        holder.set(viewModel);
    }

    @Override
    public int getItemCount() {
        return _modelList.size();
    }
}