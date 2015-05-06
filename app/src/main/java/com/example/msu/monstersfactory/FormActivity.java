package com.example.msu.monstersfactory;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by pvsousalima on 5/4/15.
 */
public class FormActivity extends Activity{

    ImageView imageView;
    ImageView icone_height;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form_activity);

        // Setbackground color?
        //getWindow().getDecorView().setBackgroundColor(Color.DKGRAY);

        final EditText tvname = (EditText) findViewById(R.id.tvname);
        final EditText tvheight = (EditText) findViewById(R.id.tvheight);
        final EditText tvweight = (EditText) findViewById(R.id.tvweight);
        final EditText tvage = (EditText) findViewById(R.id.tvage);

        imageView = (ImageView) findViewById(R.id.imageView);
        icone_height = (ImageView) findViewById(R.id.imageView2);


        Handler uiHandler = new Handler(Looper.getMainLooper());
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                Picasso.with(getApplicationContext())
                        .load("http://www.muscleclubapparel.com/wp-content/uploads/2013/07/BigBiceps_2560x1440.jpg")
                        .resize(1200, 280)
                        .into(imageView);
            }
        });

        uiHandler = new Handler(Looper.getMainLooper());
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                Picasso.with(getApplicationContext())
                        .load("http://www.veryicon.com/icon/ico/System/Android%201/Measurement%20Units%20weight.ico")
                                //.resize(300, 300)
                        .into(icone_height);
            }
        });

        tvheight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tvheight.setText("");
                return false;
            }
        });


        tvweight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tvweight.setText("");
                return false;
            }
        });

        tvname.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tvname.setText("");
                return false;
            }
        });

        tvage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tvage.setText("");
                return false;
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


