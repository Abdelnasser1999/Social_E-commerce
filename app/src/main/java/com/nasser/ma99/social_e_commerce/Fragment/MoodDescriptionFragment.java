package com.nasser.ma99.social_e_commerce.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentMoodDescriptionBinding;
import com.nasser.ma99.social_e_commerce.databinding.FragmentMoodboardBinding;


public class MoodDescriptionFragment extends Fragment {
    FragmentMoodDescriptionBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMoodDescriptionBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.btNextContent.setOnClickListener(view1 -> {
    getActivity().getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragmentContainerView,new ContentFragment()).commit();

        });

        return view;
    }
}