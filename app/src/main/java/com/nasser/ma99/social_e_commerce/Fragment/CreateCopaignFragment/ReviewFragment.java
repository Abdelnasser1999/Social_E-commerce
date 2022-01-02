package com.nasser.ma99.social_e_commerce.Fragment.CreateCopaignFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentReviewBinding;

public class ReviewFragment extends Fragment {
    FragmentReviewBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentReviewBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.btNextPrelaoded.setOnClickListener(view1 -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView,new PrelaodedFragment()).commit();


        });

        binding.btBackInterest.setOnClickListener(view1 -> {

            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragmentContainerView, new InterestFragment()).commit();


        });



        return view;
    }
}