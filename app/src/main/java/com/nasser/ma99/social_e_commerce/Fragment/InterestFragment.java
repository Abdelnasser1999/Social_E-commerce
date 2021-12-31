package com.nasser.ma99.social_e_commerce.Fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentInterestBinding;


public class InterestFragment extends Fragment {
    FragmentInterestBinding binding;

    boolean flag = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentInterestBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.tvBeautyfashion.setOnClickListener(view1 -> {
          if(!flag) {
               binding.tvBeautyfashion.setTypeface( binding.tvBeautyfashion.getTypeface(), Typeface.BOLD);
               binding.tvBeautyfashion.setTextColor(Color.parseColor("#B74797"));
           }

        });


        return view;
    }
}