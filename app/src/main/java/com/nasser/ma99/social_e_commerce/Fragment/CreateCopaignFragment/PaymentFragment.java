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
import com.nasser.ma99.social_e_commerce.databinding.FragmentPaymentBinding;
import com.nasser.ma99.social_e_commerce.databinding.FragmentSetBreifBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;
import com.nasser.ma99.social_e_commerce.utilities.PreferenceManager;

import java.util.ArrayList;

public class PaymentFragment extends Fragment {

    FragmentPaymentBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPaymentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        preferenceManager = new PreferenceManager(getContext());
        binding.btNextFinancial.setOnClickListener(view1 -> {

          if(isNotEmpty()) {

              Bundle b = new Bundle();
              Fragment f = new FinancialFragment();


              preferenceManager.putString(Constants.KEY_PAYMENT_TYPE,binding.etPaymentType.getText().toString());
              preferenceManager.putString(Constants.KEY_PUBLISHDATE,binding.etPublishdate.getText().toString());
              preferenceManager.putString(Constants.KEY_ENDDATE,binding.etEndDate.getText().toString());
              preferenceManager.putString(Constants.KEY_FIRST_NAME_MANGER,binding.etFirstNameManger.getText().toString());
              preferenceManager.putString(Constants.KEY_LAST_NAME_MANGER,binding.etLastNameManger.getText().toString());
              preferenceManager.putString(Constants.KEY_EMAIL_MANGER,binding.etEmailManger.getText().toString());
              preferenceManager.putString(Constants.KEY_MOBILE_NUMBER_NAME_MANGER,binding.etMobileManger.getText().toString());

              f.setArguments(b);


              getActivity().getSupportFragmentManager().beginTransaction()
                      .replace(R.id.fragmentContainerView, f).commit();

          }



        });

        binding.btBackPrelaoded.setOnClickListener(view1 -> {

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new PrelaodedFragment()).commit();


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

    private void showToast(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private Boolean isNotEmpty() {

        if (binding.etPaymentType.getText().toString().isEmpty()) {
            showToast("Enter Payment Type ");
            return false;
        } else if (binding.etPublishdate.getText().toString().isEmpty()) {
            showToast("Enter Publish date ");
            return false;
        } else if (binding.etEndDate.getText().toString().isEmpty()) {
            showToast("Enter End Date");
            return false;
        } else if (binding.etFirstNameManger.getText().toString().isEmpty()) {
            showToast("Enter First Name Manger");
            return false;

        } else if (binding.etLastNameManger.getText().toString().isEmpty()) {
            showToast("Enter Last Name Manger ");
            return false;

        } else if (binding.etEmailManger.getText().toString().isEmpty()) {
        showToast("Enter  Email Manger");
        return false;

    } else if (binding.etMobileManger.getText().toString().isEmpty()) {
        showToast("Enter  Mobile Manger");
        return false;

    } else {

            return true;

        }
    }
}