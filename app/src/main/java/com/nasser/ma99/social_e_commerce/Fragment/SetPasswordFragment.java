package com.nasser.ma99.social_e_commerce.Fragment;

import android.content.Intent;
import android.os.Bundle;


import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nasser.ma99.social_e_commerce.Activity.AddCompaignActivity;
import com.nasser.ma99.social_e_commerce.Activity.MainActivity;
import com.nasser.ma99.social_e_commerce.Activity.MainAppActivity;
import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentSetPasswordBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;
import com.nasser.ma99.social_e_commerce.utilities.PreferenceManager;

import java.util.HashMap;
import java.util.UUID;

public class SetPasswordFragment extends Fragment {

    FragmentSetPasswordBinding binding;
    String name, email, mobile, phone, password, confirmpassword, typeuser;
    private PreferenceManager preferenceManger;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSetPasswordBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        preferenceManger = new PreferenceManager(getActivity().getApplicationContext());

        name = getArguments().getString(Constants.KEY_NAME);
        email = getArguments().getString(Constants.KEY_EMAIL);
        mobile = getArguments().getString(Constants.KEY_MOBILE);
        phone = getArguments().getString(Constants.KEY_PHONE);
        typeuser = getActivity().getIntent().getStringExtra("type");

        Log.e("Hun", typeuser);

        binding.btBack.setOnClickListener(v -> {

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView4, new LoginFragment()).commit();

        });

        binding.tvSignupAtLogin.setOnClickListener(v -> {
            if (isNotEmpty()) {

                if (binding.checkBoxSignUp.isChecked()) {
                    password = binding.etPassword.getText().toString();
                    confirmpassword = binding.etConfirmPassword.getText().toString();
                    signUp();

                } else
                    showToast("Please Accept Terme and Conditions");

            }

        });


        return view;
    }
    public String main() {
        final String uuid = UUID.randomUUID().toString().replace("-", "");
        return  uuid;
    }

    private void signUp() {
        loading(true);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        HashMap<String, Object> user = new HashMap<>();
        user.put(Constants.KEY_NAME, name);
        user.put(Constants.KEY_EMAIL, email);
        user.put(Constants.KEY_PASSWORD, password);
        user.put(Constants.KEY_PHONE, phone);
        user.put(Constants.KEY_MOBILE, mobile);
        user.put(Constants.KEY_TYPE_USER, typeuser);
        user.put(Constants.KEY_IS_VALID, 0);
        user.put(Constants.KEY_WALLET, 0.0);
        user.put(Constants.KEY_USER_ID,main());


        database.collection(Constants.KEY_COLLECTION_USERS)
                .add(user)
                .addOnSuccessListener(documentReference -> {
                    loading(false);
                    preferenceManger.putBoolean(Constants.KEY_IS_SIGNED_IN, true);
                    preferenceManger.putString(Constants.KEY_USER_ID, documentReference.getId());
                    preferenceManger.putString(Constants.KEY_NAME, name);
                    preferenceManger.putString(Constants.KEY_EMAIL, email);
                    Intent intent = new Intent(getContext(), AddCompaignActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                })
                .addOnFailureListener(Exception -> {
                    loading(false);
                    showToast(Exception.getMessage());

                });

    }

    private void showToast(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private Boolean isNotEmpty() {

        if (binding.etPassword.getText().toString().trim().isEmpty()) {
            showToast("Enter Password");
            return false;
        } else if (binding.etConfirmPassword.getText().toString().trim().isEmpty()) {
            showToast("Confirm your password");
            return false;
        } else if (!binding.etPassword.getText().toString().equals(binding.etConfirmPassword.getText().toString())) {
            showToast("Password & confirm password must be same");
            return false;
        } else {

            return true;

        }


    }

    private void loading(Boolean isLoading) {

        if (isLoading) {

            binding.progressBar.setVisibility(View.VISIBLE);

        } else {
            binding.progressBar.setVisibility(View.INVISIBLE);


        }
    }
}