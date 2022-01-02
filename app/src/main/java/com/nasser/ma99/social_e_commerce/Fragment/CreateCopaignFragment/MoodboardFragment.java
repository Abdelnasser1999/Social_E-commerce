package com.nasser.ma99.social_e_commerce.Fragment.CreateCopaignFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentMoodboardBinding;


public class MoodboardFragment extends Fragment {
    FragmentMoodboardBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMoodboardBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.btNextMoodboardDec.setOnClickListener(view1 -> {


            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new MoodDescriptionFragment()).commit();

        });


        binding.btBackSetBreif.setOnClickListener(view1 -> {

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView,new SetBreifFragment()).commit();


        });


        return view;
    }
}