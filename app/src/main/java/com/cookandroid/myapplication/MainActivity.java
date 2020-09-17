package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int flagNum;
    private ImageButton imgbtn;
    private ImageView gpsBtn;
    private ImageView optionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgbtn = (ImageButton) findViewById(R.id.News);
        gpsBtn = (ImageView) findViewById(R.id.Gps);
        optionBtn = (ImageView) findViewById(R.id.Option);

        imgbtn.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1){
                Intent intent = new Intent(getApplicationContext(), Main2.class);
                flagNum = 0;
                intent.putExtra("flagName",flagNum);

                startActivity(intent);
                return false;
            }
        });

        gpsBtn.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1){
                Intent intent = new Intent(getApplicationContext(), Main2.class);
                flagNum = 1;
                intent.putExtra("flagName",flagNum);

                startActivity(intent);
                return false;
            }
        });

        optionBtn.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1){
                Intent intent = new Intent(getApplicationContext(), Main2.class);
                flagNum = 2;
                intent.putExtra("flagName",flagNum);

                startActivity(intent);
                return false;
            }
        });
    }
}
