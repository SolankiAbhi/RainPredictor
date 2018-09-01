package com.example.app.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements callback {

    static callback callback;
    static TextView temptext;
    static TextView weather;
    static TextView des;
    static TextView temp;
    static TextView humidity;
    static TextView pressure;
    static TextView temp_min;
    static TextView temp_max;
    static TextView wind_speed;
    static TextView deg;
    static TextView lon;
    static TextView lat;
    static ProgressBar pb;
    LineChart mChart;
    ArrayList<Entry> entries;
    ArrayList<String> label;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callback = this;
        pb = findViewById(R.id.pb);
        pb.setVisibility(View.GONE);
        LinearLayout templay = findViewById(R.id.templay);
        temptext = findViewById(R.id.temptext);
        temp = findViewById(R.id.temp);
        weather = findViewById(R.id.weather);
        des = findViewById(R.id.des);
        temp_min = findViewById(R.id.tmp_min);
        temp_max = findViewById(R.id.tmp_max);
        wind_speed = findViewById(R.id.wind_speed);
        deg = findViewById(R.id.deg);
        lon = findViewById(R.id.lon);
        lat = findViewById(R.id.lat);
        humidity = findViewById(R.id.humidity);
        pressure = findViewById(R.id.pressure);
        Button pred_views = findViewById(R.id.btn_pred_views);

        ImageView img = findViewById(R.id.logout);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth = FirebaseAuth.getInstance();
                auth.signOut();
                startActivity(new Intent(MainActivity.this, login.class));
                finish();
            }
        });
        templay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temptext.setVisibility(View.GONE);
                pb.setVisibility(View.VISIBLE);
                library library = new library();
                asynservice asynservice = new asynservice(library.weatherurl, callback);
                asynservice.execute();
            }
        });
        pred_views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Switcher.class));
            }
        });
    }

    @Override
    public String onresponse(String response) {
        Log.d("value", response);
        try {
            pb.setVisibility(View.GONE);
            JSONObject jsonObject = new JSONObject(response);
            Toast.makeText(this, "Weather: " + jsonObject.getJSONArray("weather").getJSONObject(0).getString("main").toString(), Toast.LENGTH_SHORT).show();
            weather.setText("Weather: " + jsonObject.getJSONArray("weather").getJSONObject(0).getString("main").toString());
            des.setText("Description: " + jsonObject.getJSONArray("weather").getJSONObject(0).getString("description").toString());

            String value = String.valueOf((Double.parseDouble(jsonObject.getJSONObject("main").get("temp").toString())) / 10);
            temp.setText("Temperature: " + value.substring(0, 5));
            temp_min.setText("Temp_Min: " + (Double.parseDouble(jsonObject.getJSONObject("main").get("temp_min").toString())) / 10 + " C");
            temp_max.setText("Temp_Max: " + (Double.parseDouble(jsonObject.getJSONObject("main").get("temp_max").toString())) / 10 + " C");
            wind_speed.setText("Wind Speed: " + (Double.parseDouble(jsonObject.getJSONObject("wind").get("speed").toString())) + " m/s");
            deg.setText("Deg : " + (Double.parseDouble(jsonObject.getJSONObject("wind").get("deg").toString())));
            lon.setText("Coordinates:  lon: " + (Double.parseDouble(jsonObject.getJSONObject("coord").get("lon").toString())));
            lat.setText("Coordinates:  lon: " + (Double.parseDouble(jsonObject.getJSONObject("coord").get("lat").toString())));
            pressure.setText("Pressure: " + jsonObject.getJSONObject("main").get("pressure").toString());
            humidity.setText("Humidity: " + (jsonObject.getJSONObject("main").get("humidity")).toString() + " %");
            Log.d("value", jsonObject.getJSONObject("main").get("temp").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
