package com.cookandroid.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Option extends Fragment {

    private View view;
    private TextView password;
    private TextView locationSet;
    private int flagNum;

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


        return view;
    }
}
