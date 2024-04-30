package com.example.betterbits;

import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class BetterBitsAsyncTask extends AsyncTask<Void, Integer, String> {

    private static final String TAG = "BetterBitsAsyncTask";
    private BetterBitsListener mListener;

    public interface BetterBitsListener {
        void onProgressUpdate(int progress);

        void onTaskComplete(String result);

        void onError(String error);
    }

    public BetterBitsAsyncTask(BetterBitsListener listener) {
        mListener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Perform any setup or UI changes before task execution
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            // Simulate a long-running task
            for (int i = 0; i <= 100; i += 10) {
                Thread.sleep(1000); // Simulate some work
                publishProgress(i);
            }

            // Code to make HTTPSUrlConnection request
            URL url = new URL("your_url_here");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();

        } catch (IOException | InterruptedException e) {
            Log.e(TAG, "Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mListener.onProgressUpdate(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (result != null) {
            mListener.onTaskComplete(result);
        } else {
            mListener.onError("An error occurred during network request");
        }
    }
}
