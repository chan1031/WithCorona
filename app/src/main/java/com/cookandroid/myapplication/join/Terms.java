package com.cookandroid.myapplication.join;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cookandroid.myapplication.R;

public class Terms extends AppCompatActivity {
    private RadioGroup rg;
    private Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_terms);

        nextButton= (Button) findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Join.class);
                startActivity(intent);
            }
        });
        rg=findViewById(R.id.radioGroup);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if (i == R.id.RadioButtonYes) {
                    nextButton.setEnabled(true);


                } else if (i == R.id.RadioButtonNo) {
                    nextButton.setEnabled(false);
                }


            }

        });
        TextView Back=(TextView) findViewById(R.id.back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Terms.class);
                startActivity(intent);


    }
});
    }
}