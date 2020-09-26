package com.example.firebase_auth_google_facebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        final FirebaseUser currentUser = mAuth.getCurrentUser();

        int TIME_OUT = 2000;

        /**
         * If user is not authenticated then send him to SignInActivity to authenticate first,
         * else send him to DashboardActivity
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentUser != null) {
                    Intent dashboardIntent = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(dashboardIntent);
                    finish();
                } else {
                    Intent signInIntent = new Intent(MainActivity.this, SignInActivity.class);
                    startActivity(signInIntent);
                    finish();
                }
            }
        }, TIME_OUT);

    }
}
