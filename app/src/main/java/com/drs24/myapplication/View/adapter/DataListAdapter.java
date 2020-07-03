package com.drs24.myapplication.View.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.drs24.myapplication.databinding.ItemDataBinding;
import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;
import com.drs24.myapplication.Model.DataList;

import java.util.ArrayList;
import java.util.List;

import static com.drs24.myapplication.databinding.ItemDataBinding.inflate;

/**
 * Created by dustin0128 on 2020/3/13
 */
public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.MyViewHolder>{

    private List<DataList> dataLists;

    public DataListAdapter() {
        dataLists = new ArrayList<>();
    }

    public void addDataList(List<DataList> currencyList) {
        this.dataLists = currencyList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemDataBinding binding = ItemDataBinding.inflate(layoutInflater, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DataListAdapter.MyViewHolder holder, int position) {
        final MyViewHolder data = holder;
        DataList dataList = dataLists.get(position);

        data.binding.tvDate.setText(dataList.getDate());
        data.binding.tvName.setText(dataList.getName());
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemDataBinding binding;

        MyViewHolder(ItemDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public int getItemCount() {
        return dataLists != null ? dataLists.size() : 0;
    }
}
