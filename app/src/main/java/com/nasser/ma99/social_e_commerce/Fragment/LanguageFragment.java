package com.nasser.ma99.social_e_commerce.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentLanguageBinding;


public class LanguageFragment extends Fragment {
    FragmentLanguageBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLanguageBinding.inflate(inflater, container, false);
        View view = binding.getRoot();



        binding.btBackToSettings.setOnClickListener(v->{

            Navigation.findNavController(v).navigate(R.id.action_languageFragment_to_navigation_settings);

        });
        return view;
    }
}