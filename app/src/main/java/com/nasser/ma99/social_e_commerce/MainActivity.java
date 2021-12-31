package com.nasser.ma99.social_e_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nasser.ma99.social_e_commerce.Adapter.PrefManager;


public class MainActivity extends AppCompatActivity {
    TextView signup,signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PrefManager prefManager = new PrefManager(getApplicationContext());
        if(prefManager.isFirstTimeLaunch()){
            prefManager.setFirstTimeLaunch(false);
            startActivity(new Intent(MainActivity.this,WelcomeActivity.class));
            finish();
        }

        signup = (TextView)findViewById(R.id.tv_signup);

        signup.setOnClickListener(view -> {

            Intent i = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(i);

        });



    }


}