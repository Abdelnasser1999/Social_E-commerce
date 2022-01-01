package com.nasser.ma99.social_e_commerce.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.kofigyan.stateprogressbar.StateProgressBar;
import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    String[] descriptionData = {"Step 1", "Step 2"};
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        StateProgressBar stateProgressBar = findViewById(R.id.your_state_progress_bar_id);
        stateProgressBar.setStateDescriptionData(descriptionData);


        binding.tvSignupAtLogin.setOnClickListener(view -> {
            String type = getIntent().getStringExtra("type");

            if(type.equals("Influencer"))
            {
                Intent i = new Intent(LoginActivity.this,InfluencerCreateActivity.class);
                startActivity(i);

            }

            else
                {
                    Intent i = new Intent(LoginActivity.this,AddCompaignActivity.class);
                    startActivity(i);
                }




        });











/*
        // button given along with id
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (stateProgressBar.getCurrentStateNumber()) {
                    case 1:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                        break;
                    case 2:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                        break;

                }
            }
        });*/
    }
}
