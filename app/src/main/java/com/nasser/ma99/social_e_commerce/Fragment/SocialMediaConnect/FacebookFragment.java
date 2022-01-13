package com.nasser.ma99.social_e_commerce.Fragment.SocialMediaConnect;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentFacebookBinding;


public class FacebookFragment extends Fragment {


    FragmentFacebookBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFacebookBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        return view;
    }
}