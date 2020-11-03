package com.cookandroid.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.cookandroid.myapplication.gioFencing.GpsService;
import com.cookandroid.myapplication.login.LoginPage;
import com.cookandroid.myapplication.login.LoginRequest;

import static android.content.Context.MODE_PRIVATE;

public class Option extends Fragment {

    private View view;
    private TextView password;
    private TextView locationSet;
    private int flagNum;
    private Button logout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frame_option, container, false);

        // 비밀번호 변경 페이지로 이동
        password = (TextView) view.findViewById(R.id.textView3);
        password.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1){
                //프래그먼트는 context가 없어서 getActivity()를 사용한다.
                Intent intent = new Intent(getActivity(), Main2.class);
                flagNum = 4;
                intent.putExtra("flagName",flagNum);

                startActivity(intent);
                return false;
            }
        });

        //홈 주소 설정
        locationSet = (TextView) view.findViewById(R.id.textView7);
        locationSet.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1){
                //프래그먼트는 context가 없어서 getActivity()를 사용한다.
                Intent intent = new Intent(getActivity(), Main2.class);
                flagNum = 5;
                intent.putExtra("flagName",flagNum);

                startActivity(intent);
                return false;
            }
        });

        //로그아웃
        logout = (Button)view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                SharedPreferences sp = requireActivity().getSharedPreferences("user", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.commit();

                Toast.makeText(getActivity(),"로그아웃 하셨습니다.", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getActivity(), GpsService.class);
                getActivity().stopService(intent2);
                Intent intent = new Intent(getActivity(), LoginPage.class);
                startActivity(intent);
                }
            });

        return view;
    }
}
