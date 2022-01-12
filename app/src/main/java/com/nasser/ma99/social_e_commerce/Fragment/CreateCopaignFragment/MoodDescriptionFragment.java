package com.nasser.ma99.social_e_commerce.Fragment.CreateCopaignFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentMoodDescriptionBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;
import com.nasser.ma99.social_e_commerce.utilities.PreferenceManager;


public class MoodDescriptionFragment extends Fragment {
    FragmentMoodDescriptionBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMoodDescriptionBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        preferenceManager = new PreferenceManager(getContext());



        binding.btNextContent.setOnClickListener(view1 -> {

            if (isNotEmpty()) {
                Bundle b = getArguments();
                Fragment f = new ContentFragment();

                String attaDescription  = binding.etAttachementDescription.getText().toString();
                preferenceManager.putString(Constants.KEY_ATTACHMENT_DISCRIPE,attaDescription);

                f.setArguments(b);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, f).commit();

            }


        });


        binding.btBackMoodboard.setOnClickListener(view1 -> {

            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragmentContainerView, new MoodboardFragment()).commit();


        });

        return view;
    }


    private void showToast(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private Boolean isNotEmpty() {

        if (binding.etAttachementDescription.getText().toString().isEmpty()) {
            showToast("Enter Attachment Description");
            return false;

        } else
            return true;
    }

}