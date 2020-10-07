package com.cookandroid.myapplication.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.cookandroid.myapplication.R;

public class Option extends Fragment  {
protected Activity mActivity;
    private View view;
    private TextView password;
    private TextView locationSet;
    private int flagNum;
  Toolbar toolbar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frame_option, container, false);

        toolbar = (Toolbar) view.findViewById(R.id.OptionToolBar);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        if (activity != null) {
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ActionBar ab = activity.getSupportActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);//기본 제목을 없애줍니다.
        ab.setDisplayHomeAsUpEnabled(true);

toolbar.setNavigationOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        getActivity().onBackPressed();
    }
});


                // 비밀번호 변경 페이지로 이동
                password = (TextView) view.findViewById(R.id.textView3);
                password.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View arg0, MotionEvent arg1) {
                        //프래그먼트는 context가 없어서 getActivity()를 사용한다.
                        Intent intent = new Intent(getActivity(), Main2.class);
                        flagNum = 4;
                        intent.putExtra("flagName", flagNum);

                        startActivity(intent);
                        return false;
                    }
                });

                //홈 주소 설정
                locationSet = (TextView) view.findViewById(R.id.textView7);
                locationSet.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View arg0, MotionEvent arg1) {
                        //프래그먼트는 context가 없어서 getActivity()를 사용한다.
                        Intent intent = new Intent(getActivity(), Main2.class);
                        flagNum = 5;
                        intent.putExtra("flagName", flagNum);

                        startActivity(intent);
                        return false;
                    }
                });


                return view;

            }



    }

