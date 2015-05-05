package com.example.msu.monstersfactory;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by pvsousalima on 5/4/15.
 */
public class FormActivity extends Activity{

    ImageView imageView;

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

        Handler uiHandler = new Handler(Looper.getMainLooper());
        uiHandler.post(new Runnable(){
            @Override
            public void run() {
                Picasso.with(getApplicationContext())
                        .load("http://www.muscleclubapparel.com/wp-content/uploads/2013/07/BigBiceps_2560x1440.jpg")
                        .resize(1200, 280)
                        .into(imageView);
            }
        });



        tvname.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tvname.setText("");
                return true;
            }
        });


        tvheight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tvheight.setText("");
                return true;
            }
        });


        tvweight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tvweight.setText("");
                return true;
            }
        });


        tvage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tvage.setText("");
                return true;
            }
        });

    }
}


