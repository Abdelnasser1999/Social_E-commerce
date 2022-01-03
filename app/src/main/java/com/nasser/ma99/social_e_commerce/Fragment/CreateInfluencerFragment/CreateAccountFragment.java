package com.nasser.ma99.social_e_commerce.Fragment.CreateInfluencerFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.Fragment.LanguageFragment;
import com.nasser.ma99.social_e_commerce.Fragment.SettingsFragment;
import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentCreateAccountBinding;


public class CreateAccountFragment extends Fragment {

    FragmentCreateAccountBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentCreateAccountBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.btNextChangelanguage.setOnClickListener(view1 -> {


            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView3, new SettingsFragment()).commit();

        });


        return view;
    }
}