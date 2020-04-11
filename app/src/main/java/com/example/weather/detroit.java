package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;





public class detroit extends AppCompatActivity {


    Button home;


    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detroit);


        home = findViewById(R.id.home);

        //instantiate the request queue
        requestQueue = Volley.newRequestQueue(this);

        //create object request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://api.openweathermap.org/data/2.5/onecall?lat=42.331429&lon=-83.045753&appid=1b34e5a03df81b9a93e074cea4852b5d", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray weather = response.getJSONArray("weather");

                            JSONObject currentWeather = weather.getJSONObject(0);

                            int id = currentWeather.getInt("id");
                            String mainWeather = currentWeather.getString("main");
                            String description = currentWeather.getString("description");

                            Log.i("JSON info", "ID: " + id);
                            Log.i("JSON info", "main weather: " + mainWeather);
                            Log.i("JSON info", "Description" + description);
                        } catch (JSONException ex) {
                            Log.e("JSON Error", ex.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        requestQueue.add(jsonObjectRequest);



        //IMPORT WEATHER INFO FROM API


        //create object request


        //PARSE THROUGH INFO


        //EXPORT INFO TO SCREEN


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(detroit.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}