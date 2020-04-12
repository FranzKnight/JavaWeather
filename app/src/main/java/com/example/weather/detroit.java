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
    TextView tempTest;


    String URL = "http://api.openweathermap.org/data/2.5/forecast?q=detroit&appid=5225ba78215711c14d97b36ee6d49633";
    String dataResults = " ";
    String tempResults = " ";


    String actualTemp;
    String clouds;


    String feelsLikeTemp;
    String minTemp;
    String maxTemp;



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
        tempTest = findViewById(R.id.tempTest);


        //End initializing views


        //instantiate the request queue
        requestQueue = Volley.newRequestQueue(this);

        //create object request



        //BAUGH CODE

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://api.openweathermap.org/data/2.5/forecast?q=detroit&units=imperial&appid=5225ba78215711c14d97b36ee6d49633", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {


                            JSONArray theList = response.getJSONArray("list");

                            String TESTJSON = theList.toString();

                            JSONObject firstElement = theList.getJSONObject(0);

                            JSONObject mainElement = firstElement.getJSONObject("main");

                            actualTemp = mainElement.getString("temp");

                            JSONObject secondElement = firstElement.getJSONObject("clouds");

                            clouds = secondElement.getString("all");









                            JSONArray weatherArray = firstElement.getJSONArray("weather");

                            JSONObject theWeather = weatherArray.getJSONObject(0);

                            String TESTJSON2 = weatherArray.toString();


                            tempTest.setText(clouds);

                            jTesting.setText(actualTemp);






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