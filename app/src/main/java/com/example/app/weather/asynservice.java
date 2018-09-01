package com.example.app.weather;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class asynservice extends AsyncTask<Void, Void, Void> {
    static String urls, response;
    private callback callback;
    private HttpURLConnection urlConnection;

    asynservice(String url, callback callback) {
        urls = url;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        StringBuilder result = new StringBuilder();
        URL url = null;
        try {
            url = new URL(urls);
//            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.1", 8080));
            urlConnection = (HttpURLConnection) url.openConnection(/*proxy*/);
            urlConnection.setDoInput(true);
            urlConnection.setConnectTimeout(20 * 1000);
            urlConnection.setReadTimeout(20 * 1000);
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                response = result.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        try {
            this.callback.onresponse(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
