package com.cookandroid.myapplication.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.cookandroid.myapplication.MainActivity;
import com.cookandroid.myapplication.R;
import com.cookandroid.myapplication.join.RegisterTerms;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginPage extends AppCompatActivity {
    private Button loginbtn;
    private EditText login_id;
    private EditText login_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        login_id = findViewById(R.id.login_id);
        login_pass = findViewById(R.id.login_pass);

        loginbtn = (Button)findViewById(R.id.loginButton);
        loginbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //아이디 값과 패스워드 값을 변수에 저장한다.
                final String userID = login_id.getText().toString();
                String userPass = login_pass.getText().toString();

                //StringRequest에 넣을 responseListner를 선언한다.
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // 서버로부터 문자열 response를 받아서 처리하는 과정
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            // Register php의 불린 값을 요청
                            boolean success = jsonObject.getBoolean("success");
                            if (success){
                                //php에서 불러온 데이터를 저장
                                String userID = jsonObject.getString("userID");
                                String userPass = jsonObject.getString("userPassword");
                                // 로그인에 성공
                                Toast.makeText(getApplicationContext(),"로그인에 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginPage.this, MainActivity.class);
                                intent.putExtra("userID",userID);
                                intent.putExtra("userPass",userPass);

                                startActivity(intent);
                            }else{ // 회원가입에 실패
                                Toast.makeText(getApplicationContext(),"로그인에 실패", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequset = new LoginRequest(userID,userPass,responseListener);
                //RequestQueue를 선언한다.
                RequestQueue queue = Volley.newRequestQueue(LoginPage.this);
                //서버에 값을 요청한다.
                queue.add(loginRequset);
            }
        });

        TextView nextButton=(TextView) findViewById(R.id.passSch);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), RegisterTerms.class);
                startActivity(intent);
            }
        });
    }
}


