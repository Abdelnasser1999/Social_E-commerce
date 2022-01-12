package com.nasser.ma99.social_e_commerce.Fragment.CreateCopaignFragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentContentBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;
import com.nasser.ma99.social_e_commerce.utilities.PreferenceManager;


public class ContentFragment extends Fragment {
    FragmentContentBinding binding;
    private PreferenceManager preferenceManager;
    String type;
    String Gender;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentContentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        preferenceManager = new PreferenceManager(getContext());


        binding.tvGeneric.setOnClickListener(v -> {
            type = "Generic";
            binding.tvGeneric.setTextColor(Color.parseColor("#FF000000"));
            binding.tvElite.setTextColor(Color.parseColor("#FFFFFFFF"));

        });
        binding.tvElite.setOnClickListener(v -> {
            type = "Elite";
            binding.tvElite.setTextColor(Color.parseColor("#FF000000"));
            binding.tvGeneric.setTextColor(Color.parseColor("#FFFFFFFF"));

        });

        binding.tvGenderMale.setOnClickListener(v -> {
            Gender = "Male";
            binding.tvGenderMale.setTextColor(Color.parseColor("#FF000000"));
            binding.tvGenderFemale.setTextColor(Color.parseColor("#FFFFFFFF"));

        });
        binding.tvGenderFemale.setOnClickListener(v -> {
            Gender = "Female";
            binding.tvGenderFemale.setTextColor(Color.parseColor("#FF000000"));
            binding.tvGenderMale.setTextColor(Color.parseColor("#FFFFFFFF"));

        });


        binding.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.tvAge.setText(i + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        binding.btNextInterest.setOnClickListener(view1 -> {

            if(isNotEmpty()) {

                Bundle b = getArguments();
                Fragment f = new InterestFragment();
                preferenceManager.putString(Constants.KEY_INFLUENCER_TYPE, type);
                preferenceManager.putString(Constants.KEY_GENDER, Gender);
                preferenceManager.putString(Constants.KEY_AGE, binding.tvAge.getText().toString());
                preferenceManager.putString(Constants.KEY_PRICE, binding.etPrice.getText().toString());
                preferenceManager.putString(Constants.KEY_TARGET_CONTRY, binding.etTargetCountry.getText().toString());

                f.setArguments(b);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, f).commit();

            }
        });

        binding.btBackMooddecrip.setOnClickListener(view1 -> {

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new MoodDescriptionFragment()).commit();


        });


        return view;
    }

    private void showToast(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private Boolean isNotEmpty() {

        if (binding.etPrice.getText().toString().isEmpty()) {
            showToast("Enter Price");
            return false;

        } else if (binding.etTargetCountry.getText().toString().isEmpty()) {
            showToast("Enter Target Country");
            return false;
        } else if (type.isEmpty()) {
            showToast("choose type influencer ");
            return false;

        } else if (Gender.isEmpty()) {
            showToast("choose YOUR Gender  ");
            return false;
        } else
            return true;
    }
}