package com.example.app.weather;

import org.json.JSONException;

public interface callback {
    String onresponse(String response) throws JSONException;
}
