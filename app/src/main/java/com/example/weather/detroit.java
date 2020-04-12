package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


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


    TextView idTest;
    TextView mainWeatherTest;
    TextView descriptionTest;

    TextView jTesting;
    String URL = "https://www.api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=5225ba78215711c14d97b36ee6d49633";
    String dataResults = " ";




    //IMPORT WEATHER INFO FROM API
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detroit);

        //Initializing all the buttons and views

            //Buttons
        home = findViewById(R.id.home);

            //Text Views
        idTest = findViewById(R.id.idTest);
        mainWeatherTest = findViewById(R.id.mainWeatherTest);
        descriptionTest = findViewById(R.id.descriptionTest);
        jTesting = findViewById(R.id.jTesting);


        //End initializing views


        //instantiate the request queue
        requestQueue = Volley.newRequestQueue(this);

        //create object request

        //BAUGH CODE

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://api.openweathermap.org/data/2.5/weather?q=Detroit&appid=5225ba78215711c14d97b36ee6d49633", null,
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


                            dataResults = weather.toString();



                            jTesting.setText(weather.toString());


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

//END OF JSON OBJECT REQUEST

            //jTesting.setText(dataResults);




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