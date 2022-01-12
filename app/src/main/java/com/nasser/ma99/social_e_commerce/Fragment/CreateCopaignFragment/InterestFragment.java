package com.nasser.ma99.social_e_commerce.Fragment.CreateCopaignFragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentInterestBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;
import com.nasser.ma99.social_e_commerce.utilities.PreferenceManager;

import java.util.ArrayList;
import java.util.Set;


public class InterestFragment extends Fragment {
    FragmentInterestBinding binding;
    int couneter = 0;
    String intrest = "";
    boolean flag = false;
    private PreferenceManager preferenceManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentInterestBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        preferenceManager = new PreferenceManager(getContext());

        binding.tvBeautyfashion.setOnClickListener(view1 -> {


            if (couneter < 3) {
                flag = true ;
                binding.tvBeautyfashion.setTypeface(binding.tvBeautyfashion.getTypeface(), Typeface.BOLD);
                binding.tvBeautyfashion.setTextColor(Color.parseColor("#B74797"));
                binding.tvBeautyfashion.setEnabled(false);
                intrest = intrest + binding.tvBeautyfashion.getText().toString() ;
                couneter++;

            }


        });
        binding.tvHowtostyle.setOnClickListener(view1 -> {


            if (couneter < 3) {
                binding.tvHowtostyle.setTypeface(binding.tvHowtostyle.getTypeface(), Typeface.BOLD);
                binding.tvHowtostyle.setTextColor(Color.parseColor("#B74797"));
                binding.tvHowtostyle.setEnabled(false);
                intrest = intrest + binding.tvHowtostyle.getText().toString() ;
                couneter++;

            }

        });
        binding.tvFitnessyoga.setOnClickListener(view1 -> {

            if (couneter < 3) {
                binding.tvFitnessyoga.setTypeface(binding.tvFitnessyoga.getTypeface(), Typeface.BOLD);
                binding.tvFitnessyoga.setTextColor(Color.parseColor("#B74797"));
                binding.tvFitnessyoga.setEnabled(false);
                intrest = intrest + binding.tvFitnessyoga.getText().toString() ;
                couneter++;

            }



        });
        binding.tvTechnologieSience.setOnClickListener(view1 -> {

            if (couneter < 3) {
                binding.tvTechnologieSience.setTypeface(binding.tvTechnologieSience.getTypeface(), Typeface.BOLD);
                binding.tvTechnologieSience.setTextColor(Color.parseColor("#B74797"));
                binding.tvTechnologieSience.setEnabled(false);
                intrest = intrest + binding.tvTechnologieSience.getText().toString() ;
                couneter++;

            }



        });
        binding.tvRestaurantFoodGrocery.setOnClickListener(view1 -> {

            if (couneter < 3) {
                binding.tvRestaurantFoodGrocery.setTypeface(binding.tvRestaurantFoodGrocery.getTypeface(), Typeface.BOLD);
                binding.tvRestaurantFoodGrocery.setTextColor(Color.parseColor("#B74797"));
                binding.tvRestaurantFoodGrocery.setEnabled(false);
                intrest = intrest + binding.tvRestaurantFoodGrocery.getText().toString() ;
                couneter++;

            }



        });
        binding.tvHomeGarden.setOnClickListener(view1 -> {

            if (couneter < 3) {
                binding.tvHomeGarden.setTypeface(binding.tvHomeGarden.getTypeface(), Typeface.BOLD);
                binding.tvHomeGarden.setTextColor(Color.parseColor("#B74797"));
                binding.tvHomeGarden.setEnabled(false);
                intrest = intrest + binding.tvHomeGarden.getText().toString() ;

                couneter++;

            }



        });
        binding.tvCooking.setOnClickListener(view1 -> {

            if (couneter < 3) {
                binding.tvCooking.setTypeface(binding.tvCooking.getTypeface(), Typeface.BOLD);
                binding.tvCooking.setTextColor(Color.parseColor("#B74797"));
                binding.tvCooking.setEnabled(false);
                intrest = intrest + binding.tvCooking.getText().toString() ;
                couneter++;

            }




        });
        binding.tvHealthyLifestyle.setOnClickListener(view1 -> {

            if (couneter < 3) {
                binding.tvHealthyLifestyle.setTypeface(binding.tvHealthyLifestyle.getTypeface(), Typeface.BOLD);
                binding.tvHealthyLifestyle.setTextColor(Color.parseColor("#B74797"));
                binding.tvHealthyLifestyle.setEnabled(false);
                intrest = intrest + binding.tvHealthyLifestyle.getText().toString() ;
                couneter++;

            }



        });
        binding.tvBooksLiterature.setOnClickListener(view1 -> {

            if (couneter < 3) {

                binding.tvBooksLiterature.setTypeface(binding.tvBooksLiterature.getTypeface(), Typeface.BOLD);
                binding.tvBooksLiterature.setTextColor(Color.parseColor("#B74797"));
                binding.tvBooksLiterature.setEnabled(false);
                intrest = intrest + binding.tvBooksLiterature.getText().toString() ;
                couneter++;

            }



        });
        binding.tvMoviestv.setOnClickListener(view1 -> {

            if (couneter < 3) {

                binding.tvMoviestv.setTypeface(binding.tvMoviestv.getTypeface(), Typeface.BOLD);
                binding.tvMoviestv.setTextColor(Color.parseColor("#B74797"));
                intrest = intrest + binding.tvMoviestv.getText().toString() ;
                binding.tvMoviestv.setEnabled(false);
                couneter++;

            }


        });
        binding.tvLuxuryGoods.setOnClickListener(view1 -> {

            if (couneter < 3) {

                binding.tvLuxuryGoods.setTypeface(binding.tvLuxuryGoods.getTypeface(), Typeface.BOLD);
                binding.tvLuxuryGoods.setTextColor(Color.parseColor("#B74797"));
                intrest = intrest + binding.tvLuxuryGoods.getText().toString() ;

                binding.tvLuxuryGoods.setEnabled(false);
                couneter++;

            }



        });
        binding.tvEntertainment.setOnClickListener(view1 -> {

            if (couneter < 3) {

                binding.tvEntertainment.setTypeface(binding.tvEntertainment.getTypeface(), Typeface.BOLD);
                binding.tvEntertainment.setTextColor(Color.parseColor("#B74797"));
                binding.tvEntertainment.setEnabled(false);
                intrest = intrest + binding.tvEntertainment.getText().toString() ;
                couneter++;

            }



        });
        binding.tvChildrenFamily.setOnClickListener(view1 -> {

            if (couneter < 3) {

                binding.tvChildrenFamily.setTypeface(binding.tvChildrenFamily.getTypeface(), Typeface.BOLD);
                binding.tvChildrenFamily.setTextColor(Color.parseColor("#B74797"));
                binding.tvChildrenFamily.setEnabled(false);
                intrest = intrest + binding.tvChildrenFamily.getText().toString() ;

                couneter++;

            }



        });
        binding.tvPhotography.setOnClickListener(view1 -> {
            if (couneter < 3) {

                binding.tvPhotography.setTypeface(binding.tvPhotography.getTypeface(), Typeface.BOLD);
                binding.tvPhotography.setTextColor(Color.parseColor("#B74797"));
                binding.tvPhotography.setEnabled(false);
                intrest = intrest + binding.tvPhotography.getText().toString() ;

                couneter++;

            }



        });
        binding.tvTravelTourism.setOnClickListener(view1 -> {

            if (couneter < 3) {

                binding.tvTravelTourism.setTypeface(binding.tvTravelTourism.getTypeface(), Typeface.BOLD);
                binding.tvTravelTourism.setTextColor(Color.parseColor("#B74797"));
                binding.tvTravelTourism.setEnabled(false);
                intrest = intrest + binding.tvTravelTourism.getText().toString() ;

                couneter++;

            }



        });
        binding.tvSports.setOnClickListener(view1 -> {

            if (couneter < 3) {

                binding.tvSports.setTypeface(binding.tvSports.getTypeface(), Typeface.BOLD);
                binding.tvSports.setTextColor(Color.parseColor("#B74797"));
                binding.tvSports.setEnabled(false);
                intrest = intrest + binding.tvSports.getText().toString() ;
                couneter++;

            }



        });
        binding.tvMusic.setOnClickListener(view1 -> {

            if (couneter < 3) {

                binding.tvMusic.setTypeface(binding.tvMusic.getTypeface(), Typeface.BOLD);
                binding.tvMusic.setTextColor(Color.parseColor("#B74797"));
                binding.tvMusic.setEnabled(false);
                intrest = intrest + binding.tvMusic.getText().toString() ;
                couneter++;

            }



        });
        binding.tvArtDesign.setOnClickListener(view1 -> {

            if (couneter < 3) {

                binding.tvArtDesign.setTypeface(binding.tvArtDesign.getTypeface(), Typeface.BOLD);
                binding.tvArtDesign.setTextColor(Color.parseColor("#B74797"));
                binding.tvArtDesign.setEnabled(false);
                intrest = intrest + binding.tvArtDesign.getText().toString() ;
                couneter++;

            }



        });
        binding.tvBusinessCareers.setOnClickListener(view1 -> {

            if (couneter < 3) {

                binding.tvBusinessCareers.setTypeface(binding.tvBusinessCareers.getTypeface(), Typeface.BOLD);
                binding.tvBusinessCareers.setTextColor(Color.parseColor("#B74797"));
                binding.tvBusinessCareers.setEnabled(false);
                intrest = intrest + binding.tvBusinessCareers.getText().toString() ;
                couneter++;

            }



        });
        binding.tvCarsMotorbikes.setOnClickListener(view1 -> {

            if (couneter < 3) {

                binding.tvCarsMotorbikes.setTypeface(binding.tvCarsMotorbikes.getTypeface(), Typeface.BOLD);
                binding.tvCarsMotorbikes.setTextColor(Color.parseColor("#B74797"));
                binding.tvCarsMotorbikes.setEnabled(false);
                intrest = intrest + binding.tvCarsMotorbikes.getText().toString() ;
                couneter++;

            }



        });







        binding.btNextReview.setOnClickListener(view1 ->
    {
        if (isNotEmpty()){

            Bundle bundle = getArguments();
            Fragment f = new ReviewFragment();
            preferenceManager.putString(Constants.KEY_TARGET_CONTRY,binding.etRegion.getText().toString());
            preferenceManager.putString(Constants.KEY_INTREST,intrest);



            f.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, f).commit();

    }


    });

        binding.btBackContent.setOnClickListener(view1 ->

    {

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, new ContentFragment()).commit();


    });





        return view;
}

    private void showToast(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private Boolean isNotEmpty() {

        if (binding.etRegion.getText().toString().isEmpty()) {
            showToast("Enter Target Region ");
            return false;
        } else if (intrest.equals("")) {
            showToast("choose Interest  ");
            return false;
        } else {
            return true;

        }
    }


}