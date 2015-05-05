package com.example.msu.monstersfactory;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;


public class MainActivity extends Activity {

    //SharedPreferences
    final String PREFS_NAME = "MyPrefsFile";
    SharedPreferences settings;


    ImageView imageView;

    public boolean checkFirstLaunch(){
        if (settings.getBoolean("my_first_time", true)) {

            // first time task
            Toast t = Toast.makeText(getApplicationContext(), "First time", Toast.LENGTH_LONG);
            t.show();

            // record the fact that the app has been started at least once
            settings.edit().putBoolean("my_first_time", false).apply();
            settings.edit().commit();

            return true;
        } else {

            // Checks the second time launch
            //the app is being launched for second time, do something

            setContentView(R.layout.second);

            // first time task
            Toast t = Toast.makeText(getApplicationContext(), "Second time", Toast.LENGTH_LONG);
            t.show();

            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Get SharedPreferences
        settings = getSharedPreferences(PREFS_NAME, 0);

        //Gets ImageView object
        imageView = (ImageView) findViewById(R.id.image);

        // Loads image from the Internet
        Picasso.with(getApplicationContext())
        .load("https://scontent.xx.fbcdn.net/hphotos-xfp1/t31.0-8/1798924_795706623828627_1556304660425544635_o.png")
        .into(imageView);

        Toast t = Toast.makeText(getApplicationContext(), "Load image", Toast.LENGTH_SHORT);
        t.show();


        Button button_new = (Button) findViewById(R.id.button_new);


        button_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i  = new Intent(getApplicationContext(), FormActivity.class);

                startActivity(i);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
