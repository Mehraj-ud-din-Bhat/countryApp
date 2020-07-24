package com.mehraj.assignment.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mehraj.assignment.R;
import com.mehraj.assignment.UI.countries.CountriesList;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(Splash.this, CountriesList.class);
                startActivity(i);
                finish();
            }
        }, 2100);


    }
}
