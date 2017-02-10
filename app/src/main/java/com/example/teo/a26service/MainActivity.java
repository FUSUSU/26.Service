package com.example.teo.a26service;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    //Khai báo
    Button buttonStart, buttonStop, buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ánh xạ
        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStop = (Button) findViewById(R.id.buttonStop);
        buttonNext = (Button) findViewById(R.id.buttonNext);

        //Bất chế độ lắng nghe.
        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View src) {
        switch (src.getId()){
            case R.id.buttonStart:
                startService(new Intent(this, MyService.class)); //Bắt đầu service
                break;
            case R.id.buttonStop:
                stopService(new Intent(this, MyService.class)); //Kết thức service
                break;
            case R.id.buttonNext:
                Intent intent = new Intent(this, NextPage.class); //Chuyển trang service vẫn chạy ngầm
                startActivity(intent);
                break;
        }
    }
}
