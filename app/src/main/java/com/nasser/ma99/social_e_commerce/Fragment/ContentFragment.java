package com.nasser.ma99.social_e_commerce.Fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentContentBinding;


public class ContentFragment extends Fragment {
    FragmentContentBinding binding;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentContentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.RangeSlider.setValues(13f, 30f);

        binding.RangeSlider.setOnCapturedPointerListener(new View.OnCapturedPointerListener() {
            @Override
            public boolean onCapturedPointer(View view, MotionEvent motionEvent) {
                Float age = binding.RangeSlider.getValueTo();

                binding.tvAge.setText(age.toString());

                return false;
            }
        });

        return view;
    }
}