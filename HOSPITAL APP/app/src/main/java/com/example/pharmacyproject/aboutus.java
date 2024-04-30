package com.example.pharmacyproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class aboutus extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        // Get the TextView reference
        TextView textViewWelcomeMessage = findViewById(R.id.textViewDescription);

        // Retrieve the user's name (you would replace this with your actual logic)
        String userName = getUserFullName();

        // Display a personalized welcome message
        textViewWelcomeMessage.setText("Welcome, " + userName + "!");
    }

    // Example method to retrieve user's name (replace this with your actual logic)
    private String getUserFullName() {
        // For demonstration purposes, returning a hardcoded name
        return "Santiago Hospital is a beacon of care and compassion, dedicated to serving our community with excellence in healthcare. With a legacy spanning decades, we stand as a pillar of support for patients and their families, offering cutting-edge medical expertise combined with a warm and welcoming environment. Our team of skilled professionals works tirelessly to provide personalized care, ensuring the highest standards of treatment and comfort for every individual who walks through our doors. At Santiago Hospital, we believe in the power of healing, and it is our privilege to accompany our patients on their journey towards wellness and recovery.";
    }
}

