package com.example.weather;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.Menu;

//import for project
import android.view.MenuInflater; //import this for menu inflater
import android.view.MenuItem;
import android.widget.Toast;

//Packages allowing for fragment views to be used
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        Fragment f;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        f = new splash();
        fragmentTransaction.replace(R.id.fragment_container_view, f);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();



    }







    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);



        return super.onCreateOptionsMenu(menu);
    }






    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        Fragment f;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        if ( (item.getItemId()) == R.id.detroit)
        {
            Toast.makeText(this, "Detroit", Toast.LENGTH_SHORT).show();
            f = new Detroit();
            fragmentTransaction.replace(R.id.fragment_container_view,f);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }

        else if ((item.getItemId()) == R.id.nyc)
        {
            Toast.makeText(this, "Nyc", Toast.LENGTH_SHORT).show();
            f= new Nyc();
            fragmentTransaction.replace(R.id.fragment_container_view,f);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        else if ((item.getItemId()) == R.id.seattle)
        {
            Toast.makeText(this, "Seattle", Toast.LENGTH_SHORT).show();
            f= new Seattle();
            fragmentTransaction.replace(R.id.fragment_container_view,f);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        else if ((item.getItemId()) == R.id.chicago)
        {
            Toast.makeText(this, "Chicago", Toast.LENGTH_SHORT).show();
            f= new Chicago();
            fragmentTransaction.replace(R.id.fragment_container_view,f);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        else if ((item.getItemId()) == R.id.sandiego)
        {
            Toast.makeText(this, "San Diego", Toast.LENGTH_SHORT).show();
            f= new Sandiego();
            fragmentTransaction.replace(R.id.fragment_container_view,f);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }



        return super.onOptionsItemSelected(item);
    }















}
