package com.example.betterbits;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements BetterBitsAsyncTask.BetterBitsListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Execute the AsyncTask
        new BetterBitsAsyncTask(this).execute();
    }

    @Override
    public void onProgressUpdate(int progress) {
        // Update UI with progress
    }

    @Override
    public void onTaskComplete(String result) {
        // Handle task completion
    }

    @Override
    public void onError(String error) {
        // Handle error
    }
}