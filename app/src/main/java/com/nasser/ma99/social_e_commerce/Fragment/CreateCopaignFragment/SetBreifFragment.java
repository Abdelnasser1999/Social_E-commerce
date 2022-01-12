package com.nasser.ma99.social_e_commerce.Fragment.CreateCopaignFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.nasser.ma99.social_e_commerce.Model.campaignModel;
import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentSetBreifBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;
import com.nasser.ma99.social_e_commerce.utilities.PreferenceManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class SetBreifFragment extends Fragment {
    FragmentSetBreifBinding binding;
    private FirebaseFirestore database;

    private PreferenceManager preferenceManager;
    String platforms = "";
    String instegram = "", facebook = "", tiktok = "", youtube = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSetBreifBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        database = FirebaseFirestore.getInstance();
        preferenceManager = new PreferenceManager(getContext());


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
            if (isNotEmpty()) {
                String companyname = binding.etCompaignName.getText().toString();
                String companytype = binding.etCompaignType.getText().toString();
                String companydescription = binding.etCompaignDescription.getText().toString();
                String calltoaction = binding.etCallToAction.getText().toString();

                String preloaded = binding.etPreloadedContent.getText().toString();

                Bundle b = getArguments();
                platforms = instegram + facebook +tiktok +youtube;
                preferenceManager.putString(Constants.KEY_COMP_NAME, companyname);
                preferenceManager.putString(Constants.KEY_COMP_TYPE, companytype);
                preferenceManager.putString(Constants.KEY_COMP_DESCRIPTION, companydescription);
                preferenceManager.putString(Constants.KEY_CALL_TO_ACTION, calltoaction);
                preferenceManager.putString(Constants.KEY_PRAND_PLATFORMS, platforms);
                preferenceManager.putString(Constants.KEY_PRELAODED, preloaded);
                Fragment f = new MoodboardFragment();
                f.setArguments(b);


                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView,f).commit();

            }

        });
        binding.tvSaveAtSettheBreif.setOnClickListener(v -> {

            if (isNotEmpty()) {

            }
        });
        binding.instegram.setOnClickListener(v1 -> {
            instegram = "instegram , ";
            binding.instegram.setBackgroundResource(R.drawable.et_shap);

        });

        binding.facebook.setOnClickListener(v2 -> {
            facebook = "facebook , ";
            binding.facebook.setBackgroundResource(R.drawable.et_shap);

        });
        binding.tiktok.setOnClickListener(v3 -> {
            tiktok = "tiktok , ";
            binding.tiktok.setBackgroundResource(R.drawable.et_shap);

        });
        binding.youtube.setOnClickListener(v4 -> {
            youtube = "youtube , ";
            binding.youtube.setBackgroundResource(R.drawable.et_shap);

        });


        return view;

    }


/*
    public void update(String Companyid,String id, String imagecomp, String imagebrand, String brandname, String branddiscripe, ArrayList<String> catagorie, String urlbarnd, String copmname, String coptype, String copdescription, String calltoaction, ArrayList<String> platforms, String prelaoded, String moodboard, String aDo, String dont, String attachmentdiscripe, String age, int price, String influencertype, String gender, String targetcontry, String intrest, String paymenttype, String publishdate, String enddate, String firstnamemaneger, String lastnamemaneger, String emailmaneger, String mobilemanegernumber, String companyname, String vat, String cr, String financialEmail, String financialphone, String streetadress, String city, String wilaya, String zip, ArrayList<String> billingAddress) {
        campaignModel company = new campaignModel(Companyid,id, imagecomp, imagebrand, brandname, branddiscripe, catagorie, urlbarnd, copmname, coptype, copdescription, calltoaction, platforms, prelaoded, moodboard, aDo, dont, attachmentdiscripe, age, price, influencertype, gender, targetcontry, intrest, paymenttype, publishdate, enddate, firstnamemaneger, lastnamemaneger, emailmaneger, mobilemanegernumber, companyname, vat, cr, financialEmail, financialphone, streetadress, city, wilaya, zip, billingAddress);

        database.collection(Constants.KEY_COLLECTION_COMPAIGN).document(id)
                .set(company)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("hzm", e.getMessage());
            }
        });
    }
*/

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

    //             update(DATA.get(0).getUserid(), DATA.get(0).getImagecomp(), DATA.get(0).getImagebrand(), DATA.get(0).getBrandname(), DATA.get(0).getBranddiscripe(), DATA.get(0).getCatagorie(), DATA.get(0).getUrlbarnd(), DATA.get(0).getCopmname(), DATA.get(0).getCoptype(), DATA.get(0).getCopdescription(), DATA.get(0).getCalltoaction(), DATA.get(0).getPlatforms(), DATA.get(0).getPrelaoded(), DATA.get(0).getMoodboard(), DATA.get(0).getDo(), DATA.get(0).getDont(), DATA.get(0).getAttachmentdiscripe(), DATA.get(0).getAge(), DATA.get(0).getPrice(), DATA.get(0).getInfluencertype(), DATA.get(0).getGender(), DATA.get(0).getTargetcontry(), DATA.get(0).getIntrest(), DATA.get(0).getPaymenttype(), DATA.get(0).getPublishdate(), DATA.get(0).getEnddate(), DATA.get(0).getFirstnamemaneger(), DATA.get(0).getLastnamemaneger(), DATA.get(0).getEmailmaneger(), DATA.get(0).getMobilemanegernumber(), DATA.get(0).getCompanyname(), DATA.get(0).getVat(), DATA.get(0).getCr()
    //                                , DATA.get(0).getFinancialEmail(), DATA.get(0).getFinancialphone(), DATA.get(0).getStreetadress(), DATA.get(0).getCity(), DATA.get(0).getWilaya(), DATA.get(0).getZip(), DATA.get(0).getBillingAddress());
}