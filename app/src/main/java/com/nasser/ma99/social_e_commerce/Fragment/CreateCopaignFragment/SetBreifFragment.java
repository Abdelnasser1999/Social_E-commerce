package com.nasser.ma99.social_e_commerce.Fragment.CreateCopaignFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentSetBreifBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;

import java.util.HashMap;


public class SetBreifFragment extends Fragment {
    FragmentSetBreifBinding binding;

    Boolean isSave = false;

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
                    .replace(R.id.fragmentContainerView, new CreateCopaignFragment()).commit();

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
            if(isNotEmpty()) {
                Save();


            }

        });
        binding.tvSaveAtSettheBreif.setOnClickListener(v -> {

            if (isNotEmpty()) {
                Save();
            }
        });


        return view;


    }

    private void Save() {
        loading(true);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        HashMap<String, Object> company = new HashMap<>();
        company.put(Constants.KEY_COMP_NAME, binding.etCompaignName.getText().toString());
        company.put(Constants.KEY_COMP_TYPE, binding.etCompaignType.getText().toString());
        company.put(Constants.KEY_COMP_DESCRIPTION, binding.etCompaignDescription.getText().toString());
        company.put(Constants.KEY_CALL_TO_ACTION, binding.etCallToAction.getText().toString());
        company.put(Constants.KEY_PRELAODED, binding.etPreloadedContent.getText().toString());

        database.collection(Constants.KEY_COLLECTION_COMPAIGN)
                .add(company)
                .addOnSuccessListener(documentReference -> {
                    loading(false);
                    showToast("Save Successfully");

                })
                .addOnFailureListener(Exception -> {
                    loading(false);

                    showToast("Save Failed");

                });

    }

    private void loading(Boolean isLoading) {

        if (isLoading) {
            binding.progressBar.setVisibility(View.VISIBLE);

        } else {
            binding.progressBar.setVisibility(View.INVISIBLE);

        }
    }

    private void showToast(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private Boolean isNotEmpty() {

        if (binding.etCompaignName.getText().toString().isEmpty()) {
            showToast("Enter Compaign Name");
            return false;
        } else if (binding.etCompaignType.getText().toString().isEmpty()) {
            showToast("Enter Compaign Type ");
            return false;
        } else if (binding.etCompaignDescription.getText().toString().isEmpty()) {
            showToast("Enter Compaign Description");
            return false;
        } else if (binding.etCallToAction.getText().toString().isEmpty()) {
            showToast("Enter Call To Action");
            return false;

        } else if (binding.etPreloadedContent.getText().toString().isEmpty()) {
            showToast("Enter Preloaded Content");
            return false;

        } else {

            return true;

        }
    }
}