package com.example.weather;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.Menu;

//import for project
import android.view.MenuInflater; //import this for menu inflater
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

//Packages allowing for fragment views to be used
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

private Spinner spinner;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        final List<String> cities = new ArrayList<>();
        cities.add(0, "Choose City");
        cities.add("Detroit");
        cities.add("New York City");
        cities.add("Chicago");
        cities.add("San Diego");
        cities.add("Seattle");



        //Style and populate spinner
        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);

        //Dropdown Layout Style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (parent.getItemAtPosition(position).equals("Choose City"))
                {
                    //do nothing
                }

                else
                {
                    //on selecting a spinner item
                    String item = parent.getItemAtPosition(position).toString();

                    //Show selected spinner item
                    Toast.makeText(parent.getContext(),"Selected City: "+item, Toast.LENGTH_SHORT).show();

                    //EVERYTHING else that happens based on item selection here.
                    //IMPORTANT CODE GOES HERE


                    //DETROIT
                    if (parent.getItemAtPosition(position).equals("Detroit"))
                    {
                        Intent intent = new Intent(MainActivity.this, detroit.class);
                        startActivity(intent);

                    }




                    //NEW YORK CITY
                    else if (parent.getItemAtPosition(position).equals("New York City"))
                    {
                        Intent intent = new Intent(MainActivity.this, NewYorkCity.class);
                        startActivity(intent);

                    }



                    //CHICAGO
                    else if (parent.getItemAtPosition(position).equals("Chicago"))
                    {
                        Intent intent = new Intent(MainActivity.this, Chicago.class);
                        startActivity(intent);

                    }




                    //SAN DIEGO
                    else if (parent.getItemAtPosition(position).equals("San Diego"))
                {
                    Intent intent = new Intent(MainActivity.this, SanDiego.class);
                    startActivity(intent);

                }



                    //SEATTLE
                    else if (parent.getItemAtPosition(position).equals("Seattle"))
                    {
                        Intent intent = new Intent(MainActivity.this, Seattle.class);
                        startActivity(intent);

                    }






                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                //To Do Auto-Generated Method stub

            }
        });



    }
}
