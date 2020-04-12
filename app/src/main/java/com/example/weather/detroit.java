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


    TextView currentTemp;
    TextView currentDescription;

    TextView dayOne;
    TextView dayTwo;
    TextView dayThree;
    TextView dayFour;
    TextView dayFive;



    String URL = "https://api.openweathermap.org/data/2.5/forecast?q=detroit&units=imperial&appid=5225ba78215711c14d97b36ee6d49633";








    String currentTemperature;
    String currentDescriptionText;
    String clouds;



    String feelsLikeTemp;

    String minTemp;
    String maxTemp;
    String dayDescription;
    String dateInfo;

    String fiveDayForecast;



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

        currentTemp = findViewById(R.id.currentTemp);
        currentDescription = findViewById(R.id.currentDescription);

        dayOne = findViewById(R.id.dayOne);
        dayTwo = findViewById(R.id.dayTwo);
        dayThree = findViewById(R.id.dayThree);
        dayFour = findViewById(R.id.dayFour);
        dayFive = findViewById(R.id.dayFive);


        //End initializing views


        //instantiate the request queue
        requestQueue = Volley.newRequestQueue(this);

        //create object request




        //BAUGH CODE

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {


                        //Returns full JSON List
                            JSONArray theList = response.getJSONArray("list");

                        //Parse to first index of "LIST" which shows first time stamp of data
                            JSONObject firstElement = theList.getJSONObject(0);

                            //Parse to second level of 'main' with temp, feels like, min, max, etc
                                JSONObject mainElement = firstElement.getJSONObject("main");

                                    //Parse to lower level to get string based on the key string such as "temp", or "temp_min" etc
                                     currentTemperature = mainElement.getString("temp");

                                     //Set textview based on string
                                     currentTemp.setText(currentTemperature);


                         //Parse through WEATHER array in the List
                            JSONArray weatherArray = firstElement.getJSONArray("weather");

                            //Parse to the first index of the array
                            JSONObject currentWeather = weatherArray.getJSONObject(0);

                                    //Parse to the string with the key of "description", and also can access id, main, and icon
                                    currentDescriptionText = currentWeather.getString("description");
                                    currentDescription.setText(currentDescriptionText);



                                    //LOOP to populate 5 day forecast
                                    for (int index = 0; index < 5; index++)
                                    {
                                        //Multiplying index by 8 to increment by each day
                                        JSONObject loopElement = theList.getJSONObject(index * 8);
                                        JSONObject loopElementLower = loopElement.getJSONObject("main");

                                        minTemp = loopElementLower.getString("temp_min");
                                        maxTemp = loopElementLower.getString("temp_max");

                                        JSONArray loopArray = firstElement.getJSONArray("weather");
                                        JSONObject loopWeather = loopArray.getJSONObject(0);

                                        dayDescription = loopWeather.getString("description");

                                       // JSONObject dateElement = loopElement.getJSONObject("sys");
                                        dateInfo = loopElement.getString("dt_txt");

                                        fiveDayForecast = "Date: " + dateInfo + "MIN:" + minTemp + "| " + "MAX:" + maxTemp + "DESC: " + dayDescription;

                                        if (index == 0)
                                        {
                                            dayOne.setText(fiveDayForecast);
                                        }
                                        else if (index == 1)
                                        {
                                            dayTwo.setText(fiveDayForecast);
                                        }
                                        else if (index == 2)
                                        {
                                            dayThree.setText(fiveDayForecast);
                                        }
                                        else if (index == 3)
                                        {
                                            dayFour.setText(fiveDayForecast);
                                        }
                                        else if (index == 4)
                                        {
                                            dayFive.setText(fiveDayForecast);
                                        }

                                    }

















                            JSONObject theWeather = weatherArray.getJSONObject(0);

















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