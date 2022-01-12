package com.nasser.ma99.social_e_commerce.Activity.ui.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.nasser.ma99.social_e_commerce.Activity.AddCompaignActivity;
import com.nasser.ma99.social_e_commerce.Activity.MainActivity;
import com.nasser.ma99.social_e_commerce.Adapter.CompanyAdapter;
import com.nasser.ma99.social_e_commerce.Model.campaignModel;
import com.nasser.ma99.social_e_commerce.databinding.FragmentHomeBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;
import com.nasser.ma99.social_e_commerce.utilities.PreferenceManager;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    FirebaseFirestore database;
    CompanyAdapter companyAdapter;
    private PreferenceManager preferenceManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        preferenceManager = new PreferenceManager(getContext());

        database = FirebaseFirestore.getInstance();

        binding.addCompany.setOnClickListener(v -> {

            Intent i = new Intent(getActivity(), AddCompaignActivity.class);
            startActivity(i);
            getActivity().finish();

        });

        binding.addCompanyBotton.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), AddCompaignActivity.class);
            startActivity(i);
            getActivity().finish();
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.reycler.setLayoutManager(linearLayoutManager);
        getAllUpcoming();
        return root;
    }

    private ArrayList<campaignModel> getAllUpcoming() {
        ProgressDialog pd = new ProgressDialog(getActivity());
        pd.setCancelable(false);
        pd.show();

        ArrayList<campaignModel> DATA = new ArrayList<>();
        //db.collection("users").limit(2).orderBy("name", Query.Direction.DESCENDING).get()
        database.collection(Constants.KEY_COLLECTION_COMPAIGN).whereEqualTo(Constants.KEY_USER,preferenceManager.getString(Constants.KEY_USER_ID)).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {

                            campaignModel hotel = documentSnapshot.toObject(campaignModel.class);
                            DATA.add(hotel);

                        }
                        Log.e("HZM",DATA.size()+"");
                        companyAdapter = new CompanyAdapter(getActivity(), DATA);
                        binding.reycler.setAdapter(companyAdapter);
                        pd.dismiss();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("hzm", e.getMessage());
            }
        });
        return DATA;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}