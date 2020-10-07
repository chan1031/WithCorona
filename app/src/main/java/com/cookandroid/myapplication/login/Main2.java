package com.cookandroid.myapplication.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cookandroid.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main2 extends AppCompatActivity  {

    private int FlagNum;

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Option frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private PasswordChange pc;
    private HomeSet hs;
    private MapDetial md;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_main2);

        Intent intent = getIntent();
        FlagNum = intent.getExtras().getInt("flagName");
        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.action_news:
                        setFrag(0);
                        break;
                    case R.id.action_gps:
                        setFrag(1);
                        break;
                    case R.id.action_setting:
                        setFrag(2);
                        break;
                }
                return false;
            }
        });
        frag1 = new Option();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        pc = new PasswordChange();
        hs = new HomeSet();
        md = new MapDetial();

        setFrag(FlagNum);
    }

    // 프래그먼트 교체
    private boolean setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch(n){
            case 0:

                ft.replace(R.id.Main_Frame, frag2);
                ft.commit();
                break;
            case 1:

                ft.replace(R.id.Main_Frame,frag3);
                ft.commit();
                break;
            case 2:

                ft.replace(R.id.Main_Frame,frag1);
                ft.commit();
                break;
            case 3:

                ft.replace(R.id.Main_Frame,frag4);
                ft.commit();
                break;
            case 4:
                // commit already called 에러 해결: ft가 이미 실행되었기에 재실행 해주어야 함
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.Main_Frame,pc);
                ft.commit();
                break;
            case 5:
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.Main_Frame,hs);
                ft.commit();
                break;
            case 6:
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.Main_Frame,md);
                ft.commit();
                break;
        }
        return false;
    }

}
