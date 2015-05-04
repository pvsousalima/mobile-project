package com.example.msu.monstersfactory;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity {

    final String PREFS_NAME = "MyPrefsFile";

    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (settings.getBoolean("my_first_time", true)) {

            //the app is being launched for first time, do something
            Log.d("Comments", "First time");

            // first time task
            Toast t = Toast.makeText(getApplicationContext(), "First time", Toast.LENGTH_LONG);
            t.show();

            // record the fact that the app has been started at least once
            settings.edit().putBoolean("my_first_time", false);
            settings.edit().commit();
        }



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
