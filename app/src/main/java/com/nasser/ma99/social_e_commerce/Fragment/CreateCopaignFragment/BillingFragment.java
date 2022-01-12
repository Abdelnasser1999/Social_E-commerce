package com.nasser.ma99.social_e_commerce.Fragment.CreateCopaignFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.nasser.ma99.social_e_commerce.Activity.MainAppActivity;
import com.nasser.ma99.social_e_commerce.Model.UserModel;
import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.ActivityMainAppBinding;
import com.nasser.ma99.social_e_commerce.databinding.FragmentBillingBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;
import com.nasser.ma99.social_e_commerce.utilities.PreferenceManager;

import java.util.ArrayList;
import java.util.HashMap;


public class BillingFragment extends Fragment {

    FragmentBillingBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBillingBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        preferenceManager = new PreferenceManager(getContext());

        binding.tvSubmit.setOnClickListener(v -> {

            Save();
        });

        return view;
    }

    private void Save() {

        loading(true);
        Bundle b = new Bundle();

        int price = Integer.parseInt(preferenceManager.getString(Constants.KEY_PRICE));

        FirebaseFirestore database = FirebaseFirestore.getInstance();
        HashMap<String, Object> company = new HashMap<>();
        company.put(Constants.KEY_USER, preferenceManager.getString(Constants.KEY_USER_ID));
        company.put(Constants.KEY_BRAND_NAME, preferenceManager.getString(Constants.KEY_BRAND_NAME));
        company.put(Constants.KEY_BRAND_DISCRIPE, preferenceManager.getString(Constants.KEY_BRAND_DISCRIPE));
        company.put(Constants.KEY_CATAGORIS, preferenceManager.getString(Constants.KEY_CATAGORIS));
        company.put(Constants.KEY_URL_BRAND, preferenceManager.getString(Constants.KEY_URL_BRAND));
        company.put(Constants.KEY_IMAGE_BRAND, preferenceManager.getString(Constants.KEY_IMAGE_BRAND));
        company.put(Constants.KEY_IMAGE_COMP, preferenceManager.getString(Constants.KEY_IMAGE_COMP));
        company.put(Constants.KEY_COMP_NAME, preferenceManager.getString(Constants.KEY_COMP_NAME));
        company.put(Constants.KEY_COMP_TYPE, preferenceManager.getString(Constants.KEY_COMP_TYPE));
        company.put(Constants.KEY_COMP_DESCRIPTION, preferenceManager.getString(Constants.KEY_COMP_DESCRIPTION));
        company.put(Constants.KEY_CALL_TO_ACTION, preferenceManager.getString(Constants.KEY_CALL_TO_ACTION));
        company.put(Constants.KEY_PRELAODED, preferenceManager.getString(Constants.KEY_PRELAODED));
        company.put(Constants.KEY_MOODBOARD, preferenceManager.getString(Constants.KEY_MOODBOARD));
        company.put(Constants.KEY_DO, preferenceManager.getString(Constants.KEY_DO));
        company.put(Constants.KEY_DONT, preferenceManager.getString(Constants.KEY_DONT));
        company.put(Constants.KEY_ATTACHMENT_DISCRIPE, preferenceManager.getString(Constants.KEY_ATTACHMENT_DISCRIPE));
        company.put(Constants.KEY_AGE, preferenceManager.getString(Constants.KEY_AGE));
        company.put(Constants.KEY_PRICE, price);
        company.put(Constants.KEY_INFLUENCER_TYPE, preferenceManager.getString(Constants.KEY_INFLUENCER_TYPE));
        company.put(Constants.KEY_GENDER, preferenceManager.getString(Constants.KEY_GENDER));
        company.put(Constants.KEY_TARGET_CONTRY, preferenceManager.getString(Constants.KEY_TARGET_CONTRY));
        company.put(Constants.KEY_INTREST, preferenceManager.getString(Constants.KEY_INTREST));
        company.put(Constants.KEY_PAYMENT_TYPE, preferenceManager.getString(Constants.KEY_PAYMENT_TYPE));
        company.put(Constants.KEY_PUBLISHDATE, preferenceManager.getString(Constants.KEY_PUBLISHDATE));
        company.put(Constants.KEY_ENDDATE, preferenceManager.getString(Constants.KEY_ENDDATE));
        company.put(Constants.KEY_FIRST_NAME_MANGER, preferenceManager.getString(Constants.KEY_FIRST_NAME_MANGER));
        company.put(Constants.KEY_LAST_NAME_MANGER, preferenceManager.getString(Constants.KEY_LAST_NAME_MANGER));
        company.put(Constants.KEY_EMAIL_MANGER, preferenceManager.getString(Constants.KEY_EMAIL_MANGER));
        company.put(Constants.KEY_MOBILE_NUMBER_NAME_MANGER, preferenceManager.getString(Constants.KEY_MOBILE_NUMBER_NAME_MANGER));
        company.put(Constants.KEY_VAT, preferenceManager.getString(Constants.KEY_VAT));
        company.put(Constants.KEY_CR, preferenceManager.getString(Constants.KEY_CR));
        company.put(Constants.KEY_FINANCIAL_EMAIL, preferenceManager.getString(Constants.KEY_FINANCIAL_EMAIL));
        company.put(Constants.KEY_FINANCIAL_PHONE, binding.etFinancialPhone.getText().toString());
        company.put(Constants.KEY_STREET_ADRESS, binding.etStreet.getText().toString());
        company.put(Constants.KEY_CITY, binding.etCity.getText().toString());
        company.put(Constants.KEY_WILAYA, binding.etWilaya.getText().toString());
        company.put(Constants.KEY_COMPANY_ID, "1");
        company.put(Constants.KEY_POST_ZIP, binding.etPostZip.getText().toString());
        company.put(Constants.KEY_PRAND_PLATFORMS, preferenceManager.getString(Constants.KEY_PRAND_PLATFORMS));


        database.collection(Constants.KEY_COLLECTION_COMPAIGN)
                .add(company)
                .addOnSuccessListener(documentReference -> {
                    loading(false);
                    showToast("Save Successfully");
                    Intent intent = new Intent(getActivity(), MainAppActivity.class);
                    getActivity().startActivity(intent);
                    getActivity().finish();

                })
                .addOnFailureListener(Exception -> {
                    loading(false);
                    showToast(Exception.getMessage());
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

        if (binding.etFinancialPhone.getText().toString().isEmpty()) {
            showToast("Enter Brand Name");
            return false;
        } else if (binding.etStreet.getText().toString().isEmpty()) {
            showToast("Enter Descripetion of Brand");
            return false;
        } else if (binding.etCity.getText().toString().isEmpty()) {
            showToast("Enter Catagorie");
            return false;
        } else if (binding.etWilaya.getText().toString().isEmpty()) {
            showToast("Enter Url Brand");
            return false;
        } else if (binding.etPostZip.getText().toString().isEmpty()) {
            showToast("Enter Url Brand");
            return false;
        } else {

            return true;

        }
    }
}