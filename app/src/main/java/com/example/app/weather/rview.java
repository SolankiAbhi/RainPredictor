package com.example.app.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class rview extends AppCompatActivity implements rviewadapter.ItemClickListener, callback {

    rviewadapter adapter;
    ArrayList<String[]> fin = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rview);

        // data to populate the RecyclerView with

        // set up the RecyclerView
        library library = new library();
        asynservice asynservice = new asynservice(library.Rainfallurl, this);
        asynservice.execute();

//        String intial=getResources().getString(R.string.rainfall);
//        String []arr=intial.split("]");

        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new rviewadapter(this, fin);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
//        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String onresponse(String response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        for (int i = 0; i < jsonObject.getJSONArray("records").length(); i++) {
            // Log.d("mesaage from res",jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());
            System.out.println(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());
        }

        return null;
    }
}