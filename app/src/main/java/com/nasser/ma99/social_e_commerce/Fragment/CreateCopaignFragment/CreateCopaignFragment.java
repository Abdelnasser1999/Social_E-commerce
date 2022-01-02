package com.nasser.ma99.social_e_commerce.Fragment.CreateCopaignFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.Activity.LoginActivity;
import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentCreateCopaignBinding;


public class CreateCopaignFragment extends Fragment {

    FragmentCreateCopaignBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCreateCopaignBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.btNextSetBreif.setOnClickListener(view1 -> {
            getActivity().getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragmentContainerView, new SetBreifFragment()).commit();

        });


        binding.btBackToLogin.setOnClickListener(view1 -> {

            Intent i = new Intent(getActivity(), LoginActivity.class);
            startActivity(i);


        });


        return view;
    }
}