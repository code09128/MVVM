package com.drs24.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drs24.myapplication.databinding.FragmentOneBinding;

public class OneFragment extends Fragment {

    private FragmentOneBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOneBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onDestroyView() {
        binding = null;
    }
}
