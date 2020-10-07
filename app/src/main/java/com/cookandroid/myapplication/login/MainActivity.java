package com.cookandroid.myapplication.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.cookandroid.myapplication.R;

public class MainActivity extends AppCompatActivity {

    int flagNum;
    private ImageView imgbtn;
    private ImageView gpsBtn;
    private ImageView optionBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        imgbtn = (ImageView) findViewById(R.id.News);
        gpsBtn = (ImageView) findViewById(R.id.Gps);
        optionBtn = (ImageView) findViewById(R.id.Option);
        gpsBtn.setSelected(true);

        imgbtn.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                Intent intent = new Intent(getApplicationContext(), Main2.class);
                flagNum = 0;
                intent.putExtra("flagName", flagNum);

                startActivity(intent);
                return false;
            }
        });

        gpsBtn.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                Intent intent = new Intent(getApplicationContext(), Main2.class);
                flagNum = 1;
                intent.putExtra("flagName", flagNum);

                startActivity(intent);
                return false;
            }
        });

        optionBtn.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                Intent intent = new Intent(getApplicationContext(), Main2.class);
                flagNum = 2;
                intent.putExtra("flagName", flagNum);

                startActivity(intent);
                return false;
            }
        });
    }






}
