package com.nasser.ma99.social_e_commerce.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentMoodboardBinding;


public class MoodboardFragment extends Fragment {
    FragmentMoodboardBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMoodboardBinding.inflate(inflater, container, false);
        View view = binding.getRoot();







        return view;
    }
}