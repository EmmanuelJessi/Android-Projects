package com.example.betterbits;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements NetworkTask.OnTaskCompletedListener {

    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusTextView = findViewById(R.id.statusTextView);

        try {
            URL url = new URL("https://example.com/api/data");
            new NetworkTask(this).execute(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTaskCompleted(String result) {
        // Handle the completed task result
    }

    @Override
    public void onProgressUpdate(int progress) {
        // Update UI with progress
        statusTextView.setText("Downloading: " + progress + "%");
    }
}
