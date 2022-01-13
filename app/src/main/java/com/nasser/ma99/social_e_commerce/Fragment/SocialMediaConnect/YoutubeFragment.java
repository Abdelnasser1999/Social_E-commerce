package com.nasser.ma99.social_e_commerce.Fragment.SocialMediaConnect;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentYoutubeBinding;


public class YoutubeFragment extends Fragment {

    FragmentYoutubeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentYoutubeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();




        return view;
    }
}