package com.nasser.ma99.social_e_commerce.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentSettingsBinding;


public class SettingsFragment extends Fragment {

    FragmentSettingsBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.LanguageEdit.setOnClickListener(view1 -> {

        Navigation.findNavController(view1).navigate(R.id.action_navigation_settings_to_languageFragment);

        });


        return view;
    }
}