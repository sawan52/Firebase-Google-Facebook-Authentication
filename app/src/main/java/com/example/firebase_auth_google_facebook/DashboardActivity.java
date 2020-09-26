package com.example.firebase_auth_google_facebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button logOut = findViewById(R.id.logOutButton);
        TextView id = findViewById(R.id.id_textView);
        TextView name = findViewById(R.id.name_textView);
        TextView email = findViewById(R.id.email_textView);
        ImageView photo = findViewById(R.id.photo_imageView);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        String ID = currentUser.getUid();
        String NAME = currentUser.getDisplayName();
        String EMAIL = currentUser.getEmail();

        id.setText(ID);
        name.setText(NAME);
        email.setText(EMAIL);

        Glide.with(this).load(currentUser.getPhotoUrl()).into(photo);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent = new Intent(DashboardActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
