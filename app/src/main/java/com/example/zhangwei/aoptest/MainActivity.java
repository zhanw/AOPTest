package com.example.zhangwei.aoptest;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @BehaviorTrace("test1")
    public void test1(View view){
        SystemClock.sleep(2000 + new Random().nextInt(1000));
        Log.d("SSS","this is test1");
    }

    public void test2(View view){
        Log.d("SSS","this is test2");
    }

    public void test3(View view){

    }

}
