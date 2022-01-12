package com.nasser.ma99.social_e_commerce.Fragment.CreateCopaignFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentFinancialBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;
import com.nasser.ma99.social_e_commerce.utilities.PreferenceManager;


public class FinancialFragment extends Fragment {

    FragmentFinancialBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFinancialBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        preferenceManager = new PreferenceManager(getContext());

        binding.btNextBilling.setOnClickListener(view1 -> {

       if(isNotEmpty())   {
           Bundle b = getArguments();
           Fragment f = new BillingFragment();
           preferenceManager.putString(Constants.KEY_VAT,binding.etVat.getText().toString());
           preferenceManager.putString(Constants.KEY_CR,binding.etCr.getText().toString());
           preferenceManager.putString(Constants.KEY_FINANCIAL_EMAIL,binding.rtFinancialEmail.getText().toString());

           f.setArguments(b);


           getActivity().getSupportFragmentManager().beginTransaction()
                   .replace(R.id.fragmentContainerView, f).commit();


       }

        });


        return view;
    }


    private void showToast(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private Boolean isNotEmpty() {

        if (binding.etCompanyName.getText().toString().isEmpty()) {
            showToast("Enter Compaign Name");
            return false;
        } else if (binding.etVat.getText().toString().isEmpty()) {
            showToast("Enter VAT ");
            return false;
        } else if (binding.etCr.getText().toString().isEmpty()) {
            showToast("Enter CR");
            return false;
        } else if (binding.rtFinancialEmail.getText().toString().isEmpty()) {
            showToast("Enter Financial Email");
            return false;

        } else {

            return true;

        }
    }
}