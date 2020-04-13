package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;



public class Chicago extends AppCompatActivity {

    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicago);


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
                "https://api.openweathermap.org/data/2.5/forecast?q=chicago&appid=5225ba78215711c14d97b36ee6d49633", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray theList = response.getJSONArray("list");
                            String TESTJSON = theList.toString();

                            JSONObject firstElement = theList.getJSONObject(0);

                            JSONArray weatherArray = firstElement.getJSONArray("weather");

                            JSONObject theWeather = weatherArray.getJSONObject(0);

                            String TESTJSON2 = weatherArray.toString();

                            tempTest.setText(firstElement.toString());

                            jTesting.setText(TESTJSON2);

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

                Intent intent = new Intent(Chicago.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }
}
