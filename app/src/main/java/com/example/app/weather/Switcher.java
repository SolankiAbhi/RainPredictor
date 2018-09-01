package com.example.app.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Switcher extends AppCompatActivity {
    LineChart mChart;
    ArrayList<Entry> entries;
    ArrayList<String> label;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switcher);

        LinearLayout ll1 = findViewById(R.id.ll1);
        LinearLayout ll2 = findViewById(R.id.ll2);
        LinearLayout ll3 = findViewById(R.id.ll3);
        LinearLayout ll4 = findViewById(R.id.ll4);
        LinearLayout ll5 = findViewById(R.id.ll5);
        LinearLayout ll6 = findViewById(R.id.ll6);
        LinearLayout ll7 = findViewById(R.id.ll7);
        LinearLayout ll8 = findViewById(R.id.ll8);
        LinearLayout templay = findViewById(R.id.templay);

        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Switcher.this, RainfallView.class));
            }
        });
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Switcher.this, MeanTempView.class));
            }
        });
        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Switcher.this, MaxTempView.class));
            }
        });
        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Switcher.this, MinTempView.class));
            }
        });
        ll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Switcher.this, RainfallPred.class));
            }
        });
        ll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Switcher.this, MeanTempPred.class));
            }
        });
        ll7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Switcher.this, MaxTempPred.class));
            }
        });
        ll8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Switcher.this, MinTempPred.class));
            }
        });
    }
}