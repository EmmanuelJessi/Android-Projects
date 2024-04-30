package com.example.datatransfer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SharedViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        // Begin the fragment transaction
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new FragmentA()) // Replace the container with FragmentA
                .commit();
    }
}
