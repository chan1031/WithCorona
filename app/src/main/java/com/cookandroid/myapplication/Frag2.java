package com.cookandroid.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag2 extends Fragment {
    int flagNum;

    private View view;
    private ImageView imgView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frame_news, container, false);

        imgView = (ImageView)view.findViewById(R.id.abc);

        imgView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1){
                //프래그먼트는 context가 없어서 getActivity()를 사용한다.
                Intent intent = new Intent(getActivity(), Main2.class);
                flagNum = 3;
                intent.putExtra("flagName",flagNum);

                startActivity(intent);
                return false;
            }
        });

        return view;
    }
}
