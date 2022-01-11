package com.nasser.ma99.social_e_commerce.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasser.ma99.social_e_commerce.Activity.AddCompaignActivity;
import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentLogoBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;
import com.nasser.ma99.social_e_commerce.utilities.PreferenceManager;


public class LogoFragment extends Fragment {

    FragmentLogoBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLogoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        preferenceManager = new PreferenceManager(getActivity().getApplicationContext());

        if (preferenceManager.getBoolean(Constants.KEY_IS_SIGNED_IN)) {

            Intent intent = new Intent(getActivity().getApplicationContext(), AddCompaignActivity.class);
            startActivity(intent);
            getActivity().finish();
        }

        binding.tvSignup.setOnClickListener(view1 ->
                {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, new TypeSignUpFragment()).commit();

                }

        );


        binding.tvSignin.setOnClickListener(v -> {


        });


        return view;
    }
}