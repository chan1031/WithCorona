package com.cookandroid.myapplication.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cookandroid.myapplication.MainActivity;
import com.cookandroid.myapplication.R;
import com.cookandroid.myapplication.join.Terms;

public class LoginPage extends AppCompatActivity {
    private Button loginbtn;

    //loginbranch Test
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        loginbtn = (Button)findViewById(R.id.loginButton);
        loginbtn.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
                return false;
            }
        });

        TextView nextButton=(TextView) findViewById(R.id.passSch);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Terms.class);
                startActivity(intent);
            }
        });
    }
}


