package com.example.betterbits;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkTask extends AsyncTask<URL, Integer, String> {

    private OnTaskCompletedListener listener;

    public interface OnTaskCompletedListener {
        void onTaskCompleted(String result);
        void onProgressUpdate(int progress);
    }

    public NetworkTask(OnTaskCompletedListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(URL... urls) {
        StringBuilder result = new StringBuilder();
        int count;
        try {
            URL url = urls[0];
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                int totalBytes = connection.getContentLength();
                int downloadedBytes = 0;
                char[] buffer = new char[1024];
                while ((count = reader.read(buffer)) != -1) {
                    result.append(buffer, 0, count);
                    downloadedBytes += count;
                    publishProgress((downloadedBytes * 100) / totalBytes);
                }
                inputStream.close();
            } else {
                Log.e("NetworkTask", "Error: Response Code " + responseCode);
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        if (listener != null) {
            listener.onProgressUpdate(values[0]);
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (listener != null) {
            listener.onTaskCompleted(result);
        }
    }
}

