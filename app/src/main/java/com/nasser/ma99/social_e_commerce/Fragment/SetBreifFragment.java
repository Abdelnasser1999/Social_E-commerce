package com.nasser.ma99.social_e_commerce.Fragment;

import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentSetBreifBinding;

import java.util.ArrayList;


public class SetBreifFragment extends Fragment {
    FragmentSetBreifBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSetBreifBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String select = binding.spinner.getSelectedItem().toString();

                binding.etCompaignType.setText(select);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                binding.etCompaignType.setText("");
            }
        });


        binding.btBackCreatecom.setOnClickListener(view1 -> {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView,new CreateCopaignFragment()).commit();

        });

        binding.spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String select = binding.spinner2.getSelectedItem().toString();

                binding.tvSpinner2Type.setText(select);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                binding.etCompaignType.setText("");
            }
        });

        binding.btNextMoodBoard.setOnClickListener(view1 -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView,new MoodboardFragment()).commit();

        });


        return view;


    }
}