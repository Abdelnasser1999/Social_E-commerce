package com.nasser.ma99.social_e_commerce.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.LoginActivity;
import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentLogoBinding;


public class LogoFragment extends Fragment {

    FragmentLogoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLogoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.tvSignup.setOnClickListener(view1 ->
                {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2,new TypeSignUpFragment()).commit();

                }
                );





        return view;
    }
}