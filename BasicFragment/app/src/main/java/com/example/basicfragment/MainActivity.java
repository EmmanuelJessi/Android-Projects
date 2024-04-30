package com.example.basicfragment;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new Fragment1());
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void setDataToFragment2(String data) {
        Fragment2 fragment2 = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putString("data", data);
        fragment2.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment2);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void setDataToFragment1(String data) {
        Fragment1 fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        if (fragment1 != null) {
            fragment1.updateData(data);
        }
    }
}


