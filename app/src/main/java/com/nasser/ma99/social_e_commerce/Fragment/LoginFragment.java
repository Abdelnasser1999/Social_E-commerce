package com.nasser.ma99.social_e_commerce.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentLoginBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;


public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    String typeuser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.btBack.setOnClickListener(v -> {
            getActivity().finish();
        });

        binding.btNextSignUp.setOnClickListener(v -> {
            if (isNotEmpty()) {

                SetPasswordFragment f = new SetPasswordFragment();
                Bundle b = new Bundle();
                typeuser = getActivity().getIntent().getStringExtra("type");
                b.putString(Constants.KEY_NAME, binding.etName.getText().toString());
                b.putString(Constants.KEY_EMAIL, binding.etEmail.getText().toString());
                b.putString(Constants.KEY_MOBILE, binding.etMobile.getText().toString());
                b.putString(Constants.KEY_PHONE, binding.etPhone.getText().toString());
                f.setArguments(b);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView4, f).commit();

            }


        });


        return view;
    }

    private void ToastMessage(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private Boolean isNotEmpty() {

        if (binding.etName.getText().toString().isEmpty()) {
            ToastMessage("Enter Name !! ");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.getText().toString()).matches()) {
            ToastMessage("Enter a Valid Email !!");
            return false;

        } else if (binding.etMobile.getText().toString().isEmpty()) {
            ToastMessage("Enter Mobile Number !! ");
            return false;

        } else if (binding.etPhone.getText().toString().isEmpty()) {
            ToastMessage("Enter Phone Number !!");
            return false;

        } else {
            return true;
        }


    }
}