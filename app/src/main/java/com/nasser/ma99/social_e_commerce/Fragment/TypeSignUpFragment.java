package com.nasser.ma99.social_e_commerce.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.Activity.LoginActivity;
import com.nasser.ma99.social_e_commerce.databinding.FragmentTypeSignUpBinding;


public class TypeSignUpFragment extends Fragment {
    FragmentTypeSignUpBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentTypeSignUpBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.brand.setOnClickListener(view1 -> {
            Intent i = new Intent(getActivity(), LoginActivity.class);
            i.putExtra("type","Influencer");
            getActivity().startActivity(i);

        });


        binding.influe.setOnClickListener(view1 -> {
            Intent i = new Intent(getActivity(), LoginActivity.class);
            i.putExtra("type","Brand");
            getActivity().startActivity(i);

        });
        return view;
    }
}