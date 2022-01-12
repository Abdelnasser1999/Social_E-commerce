package com.nasser.ma99.social_e_commerce.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.nasser.ma99.social_e_commerce.Activity.MainAppActivity;
import com.nasser.ma99.social_e_commerce.Model.UserModel;
import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentLoginBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;
import com.nasser.ma99.social_e_commerce.utilities.PreferenceManager;

import java.util.ArrayList;


public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    String typeuser;
    private PreferenceManager preferenceManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        preferenceManager = new PreferenceManager(getActivity().getApplicationContext());

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
            else {
                Toast.makeText(getContext(), "Email iS Already exists", Toast.LENGTH_SHORT).show();

            }


        });


        return view;
    }

    private ArrayList<UserModel> checkdoublicat() {

        ArrayList<UserModel> DATA = new ArrayList<>();

        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection(Constants.KEY_COLLECTION_USERS)
               .whereEqualTo(Constants.KEY_EMAIL,binding.etEmail.getText().toString()).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            UserModel userModel = documentSnapshot.toObject(UserModel.class);
                            DATA.add(userModel);

                        }
                        if(DATA.size()>0){
                            preferenceManager.putBoolean("Isdublicate",false);
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        return DATA;
    }

    private void showToast(String message) {

        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
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