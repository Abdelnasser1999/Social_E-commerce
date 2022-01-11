package com.nasser.ma99.social_e_commerce.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nasser.ma99.social_e_commerce.Adapter.PrefManager;
import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PrefManager prefManager = new PrefManager(getApplicationContext());
        if (prefManager.isFirstTimeLaunch()) {
            prefManager.setFirstTimeLaunch(false);
            startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
            finish();
        }


    }


}